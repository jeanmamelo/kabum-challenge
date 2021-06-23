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
public class ShippingResponse {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("valor_frete")
    private Double shippingPrice;

    @JsonProperty("prazo_dias")
    private Integer shippingTimeByDays;

}
