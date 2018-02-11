package nyc.muaadh_melhi_develpoer.aerisweather;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AerisNotification extends IntentService {

    private static final int NOTIFICATION_ID = 000;
    private static String NOTIFICATION_CHANNEL = "Weather Update";

    private static final String SERVICE_NAME = "notification-service";
    int requestID = (int) System.currentTimeMillis();
    int flags = PendingIntent.FLAG_CANCEL_CURRENT;

    public AerisNotification() {
        super(SERVICE_NAME);
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent weatherIntent = new Intent(this, MainActivity.class);
        int requestID = (int) System.currentTimeMillis();
        int flags = PendingIntent.FLAG_CANCEL_CURRENT;
       PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, weatherIntent, flags);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.noticication_icon)
                .setContentTitle("Weather AerisNotification")
                .setContentText("Weather in your area")
                .setTicker("Alert New AerisNotification")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        if (Build.VERSION.SDK_INT >= 21) notificationBuilder.setVibrate(new long[0]);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    }


}
