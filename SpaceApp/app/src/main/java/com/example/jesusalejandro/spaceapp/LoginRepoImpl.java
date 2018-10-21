package com.example.jesusalejandro.spaceapp;

import io.reactivex.Single;

public class LoginRepoImpl implements LoginRepository {
    @Override
    public Single<Boolean> getLogin(User user) {
        return Single.just(true);
    }

    @Override
    public Single<User> getRegister(User user) {
        return Single.just(user);
    }
}
