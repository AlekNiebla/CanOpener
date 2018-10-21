package com.example.jesusalejandro.spaceapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MyLists implements Parcelable {

    private String name;
    private String userEmail;
    private long id;
    private List<Item> items;

    public MyLists(String name, String userEmail, long id, List<Item> items) {
        this.name = name;
        this.userEmail = userEmail;
        this.id = id;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.userEmail);
        dest.writeLong(this.id);
        dest.writeList(this.items);
    }

    protected MyLists(Parcel in) {
        this.name = in.readString();
        this.userEmail = in.readString();
        this.id = in.readLong();
        this.items = new ArrayList<Item>();
        in.readList(this.items, Item.class.getClassLoader());
    }

    public static final Creator<MyLists> CREATOR = new Creator<MyLists>() {
        @Override
        public MyLists createFromParcel(Parcel source) {
            return new MyLists(source);
        }

        @Override
        public MyLists[] newArray(int size) {
            return new MyLists[size];
        }
    };
}
