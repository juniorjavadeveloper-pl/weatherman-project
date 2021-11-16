package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.LocationEntity;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationMapper.class);

    public List<LocationModel> fromList(List<LocationEntity> locationEntities) {
        LOGGER.info("from({})", locationEntities);
        return locationEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public LocationEntity from(LocationModel locationModel) {
        LOGGER.info("from({})", locationModel);
        ModelMapper modelMapper = new ModelMapper();
        LocationEntity locationEntity = modelMapper.map(locationModel, LocationEntity.class);
        LOGGER.info("from(...) = {}", locationEntity);
        return locationEntity;
    }

    public LocationModel from(LocationEntity locationEntity) {
        LOGGER.info("from({})", locationEntity);
        ModelMapper modelMapper = new ModelMapper();
        LocationModel locationModel = modelMapper.map(locationEntity, LocationModel.class);
        LOGGER.info("from(...) = {}", locationModel);
        return locationModel;
    }
}
