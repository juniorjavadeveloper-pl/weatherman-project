package pl.juniorjavadeveloper.project.weathermanproject.web.model;

import javax.validation.constraints.NotBlank;

public class WeatherDataRequestModel {
    @NotBlank(message = "Please enter location name")
    private String city;
    private String countryCode;

    private double latitude;
    private double longitude;

    private int days = 1;

    public WeatherDataRequestModel() {
    }

    public WeatherDataRequestModel(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public WeatherDataRequestModel(String city, String countryCode, int days) {
        this.city = city;
        this.countryCode = countryCode;
        this.days = days;
    }

    public WeatherDataRequestModel(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public WeatherDataRequestModel(double latitude, double longitude, int days) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.days = days;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "WeatherDataRequestModel{" +
                "city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", days=" + days +
                '}';
    }
}
