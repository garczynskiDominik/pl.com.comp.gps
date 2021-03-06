package com.example.gps.dto;

import com.example.gps.moedel.Gps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GpsConverter {
    public GpsDto gpsToGpsDto(Gps gps) {
        GpsDto gpsDto = new GpsDto();
        gpsDto.setDeviceId(gps.getDeviceId());
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
        gps.setDeviceId(gpsDto.getDeviceId());
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
