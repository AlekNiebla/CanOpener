package com.example.jesusalejandro.spaceapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SwipeAdapter extends FragmentPagerAdapter {

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragmentMyLists = new MyListsFragment();
        Fragment fragmentDisasters = new DisasterListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count",i+1);
        fragmentDisasters.setArguments(bundle);
        fragmentMyLists.setArguments(bundle);
        return fragmentDisasters;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
