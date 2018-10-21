package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListsService {
    @GET("containers")
    Single<List<Container>> getContainers(@Query("userEmail") String email);
}
