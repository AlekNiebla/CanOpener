package com.example.jesusalejandro.spaceapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MyLists implements Parcelable {

    private String title;
    private int id;

    public MyLists(){
        title="";
        id=0;
    }

    public MyLists(int id, String listTitle)
    {
        id=0;
        title=listTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.id);
    }

    protected MyLists(Parcel in) {
        this.title = in.readString();
        this.id = in.readInt();
    }

    public static final Parcelable.Creator<MyLists> CREATOR = new Parcelable.Creator<MyLists>() {
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
