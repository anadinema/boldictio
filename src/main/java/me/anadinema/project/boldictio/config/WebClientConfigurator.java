package me.anadinema.project.boldictio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigurator {
    public WebClient configureWebClient(String uri) {
        return WebClient.builder()
                .baseUrl(uri)
                .build();
    }
}
