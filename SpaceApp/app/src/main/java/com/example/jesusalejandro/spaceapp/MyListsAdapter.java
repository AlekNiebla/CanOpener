package com.example.jesusalejandro.spaceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyListsAdapter extends RecyclerView.Adapter<MyListsAdapter.ViewHolderLists> {

    private List<Container> mylists = new ArrayList<>();
    private MyListsListener listener;

    public MyListsAdapter(MyListsListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolderLists onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.holder_mylist_listelement, viewGroup, false);
        return new ViewHolderLists(view);
    }

    @Override
    public void onBindViewHolder(MyListsAdapter.ViewHolderLists viewHolderLists, int i) {
        viewHolderLists.bindView(mylists.get(i));
    }

    @Override
    public int getItemCount() {
        return mylists.size();
    }

    public void update(List<Container> lists) {
        this.mylists.clear();
        this.mylists.addAll(lists);
        notifyDataSetChanged();
    }

    class ViewHolderLists extends RecyclerView.ViewHolder {

        TextView listTitle, BtnProvisions, BtnPlans;

        public ViewHolderLists(View itemView) {

            super(itemView);
            listTitle = itemView.findViewById(R.id.id_mylist_titulo);
            BtnProvisions = itemView.findViewById(R.id.btn_Provision);
            BtnPlans = itemView.findViewById(R.id.btn_Plans);


        }

        void bindView(final Container mylists) {
            listTitle.setText(mylists.getDisasterName());

            BtnProvisions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onListSelected(mylists);
                }
            });

            BtnPlans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onListSelected(mylists);
                }
            });
        }


    }

    interface MyListsListener {
        void onListSelected(Container list);
    }


}
