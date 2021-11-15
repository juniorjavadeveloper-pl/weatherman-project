package pl.juniorjavadeveloper.project.weathermanproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.LocationEntity;
import pl.juniorjavadeveloper.project.weathermanproject.service.mapper.LocationMapper;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;

import java.util.List;

@Service
public class WeathermanService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeathermanService.class);

    private final LocationMapper locationMapper;

    public WeathermanService(LocationMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        return null;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(LocationModel locationModel) {
        LOGGER.info("create({})", locationModel);
        LocationEntity locationEntity = locationMapper.from(locationModel);
        return null;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read({})", id);
        return null;
    }

    // U - update aka. saveLocationWeather(...)
    public LocationModel update(LocationModel locationModel) {
        LOGGER.info("update({})", locationModel);
        LocationEntity locationEntity = locationMapper.from(locationModel);
        return null;
    }

    // D - delete aka. removeLocation(...)
    public void delete(Long id) {
        LOGGER.info("delete({})", id);
        throw new UnsupportedOperationException("Operation not supported YET!");
    }
}
