package pl.juniorjavadeveloper.project.weathermanproject.repository.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "locations")
@Table(name = "LOCATIONS")
public class LocationEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    private double latitude;
    private double longitude;

    @Embedded
    private WeatherEntity weather;

    public LocationEntity() {
    }

    public LocationEntity(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public LocationEntity(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationEntity(String city, String countryCode, double latitude, double longitude, WeatherEntity weather) {
        this.city = city;
        this.countryCode = countryCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.weather = weather;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public WeatherEntity getWeather() {
        return weather;
    }

    public void setWeather(WeatherEntity weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", weather=" + weather +
                '}';
    }
}
