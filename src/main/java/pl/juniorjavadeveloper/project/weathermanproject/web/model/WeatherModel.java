package pl.juniorjavadeveloper.project.weathermanproject.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherModel {
    private Long id;

    private Double temperature;
    private Integer pressure;
    private Integer humidity;
    private Double windSpeed;

    private LocationModel location;
}
