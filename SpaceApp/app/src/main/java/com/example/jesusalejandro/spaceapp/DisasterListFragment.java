package com.example.jesusalejandro.spaceapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisasterListFragment extends Fragment implements NaturalDisasterContract.View,
        NaturalDisasterAdapter.DisasterListListener {
    private RecyclerView disasters;
    private NaturalDisasterAdapter adapter;
    private NaturalDisasterFragmentListener listener;
    private DisasterPresenter presenter;

    public DisasterListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_nat_disaster_layout, container, false);
        presenter = new DisasterPresenter(new DisasterRepoImpl(), this);
        adapter = new NaturalDisasterAdapter();
        disasters = view.findViewById(R.id.disaster_list);
        disasters.setLayoutManager(new LinearLayoutManager(getContext()));
        disasters.setAdapter(adapter);
        presenter.getDisasters();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof NaturalDisasterFragmentListener) {
            listener = (NaturalDisasterFragmentListener) getActivity();
        } else {
            throw new IllegalStateException("Must implement" + NaturalDisasterFragmentListener.class.getName());
        }
    }

    public static DisasterListFragment newInstance(){
        DisasterListFragment fragment = new DisasterListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    interface NaturalDisasterFragmentListener{
        void onDisasterSelected(NaturalDisaster disaster);
    }

    @Override
    public void showDisasters(List<NaturalDisaster> disasters) {
        adapter.update(disasters);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDisasterSelected(NaturalDisaster disaster) {
        listener.onDisasterSelected(disaster);
    }
}
