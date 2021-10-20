package com.example.gps.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/test.sql")
class GpsControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testShouldReturnGpsData() throws Exception {
        mockMvc.perform(get("/gps/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].latitude").value(50))
                .andExpect(jsonPath("$.[0].longitude").value(50))
                .andExpect(jsonPath("$.[0].id").value(1))
                .andExpect(status().isOk());
    }




}