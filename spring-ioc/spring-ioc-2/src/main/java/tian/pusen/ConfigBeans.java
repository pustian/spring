package tian.pusen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianpusen on 2017/3/26.
 */
@Configuration
public class ConfigBeans {
    @Bean(name="user")
    public User buildUser(){
           User user = new User();
           user.setUserID("612129198XXXXX");
           user.setName("田圃森");
           return user;
    }
}
