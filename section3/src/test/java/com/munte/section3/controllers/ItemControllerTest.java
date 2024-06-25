package com.munte.section3.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDummyItem_basic() throws Exception {
        // call "/hello-world
        // verify "Hello World"

        RequestBuilder request = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                // .json() calls JSONAssert.assertEquals(expected, actual, strict = false)
                .andExpect(content().json("{\"name\": \"Ball\",\"id\" :1,\"price\":10,\"quantity\":100}"))
                .andReturn();

        // verify "Hello World"
//        assertEquals("Hello World", result.getResponse().getContentAsString());
    }

}