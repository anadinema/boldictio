package me.anadinema.project.boldictio.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Definitions {
    @JsonProperty("definition")
    private String definition;
    @JsonProperty(value = "synonyms", defaultValue = "null")
    private List<String> synonyms;
    @JsonProperty(value = "antonyms", defaultValue = "null")
    private List<String> antonyms;
    @JsonProperty("example")
    private String example;
}
