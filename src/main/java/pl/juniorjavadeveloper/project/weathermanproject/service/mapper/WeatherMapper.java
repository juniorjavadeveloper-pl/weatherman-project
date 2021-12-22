package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.WeatherEntity;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherModel;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherMapper.class);

    public List<WeatherModel> fromList(List<WeatherEntity> weatherEntities) {
        LOGGER.info("from({})", weatherEntities);
        return weatherEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public WeatherEntity from(WeatherModel weatherModel) {
        LOGGER.info("from({})", weatherModel);
        ModelMapper modelMapper = new ModelMapper();
        WeatherEntity weatherEntity = modelMapper.map(weatherModel, WeatherEntity.class);
        LOGGER.info("from(...) = {}", weatherEntity);
        return weatherEntity;
    }

    public WeatherModel from(WeatherEntity weatherEntity) {
        LOGGER.info("from({})", weatherEntity);
        ModelMapper modelMapper = new ModelMapper();
        WeatherModel weatherModel = modelMapper.map(weatherEntity, WeatherModel.class);
        LOGGER.info("from(...) = {}", weatherModel);
        return weatherModel;
    }
}
