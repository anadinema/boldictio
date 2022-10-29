package me.anadinema.project.boldictio.entity.dictionaryapidev;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anadinema.project.boldictio.entity.common.Meanings;

import java.util.List;

@Data
@NoArgsConstructor
public class DictionaryResponse {
    @JsonProperty("word")
    private String word;
    @JsonProperty("phonetic")
    private String phonetic;
    @JsonProperty("phonetics")
    private List<Phonetics> phonetics;
    @JsonProperty("meanings")
    private List<Meanings> meanings;
    @JsonProperty("license")
    private License license;
    @JsonProperty("sourceUrls")
    private List<String> sourceUrls;
}
