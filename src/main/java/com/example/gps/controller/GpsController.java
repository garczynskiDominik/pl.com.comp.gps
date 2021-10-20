package com.example.gps.controller;

import com.example.gps.moedel.Gps;
import com.example.gps.repository.GpsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GpsController {

    private final GpsRepository gpsRepository;

    @PutMapping(value = {"/gps"})
    @ResponseBody
    public void addSpecGps(@RequestParam long latitude, @RequestParam long longitude) {
        gpsRepository.save(new Gps(latitude, longitude));
    }


    @GetMapping(value = {"/gps/all"})
    public List<Gps> getAll() {
        List<Gps> gpsList = gpsRepository.findAll();
        return gpsList;
    }
}

