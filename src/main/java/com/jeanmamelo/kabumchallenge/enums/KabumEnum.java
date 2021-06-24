package com.jeanmamelo.kabumchallenge.enums;

import com.jeanmamelo.kabumchallenge.model.dto.ShippingRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum KabumEnum {

    SHIPPING_FACTOR(0.2),
    MINIMUM_HEIGHT(5.0),
    MAXIMUM_HEIGHT(140.0),
    MINIMUM_WIDTH(13.0),
    MAXIMUM_WIDTH(125.0),
    SHIPPING_TIME_BY_DAYS(4.0);

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
        return isValidHeight(shippingRequest.getDimension().getHeight().doubleValue()) &&
                isValidWidth(shippingRequest.getDimension().getWidth().doubleValue());
    }

}
