package com.ssa.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI favoritesOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Favorites Service API")
                        .description("API for managing user favorites/bookmarks in Flatmate Finder System")
                        .version("1.0.0"));
    }
}
