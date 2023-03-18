package #BASE_PACKAGE#.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                        "/images/**",
                        "/css/**")
                .addResourceLocations(
                        "classpath:/META-INF/public-web-resources/images/",
                        "classpath:/META-INF/public-web-resources/css/");
    }

}
