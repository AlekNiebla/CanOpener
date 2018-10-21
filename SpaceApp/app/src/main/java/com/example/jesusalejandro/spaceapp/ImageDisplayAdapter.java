package com.example.jesusalejandro.spaceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ImageDisplayAdapter extends RecyclerView.Adapter<ImageDisplayAdapter.ImageHolder> {

    List<DisasterImage> images = new ArrayList<>();

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.holder_image, viewGroup, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder imageHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ImageHolder extends RecyclerView.ViewHolder{

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
        }


        void bindData(DisasterImage image){

        }
    }
}
