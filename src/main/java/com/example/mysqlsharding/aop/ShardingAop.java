package com.example.mysqlsharding.aop;

import com.example.mysqlsharding.model.User;
import com.example.mysqlsharding.util.ApplicationContextUtil;
import com.example.mysqlsharding.util.LoginThreadCacheUtil;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ShardingAop {

    @Pointcut("execution(public * com.example.mysqlsharding.mapper.*.*(..)))")
    public void shardingAop(){

    }

    /**
     * @description  使用环绕通知
     */
    @Around("shardingAop()")
    public Object doAroundGame(ProceedingJoinPoint pjp) throws Throwable {

        //执行的类
        Class<?> clazz = pjp.getTarget().getClass();
        //因为mybatis执行的是代理类 ,我们要找到之前被代理的类
        Class<?>[] interfaces = clazz.getInterfaces();
        //取得第一个就是mybatis的实现类
        Class mapperClass = interfaces[0];

        //执行的方法
        String methodName = pjp.getSignature().getName();
        //执行的参数
        Object[] args = pjp.getArgs();
        //获取登录人
        User user = LoginThreadCacheUtil.getUser();
        //获取当前人的sqlsession
        SqlSession sqlSession = ApplicationContextUtil.getBean(user.getSqlSessionBeanName(), SqlSession.class);
        //获取mapper
        Object mapper = sqlSession.getMapper(mapperClass);
        //通过反射拿到方法，mybatis 因为是通过namespace+ 方法名来执行的  ，所以方法名不可能重复.这里我们就不用去判断多个方法名重复的
        Method[] methods = clazz.getMethods();
        //获取执行的方法
        Method exeMethod = null;
        for (Method method : methods) {
            if(methodName.equals(method.getName())){
                exeMethod = method;
                break;
            }
        }
        //如果没找到 抛异常
        if(exeMethod == null){
            throw new NoSuchMethodException("没有找到方法---");
        }
        //找到就执行
        Object result = exeMethod.invoke(mapper, args);

        return result;
    }
}
