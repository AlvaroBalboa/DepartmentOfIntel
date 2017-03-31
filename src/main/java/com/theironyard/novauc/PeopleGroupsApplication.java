package com.theironyard.novauc;

//import io.swagger.models.Contact;
import com.theironyard.novauc.entities.Contact;
import io.swagger.models.Swagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@SpringBootApplication
public class PeopleGroupsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleGroupsApplication.class, args);
	}


	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/");
	}

	private ApiInfo metaData() {
		//Contact contactInfo = new Contact("Alvaro Balboa", "https://theironyard.com", "alvaro@Balboa.guru");
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API for a database of POTENTIAL THREATS to NATIONAL SECURITY",
				"Spring Boot REST API for saving America",
				"1.0.2.34.2123.1",
				"Terms of service",
//				new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
//				contactInfo.toString()toString,
				"Alvaro Balboa","http:/theironyard.com","RandomLocation.com");
		return apiInfo;
	}


}
