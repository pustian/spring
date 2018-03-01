package tian.pusen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianpusen on 2017/3/25.
 */
public class MainApp {
    private static final Log logger = LogFactory.getLog(MainApp.class);

    public static void main(String[] args) {
        System.out.println("BeanFactory --> ApplicationContext ---begin");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        logger.info("===init ApplicationContext");
        User user0 = applicationContext.getBean("user", User.class);
        User user1 = (User)applicationContext.getBean("user");
        logger.info("===It is ready for user to use bean");
        System.out.println("user0:"+user0 +"\nuser1:"+user1);
        System.out.println("BeanFactory --> ApplicationContext ---end");
    }
 }
