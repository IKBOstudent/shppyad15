package com.example.shppyad15.Departure;

import jakarta.persistence.*;

@Entity
@Table(name = "departures_table")
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(name = "departure_date")
    private String departureDate;

    public Departure() {}

    public Departure(String type, String departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}