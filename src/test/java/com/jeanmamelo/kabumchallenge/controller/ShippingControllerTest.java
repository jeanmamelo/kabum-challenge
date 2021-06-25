package com.jeanmamelo.kabumchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeanmamelo.kabumchallenge.model.dto.DimensionRequest;
import com.jeanmamelo.kabumchallenge.model.dto.ShippingRequest;
import com.jeanmamelo.kabumchallenge.model.dto.ShippingResponse;
import com.jeanmamelo.kabumchallenge.service.ShippingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class ShippingControllerTest extends AbstractControllerTest<ShippingController> {

    private static final String POST_SHIPPINGS = "/shippings";

    @MockBean
    private ShippingService shippingService;

    private ShippingRequest shippingRequest;

    @Test
    public void shouldRetrieveAListOfShippings() throws Exception {
        givenAValidShippingRequest();
        givenShippingServiceReturnsAListOfShippingResponse();
        whenCallRequestShipping();
        thenExpectOkStatus();
        thenExpectShippingServiceRequestShippingCalledOnce();
    }

    /**
     * Given methods
     */
    private void givenAValidShippingRequest() {
        shippingRequest = ShippingRequest.builder()
                .dimension(DimensionRequest.builder()
                        .height(102)
                        .width(40)
                        .build())
                .weight(400)
                .build();
    }

    private void givenShippingServiceReturnsAListOfShippingResponse() {
        doReturn(Arrays.asList(ShippingResponse.builder()
                        .name("Entrega Ninja")
                        .shippingPrice(12.00)
                        .shippingTimeByDays(6)
                        .build(),
                ShippingResponse.builder()
                        .name("Entrega KaBuM")
                        .shippingPrice(8.00)
                        .shippingTimeByDays(4)
                        .build()))
                .when(shippingService).requestShipping(shippingRequest);
    }

    /**
     * When methods
     */
    private void whenCallRequestShipping() throws Exception {
        response = mockMvc.perform(post(POST_SHIPPINGS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(shippingRequest)))
                .andReturn().getResponse();
    }

    /**
     * Then methods
     */
    private void thenExpectOkStatus() {
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    private void thenExpectShippingServiceRequestShippingCalledOnce() {
        verify(shippingService, times(1)).requestShipping(shippingRequest);
    }

}
