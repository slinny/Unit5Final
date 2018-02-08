package nyc.muaadh_melhi_develpoer.aerisweather;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by AmyRivera on 2/7/18.
 */

public class BootBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context, Notification.class);
        startWakefulService(context, startServiceIntent);

    }
}
