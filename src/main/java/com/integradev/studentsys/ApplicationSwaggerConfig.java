package com.integradev.studentsys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class})
public class ApplicationSwaggerConfig {

    @Bean
    public Docket studentApi() {
        return
                new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((RequestHandlerSelectors.any()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    // Create api metadata that goes at the top of the generated page
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Students Management System API")
                .version("1.0")
                .description("API for managing students and courses.")
                .contact(new Contact("William Yu","","williamyuaus@gmail.com"))
                .license("Apache License Version 2.0")
                .build();
    }
}
