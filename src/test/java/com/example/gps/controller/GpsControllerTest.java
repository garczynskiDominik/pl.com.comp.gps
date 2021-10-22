package com.example.gps.controller;

import com.example.gps.moedel.Gps;
import com.example.gps.repository.GpsRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class GpsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GpsRepository gpsRepository;


    @Test
    @Sql("/sql/test.sql")
    @Sql(scripts = "/sql/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testShouldReturnGpsData() throws Exception {
        mockMvc.perform(get("/gps/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].latitude").value(50))
                .andExpect(jsonPath("$.[0].longitude").value(50))
                .andExpect(jsonPath("$.[0].id").value(9999))
                .andExpect(status().isOk());
    }

    @Test
    public void testShouldAddGpsToData() throws Exception {
        //given
        final long testLatitude = 20;
        final long testLongitude = 20;


        //when
        mockMvc.perform(put("/gps?latitude=20&longitude=20"))
                .andExpect(status().isOk());
        List<Gps> listGps = gpsRepository.findAll();
        boolean isContains = listGps.stream()
                .anyMatch(x -> x.getLatitude() == testLatitude && x.getLongitude() == testLongitude);

        //them
        Assertions.assertFalse(listGps.isEmpty());
        Assertions.assertTrue(isContains);

    }


    @Test(expected = NestedServletException.class)
    public void testShouldReturnThrow() throws Exception {
        mockMvc.perform(put("/gps?latitude=300&longitude=300"))
                .andExpect(status().is5xxServerError());


    }


}


