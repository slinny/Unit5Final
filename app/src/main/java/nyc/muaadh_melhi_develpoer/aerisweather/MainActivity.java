package nyc.muaadh_melhi_develpoer.aerisweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Location location = new Location();
        location.getLatitude();
        location.getLongitude();
        Log.d("laittude", String.valueOf(location.getLatitude()));
        Log.d("longtitude",String.valueOf(location.getLongitude()));

    }

//    public void goToMapActivity(View view){
//        Intent intent = new Intent(this, MapsActivity.class);
//        startActivity(intent);
//    }


}