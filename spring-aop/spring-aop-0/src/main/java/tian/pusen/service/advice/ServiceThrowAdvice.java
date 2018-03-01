package tian.pusen.service.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by tianpusen on 2017/3/26.
 */
public class ServiceThrowAdvice implements ThrowsAdvice {
    /**
     * 注意必须自己创建一个类似于
     *  public void afterThrowing(Method method, Object[] args, Object target, Exception exception)
     *  public void afterThrowing(Throwable exception)
     * @param method
     * @param args
     * @param target
     * @param exception
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception exception) {
        System.out.println("---------------");
        System.out.println("ServiceThrowAdvice: method:"+method.getName()+"抛出异常："+ exception.getMessage()+"请添加处理");
    }
}
