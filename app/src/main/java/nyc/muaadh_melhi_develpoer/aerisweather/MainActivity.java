package nyc.muaadh_melhi_develpoer.aerisweather;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import nyc.muaadh_melhi_develpoer.aerisweather.background.MyJobScheduler;
import nyc.muaadh_melhi_develpoer.aerisweather.database.WeatherDatabase;
import nyc.muaadh_melhi_develpoer.aerisweather.database.WeatherModel;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;
import nyc.muaadh_melhi_develpoer.aerisweather.utility.TimeFormat;


public class MainActivity extends AppCompatActivity {
    private Snackbar snackbar;
    private WeatherDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class, "WeatherDataBase")
                .allowMainThreadQueries().build();

        if (isNetworkAvailable()) {
            MyJobScheduler.start(getApplicationContext());
        } else {
            snakBar();

        }
    }

    // Check all conductivities whether available or not
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public void snakBar() {
        snackbar = Snackbar
                .make(findViewById(R.id.empty_space), "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }

}