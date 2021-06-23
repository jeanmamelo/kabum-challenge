package com.jeanmamelo.kabumchallenge.service;

import com.jeanmamelo.kabumchallenge.enums.KabumEnum;
import com.jeanmamelo.kabumchallenge.enums.NinjaEnum;
import com.jeanmamelo.kabumchallenge.model.dto.ShippingRequest;
import com.jeanmamelo.kabumchallenge.model.dto.ShippingResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingService {

    public List<ShippingResponse> requestShipping(ShippingRequest shippingRequest) {
        List<ShippingResponse> response = new ArrayList<>();

        checkShippingNinja(shippingRequest, response);
        checkShippingKabum(shippingRequest, response);

        return response;
    }

    private void checkShippingKabum(ShippingRequest shippingRequest, List<ShippingResponse> shippingResponseList) {
        if (KabumEnum.isValid(shippingRequest)) {
            Double shippingPrice = calculateShippingPrice(shippingRequest.getWeight(), KabumEnum.SHIPPING_FACTOR.getValue());

            ShippingResponse shippingResponse = ShippingResponse.builder()
                    .shippingPrice(shippingPrice)
                    .shippingTimeByDays(KabumEnum.SHIPPING_TIME_BY_DAYS.getValue().intValue())
                    .name("Entrega KaBuM")
                    .build();

            shippingResponseList.add(shippingResponse);
        }
    }

    private void checkShippingNinja(ShippingRequest shippingRequest, List<ShippingResponse> shippingResponseList) {
        if (NinjaEnum.isValid(shippingRequest)) {
            Double shippingPrice = calculateShippingPrice(shippingRequest.getWeight(), NinjaEnum.SHIPPING_FACTOR.getValue());

            ShippingResponse shippingResponse = ShippingResponse.builder()
                    .shippingPrice(shippingPrice)
                    .shippingTimeByDays(NinjaEnum.SHIPPING_TIME_BY_DAYS.getValue().intValue())
                    .name("Entrega Ninja")
                    .build();

            shippingResponseList.add(shippingResponse);
        }
    }

    private Double calculateShippingPrice(Double weight, Double shippingFactor) {
        return (weight * shippingFactor) / 10;
    }

}
