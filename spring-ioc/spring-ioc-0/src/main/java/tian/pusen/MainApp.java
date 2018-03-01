package tian.pusen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by tianpusen on 2017/3/25.
 */
public class MainApp {
    private static final Log logger = LogFactory.getLog(MainApp.class);

    public static void main(String[] args) {
        System.out.println("Debug the spring source: --- begin");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        logger.info("===init BeanFactory");

        User user0 = beanFactory.getBean("user", User.class);
        User user1 = (User)beanFactory.getBean("user");
        logger.info("===It is ready for use to use bean");
        System.out.println("user0:"+user0 +"\nuser1:"+user1);
        System.out.println("Debug the spring source: --- end");
    }
 }
