package nyc.muaadh_melhi_develpoer.aerisweather.recyclerView_helper;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.muaadh_melhi_develpoer.aerisweather.model.AerisResponse;

/**
 * Created by c4q on 2/5/18.
 */

public class AerisAdapter extends RecyclerView.Adapter<AerisViewHolder> {
    List<AerisResponse> responseList = new ArrayList<>();

    public AerisAdapter(List<AerisResponse> responseList) {
        this.responseList = responseList;
    }

    @Override
    public AerisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AerisViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }
}
