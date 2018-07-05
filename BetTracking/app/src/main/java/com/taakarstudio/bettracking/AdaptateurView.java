package com.taakarstudio.bettracking;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdaptateurView extends RecyclerView.Adapter<ViewHolder> {

    public List<DataBookmaker> dataBookmakers;

    public AdaptateurView(List<DataBookmaker> dataBookmakers){
        this.dataBookmakers = dataBookmakers;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataBookmaker myObject = dataBookmakers.get(position);
        holder.chargerParDataBookmaker(myObject);
    }


    @Override
    public int getItemCount() {
        return dataBookmakers.size();
    }
}
