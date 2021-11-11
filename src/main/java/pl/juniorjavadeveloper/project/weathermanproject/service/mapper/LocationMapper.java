package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.LocationEntity;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;

@Component
public class LocationMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationMapper.class);

    public LocationEntity from(LocationModel locationModel) {
        LOGGER.info("from({})", locationModel);
        ModelMapper modelMapper = new ModelMapper();
        LocationEntity locationEntity = modelMapper.map(locationModel, LocationEntity.class);
        LOGGER.info("from(...) = {}", locationEntity);
        return locationEntity;
    }
}
