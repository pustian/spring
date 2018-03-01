package tian.pusen.service.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by tianpusen on 2017/3/26.
 */
public class ServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() +"."+method.getName()) ;
        String clientName = (String)objects[0];
        System.out.println("ServiceBeforeAdvice: How are you! Mr. " +clientName + ".");
    }
}
