package com.example.dto;

import com.example.gps.moedel.Gps;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GpsMapper {
    GpsMapper INSTANCE = Mappers.getMapper(GpsMapper.class);

     GpsDto map(Gps gps);
     List<GpsDto> map(List<Gps> gpsList);



}
