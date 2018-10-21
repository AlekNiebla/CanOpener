package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;

public interface MyListsRepository {
    Single<List<Container>> getMyLists(String email);
    String getUserEmail();
    Single<List<String>> getActionItems(NaturalDisaster disaster);
    Single<List<String>> getSupplies(NaturalDisaster disaster);
}
