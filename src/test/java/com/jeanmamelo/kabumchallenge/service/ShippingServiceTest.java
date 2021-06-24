package com.jeanmamelo.kabumchallenge.service;

import com.jeanmamelo.kabumchallenge.model.dto.DimensionRequest;
import com.jeanmamelo.kabumchallenge.model.dto.ShippingRequest;
import com.jeanmamelo.kabumchallenge.model.dto.ShippingResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ShippingServiceTest {

    @InjectMocks
    private ShippingService shippingService;

    private ShippingRequest shippingRequest;
    private List<ShippingResponse> shippingResponseList;

    @Test
    public void shouldReturnAListOfTwoValidShippingResponseObjects() {
        givenAValidShippingRequest();
        whenCallRequestShipping();
        thenExpectAListWithTwoShippingResponseObjects();
    }

    @Test
    public void shouldReturnAnEmptyList() {
        givenAnInvalidShippingRequest();
        whenCallRequestShipping();
        thenExpectAEmptyList();
    }

    @Test
    public void shouldReturnAListOfOneValidShippingResponseObjects() {
        givenAValidShippingRequestForKabumShippingType();
        whenCallRequestShipping();
        thenExpectAListWithOneShippingResponseObjects();
        thenExpectAObjectWithNinjaName();
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

    private void givenAnInvalidShippingRequest() {
        shippingRequest = ShippingRequest.builder()
                .dimension(DimensionRequest.builder()
                        .height(230)
                        .width(162)
                        .build())
                .weight(5600)
                .build();
    }

    private void givenAValidShippingRequestForKabumShippingType() {
        shippingRequest = ShippingRequest.builder()
                .dimension(DimensionRequest.builder()
                        .height(152)
                        .width(50)
                        .build())
                .weight(850)
                .build();
    }

    /**
     * When methods
     */
    private void whenCallRequestShipping() {
        shippingResponseList = shippingService.requestShipping(shippingRequest);
    }

    /**
     * Then methods
     */
    private void thenExpectAListWithTwoShippingResponseObjects() {
        assertEquals(2, shippingResponseList.size());
    }

    private void thenExpectAEmptyList() {
        assertEquals(0, shippingResponseList.size());
    }

    private void thenExpectAListWithOneShippingResponseObjects() {
        assertEquals(1, shippingResponseList.size());
    }

    private void thenExpectAObjectWithNinjaName() {
        assertEquals("Entrega Ninja", shippingResponseList.get(0).getName());
    }

}
