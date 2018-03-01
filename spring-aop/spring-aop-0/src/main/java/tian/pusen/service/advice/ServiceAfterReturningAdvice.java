package tian.pusen.service.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by tianpusen on 2017/3/26.
 */
public class ServiceAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("ServiceAfterReturningAdvice: Please enjoy yourself");
    }
}
