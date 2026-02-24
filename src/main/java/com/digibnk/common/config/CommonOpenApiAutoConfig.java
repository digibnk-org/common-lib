package com.digibnk.common.config;

import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration
@ConditionalOnClass(OpenApiCustomizer.class)
public class CommonOpenApiAutoConfig {

    private static final String BEARER_SCHEME = "bearerAuth";

    @Value("${app.swagger.server-url:}")
    private String serverUrl;


    //Adds the Authorize button to Swagger UI.
    @Bean
    public OpenApiCustomizer bearerAuthOpenApiCustomizer() {
        return openApi -> openApi
                .addSecurityItem(new SecurityRequirement().addList(BEARER_SCHEME))
                .schemaRequirement(BEARER_SCHEME,
                        new SecurityScheme()
                                .name(BEARER_SCHEME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Paste your Keycloak JWT (without 'Bearer ' prefix). " +
                                             "Get one from: POST {keycloak-url}/realms/{realm}/protocol/openid-connect/token"));
    }

    @Bean
    public OpenApiCustomizer serverUrlOpenApiCustomizer() {
        return openApi -> {
            if (serverUrl != null && !serverUrl.isBlank()) {
                openApi.servers(List.of(new Server().url(serverUrl).description("Configured server")));
            }
        };
    }
}
