package tian.pusen.service.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * Created by tianpusen on 2017/3/26.
 */
public class ServiceIntroductionInterceptor implements IntroductionInterceptor {
    @Override
    public boolean implementsInterface(Class<?> aClass) {
        System.out.println("ServiceIntroductionInterceptor: implementsInterface 我们能在目标类中添加一些新的方法和属性");
        return false;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("ServiceIntroductionInterceptor: invoke 我们能在目标类中添加一些新的方法和属性");
        return null;
    }
}
