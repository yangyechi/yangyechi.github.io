package com.team69.cet.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

	static List<Parameter> getParamList()
	{
		List<Parameter> pars = new ArrayList<Parameter>();
		ParameterBuilder tokenPar = new ParameterBuilder();
		tokenPar.name("token").description("令牌")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build();
		
		ParameterBuilder signPar = new ParameterBuilder();
		signPar.name("sign").description("数据签名")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build();
		ParameterBuilder timePar = new ParameterBuilder();
		timePar.name("timestamp").description("时间戳")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build();
		pars.add(tokenPar.build());
		pars.add(signPar.build());
		pars.add(timePar.build());
		return pars;
	}
	 @Bean
	    public Docket createRestApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.team69.cet"))
	                .paths(PathSelectors.any())
	                .build();
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("CET APIs")
	                .description("四六级在线报名系统api")
	                .version("1.0")
	                .build();
	    }
	    
	
}
