package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherDataRequestModel;

@Component
public class WeatherDataRequestMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataRequestMapper.class);

    public LocationModel from(WeatherDataRequestModel weatherDataRequestModel) {
        LOGGER.info("from({})", weatherDataRequestModel);
        ModelMapper modelMapper = new ModelMapper();
        LocationModel locationModel = modelMapper.map(weatherDataRequestModel, LocationModel.class);
        LOGGER.info("from(...) = {}", locationModel);
        return locationModel;
    }

    public WeatherDataRequestModel from(LocationModel locationModel) {
        LOGGER.info("from({})", locationModel);
        ModelMapper modelMapper = new ModelMapper();
        WeatherDataRequestModel weatherDataRequestModel = modelMapper.map(locationModel, WeatherDataRequestModel.class);
        LOGGER.info("from(...) = {}", weatherDataRequestModel);
        return weatherDataRequestModel;
    }
}
