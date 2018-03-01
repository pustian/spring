package tian.pusen.service.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import tian.pusen.service.Seller;
import tian.pusen.service.Waiter;

/**
 * Created by tianpusen on 2017/3/26.
 */
public class ServiceBeforeAdviceXMLTest {
    @Test
    public void testAdviceCGlibProxy() {
        System.out.println("proxy by CGlib");
        String configPath = "applicationContext-cglib-proxy.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter =  ctx.getBean("waiter", Waiter.class);
        waiter.greetTo("田雨晞");
        waiter.serveTo("田雨凇");
        try {
            waiter.waiting("天使");
        }catch (Exception e) {}

        Seller seller =  ctx.getBean("seller", Seller.class);
        seller.greetTo("飞机");

    }

}
