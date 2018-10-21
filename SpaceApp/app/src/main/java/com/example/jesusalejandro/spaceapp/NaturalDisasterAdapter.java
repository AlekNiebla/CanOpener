package com.example.jesusalejandro.spaceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NaturalDisasterAdapter extends RecyclerView.Adapter<NaturalDisasterAdapter.NaturalDisasterHolder> {

    private List<NaturalDisaster> disasters = new ArrayList<>();
    private DisasterListListener listener;


    public NaturalDisasterAdapter(DisasterListListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NaturalDisasterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.holder_natural_disaster, viewGroup, false);
        return new NaturalDisasterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NaturalDisasterHolder naturalDisasterHolder, int i) {
        naturalDisasterHolder.bindView(disasters.get(i));
    }

    @Override
    public int getItemCount() {
        return disasters.size();
    }

    public void update(List<NaturalDisaster> disasters){
        this.disasters.clear();
        this.disasters.addAll(disasters);
        notifyDataSetChanged();
    }

    class NaturalDisasterHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        ImageView icon;

        NaturalDisasterHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            icon = itemView.findViewById(R.id.disaster_icon);
        }

        void bindView(final NaturalDisaster disaster){
            title.setText(disaster.getName());
            description.setText(disaster.getDescription());
            icon.setImageResource(disaster.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDisasterSelected(disaster);
                }
            });
        }
    }

    interface DisasterListListener{
        void onDisasterSelected(NaturalDisaster disaster);
    }
}
