package com.example.gps.repository;

import com.example.gps.moedel.Gps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpsRepository extends JpaRepository<Gps, Long> {
}
