package com.munte.section3.controllers;

import com.munte.section3.business.ItemBusinessService;
import com.munte.section3.models.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void getDummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                // .json() calls JSONAssert.assertEquals(expected, actual, strict = false)
                .andExpect(content().json("{\"name\": \"Ball\",\"id\" :1,\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    public void getItemFromBusinessService_basic() throws Exception {
        when(businessService.retrieveHardCodedItem()).thenReturn(new Item(2, "Item2", 10, 10));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/items/from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                // .json() calls JSONAssert.assertEquals(expected, actual, strict = false)
                .andExpect(content().json("{\"name\": \"Item2\",\"id\" :2,\"price\":10,\"quantity\":10}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(businessService.retrieveAllItems()).thenReturn(
                    List.of(
                        new Item(2, "Item2", 10, 10)
                    )
                );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/items/all-items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                // .json() calls JSONAssert.assertEquals(expected, actual, strict = false)
                .andExpect(content().json("[{id: 2, name:Item2, price:10, quantity:10}]"))
                .andReturn();
    }

}