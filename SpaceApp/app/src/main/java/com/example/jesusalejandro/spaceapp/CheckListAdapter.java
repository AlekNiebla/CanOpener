package com.example.jesusalejandro.spaceapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CheckListAdapter extends RecyclerView.Adapter {

    private List<String> items = new ArrayList<>();
    private CheckListListener listener;

    public CheckListAdapter(CheckListListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < items.size()) return 0;
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        if (i == 0) {
            View view = inflater.inflate(R.layout.holder_checkable_item, viewGroup, false);
            return new CheckItem(view);
        } else {
            View view = inflater.inflate(R.layout.holder_export_list, viewGroup, false);
            return new AddListItem(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if (i != items.size()) ((CheckItem)holder).bindData(items.get(i), i);
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

    void update(List<String> items){
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    class CheckItem extends RecyclerView.ViewHolder{

        CheckBox checkBox;

        public CheckItem(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }

        void bindData(final String item, final int position){
            checkBox.setText(item);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    listener.onItemClicked(item, position, isChecked);
                }
            });
        }
    }

    class AddListItem extends RecyclerView.ViewHolder{


        public AddListItem(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onAddListSelected();
                }
            });
        }
    }

    interface CheckListListener{
        void onItemClicked(String item, int position, boolean isChecked);
        void onAddListSelected();
    }

}
