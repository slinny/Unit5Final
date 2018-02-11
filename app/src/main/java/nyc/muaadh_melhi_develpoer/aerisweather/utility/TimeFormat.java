package nyc.muaadh_melhi_develpoer.aerisweather.utility;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by C4Q on 2/10/18.
 */

public class TimeFormat {

    private static String formatedHour;
    private static int hour;

    public static String getTime(String dateTimeISO) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            Date dt = formatter.parse(dateTimeISO);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            hour = cal.get(Calendar.HOUR);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatedHour = String.valueOf(hour);
        return formatedHour;
    }
}
