package nyc.muaadh_melhi_develpoer.aerisweather.Interface;

import nyc.muaadh_melhi_develpoer.aerisweather.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by c4q on 2/5/18.
 */

public interface AerisService {
    // https://api.aerisapi.com/forecasts/42.25,-95.25?filter=1hr&limit=12&client_id=qJI48hjqUBmyYfeEnKzPV&client_secret=hLfGq3aEO0H9PQqPcewUZSJqihVxzUpcg2GQ5bI4
    //Return forecast data for the coordinate 42.25N, 95.25W.

    @GET("forecasts/{location}?filter=1hr&limit=12")
    Call<WeatherResponse> getWeatherResponse(@Path("location") String location,
                                             @Query("client_id") String client_id,
                                             @Query("client_secret") String client_secret
    );
}
