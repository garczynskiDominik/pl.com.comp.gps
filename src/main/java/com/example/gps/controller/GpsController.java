package com.example.gps.controller;

import com.example.dto.GpsDto;
import com.example.services.GpsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GpsController {

    private final GpsServices gpsServices;


    @PutMapping(value = {"/gps"})
    @ResponseBody
    public void addSpecGps(@RequestParam long latitude, @RequestParam long longitude) {
        gpsServices.addToData(latitude, longitude);
    }


    @GetMapping(value = {"/gps/all"})
    public List<GpsDto> getAllGpsSpec() {
        return gpsServices.getAllGps();
    }
}