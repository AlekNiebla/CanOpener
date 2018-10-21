package com.example.jesusalejandro.spaceapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.TextView;

public class DisasterDetailActivity extends AppCompatActivity {

    private SurfaceView video;
    private TextView name;
    private TextView description;
    private ImageView icon;
    private RecyclerView actions;
    private RecyclerView supplies;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_detail);

        player = MediaPlayer.create(this, R.raw.flood);
        player.start();

    }
}
