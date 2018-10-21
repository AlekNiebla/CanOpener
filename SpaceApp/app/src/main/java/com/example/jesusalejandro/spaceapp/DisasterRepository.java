package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;

public interface DisasterRepository {
    Single<List<NaturalDisaster>> getDisasters();
}
