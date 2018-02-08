package nyc.muaadh_melhi_develpoer.aerisweather;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Notification extends IntentService {

    private static final int NOTIFICATION_ID = 000;
    private static String NOTIFICATION_CHANNEL = "Weather Update";

    private static final String SERVICE_NAME = "notification-service";


            int requestID = (int) System.currentTimeMillis();
            int flags = PendingIntent.FLAG_CANCEL_CURRENT;


    public Notification() {super(SERVICE_NAME);}


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        Intent i = new Intent(this, MainActivity.class);

        int requestID = (int) System.currentTimeMillis();

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;


        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this );
        taskStackBuilder.addParentStack(MainActivity.class);
        taskStackBuilder.addNextIntent(intent);



        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);



                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.freezingrain)
                .setContentTitle("Weather Notification")
                .setContentText("Weather in your area")
                .setTicker("Alert New Notification")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    }





}
