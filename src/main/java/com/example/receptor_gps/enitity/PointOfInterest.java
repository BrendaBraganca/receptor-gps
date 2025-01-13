package com.example.receptor_gps.enitity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name="tb_point_of_interest")
public class PointOfInterest {
    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long x;

    private Long y;

    public PointOfInterest() {}

    public PointOfInterest(String name, Long x, Long y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
