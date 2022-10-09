package me.anadinema.project.boldictio.service;

import lombok.extern.slf4j.Slf4j;
import me.anadinema.project.boldictio.config.ApiCallConfigurator;
import me.anadinema.project.boldictio.entity.boldictio.BoldictioResponse;
import me.anadinema.project.boldictio.entity.dictionaryapidev.DictionaryResponse;
import me.anadinema.project.boldictio.exception.ApiClientException;
import me.anadinema.project.boldictio.exception.WordNotFoundException;
import me.anadinema.project.boldictio.mapper.DictionaryApiToBoldictioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Slf4j
@Service
public class DictionaryService {

    @Value("${dictionary.api.base-url}")
    private String baseUrl;

    @Value("${dictionary.api.version}")
    private String version;

    @Autowired
    private ApiCallConfigurator apiCallConfigurator;

    @Autowired
    private DictionaryApiToBoldictioMapper responseMapper;

    public BoldictioResponse getMeaning(String inputWord) throws WordNotFoundException, ApiClientException, RuntimeException {

        ResponseEntity<List<DictionaryResponse>> response = new ResponseEntity<>(HttpStatus.PROCESSING);

        try {
            long startTime = System.currentTimeMillis();
            response = apiCallConfigurator.getConnection().exchange(baseUrl + version + "/entries/en/" + inputWord,
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<DictionaryResponse>>() {
            });
            log.info("Time taken to get the response for word : {}, from dictionary API : {}ms", inputWord, System.currentTimeMillis() - startTime);
        } catch (HttpClientErrorException exception) {
            log.error("Client error exception while calling dictionary API for word {}", inputWord);
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new WordNotFoundException("Word not available in the Dictionary API!", inputWord, "Word might be misspelled, kindly check.");
            } else if (response.getStatusCode().is4xxClientError()) {
                throw new ApiClientException("Something gone wrong in the API call!", inputWord, "Client API call failed, try again later.");
            }
        } catch (HttpServerErrorException exception) {
            log.error("Client server exception while calling dictionary API for word {}", inputWord);
            if (response.getStatusCode().is5xxServerError())
                throw new ApiClientException("Fatal! Error occurred on API server!", inputWord, "API not available, please try again later.");
            else
                throw new ApiClientException("Something went wrong!", inputWord, "Please contact admin, if this is unexpected, or try again later.");
        } catch (RuntimeException exception) {
            log.error("Fatal! Unknown error occurred throwing runtime exception. Please check ASAP!");
            throw new RuntimeException("Unknown error occurred throwing runtime exception. Please check ASAP!");
        }

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null)
            return responseMapper.map(response.getBody().get(0));
        else return null;

    }
}
