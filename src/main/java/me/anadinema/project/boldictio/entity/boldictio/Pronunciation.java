package me.anadinema.project.boldictio.entity.boldictio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pronunciation {
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("uri")
    private String uri;
}
