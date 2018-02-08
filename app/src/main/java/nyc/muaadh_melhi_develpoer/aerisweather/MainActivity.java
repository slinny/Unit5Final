package nyc.muaadh_melhi_develpoer.aerisweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.muaadh_melhi_develpoer.aerisweather.background.MyJobScheduler;


public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 000;
    private static String NOTIFICATION_CHANNEL = "Weather Update";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyJobScheduler.start(getApplicationContext());

        Intent i = new Intent(this, Notification.class);
        startService(i);

    }


}
