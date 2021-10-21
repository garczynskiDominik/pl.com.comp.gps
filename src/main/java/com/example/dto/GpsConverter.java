package com.example.dto;

import com.example.gps.moedel.Gps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GpsConverter {
    public GpsDto gpsToGpsDto(Gps gps) {
        GpsDto gpsDto = new GpsDto();
        gpsDto.setId(gps.getId());
        gpsDto.setLongitude(gps.getLongitude());
        gpsDto.setLatitude(gps.getLatitude());
        return gpsDto;
    }

    public List<GpsDto> gpsToGpsDto(List<Gps> gpsList) {
        return gpsList.stream()
                .map(this::gpsToGpsDto)
                .collect(Collectors.toList());
    }

    public Gps gpsDtoToGps(GpsDto gpsDto) {
        Gps gps = new Gps();
        gps.setId(gpsDto.getId());
        gps.setLongitude(gpsDto.getLongitude());
        gps.setLatitude(gpsDto.getLatitude());

        return gps;
    }

    public List<Gps> gpsDtoToGps(List<GpsDto> gpsDtoList) {
        return gpsDtoList.stream()
                .map(this::gpsDtoToGps)
                .collect(Collectors.toList());

    }

}
