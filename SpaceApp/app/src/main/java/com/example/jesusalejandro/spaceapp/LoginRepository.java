package com.example.jesusalejandro.spaceapp;

import io.reactivex.Single;

public interface LoginRepository {
    Single<Boolean> getLogin(User user);
    Single<User> getRegister(User user);
}
