package me.anadinema.project.boldictio.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anadinema.project.boldictio.entity.common.Definitions;

import java.util.List;

@Data
@NoArgsConstructor
public class Meanings {
    @JsonProperty("partOfSpeech")
    private String partOfSpeech;
    @JsonProperty("definitions")
    private List<Definitions> definitions;
    @JsonProperty("synonyms")
    private List<String> synonyms;
    @JsonProperty("antonyms")
    private List<String> antonyms;
}
