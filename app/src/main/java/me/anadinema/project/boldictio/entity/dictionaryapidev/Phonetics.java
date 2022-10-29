package me.anadinema.project.boldictio.entity.dictionaryapidev;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phonetics {
    @JsonProperty("text")
    private String text;
    @JsonProperty("audio")
    private String audio;
    @JsonProperty("sourceUrl")
    private String sourceUrl;
    @JsonProperty("license")
    private License license;
}
