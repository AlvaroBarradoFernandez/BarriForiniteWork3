package com.utad.barriforinitework3.Fortnite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.utad.barriforinitework3.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ForniteViewHolder> {


    private List<RankFortnite> mDataObject;

    public MyAdapter(List<RankFortnite> dataObject) {
        this.mDataObject = dataObject;
    }

    @Override
    public ForniteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.cell_recycleview, viewGroup, false);
        return new ForniteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ForniteViewHolder forniteViewHolder, int i) {
        final RankFortnite item = mDataObject.get(i);
        forniteViewHolder.txtLabel.setText(item.getLabel());
        forniteViewHolder.txtValue.setText(item.getDisplayValue());
        forniteViewHolder.txtRank.setText(item.getRank());

    }

    @Override
    public int getItemCount() {
        return mDataObject.size();
    }

    public class ForniteViewHolder extends RecyclerView.ViewHolder {

        private TextView txtLabel;
        private TextView txtValue;
        private TextView txtRank;

        public ForniteViewHolder(View itemView) {
            super(itemView);
            txtLabel = itemView.findViewById(R.id.label);
            txtValue = itemView.findViewById(R.id.value);
            txtRank = itemView.findViewById(R.id.rank);
        }
    }
}