package com.example.jesusalejandro.spaceapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyListsAdapter extends RecyclerView.Adapter<MyListsAdapter.ViewHolderLists> {

    private List<MyLists> mylists = new ArrayList<>();
    private MyListsListener listener;

    public MyListsAdapter(MyListsListener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolderLists onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.fragment_mylist_listelement,null,false);
        return new ViewHolderLists(view);
    }

    @Override
    public void onBindViewHolder(MyListsAdapter.ViewHolderLists viewHolderLists, int i) {
                viewHolderLists.listTittle.setText(mylists.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mylists.size();
    }

    public  class ViewHolderLists extends RecyclerView.ViewHolder {

        TextView listTittle;

        public ViewHolderLists(View itemView){

            super(itemView);
            listTittle= (TextView)itemView.findViewById(R.id.id_mylist_titulo);
        }
    }

    interface MyListsListener{
        void onListSelected(MyLists lists);
    }



}
