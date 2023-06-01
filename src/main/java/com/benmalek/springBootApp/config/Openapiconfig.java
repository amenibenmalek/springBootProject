package com.benmalek.springBootApp.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Openapiconfig {

  @Bean
  OpenAPI openApi() {
    return new OpenAPI()
      .info(new Info()
        .title("Formation API")
        .description("An API that can manage all the entities of the training course")
        .version("v1.0"));
  }
}
