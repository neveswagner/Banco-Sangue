package br.com.bancosanguecitel.config;

import br.com.bancosanguecitel.model.Candidato;
import com.fasterxml.classmate.TypeResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final TypeResolver typeResolver;
    public SwaggerConfig(final TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)


                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.bancosanguecitel"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(metaInfo())
                .additionalModels(typeResolver.resolve(Candidato.class));
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "API Banco de Sangue",
                "API REST de Banco de Sangue",
                "Versão: Mark 1",
                "Terms of Service",
                new Contact("Wagner Neves ", "https://www.citelsoftware.com.br",
                        "wagner.neves@citelsoftware.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
