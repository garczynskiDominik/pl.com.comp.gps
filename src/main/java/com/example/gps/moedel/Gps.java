package com.example.gps.moedel;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Gps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Range(min = -90, max = 90, message = "Invalid latitude")
    private long latitude;
    @Range(min = -180, max = 180, message = "Invalid longitude")
    private long longitude;

    public Gps(long latitude, long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}



