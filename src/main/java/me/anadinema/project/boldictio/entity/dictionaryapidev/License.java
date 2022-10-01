package me.anadinema.project.boldictio.entity.dictionaryapidev;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class License {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
}
