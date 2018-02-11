package nyc.muaadh_melhi_develpoer.aerisweather.recyclerView_helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.muaadh_melhi_develpoer.aerisweather.R;
import nyc.muaadh_melhi_develpoer.aerisweather.database.WeatherModel;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;
import nyc.muaadh_melhi_develpoer.aerisweather.utility.TimeFormat;

/**
 * Created by c4q on 2/5/18.
 */

class AerisViewHolder extends RecyclerView.ViewHolder {

    TextView hour;
    TextView tempF;
    ImageView rvIcon;

    public AerisViewHolder(View itemView) {
        super(itemView);
        hour = (TextView) itemView.findViewById(R.id.hour);
        tempF = (TextView) itemView.findViewById(R.id.hourlyTemp);
        rvIcon = (ImageView) itemView.findViewById(R.id.rvIcon);
    }

    public void onBind(WeatherModel response) {
        String hr = response.getDateTimeISO();
        if (getAdapterPosition() == 0) {
            hr = "Now";
        } else if (Integer.parseInt(hr) == 0 && getAdapterPosition() != 0) {
            hr = "" + 12;
        }

        hour.setText(hr);
        tempF.setText("" + response.getTempF());
        String icon = response.getIcon();
        Drawable drawable = getIcon(itemView.getContext(), icon);
        rvIcon.setBackground(drawable);
    }

    private Drawable getIcon(Context context, String icon) {
        Resources resources = context.getResources();
        Drawable drawable;
        String uri = "@drawable/" + icon;
        uri = uri.replace(".png", "");
        int imageResource = resources.getIdentifier(uri, null, context.getPackageName());
        drawable = resources.getDrawable(imageResource, null);
        return drawable;
    }
}
