package com.example.gps.services;

import com.example.gps.dto.GpsConverter;
import com.example.gps.dto.GpsDto;
import com.example.gps.moedel.Gps;
import com.example.gps.repository.GpsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GpsServices {

    private final GpsRepository gpsRepository;
    private final GpsConverter gpsConverter;

    public void addToData(long latitude, long longitude) {
        gpsRepository.save(new Gps(latitude,longitude));
    }

    public List<GpsDto> getAllGps() {
        List<Gps> gpsList = gpsRepository.findAll();
        List<GpsDto> gpsDtoList= gpsConverter.gpsToGpsDto(gpsList);
        return gpsDtoList;
    }
}
