package com.example.shppyad15.Departure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departures")
public class DepartureController {
    private final DepartureService departureService;

    @Autowired
    public DepartureController(DepartureService departureService) {
        this.departureService = departureService;
    }

    @GetMapping
    public ResponseEntity<List<Departure>> getAllDepartures() {
        return ResponseEntity.ok(departureService.getAllDepartures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departure> getDepartureById(@PathVariable("id") Long id) {
        Departure departure = departureService.getDepartureById(id);
        if (departure == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(departure);
    }

    @PostMapping
    public ResponseEntity<Departure> createDeparture(@RequestBody Departure departure) {
        return ResponseEntity.ok(departureService.createDeparture(departure));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartureById(@PathVariable("id") Long id) {
        if (departureService.getDepartureById(id) == null) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
        departureService.deleteDepartureById(id);
        return ResponseEntity.ok("Departure deleted.");
    }
}