package com.example.receptor_gps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.receptor_gps.enitity.PointOfInterest;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long>{

}
