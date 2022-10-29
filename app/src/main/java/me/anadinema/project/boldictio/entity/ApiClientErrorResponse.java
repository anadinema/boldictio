package me.anadinema.project.boldictio.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiClientErrorResponse {
    @JsonProperty("timestamp")
    private Timestamp timestamp;
    @JsonProperty("word")
    private String word;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("action")
    private String action;
}
