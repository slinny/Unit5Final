package nyc.muaadh_melhi_develpoer.aerisweather.model;

/**
 * Created by c4q on 2/4/18.
 */

public class AerisPeriod {
    private int maxTempF;
    private int minTempF;
    private int humidity;
    private int tempF;
    private int feelslikeF;
    private int windSpeedMPH;
    private long sunrise;
    private long sunset;
    private String dateTimeISO;
    private String icon;
    private String weather;
    private String weatherPrimary;

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

    public int getFeelslikeF() {
        return feelslikeF;
    }

    public int getWindSpeedMPH() {
        return windSpeedMPH;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public String getIcon() {
        return icon;
    }

    public String getWeather() {
        return weather;
    }

    public String getWeatherPrimary() {
        return weatherPrimary;
    }
}
