package me.anadinema.project.boldictio.controller;

import me.anadinema.project.boldictio.entity.boldictio.BoldictioResponse;
import me.anadinema.project.boldictio.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/v1/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping(path = "/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoldictioResponse> getDictionaryMeaning(@PathVariable String word) {
        try {
            BoldictioResponse response = dictionaryService.getMeaning(word);
            if (response != null)
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            else
                return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
