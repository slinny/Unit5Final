package nyc.muaadh_melhi_develpoer.aerisweather;

import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by C4Q on 2/5/18.
 */

public class Location implements LocationListener{

    double latitude;
    double longitude;



    @Override
    public void onLocationChanged(android.location.Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("Latitude","status");
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


}
