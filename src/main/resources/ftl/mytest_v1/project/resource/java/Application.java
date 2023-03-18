package #BASE_PACKAGE#;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author jun.zhao
 */
@SpringBootApplication
@ComponentScan(basePackages = {"#BASE_PACKAGE#"})
@EnableFeignClients
@EnableAutoConfiguration
@EnableWebMvc
@ServletComponentScan
@MapperScan("#MAPPER_PACKAGE#")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
