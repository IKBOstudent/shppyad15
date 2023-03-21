package com.example.shppyad15.PostOffice;

import jakarta.persistence.*;

@Entity
@Table(name = "post_offices_table")
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "city_name")
    private String cityName;

    public PostOffice() {}

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
