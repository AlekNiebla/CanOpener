package com.example.jesusalejandro.spaceapp;

import android.content.Context;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.List;


public class MyListsFragment extends Fragment implements MyListsContract.View, MyListsAdapter.MyListsListener {


    private RecyclerView recycleLists;
    private MyListsAdapter adapter;
    private MyListsFragmentListener listener;
    private MyListsPresenter presenter;

    public MyListsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page__my_lists, container, false);
        presenter = new MyListsPresenter(new MyListsRepoImpl(), this);//Check this
        adapter = new MyListsAdapter(this);
        recycleLists = view.findViewById(R.id.lists_rv);
        recycleLists.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleLists.setAdapter(adapter);
        presenter.getMyLists();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof MyListsFragmentListener) {
            listener = (MyListsFragmentListener) getActivity();
        } else {
            throw new IllegalStateException("Must implement" + MyListsFragmentListener.class.getName());
        }

    }


    // TODO: Rename and change types and number of parameters
    public static MyListsFragment newInstance() {
        MyListsFragment fragment = new MyListsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showMyLists(List<Container> lists) {
        adapter.update(lists);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }


    interface MyListsFragmentListener {
        void onListSelected(Container list);
    }

    @Override
    public void onListSelected(Container list) {
        listener.onListSelected(list);
    }

}
