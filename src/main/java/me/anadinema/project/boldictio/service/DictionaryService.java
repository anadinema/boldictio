package me.anadinema.project.boldictio.service;

import lombok.extern.slf4j.Slf4j;
import me.anadinema.project.boldictio.config.WebClientConfigurator;
import me.anadinema.project.boldictio.entity.boldictio.BoldictioResponse;
import me.anadinema.project.boldictio.entity.dictionaryapidev.DictionaryResponse;
import me.anadinema.project.boldictio.mapper.DictionaryApiToBoldictioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@Service
public class DictionaryService {

    @Value("${dictionary.api.base-url}")
    private String baseUrl;

    @Value("${dictionary.api.version}")
    private String version;

    @Autowired
    private WebClientConfigurator webClientConfigurator;

    @Autowired
    private DictionaryApiToBoldictioMapper responseMapper;

    public BoldictioResponse getMeaning(String inputWord) {
        StringBuilder endpointUri = new StringBuilder().append(baseUrl).append(version).append("/entries/en/").append(inputWord);
        DictionaryResponse dictionaryResponse = webClientConfigurator.configureWebClient(endpointUri.toString())
                .get().retrieve().bodyToFlux(DictionaryResponse.class)
                .doOnError(throwable -> {log.error("Failed while calling Directory API!", throwable);}).blockFirst(Duration.ofMillis(5000));
        return responseMapper.map(dictionaryResponse);
    }

}
