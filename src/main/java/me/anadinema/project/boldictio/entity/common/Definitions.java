package me.anadinema.project.boldictio.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Definitions {
    @JsonProperty("definition")
    private String definition;
    @JsonProperty("synonyms")
    private List<?> synonyms;
    @JsonProperty("antonyms")
    private List<?> antonyms;
    @JsonProperty("example")
    private String example;
}
