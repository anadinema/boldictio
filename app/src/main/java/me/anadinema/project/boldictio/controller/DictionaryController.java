package me.anadinema.project.boldictio.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import me.anadinema.project.boldictio.entity.boldictio.BoldictioResponse;
import me.anadinema.project.boldictio.exception.ApiClientException;
import me.anadinema.project.boldictio.exception.WordNotFoundException;
import me.anadinema.project.boldictio.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/v1/dictionary", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Dictionary endpoints", description = "All the endpoints for getting dictionary meaning and further details for any word")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping(path = "/{word}")
    public ResponseEntity<BoldictioResponse> getDictionaryMeaning(@PathVariable String word) throws ApiClientException, WordNotFoundException, RuntimeException {
        BoldictioResponse response = new BoldictioResponse();
        try {
            response = dictionaryService.getMeaning(word);
        } catch (WordNotFoundException exception) {
            throw new WordNotFoundException(exception);
        } catch (ApiClientException exception) {
            throw new ApiClientException(exception);
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception);
        }

        if (response != null) {
            return new ResponseEntity<BoldictioResponse>(response, HttpStatus.OK);
        }
        else
            throw new WordNotFoundException("Word not available in the Dictionary API!", word, "Word might be misspelled, kindly check.");
    }
}
