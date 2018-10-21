package com.example.jesusalejandro.spaceapp;

import io.reactivex.Single;

public interface LoginContract {

    interface View {
        void login(boolean isAuthorized);

        void register(User user);
    }

    interface Presenter {
        void login(User user);

        void register(User user);
    }

}
