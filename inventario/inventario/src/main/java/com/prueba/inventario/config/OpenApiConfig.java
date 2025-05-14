package com.prueba.inventario.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Inventario y Depreciación de Activos")
                        .version("1.0.0")
                        .description("API REST para gestión de activos, inventario y depreciación anual de equipos."));
    }

}
