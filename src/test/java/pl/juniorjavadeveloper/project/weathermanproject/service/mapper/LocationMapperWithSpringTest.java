package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.LocationEntity;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LocationMapperWithSpringTest {

    @Autowired
    private LocationMapper locationMapper;

    @Test
    void givenMapper_whenFromModel_thenEntityIsNotNull() {
        // given
        LocationModel locationModel = new LocationModel();

        // when
        LocationEntity locationEntity = locationMapper.from(locationModel);

        // then
        assertAll(
                () -> assertNotNull(locationEntity, "Mapped locationEntity is null")
        );
    }

    @Test
    void givenMapper_whenFromEntity_thenModelIsNotNull() {
        // given
        LocationEntity locationEntity = new LocationEntity();

        // when
        LocationModel locationModel = locationMapper.from(locationEntity);

        // then
        assertAll(
                () -> assertNotNull(locationModel, "Mapped locationModel is null")
        );
    }
}