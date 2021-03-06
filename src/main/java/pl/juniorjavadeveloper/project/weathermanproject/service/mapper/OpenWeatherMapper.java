package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.model.current.Coord;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.model.current.Main;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.model.current.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.model.current.Sys;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.model.current.Wind;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherModel;

@Component
public class OpenWeatherMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapper.class);

    public LocationModel from(OpenWeatherApiCurrentWeatherDataResponse weatherDataResponse) {
        LOGGER.info("from(" + weatherDataResponse + ")");
        LocationModel locationModel = new LocationModel();
        WeatherModel weatherModel = new WeatherModel();

        locationModel.setWeather(weatherModel);
        weatherModel.setLocation(locationModel);

        if (weatherDataResponse != null) {
            Coord weatherDataResponseCoord = weatherDataResponse.getCoord();
            if (weatherDataResponseCoord != null) {
                LOGGER.info("adding weather coordinates data...");
                locationModel.setLatitude(weatherDataResponseCoord.getLat());
                locationModel.setLongitude(weatherDataResponseCoord.getLon());
            }

            Main weatherDataResponseMain = weatherDataResponse.getMain();
            if (weatherDataResponseMain != null) {
                LOGGER.info("adding weather main data...");
                weatherModel.setTemperature(weatherDataResponseMain.getTemp());
                weatherModel.setPressure(weatherDataResponseMain.getPressure());
                weatherModel.setHumidity(weatherDataResponseMain.getHumidity());
            }

            Wind weatherDataResponseWind = weatherDataResponse.getWind();
            if (weatherDataResponseWind != null) {
                LOGGER.info("adding weather wind data...");
                weatherModel.setWindSpeed(weatherDataResponseWind.getSpeed());
            }

            LOGGER.info("adding weather location info...");
            locationModel.setCity(weatherDataResponse.getName());

            Sys weatherDataResponseSys = weatherDataResponse.getSys();
            if (weatherDataResponseSys != null) {
                locationModel.setCountryCode(weatherDataResponseSys.getCountry());
            }
        }

        LOGGER.info("from(...) = " + locationModel);
        return locationModel;
    }
}
