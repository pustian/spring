package tian.pusen.service.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tian.pusen.service.Waiter;
import tian.pusen.service.impl.WaiterImpl;

/**
 * Created by tianpusen on 2017/3/26.
 */
public class ServiceBeforeAdviceTest {
    private Waiter target;
    private BeforeAdvice beforeAdvice;
    private ProxyFactory proxyFactory;
    @BeforeTest
    public void init(){
        target = new WaiterImpl();
        beforeAdvice = new ServiceBeforeAdvice();
        proxyFactory = new ProxyFactory(); // 提供工厂，设置代理目标，为代理目标增强
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(beforeAdvice);
    }

    @Test
    public void testBefore() {
        Waiter proxy = (Waiter)proxyFactory.getProxy();
        proxy.greetTo("田普森");
        proxy.greetTo("李学楠");
    }
}
