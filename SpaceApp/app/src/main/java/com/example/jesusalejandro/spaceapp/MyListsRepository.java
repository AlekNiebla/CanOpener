package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;

public interface MyListsRepository {
    Single<List<MyLists>> getMyLists();
    Single<List<String>> getActionItems(NaturalDisaster disaster);
    Single<List<String>> getSupplies(NaturalDisaster disaster);
}
