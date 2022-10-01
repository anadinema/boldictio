package me.anadinema.project.boldictio.entity.boldictio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoldictioResponse {
    @JsonProperty("text")
    private Text text;
    @JsonProperty("media")
    private Media media;
}
