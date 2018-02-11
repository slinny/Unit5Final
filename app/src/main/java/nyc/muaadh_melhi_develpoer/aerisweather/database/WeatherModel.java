package nyc.muaadh_melhi_develpoer.aerisweather.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by C4Q on 2/4/18.
 */

@Entity(tableName = "weatherModel")
public class WeatherModel {
    @PrimaryKey
    @NonNull
    private String dateTimeISO;

    @ColumnInfo(name = "_long")
    private Double _long;

    @ColumnInfo(name = "lat")
    private Double lat;

    @ColumnInfo(name = "weatherPrimary")
    private String weatherPrimary;

    @ColumnInfo(name = "maxTempF")
    private int maxTempF;

    @ColumnInfo(name = "minTempF")
    private int minTempF;

    @ColumnInfo(name = "humidity")
    private int humidity;

    @ColumnInfo(name = "tempF")
    private int tempF;

    @ColumnInfo(name = "windSpeedMPH")
    private int windSpeedMPH;

    @ColumnInfo(name = "sunrise")
    private Long sunrise;

    @ColumnInfo(name = "sunset")
    private Long sunset;

    @ColumnInfo(name = "weather")
    private String weather;
    @ColumnInfo(name = "tz")
    private String tz;
    @ColumnInfo(name = "icon")
    private String icon;

    public String getIcon() {
        return icon;
    }

    public WeatherModel setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }


    public WeatherModel(String dateTimeISO, Double _long, Double lat, String weatherPrimary, int maxTempF, int minTempF, int humidity, int tempF, int windSpeedMPH, Long sunrise, Long sunset, String weather, String tz,String icon) {
        this.dateTimeISO = dateTimeISO;
        this._long = _long;
        this.lat = lat;
        this.weatherPrimary = weatherPrimary;
        this.maxTempF = maxTempF;
        this.minTempF = minTempF;
        this.humidity = humidity;
        this.tempF = tempF;
        this.windSpeedMPH = windSpeedMPH;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.weather = weather;
        this.tz = tz;
        this.icon=icon;

    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public Double get_long() {
        return _long;
    }

    public Double getLat() {
        return lat;
    }

    public String getWeatherPrimary() {
        return weatherPrimary;
    }

    public int getMaxTempF() {
        return maxTempF;
    }

    public int getMinTempF() {
        return minTempF;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getTempF() {
        return tempF;
    }

    public int getWindSpeedMPH() {
        return windSpeedMPH;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public String getWeather() {
        return weather;
    }


    public void setDateTimeISO(String dateTimeISO) {
        this.dateTimeISO = dateTimeISO;
    }

    public void set_long(Double _long) {
        this._long = _long;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setWeatherPrimary(String weatherPrimary) {
        this.weatherPrimary = weatherPrimary;
    }

    public void setMaxTempF(int maxTempF) {
        this.maxTempF = maxTempF;
    }

    public void setMinTempF(int minTempF) {
        this.minTempF = minTempF;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTempF(int tempF) {
        this.tempF = tempF;
    }

    public void setWindSpeedMPH(int windSpeedMPH) {
        this.windSpeedMPH = windSpeedMPH;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
