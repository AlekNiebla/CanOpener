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
}
