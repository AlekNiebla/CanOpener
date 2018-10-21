package com.example.jesusalejandro.spaceapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Container implements Parcelable {
    private long id;
    private String email;
    private String disasterName;
    private MyLists actionCheckLis;
    private MyLists itemCheckLis;

    public Container(long id, String email, String disasterName, MyLists actionCheckLis, MyLists itemCheckLis) {
        this.id = id;
        this.email = email;
        this.disasterName = disasterName;
        this.actionCheckLis = actionCheckLis;
        this.itemCheckLis = itemCheckLis;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisasterName() {
        return disasterName;
    }

    public void setDisasterName(String disasterName) {
        this.disasterName = disasterName;
    }

    public MyLists getActionCheckLis() {
        return actionCheckLis;
    }

    public void setActionCheckLis(MyLists actionCheckLis) {
        this.actionCheckLis = actionCheckLis;
    }

    public MyLists getItemCheckLis() {
        return itemCheckLis;
    }

    public void setItemCheckLis(MyLists itemCheckLis) {
        this.itemCheckLis = itemCheckLis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.email);
        dest.writeString(this.disasterName);
        dest.writeParcelable(this.actionCheckLis, flags);
        dest.writeParcelable(this.itemCheckLis, flags);
    }

    protected Container(Parcel in) {
        this.id = in.readLong();
        this.email = in.readString();
        this.disasterName = in.readString();
        this.actionCheckLis = in.readParcelable(MyLists.class.getClassLoader());
        this.itemCheckLis = in.readParcelable(MyLists.class.getClassLoader());
    }

    public static final Parcelable.Creator<Container> CREATOR = new Parcelable.Creator<Container>() {
        @Override
        public Container createFromParcel(Parcel source) {
            return new Container(source);
        }

        @Override
        public Container[] newArray(int size) {
            return new Container[size];
        }
    };
}
