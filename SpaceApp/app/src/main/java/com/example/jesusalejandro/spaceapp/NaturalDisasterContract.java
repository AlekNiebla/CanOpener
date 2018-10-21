package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;

public interface NaturalDisasterContract {
    interface View{
        void showDisasters(List<NaturalDisaster> disasters);
        void showError(String error);
    }

    interface Presenter{
        void getDisasters();
        void doOnDestroy();
    }
}
