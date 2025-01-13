package com.example.receptor_gps.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.receptor_gps.dto.PointOfInterestDTO;
import com.example.receptor_gps.enitity.PointOfInterest;
import com.example.receptor_gps.repository.PointOfInterestRepository;

@RestController
public class PointOfInterestController {

    private final PointOfInterestRepository repository;

    public PointOfInterestController(PointOfInterestRepository repository){
        this.repository = repository;
    }

    @PostMapping("/points-of-interests")
    public ResponseEntity<Void> createPoi(@RequestBody PointOfInterestDTO body){

        repository.save(new PointOfInterest(body.name(), body.x(), body.y())); 
        
        return ResponseEntity.ok().build();
    }

}
