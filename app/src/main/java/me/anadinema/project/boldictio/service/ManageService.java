package me.anadinema.project.boldictio.service;

import lombok.extern.slf4j.Slf4j;
import me.anadinema.project.boldictio.config.ApiCallConfigurator;
import me.anadinema.project.boldictio.exception.HealthPingException;
import me.anadinema.project.boldictio.entity.health.Details;
import me.anadinema.project.boldictio.entity.health.HealthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ManageService {

    @Value("${dictionary.api.base-url}")
    private String baseUrl;

    @Value("${dictionary.api.version}")
    private String version;

    @Autowired
    private ApiCallConfigurator apiCallConfigurator;

    public HealthResponse getApiHealth() throws HealthPingException {
        HealthResponse healthResponse = new HealthResponse();
        List<Details> detailsList = new ArrayList<>();
        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.PROCESSING);

        try {
            response = apiCallConfigurator.getConnection().getForEntity(baseUrl + version + "/entries/en/ping", String.class);
        } catch (Exception exception) {
            log.error("Exception occurred while checking Dictionary API health : {}", exception.getMessage());
            throw new HealthPingException("Dictionary API might be down or slow!", "Contact Admin and look into it ASAP!");
        }

        if (response.getStatusCode().is2xxSuccessful()) {
            detailsList.add(new Details("Dictionary API", "healthy"));
            healthResponse.setStatus("healthy");
        } else {
            detailsList.add(new Details("Dictionary API", "down"));
            healthResponse.setStatus("down");
            log.error("Response code is not successfully! Dictionary API might be down, look into it ASAP!");
        }
        healthResponse.setDetails(detailsList);
        return healthResponse;

    }

}
