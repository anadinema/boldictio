package me.anadinema.project.boldictio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ApiCallConfigurator {

    @Value("${dictionary.api.connect-timeout}")
    private Long connectionTimeout;

    @Value("${dictionary.api.read-timeout}")
    private Long readTimeout;

    @Bean
    public RestTemplate getConnection() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }

}
