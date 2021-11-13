package pl.juniorjavadeveloper.project.weathermanproject.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel {
    private Long id;

    private String city;
    private String countryCode;

    private double latitude;
    private double longitude;

    private WeatherModel weather;
}
