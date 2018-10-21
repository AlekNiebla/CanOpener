package com.example.jesusalejandro.spaceapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return pageNatDisaster.newInstance();
            case 1:
                return MyListsFragment.newInstance();
            default:
                throw new IllegalStateException("There can't be more than 2 tabs");
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}