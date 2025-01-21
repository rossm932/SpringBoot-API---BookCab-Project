package com.demo.travelbookingproject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CabBookingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBookCab() throws Exception {
        mockMvc.perform(post("/cab/book")
                .param("from", "Work")
                .param("to", "Office")
                .param("typeOfCab", "Sedan"))
                .andExpect(status().is3xxRedirection()); // Expect redirection
    }


    @Test
    public void testCalculateFare() throws Exception {
        mockMvc.perform(post("/cab/calculate-fare")
                .param("cabType", "SUV")
                .param("distance", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("200.0")); // Expected fare
    }
}