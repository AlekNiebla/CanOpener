package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;

public interface MyListsContract {
    interface View{
        void showMyLists(List<MyLists> lists);
        void showError(String error);
    }

    interface Presenter{
        void getDisasters();
        void doOnDestroy();
    }
}
