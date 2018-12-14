package com.ocloudwork.boot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * http://localhost:8999/swagger-ui.html
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2018</p>  
 * <p>Company: www.ocloudwork.com</p>  
 * @author minghui
 * @datetime 2018年9月26日-下午1:49:26
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.ocloudwork.boot.demo.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("RESTful APIs").description("springbootDemo API")
				.termsOfServiceUrl("http://www.ocloudwork.com/").contact("minghui").version("1.0").build();
	}

}
