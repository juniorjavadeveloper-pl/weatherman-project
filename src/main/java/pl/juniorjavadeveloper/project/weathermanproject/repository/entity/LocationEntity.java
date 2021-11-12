package pl.juniorjavadeveloper.project.weathermanproject.repository.entity;

import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherModel;

//@Entity(name = "locations")
//@Table(name = "LOCATIONS")
public class LocationEntity {
//    @Id
//    @GeneratedValue
    private Long id;

    private String city;
//    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    private double latitude;
    private double longitude;

//    @Embedded
    private WeatherEntity weather;
}
