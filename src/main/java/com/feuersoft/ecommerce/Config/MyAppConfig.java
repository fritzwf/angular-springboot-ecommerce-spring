package com.feuersoft.ecommerce.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by ffeuerbacher on 5/12/2021
 */

@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    @Value("$(allowed.origins}")
    private String[] theAllowedOrigins;

    @Value("${spring.data.rest.base-path}")
    private String basePath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        // setup CORS mapping
        registry.addMapping(basePath + "/**").allowedOrigins(theAllowedOrigins);


    }
}
