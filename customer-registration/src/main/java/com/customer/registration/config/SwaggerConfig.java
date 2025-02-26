package com.customer.registration.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /*
    * Swagger UI  - http://localhost:8080/swagger-ui.html
    */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Customer API")
                                .version("1.0")
                                .description("API for managing customer registrations"));
    }
}
