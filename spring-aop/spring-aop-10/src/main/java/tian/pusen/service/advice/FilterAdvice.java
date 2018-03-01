package tian.pusen.service.advice;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import tian.pusen.service.Waiter;

import java.lang.reflect.Method;

/**
 * Created by tianpusen on 2017/3/27.
 */
public class FilterAdvice extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }
    public ClassFilter getClassFilter(){
        return new ClassFilter(){
            public boolean matches(Class clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
