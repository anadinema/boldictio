package me.anadinema.project.boldictio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Boldictio API services", version = "1.0.0",
        description = "Service exposing endpoint to server the frontend for the Boldictio dictionary application",
        license = @License(name = "MIT License", url = "https://github.com/anadinema99/boldictio/blob/master/LICENSE.md"),
        contact = @Contact(name = "Anadi Nema", email = "anadi.nema@outlook.com", url = "https://anadinema.me/contact")))
@SpringBootApplication
public class BoldictioApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoldictioApplication.class, args);
    }
}

