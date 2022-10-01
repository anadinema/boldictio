package me.anadinema.project.boldictio.entity.boldictio;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Image {
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("uri")
    private String uri;
}
