package com.jeanmamelo.kabumchallenge.enums;

import com.jeanmamelo.kabumchallenge.model.dto.ShippingRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NinjaEnum {

    SHIPPING_FACTOR(0.3),
    MINIMUM_HEIGHT(10.0),
    MAXIMUM_HEIGHT(200.0),
    MINIMUM_WIDTH(6.0),
    MAXIMUM_WIDTH(140.0),
    SHIPPING_TIME_BY_DAYS(6.0);

    private Double value;

    public Double getValue() {
        return value;
    }

    private static Boolean isValidHeight(Double height) {
        return height >= MINIMUM_HEIGHT.value && height <= MAXIMUM_HEIGHT.value;
    }

    private static Boolean isValidWidth(Double width) {
        return width >= MINIMUM_WIDTH.value && width <= MAXIMUM_WIDTH.value;
    }

    public static Boolean isValid(ShippingRequest shippingRequest) {
        return isValidHeight(shippingRequest.getDimension().getHeight()) && isValidWidth(shippingRequest.getDimension().getWeight());
    }

}
