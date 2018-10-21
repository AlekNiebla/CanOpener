package com.example.jesusalejandro.spaceapp;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {
    @POST("user/new")
    Single<User> register(@Body User user);

    @GET("user/login")
    Single<Boolean> login(@Query("email") String email, @Query("password") String password);
}
