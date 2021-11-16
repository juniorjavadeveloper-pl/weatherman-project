package pl.juniorjavadeveloper.project.weathermanproject.service.mapper;

import org.junit.jupiter.api.Test;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.LocationEntity;
import pl.juniorjavadeveloper.project.weathermanproject.web.model.LocationModel;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LocationMapperTest {

    private static final long LOCATION_ID_1 = 1L;
    private static final String LOCATION_CITY_WARSAW = "Warsaw";

    @Test
    void givenMapper_whenFromModel_thenEntityHasCorrectValues() {
        // given
        LocationMapper locationMapper = new LocationMapper();
        LocationModel locationModel = new LocationModel();
        locationModel.setId(LOCATION_ID_1);
        locationModel.setCity(LOCATION_CITY_WARSAW);

        // when
        LocationEntity locationEntity = locationMapper.from(locationModel);

        // then
        assertAll(
                () -> assertNotNull(locationEntity, "Mapped locationEntity is null"),
                () -> assertNotNull(locationEntity.getId(), "locationEntity ID is null"),
                () -> assertNotNull(locationEntity.getCity(), "locationEntity CITY is null")
        );
    }

    @Test
    void givenMapper_whenFromEntity_thenModelHasCorrectValues() {
        // given
        LocationMapper locationMapper = new LocationMapper();
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setId(LOCATION_ID_1);
        locationEntity.setCity(LOCATION_CITY_WARSAW);

        // when
        LocationModel locationModel = locationMapper.from(locationEntity);

        // then
        assertAll(
                () -> assertNotNull(locationModel, "Mapped locationModel is null"),
                () -> assertNotNull(locationModel.getId(), "locationModel ID is null"),
                () -> assertNotNull(locationModel.getCity(), "locationModel CITY is null")
        );
    }
}