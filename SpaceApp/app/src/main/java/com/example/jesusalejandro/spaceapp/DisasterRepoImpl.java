package com.example.jesusalejandro.spaceapp;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class DisasterRepoImpl implements DisasterRepository {
    @Override
    public Single<List<NaturalDisaster>> getDisasters() {
        List<NaturalDisaster> disasters = new ArrayList<>();
        disasters.add(new NaturalDisaster(R.drawable.ic_flood, "Flood", "A flood"));
        disasters.add(new NaturalDisaster(R.drawable.ic_comet, "Comet", "A Comet"));
        disasters.add(new NaturalDisaster(R.drawable.ic_earthquake, "Earthquake", "An earthquake"));
        disasters.add(new NaturalDisaster(R.drawable.ic_drought, "Drought", "A drought"));
        disasters.add(new NaturalDisaster(R.drawable.ic_fire, "Fire", "A fire"));
        disasters.add(new NaturalDisaster(R.drawable.ic_avalanche, "Avalanche", "An avalanche"));
        return Single.just(disasters);
    }

    @Override
    public Single<List<String>> getActionItems(NaturalDisaster disaster) {
        List<String> items = new ArrayList<>();
        items.add("Locate high ground");
        items.add("Save important documents in a waterproof container");
        items.add("Avoid valleys");
        items.add("Get your pet");
        return Single.just(items);
    }

    @Override
    public Single<List<String>> getSupplies(NaturalDisaster disaster) {
        List<String> items = new ArrayList<>();
        items.add("Clean water");
        items.add("Canned food");
        items.add("First-aid kit");
        items.add("Big flat surface or a boat");
        return Single.just(items);
    }
}
