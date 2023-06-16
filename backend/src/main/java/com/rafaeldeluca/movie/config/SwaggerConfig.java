package com.rafaeldeluca.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import org.springframework.web.bind.annotation.RestController;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    private static final String AUTHORIZATION_HEADER="Authorization";

    private ApiKey apiKeys () {
        return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
    }

    private List<SecurityContext> securityContextMethod () {
        return Arrays.asList(SecurityContext.builder().securityReferences(securityReferenceMethod()).build());
    }

    private List<SecurityReference> securityReferenceMethod() {
        // definindo o scopo
        AuthorizationScope globalScope = new AuthorizationScope("global", "accessEverything");
        return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[]{globalScope}));
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(securityContextMethod())
                .securitySchemes(Arrays.asList(apiKeys()))
                .select()
                //.apis(RequestHandlerSelectors.basePackage(".com.rafaeldeluca.movie.controllers"))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo metaDados () {
        return new ApiInfoBuilder().title("API de avaliação de filmes")
                .description("\"Spring Boot REST API para avaliar filmes. Dodumentação com swagger\"").version("1.0.0")
            .contact(new Contact("Rafael de Luca","https://github.com/rafaelgauderio","deluca1712@gmail.com"))
                .build();
    }
}
