package pl.juniorjavadeveloper.project.weathermanproject.web.model;

public class WeatherDataRequestModel {
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

    public String getCountryCode() {
        return countryCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getDays() {
        return days;
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
