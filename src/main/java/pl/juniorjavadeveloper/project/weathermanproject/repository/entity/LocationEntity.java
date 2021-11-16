package pl.juniorjavadeveloper.project.weathermanproject.repository.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "locations")
@Table(name = "LOCATIONS")
public class LocationEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    private double latitude;
    private double longitude;

    @Embedded
    private WeatherEntity weather;
}
