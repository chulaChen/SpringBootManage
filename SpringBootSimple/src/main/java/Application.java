import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 简单的tomcat启动的案例，三个注解是必须的，要继承SpringBootServletInitializer
 */
//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.chenzhuo")
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
