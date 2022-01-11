package pl.juniorjavadeveloper.project.weathermanproject.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ToString.Exclude
    private WeatherModel weather;
}
