package nyc.muaadh_melhi_develpoer.aerisweather.recyclerView_helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.muaadh_melhi_develpoer.aerisweather.R;
import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;

/**
 * Created by c4q on 2/5/18.
 */

class AerisViewHolder extends RecyclerView.ViewHolder {


    TextView tempHour;
    TextView tempAtHour;
    ImageView rvIcon;

    public AerisViewHolder(View itemView) {
        super(itemView);


        tempHour = (TextView) itemView.findViewById(R.id.hour);
        tempAtHour = (TextView) itemView.findViewById(R.id.hourlyTemp);
        rvIcon = (ImageView) itemView.findViewById(R.id.rvIcon);
    }
    public void onBind(AerisResponse response) {

      /*  tempHour.setText(response.);
        tempAtHour.setText(response.);
        rvIcon.setImageDrawable(response.); */
    }
}
