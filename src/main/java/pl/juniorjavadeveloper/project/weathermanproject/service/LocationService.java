package pl.juniorjavadeveloper.project.weathermanproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.juniorjavadeveloper.project.weathermanproject.repository.LocationRepository;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.LocationEntity;
import pl.juniorjavadeveloper.project.weathermanproject.service.mapper.LocationMapper;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationService.class);

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }

    // L - list aka. listLocations()
    public List<LocationModel> list() {
        LOGGER.info("list()");
        List<LocationEntity> locationEntities = locationRepository.findAll();
        List<LocationModel> locationModels = locationMapper.fromList(locationEntities);
        LOGGER.info("list() = {}", locationModels);
        return locationModels;
    }

    // C - create aka. addLocation(...)
    public LocationModel create(LocationModel locationModel) {
        LOGGER.info("create({})", locationModel);
        LocationEntity locationEntity = locationMapper.from(locationModel);
        LocationEntity savedLocationEntity = locationRepository.save(locationEntity);
        LocationModel savedLocationModel = locationMapper.from(savedLocationEntity);
        LOGGER.info("create() = {}", savedLocationModel);
        return savedLocationModel;
    }

    // R - read aka. getLocationWeather(...)
    public LocationModel read(Long id) {
        LOGGER.info("read({})", id);
        Optional<LocationEntity> optionalLocationEntity = locationRepository.findById(id);
        // FIXME: add Exception handling instead of new LocationEntity()!!!
        LocationEntity locationEntity = optionalLocationEntity.orElse(new LocationEntity());
        LocationModel locationModel = locationMapper.from(locationEntity);
        LOGGER.info("read() = {}", locationModel);
        return locationModel;
    }

    // U - update aka. saveLocationWeather(...)
    public LocationModel update(LocationModel locationModel) {
        LOGGER.info("update({})", locationModel);
        LocationEntity locationEntity = locationMapper.from(locationModel);
        LocationEntity savedLocationEntity = locationRepository.save(locationEntity);
        LocationModel savedLocationModel = locationMapper.from(savedLocationEntity);
        LOGGER.info("update() = {}", savedLocationModel);
        return savedLocationModel;
    }

    // D - delete aka. removeLocation(...)
    public void delete(Long id) {
        LOGGER.info("delete({})", id);
        throw new UnsupportedOperationException("Operation not supported YET!");
    }
}
