package nyc.muaadh_melhi_develpoer.aerisweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.muaadh_melhi_develpoer.aerisweather.Interface.AerisService;
import nyc.muaadh_melhi_develpoer.aerisweather.background.MyJobScheduler;
import nyc.muaadh_melhi_develpoer.aerisweather.common.Common;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;
import nyc.muaadh_melhi_develpoer.aerisweather.model.WeatherResponse;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyJobScheduler.start(getApplicationContext());

    }


}
