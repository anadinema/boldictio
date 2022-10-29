package me.anadinema.project.boldictio.entity.boldictio;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("uri")
    private String uri;
}
