package nyc.muaadh_melhi_develpoer.aerisweather;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import nyc.muaadh_melhi_develpoer.aerisweather.background.MyJobScheduler;
import nyc.muaadh_melhi_develpoer.aerisweather.database.WeatherDatabase;
import nyc.muaadh_melhi_develpoer.aerisweather.database.WeatherModel;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;
import nyc.muaadh_melhi_develpoer.aerisweather.recyclerView_helper.AerisAdapter;
import nyc.muaadh_melhi_develpoer.aerisweather.utility.TimeFormat;


public class MainActivity extends AppCompatActivity {
    private Snackbar snackbar;
    private WeatherDatabase db;

    Toolbar img;
    RecyclerView recyclerView;
    private List<WeatherModel> responseList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //get the data from Db=respneslist

        db = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class, "WeatherDataBase")
                .allowMainThreadQueries().build();
        MyJobScheduler.start(getApplicationContext());
        responseList = db.weatherDao().getAll();
        AerisAdapter aerisAdapter = new AerisAdapter(responseList);
        recyclerView.setAdapter(aerisAdapter);
        Log.d("onCreate: ", "" + responseList.size());
        if (!isNetworkAvailable()) {
            snakBar();
        }

        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        img = (Toolbar) findViewById(R.id.tool_bar);
        img.setBackgroundResource(R.drawable.weather_animation);
        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
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