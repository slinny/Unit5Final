package nyc.muaadh_melhi_develpoer.aerisweather.model;

import java.util.List;

/**
 * Created by c4q on 2/5/18.
 */

public class AerisResponse {
    private AerisLoc loc;
    private String interval;
    private List<AerisPeriod> periods;
    private Aerisprofile profile;

    public AerisLoc getLoc() {
        return loc;
    }

    public String getInterval() {
        return interval;
    }

    public List<AerisPeriod> getPeriods() {
        return periods;
    }

    public Aerisprofile getProfile() {
        return profile;
    }
}
