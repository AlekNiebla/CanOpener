package com.example.jesusalejandro.spaceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImageDisplayAdapter extends RecyclerView.Adapter<ImageDisplayAdapter.ImageHolder> {

    private List<DisasterImage> images = new ArrayList<>();
    private ImageListener listener;

    public ImageDisplayAdapter(ImageListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.holder_image, viewGroup, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder imageHolder, int i) {
        imageHolder.bindData(images.get(i));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    void update(List<DisasterImage> images){
        this.images.clear();
        this.images.addAll(images);
        notifyDataSetChanged();
    }

    class ImageHolder extends RecyclerView.ViewHolder{

        private ImageView image;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }

        void bindData(final DisasterImage image){
            this.image.setImageResource(image.getResource());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onImageClick(image);
                }
            });
        }
    }

    interface ImageListener{
        void onImageClick(DisasterImage image);
    }
}
