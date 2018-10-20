package com.example.jesusalejandro.spaceapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class pageNatDisaster extends android.support.v4.app.Fragment {
    TextView textView;


    public pageNatDisaster() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_page_nat_disaster_layout,container,false);
        textView = (TextView)view.findViewById(R.id.ptoTexto);

        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        textView.setText("VERGAAA "+message+" SwipeViewPage...");

        return view;
    }

}
