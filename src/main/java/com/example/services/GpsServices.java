package com.example.services;

import com.example.dto.GpsDto;
import com.example.dto.GpsMapper;
import com.example.gps.repository.GpsRepository;
import com.example.gps.moedel.Gps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GpsServices {

    private final GpsRepository gpsRepository;

    public void addToData(long latitude, long longitude) {
        gpsRepository.save(new Gps(latitude, longitude));
    }

    public List<GpsDto> getAllGps() {
        List<Gps> gpsList = gpsRepository.findAll();
        List<GpsDto> gpsDtoList =GpsMapper.INSTANCE.map(gpsList);
        return gpsDtoList;
    }
}
