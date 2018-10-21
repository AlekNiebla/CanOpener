package com.example.jesusalejandro.spaceapp;

import android.os.Parcel;
import android.os.Parcelable;

class Item implements Parcelable {
    private Long id;
    private String itenName;
    private boolean isChecked;

    public Item(Long id, String itenName, boolean isChecked) {
        this.id = id;
        this.itenName = itenName;
        this.isChecked = isChecked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItenName() {
        return itenName;
    }

    public void setItenName(String itenName) {
        this.itenName = itenName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.itenName);
        dest.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
    }

    protected Item(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.itenName = in.readString();
        this.isChecked = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
