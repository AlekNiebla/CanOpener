package com.example.jesusalejandro.spaceapp;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class MyListsRepoImpl implements MyListsRepository {
    @Override
    public Single<List<MyLists>> getMyLists() {
        List<MyLists> lists = new ArrayList<>();
        lists.add(new MyLists(1, "Flood"));
        lists.add(new MyLists(2, "Earthquake"));
        lists.add(new MyLists(3, "Drought"));
        lists.add(new MyLists(4, "Hurricane"));
        lists.add(new MyLists(5, "Comet"));
        return Single.just(lists);
    }

    @Override
    public Single<List<String>> getActionItems(NaturalDisaster disaster) {
        return null;
    }

    @Override
    public Single<List<String>> getSupplies(NaturalDisaster disaster) {
        return null;
    }
}
