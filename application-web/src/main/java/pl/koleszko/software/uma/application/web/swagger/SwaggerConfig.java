package pl.koleszko.software.uma.application.web.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket SwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ALL")
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessage())
                .globalResponseMessage(RequestMethod.POST, getCustomizedResponseMessage())
                .globalResponseMessage(RequestMethod.PUT, getCustomizedResponseMessage())
                .globalResponseMessage(RequestMethod.DELETE, getCustomizedResponseMessage())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.koleszko.software.uma.application.web.controller.users"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User application management")
                .description("User application management")
                .version("1.0.1")
                .build();
    }

    private List<ResponseMessage> getCustomizedResponseMessage() {
        return newArrayList(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build(),
                new ResponseMessageBuilder()
                        .code(201)
                        .message("Created")
                        .build(),
                new ResponseMessageBuilder()
                        .code(404)
                        .message("Not found")
                        .build(),
                new ResponseMessageBuilder()
                        .code(406)
                        .message("Not acceptable")
                        .build(),
                new ResponseMessageBuilder()
                        .code(500)
                        .message("Server error")
                        .build());
    }
}
