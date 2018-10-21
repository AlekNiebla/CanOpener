package com.example.jesusalejandro.spaceapp;

import java.util.List;
import io.reactivex.Single;

public interface MyListsContract {
    interface View{
        void showMyLists(List<Container> lists);
        void showError(String error);
    }

    interface Presenter{
        void getMyLists();
        void doOnDestroy();
    }
}
