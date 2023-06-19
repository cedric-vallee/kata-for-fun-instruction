package com.kata.kataforfunjava.controllers;

import com.kata.kataforfunjava.services.KataForFunService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class KataForFunControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KataForFunService kataForFunService;

    @Test
    public void convertNumber_ValidInput_ReturnsResultDto() throws Exception {
        // Arrange
        int inputNumber = 33;

        // Act & Assert
        mockMvc.perform(get("/kata-for-fun/{inputNumber}", inputNumber)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result").value("KataKataKata"));
    }
}