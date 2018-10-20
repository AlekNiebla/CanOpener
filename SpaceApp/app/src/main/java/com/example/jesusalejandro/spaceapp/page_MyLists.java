package com.example.jesusalejandro.spaceapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class page_MyLists extends android.support.v4.app.Fragment {


    TextView textView;

    public page_MyLists() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page_nat_disaster_layout, container, false);
        textView = (TextView) view.findViewById(R.id.TextPruebaLists);

        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));

        return view;
    }

    public static page_MyLists newInstance() {
        page_MyLists fragment = new page_MyLists();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}
