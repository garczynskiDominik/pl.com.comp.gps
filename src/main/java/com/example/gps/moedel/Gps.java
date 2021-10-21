package com.example.gps.moedel;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class Gps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long latitude;
    private long longitude;

    public Gps(long latitude, long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}



