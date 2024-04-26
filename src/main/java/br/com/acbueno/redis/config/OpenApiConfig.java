package br.com.acbueno.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI baseOPenApi() {
    //@formatter:off
    Components components = new Components();
    return new OpenAPI()
        .components(components)
        .info(new Info()
        .title("Springboot Producer SSE and Consumer Forecast API")
        .version("1.0.0")
        .description("Doc Description"));
    //@formatter:on
  }

}
