package com.jeanmamelo.kabumchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public abstract class AbstractControllerTest<T> {

    @Autowired
    protected MockMvc mockMvc;

    protected MockHttpServletResponse response;

}
