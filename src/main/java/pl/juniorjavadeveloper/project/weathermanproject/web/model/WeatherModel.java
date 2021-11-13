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
    private double temperature;
    private int pressure;
    private int humidity;
    private double windSpeed;
}
