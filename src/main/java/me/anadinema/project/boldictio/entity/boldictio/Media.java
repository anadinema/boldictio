package me.anadinema.project.boldictio.entity.boldictio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Media {
    @JsonProperty("image")
    private Image image;
    @JsonProperty("pronunciation")
    private List<Pronunciation> pronunciation;
    @JsonProperty("video")
    private Video video;
}
