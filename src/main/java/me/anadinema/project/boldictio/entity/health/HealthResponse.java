package me.anadinema.project.boldictio.entity.health;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("details")
    private List<Details> details;
}
