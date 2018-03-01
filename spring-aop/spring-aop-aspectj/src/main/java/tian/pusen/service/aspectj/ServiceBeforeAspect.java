package tian.pusen.service.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by tianpusen on 2017/3/26.
 */
@Aspect
public class ServiceBeforeAspect {
    @Before("execution(* greetTo(..) )" )
    public void beforeGreetTo(){
        System.out.println("How are you uing @Aspect");
    }
}
