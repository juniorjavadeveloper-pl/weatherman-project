package pl.juniorjavadeveloper.project.weathermanproject.repository.entity;

import javax.persistence.Embeddable;

@Embeddable
public class WeatherEntity {
    private Double temperature;
    private Integer pressure;
    private Integer humidity;
    private Double windSpeed;

    // https://issues.redhat.com/browse/HIBERNATE-50
//    @Formula("0")
//    private int dummy;

    public WeatherEntity() {
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

//    public int getDummy() {
//        return dummy;
//    }

//    public void setDummy(int dummy) {
//        this.dummy = dummy;
//    }

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
