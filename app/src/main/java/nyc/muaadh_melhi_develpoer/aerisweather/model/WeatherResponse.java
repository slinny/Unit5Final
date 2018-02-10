package nyc.muaadh_melhi_develpoer.aerisweather.model;

import java.util.List;

/**
 * Created by c4q on 2/4/18.
 */

public class WeatherResponse {
    private Boolean success;
    private String error;
    private List<AerisResponse> response;

    public Boolean getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public List<AerisResponse> getResponse() {
        return response;
    }
}
