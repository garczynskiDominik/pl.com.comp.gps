package com.example.gps.controller;

import com.example.dto.GpsDto;
import com.example.services.GpsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class GpsController {

    private final GpsServices gpsServices;


    @PutMapping(value = {"/gps"})
    @ResponseBody
    public void addSpecGps(@RequestParam @Min(value = -90) @Max(value = 90) long latitude, @RequestParam @Min(value = 180) @Max(value = 180) long longitude) {
        gpsServices.addToData(latitude, longitude);
    }


    @GetMapping(value = {"/gps/all"})
    public List<GpsDto> getAllGpsSpec() {
        return gpsServices.getAllGps();
    }
}