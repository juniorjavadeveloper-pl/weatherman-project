package pl.juniorjavadeveloper.project.weathermanproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.juniorjavadeveloper.project.weathermanproject.repository.entity.WeatherEntity;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
}
