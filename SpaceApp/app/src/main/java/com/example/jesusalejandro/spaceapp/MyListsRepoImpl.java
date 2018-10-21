package com.example.jesusalejandro.spaceapp;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyListsRepoImpl implements MyListsRepository {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private ListsService service = retrofit.create(ListsService.class);

    @Override
    public Single<List<Container>> getMyLists(String email) {
        List<Container> containers = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        items.add(new Item(1L, "Action 1", true));
        items.add(new Item(1L, "Action 2", true));
        items.add(new Item(1L, "Action 3", true));
        items.add(new Item(1L, "Action 4", true));
        containers.add(new Container(1, "ivan@ndp.com", "Flood",
                new MyLists("Provisions", "ivan@ndp.com", 1,items),
                new MyLists("Provisions", "ivan@ndp.com", 1,items)));
        containers.add(new Container(1, "ivan@ndp.com", "Comet",
                new MyLists("Provisions", "ivan@ndp.com", 1,items),
                new MyLists("Provisions", "ivan@ndp.com", 1,items)));
        containers.add(new Container(1, "ivan@ndp.com", "Hurricane",
                new MyLists("Provisions", "ivan@ndp.com", 1,items),
                new MyLists("Provisions", "ivan@ndp.com", 1,items)));
//        return service.getContainers(email);
        return Single.just(containers);
    }

    @Override
    public String getUserEmail() {
        return "ivan@ndp.com";
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
