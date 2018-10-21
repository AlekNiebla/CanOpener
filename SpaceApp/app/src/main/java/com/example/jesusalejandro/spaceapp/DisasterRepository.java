package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;

public interface DisasterRepository {
    Single<List<NaturalDisaster>> getDisasters();
    Single<List<String>> getActionItems(NaturalDisaster disaster);
    Single<List<String>> getSupplies(NaturalDisaster disaster);
    Single<List<DisasterImage>> getImages(NaturalDisaster disaster);
}
