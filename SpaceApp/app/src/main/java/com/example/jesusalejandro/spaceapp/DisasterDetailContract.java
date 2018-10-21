package com.example.jesusalejandro.spaceapp;

import java.util.List;

public interface DisasterDetailContract {
    interface View{
        void showVideo(String url);
        void showActionItems(List<String> items);
        void showSupplies(List<String> supplies);
        void showImages(List<DisasterImage> images);
    }

    interface Presenter{
        void getSupplies(NaturalDisaster disaster);
        void getActionItems(NaturalDisaster disaster);
        void getImages(NaturalDisaster disaster);
        void getVideo(NaturalDisaster disaster);
        void doOnDestroyed();
    }
}
