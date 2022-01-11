package pl.juniorjavadeveloper.project.weathermanproject.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.model.current.OpenWeatherApiCurrentWeatherDataResponse;
import pl.juniorjavadeveloper.project.weathermanproject.external.api.openweather.service.OpenWeatherApiCurrentWeatherDataService;
import pl.juniorjavadeveloper.project.weathermanproject.service.mapper.OpenWeatherMapper;
import pl.juniorjavadeveloper.project.weathermanproject.service.mapper.WeatherDataRequestMapper;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherDataRequestModel;

import java.util.List;

@Service
public class WeathermanManagerService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WeathermanManagerService.class);

    private final LocationService locationService;
    private final WeatherService weatherService;
    private final WeatherDataRequestMapper weatherDataRequestMapper;

    private final OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService;
    private final OpenWeatherMapper openWeatherMapper;

    public WeathermanManagerService(LocationService locationService, WeatherService weatherService,
                                    WeatherDataRequestMapper weatherDataRequestMapper,
                                    OpenWeatherApiCurrentWeatherDataService openWeatherApiCurrentWeatherDataService,
                                    OpenWeatherMapper openWeatherMapper) {
        this.locationService = locationService;
        this.weatherService = weatherService;
        this.weatherDataRequestMapper = weatherDataRequestMapper;
        this.openWeatherApiCurrentWeatherDataService = openWeatherApiCurrentWeatherDataService;
        this.openWeatherMapper = openWeatherMapper;
    }

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        List<LocationModel> locationModels = locationService.list();
        LOGGER.info("list() = " + locationModels);
        return locationModels;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(WeatherDataRequestModel weatherDataRequestModel) {
        LOGGER.info("create(" + weatherDataRequestModel + ")");

        LocationModel locationModel = weatherDataRequestMapper.from(weatherDataRequestModel);
        LocationModel createdLocationModel = locationService.create(locationModel);

        LOGGER.info("create(...) = " + createdLocationModel);
        return createdLocationModel;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read(" + id + ")");

        LocationModel readLocationModel = locationService.read(id);
        WeatherDataRequestModel weatherDataRequestModel = weatherDataRequestMapper.from(readLocationModel);

        OpenWeatherApiCurrentWeatherDataResponse apiCurrentWeatherDataResponse =
                openWeatherApiCurrentWeatherDataService.getCurrentWeather(weatherDataRequestModel);
        LocationModel locationModel = openWeatherMapper.from(apiCurrentWeatherDataResponse);

        locationModel.setId(id);
        locationService.update(locationModel);

        LOGGER.info("read(...) = " + readLocationModel);
        return readLocationModel;
    }
}
