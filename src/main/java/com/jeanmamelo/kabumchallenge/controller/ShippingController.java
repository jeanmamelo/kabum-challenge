package com.jeanmamelo.kabumchallenge.controller;

import com.jeanmamelo.kabumchallenge.model.dto.ShippingRequest;
import com.jeanmamelo.kabumchallenge.model.dto.ShippingResponse;
import com.jeanmamelo.kabumchallenge.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippings")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingService shippingService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShippingResponse> requestShipping(@RequestBody ShippingRequest shippingRequest) {
        return shippingService.requestShipping(shippingRequest);
    }

}
