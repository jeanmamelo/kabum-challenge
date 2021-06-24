package com.jeanmamelo.kabumchallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DimensionRequest {

    @JsonProperty("altura")
    private Integer height;

    @JsonProperty("largura")
    private Integer width;

}
