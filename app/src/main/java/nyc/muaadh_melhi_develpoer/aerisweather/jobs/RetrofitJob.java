package nyc.muaadh_melhi_develpoer.aerisweather.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.muaadh_melhi_develpoer.aerisweather.GPSTracker;
import nyc.muaadh_melhi_develpoer.aerisweather.Interface.AerisService;
import nyc.muaadh_melhi_develpoer.aerisweather.MainActivity;
import nyc.muaadh_melhi_develpoer.aerisweather.common.Common;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;
import nyc.muaadh_melhi_develpoer.aerisweather.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by c4q on 2/4/18.
 */

public class RetrofitJob extends JobService {
    private static final String TAG = RetrofitJob.class.getSimpleName();
    private List <AerisResponse> responseList = new ArrayList <>();
    GPSTracker gps;
    double latitude;
    double longitude;

    @Override
    public boolean onStartJob(JobParameters params) {
        /**
         * Create Retorfit call
         */
        AerisService aerisService = Common.getForecast();
        loadForecast(aerisService, params);
        Log.d(TAG, "onStartJob: ");
        return true;
    }

    private void getLocation() {
        gps = new GPSTracker(RetrofitJob.this);

        if (gps.canGetLocation()) {

            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            Log.d("latitude", String.valueOf(latitude));
            Log.d("longtitude", String.valueOf(longitude));
        } else {
            gps.showSettingsAlert();
        }
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return true;
    }

    private void loadForecast(AerisService aerisService, final JobParameters params) {
        getLocation();
        double lat = latitude;
        double lg = longitude;
        String location = lat + "," + lg;
        aerisService.getWeatherResponse(location, Common.CLIENT_ID, Common.CLIENT_SECRET)
                .enqueue(new Callback <WeatherResponse>() {
                    @Override
                    public void onResponse(Call <WeatherResponse> call, Response <WeatherResponse> response) {
                        Log.d("Retrofit call", "~~~~~~~~~~~onResponse:~~~~~~~~~~~~~ ");
                        responseList = response.body().getResponse();
                        Log.d("~~~~~~~~~~~~~~~~~~~~~~~", responseList.get(0).getProfile().getTz());
                        jobFinished(params, false);
                    }

                    @Override
                    public void onFailure(Call <WeatherResponse> call, Throwable t) {
                        Log.d("Retrofit call", "~~~~~~~~~~~onFailure:~~~~~~~~~~~~~ ");
                        t.printStackTrace();
                        jobFinished(params, true);

                    }
                });

    }
}
