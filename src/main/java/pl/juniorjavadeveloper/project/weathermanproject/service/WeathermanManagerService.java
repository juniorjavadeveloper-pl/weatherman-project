package pl.juniorjavadeveloper.project.weathermanproject.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.model.current.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.service.OpenWeatherApiCurrentWeatherDataService;
import pl.juniorjavadeveloper.project.weathermanproject.service.mapper.OpenWeatherMapper;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherDataRequestModel;

import java.util.List;

@Service
public class WeathermanManagerService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WeathermanManagerService.class);

    private final WeathermanService weathermanService;
    private final OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService;
    private final OpenWeatherMapper openWeatherMapper;

    public WeathermanManagerService(WeathermanService weathermanService,
                                    OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService,
                                    OpenWeatherMapper openWeatherMapper) {
        this.weathermanService = weathermanService;
        this.openWeatherApiCurrentWeatherDataService = openWeatherApiCurrentWeatherDataService;
        this.openWeatherMapper = openWeatherMapper;
    }

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        List<LocationModel> locationModels = weathermanService.list();
        LOGGER.info("list() = " + locationModels);
        return locationModels;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(WeatherDataRequestModel weatherDataRequestModel) {
        LOGGER.info("create(" + weatherDataRequestModel + ")");

        OpenWeatherApiCurrentWeatherDataResponse apiCurrentWeatherDataResponse =
                openWeatherApiCurrentWeatherDataService.getCurrentWeather(weatherDataRequestModel);
        LocationModel locationModel = openWeatherMapper.from(apiCurrentWeatherDataResponse);
        LocationModel createdLocationModel = weathermanService.create(locationModel);

        LOGGER.info("create(...) = " + createdLocationModel);
        return createdLocationModel;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read(" + id + ")");
        LocationModel readLocationModel = weathermanService.read(id);
        LOGGER.info("read(...) = " + readLocationModel);
        return readLocationModel;
    }
}
