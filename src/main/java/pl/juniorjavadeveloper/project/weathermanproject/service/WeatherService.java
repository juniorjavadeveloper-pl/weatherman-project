package pl.juniorjavadeveloper.project.weathermanproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.juniorjavadeveloper.project.weathermanproject.repository.WeatherRepository;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.WeatherEntity;
import pl.juniorjavadeveloper.project.weathermanproject.service.mapper.WeatherMapper;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.WeatherModel;

@Service
public class WeatherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    public WeatherService(WeatherRepository weatherRepository, WeatherMapper weatherMapper) {
        this.weatherRepository = weatherRepository;
        this.weatherMapper = weatherMapper;
    }

    public void list() {
        LOGGER.info("list()");
    }

    public void create(WeatherModel weatherModel) {
        LOGGER.info("create({})", weatherModel);
        WeatherEntity weatherEntity = weatherMapper.from(weatherModel);
        weatherRepository.save(weatherEntity);
    }

    public void read(Long id) {
        LOGGER.info("read({})", id);
    }

    public void update(WeatherModel weatherModel) {
        LOGGER.info("update({})", weatherModel);
    }

    public void delete(Long id) {
        LOGGER.info("delete({})", id);
    }
}
