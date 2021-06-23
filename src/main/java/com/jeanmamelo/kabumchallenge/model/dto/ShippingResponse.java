package com.jeanmamelo.kabumchallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingResponse {

    private String name;
    private Double shippingPrice;
    private Integer shippingTimeByDays;

}
