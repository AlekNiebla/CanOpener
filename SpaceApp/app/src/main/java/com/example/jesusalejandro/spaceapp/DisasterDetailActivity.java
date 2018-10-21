package com.example.jesusalejandro.spaceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DisasterDetailActivity extends AppCompatActivity
        implements SurfaceHolder.Callback, DisasterDetailContract.View,
        CheckListAdapter.CheckListListener, ImageDisplayAdapter.ImageListener {

    private SurfaceView video;
    private SurfaceHolder holder;
//    private TextView name;
    private TextView description;
//    private ImageView icon;
    private RecyclerView actions;
    private RecyclerView supplies;
    private RecyclerView images;
    private Toolbar toolbar;
    private MediaPlayer player;
    private Boolean hasActiveHolder = false;
    private DisasterDetailContract.Presenter presenter;
    private CheckListAdapter actionsAdapter;
    private CheckListAdapter suppliesAdapter;
    private ImageDisplayAdapter imagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster_detail);

        NaturalDisaster disaster = new NaturalDisaster(R.drawable.ic_flood, "Flood", "A flood is an overflow of water on land which is usually dry. Sometimes a water resource (river, lake or pond) gets flushed with too much water. Unusually heavy rain sometimes causes floods.");

        presenter = new DisasterDetailPresenter(this, new DisasterRepoImpl());
        video = findViewById(R.id.surfaceView);
//        name = findViewById(R.id.disaster_name);
        description = findViewById(R.id.description);
//        icon = findViewById(R.id.disaster_icon);
        holder = video.getHolder();
        holder.addCallback(this);
        actions = findViewById(R.id.action_items);
        supplies = findViewById(R.id.supplies);
        images = findViewById(R.id.images);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle(disaster.getName());
//        toolbar.setNavigationIcon(disaster.getImage());

        player = MediaPlayer.create(this, R.raw.flood);
        player.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        player.setScreenOnWhilePlaying(true);
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        setSupportActionBar(toolbar);

//        name.setText(disaster.getName());
        description.setText(disaster.getDescription());
//        icon.setImageResource(R.drawable.ic_flood);

        actionsAdapter = new CheckListAdapter(this);
        suppliesAdapter = new CheckListAdapter(this);
        imagesAdapter = new ImageDisplayAdapter(this);
        actions.setLayoutManager(new LinearLayoutManager(this));
        supplies.setLayoutManager(new LinearLayoutManager(this));
        images.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        actions.setAdapter(actionsAdapter);
        supplies.setAdapter(suppliesAdapter);
        images.setAdapter(imagesAdapter);

        presenter.getActionItems(disaster);
        presenter.getSupplies(disaster);
        presenter.getImages(disaster);
//        play();



    }

//    private void play(){
//        synchronized (this){
//            while (!hasActiveHolder){
//                try{
//                    this.wait();
//                } catch (InterruptedException e){
//                    //Todo
//                }
//            }
//        }
//    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        synchronized (this){
            hasActiveHolder = true;
            player.setDisplay(holder);
            player.start();
            this.notifyAll();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        synchronized (this){
            hasActiveHolder = false;
            this.notifyAll();
        }
    }

    @Override
    public void showVideo(String url) {

    }

    @Override
    public void showActionItems(List<String> items) {
        actionsAdapter.update(items);
    }

    @Override
    public void showSupplies(List<String> supplies) {
        suppliesAdapter.update(supplies);
    }

    @Override
    public void showImages(List<DisasterImage> images) {
        imagesAdapter.update(images);
    }

    @Override
    public void onItemClicked(String item, int position, boolean isChecked) {

    }

    @Override
    public void onAddListSelected() {

    }

    @Override
    public void onImageClick(DisasterImage image) {

    }
}
