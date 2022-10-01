package me.anadinema.project.boldictio.entity.boldictio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.anadinema.project.boldictio.entity.common.Meanings;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Text {
    @JsonProperty("word")
    private String word;
    @JsonProperty("meanings")
    private List<Meanings> meanings;
}
