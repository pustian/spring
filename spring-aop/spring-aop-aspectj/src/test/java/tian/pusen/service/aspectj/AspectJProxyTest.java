package tian.pusen.service.aspectj;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;
import tian.pusen.service.Waiter;
import tian.pusen.service.impl.WaiterImpl;

/**
 * Created by tianpusen on 2017/4/5.
 */
public class AspectJProxyTest {
    @Test
    public void test() {
        Waiter target = new WaiterImpl();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(target);
        aspectJProxyFactory.setTarget(target);
        aspectJProxyFactory.addAspect(ServiceBeforeAspect.class);
        Waiter proxy = aspectJProxyFactory.getProxy();

        proxy.greetTo("田圃森");
        proxy.serveTo("李雪楠");
        try {
            proxy.waiting("嘻嘻哈哈");
        }catch (Exception e) {}
    }
}
