package tian.pusen.service.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by tianpusen on 2017/3/26.
 */
public class ServiceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String)args[0];
        System.out.println("ServiceMethodInterceptor:你好，"+clientName+"先生/女士");
        Object obj = methodInvocation.proceed();
        System.out.println("ServiceMethodInterceptor:请慢用");
        return obj;
    }
}
