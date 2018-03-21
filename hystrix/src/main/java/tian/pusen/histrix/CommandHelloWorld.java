package tian.pusen.histrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.junit.Test;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * Created by tianpusen on 2017/8/1.
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
//        //  HystrixCommand 封装过后，超时是强制的，默认超时时间是1秒，
//        //  当然你可以根据需要自己在构造函数中调节 Command 的超时时间，例如2秒
//        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
//                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().
//                        withExecutionIsolationThreadTimeoutInMilliseconds(2000))
//        );
//        // 调整某个Command的线程池大小
//        super(Setter
//                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
//                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(60))
//        );
        this.name = name;
    }

    protected String run() throws Exception {
//        Thread.sleep(1000L);
        System.out.println("Hello " + name + "!");
        return "Hello " + name + "!";
    }

    public static class UnitTest {

        @Test
        public void testSynchronous() {
            assertEquals("Hello World!", new CommandHelloWorld("World").execute());
            assertEquals("Hello Bob!", new CommandHelloWorld("Bob").execute());
        }

        @Test
        public void testAsynchronous1() throws Exception {
            assertEquals("Hello World!", new CommandHelloWorld("World").queue().get());
            assertEquals("Hello Bob!", new CommandHelloWorld("Bob").queue().get());
        }

        @Test
        public void testAsynchronous2() throws Exception {

            Future<String> fWorld = new CommandHelloWorld("World").queue();
            Future<String> fBob = new CommandHelloWorld("Bob").queue();

            assertEquals("Hello World!", fWorld.get());
            assertEquals("Hello Bob!", fBob.get());
        }

        @Test
        public void testObservable() throws Exception {
            Observable<String> fWorld = new CommandHelloWorld("World").observe();
            Observable<String> fBob = new CommandHelloWorld("Bob").observe();
            // blocking
            assertEquals("Hello World!", fWorld.toBlocking().single());
            assertEquals("Hello Bob!", fBob.toBlocking().single());
            // non-blocking
            // - this is a verbose anonymous inner-class approach and doesn't do assertions
            fWorld.subscribe(new Observer<String>() {
                public void onCompleted() {
                }

                public void onError(Throwable throwable) {
                }

                public void onNext(String s) {
                    System.out.println("fWorld:" + s);
                }
            });
            fBob.subscribe(new Observer<String>() {
                public void onCompleted() {
                }

                public void onError(Throwable throwable) {
                }

                public void onNext(String s) {
                    System.out.println("fBob:" + s);
                }
            });
        }
    }
}
