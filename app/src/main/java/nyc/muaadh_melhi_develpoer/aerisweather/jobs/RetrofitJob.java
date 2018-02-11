package nyc.muaadh_melhi_develpoer.aerisweather.jobs;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.PersistableBundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.muaadh_melhi_develpoer.aerisweather.GPSTracker;
import nyc.muaadh_melhi_develpoer.aerisweather.AerisNotification;
import nyc.muaadh_melhi_develpoer.aerisweather.Interface.AerisService;
import nyc.muaadh_melhi_develpoer.aerisweather.MainActivity;
import nyc.muaadh_melhi_develpoer.aerisweather.common.Common;
import nyc.muaadh_melhi_develpoer.aerisweather.database.WeatherDatabase;
import nyc.muaadh_melhi_develpoer.aerisweather.database.WeatherModel;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisPeriod;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;
import nyc.muaadh_melhi_develpoer.aerisweather.model.WeatherResponse;
import nyc.muaadh_melhi_develpoer.aerisweather.utility.TimeFormat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by c4q on 2/4/18.
 */

public class RetrofitJob extends JobService {
    private static final String TAG = RetrofitJob.class.getSimpleName();
    private List<AerisResponse> responseList = new ArrayList<>();
    GPSTracker gps;
    double latitude;
    double longitude;
    private Intent intent;

    @Override
    public boolean onStartJob(JobParameters params) {
        /**
         * Create Retorfit call
         */
        AerisService aerisService = Common.getForecast();
        loadForecast(aerisService, params);
        intent = new Intent(getApplicationContext(), AerisNotification.class);
        startService(intent);
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
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        Log.d("Retrofit call", "~~~~~~~~~~~onResponse:~~~~~~~~~~~~~ ");
                        responseList = response.body().getResponse();
                        Log.d("~~~~~~~~~~~~~~~~~~~~~~~", responseList.get(0).getProfile().getTz());
                        insertData(responseList);
                        jobFinished(params, false);
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        Log.d("Retrofit call", "~~~~~~~~~~~onFailure:~~~~~~~~~~~~~ ");
                        t.printStackTrace();
                        jobFinished(params, true);

                    }
                });
    }

    public void insertData(List<AerisResponse> responseList) {
        WeatherDatabase db = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class, "WeatherDataBase")
                .allowMainThreadQueries().build();
        Log.d(TAG, "insertData: ");

        for (int i = 0; i < responseList.get(0).getPeriods().size(); i++) {
            Log.d(TAG, "insertData: ");
            String date = responseList.get(0).getPeriods().get(i).getDateTimeISO();
            String dateTimeISO = TimeFormat.getTime(date);
            Double _long = responseList.get(0).getLoc().get_long();
            Double lat = responseList.get(0).getLoc().getLat();
            String weatherPrimary = responseList.get(0).getPeriods().get(i).getWeatherPrimary();
            int maxTempF = responseList.get(0).getPeriods().get(i).getMaxTempF();
            int minTempF = responseList.get(0).getPeriods().get(i).getMinTempF();
            int humidity = responseList.get(0).getPeriods().get(i).getHumidity();
            int tempF = responseList.get(0).getPeriods().get(i).getTempF();
            int windSpeedMPH = responseList.get(0).getPeriods().get(i).getWindSpeedMPH();
            Long sunrise = responseList.get(0).getPeriods().get(i).getSunrise();
            Long sunset = responseList.get(0).getPeriods().get(i).getSunset();
            String weather = responseList.get(0).getPeriods().get(i).getWeather();
            String tz = responseList.get(0).getProfile().getTz();
            String icon=responseList.get(0).getPeriods().get(i).getIcon();

            db.weatherDao().insertAll(new WeatherModel(dateTimeISO, _long, lat, weatherPrimary, maxTempF, minTempF, humidity, tempF, windSpeedMPH, sunrise, sunset, weather, tz,icon));
            Log.d("insertData: ", "insert good~~~~~~~~~~"+i);
        }
        Log.d("size db= ", ""+db.weatherDao().countWeather());
    }
}
