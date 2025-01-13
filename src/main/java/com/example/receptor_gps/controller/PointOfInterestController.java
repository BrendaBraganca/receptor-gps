package com.example.receptor_gps.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/points-of-interests")
    public ResponseEntity<?> listPoi(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            if (page < 0 || pageSize <= 0) {
                return ResponseEntity.badRequest()
                        .body("Parâmetros inválidos: 'page' deve ser >= 0 e 'pageSize' deve ser > 0.");
            }

            var body = repository.findAll(PageRequest.of(page, pageSize));
            return ResponseEntity.ok(body);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("Erro ao buscar os pontos de interesse: " + e.getMessage());
        }
    }

    @GetMapping("/near-me")
    public ResponseEntity<List<PointOfInterest>> nearMe(@RequestParam("x") Long x, @RequestParam("y") Long y, @RequestParam("dmax") Long dmax){
        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;

        var body = repository.findNearMe(xMin, xMax, yMin, yMax);
        return ResponseEntity.ok(body);

    }


}
