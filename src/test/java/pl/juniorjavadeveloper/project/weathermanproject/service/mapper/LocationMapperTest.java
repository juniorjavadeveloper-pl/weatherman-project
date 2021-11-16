package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.LocationEntity;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LocationMapperTest {

    @Test
    void givenMapper_whenFromModel_thenEntityHasCorrectValues() {
        // given
        LocationMapper locationMapper = new LocationMapper();
        LocationModel locationModel = new LocationModel();

        // when
        LocationEntity locationEntity = locationMapper.from(locationModel);

        // then
        assertAll(
                () -> assertNotNull(locationEntity, "Mapped locationEntity is null")
        );
    }

    @Test
    void givenMapper_whenFromEntity_thenModelHasCorrectValues() {
        // given
        LocationMapper locationMapper = new LocationMapper();

        // when
        LocationEntity locationEntity = new LocationEntity();
        LocationModel locationModel = locationMapper.from(locationEntity);

        // then
        assertAll(
                () -> assertNotNull(locationModel, "Mapped locationModel is null")
        );
    }
}