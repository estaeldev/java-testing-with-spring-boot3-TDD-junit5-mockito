package br.project.rest_spring_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    
    @Bean
    OpenAPI openAPI() {
        Info info = new Info();
        info.setTitle("Hello Swagger OpenApi");
        info.setVersion("v1");
        info.setDescription("Some description about your API.");
        info.setLicense(new License().name("Apache 2.0"));

        return new OpenAPI().info(info);
    }

}
