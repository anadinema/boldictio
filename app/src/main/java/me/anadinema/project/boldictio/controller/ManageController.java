package me.anadinema.project.boldictio.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.anadinema.project.boldictio.exception.HealthPingException;
import me.anadinema.project.boldictio.entity.health.HealthResponse;
import me.anadinema.project.boldictio.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/manage", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Manage service", description = "Endpoints to manage and monitor health of the API")
public class ManageController {

    @Autowired
    private ManageService manageService;

    @GetMapping(path = "/health")
    public ResponseEntity<HealthResponse> checkHealth() throws HealthPingException {
        try {
            return new ResponseEntity<>(manageService.getApiHealth(), HttpStatus.OK);
        } catch (HealthPingException exception) {
            throw new HealthPingException(exception);
        }
    }
}
