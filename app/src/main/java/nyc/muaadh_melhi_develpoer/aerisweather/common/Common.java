package nyc.muaadh_melhi_develpoer.aerisweather.common;

import nyc.muaadh_melhi_develpoer.aerisweather.Interface.AerisService;
import nyc.muaadh_melhi_develpoer.aerisweather.Remote.RetrofitClient;

/**
 * Created by c4q on 2/5/18.
 */

public class Common {
    private static final String BASE_URL = "https://api.aerisapi.com/";
    public static final String CLIENT_ID = "qJI48hjqUBmyYfeEnKzPV";
    public static final String CLIENT_SECRET = "hLfGq3aEO0H9PQqPcewUZSJqihVxzUpcg2GQ5bI4";

    public static AerisService getForecast() {
        return RetrofitClient.getRetrofit(BASE_URL).create(AerisService.class);
    }

}


