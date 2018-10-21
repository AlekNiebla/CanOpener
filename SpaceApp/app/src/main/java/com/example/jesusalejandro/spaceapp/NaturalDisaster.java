package com.example.jesusalejandro.spaceapp;

import android.os.Parcel;
import android.os.Parcelable;

public class NaturalDisaster implements Parcelable {
    private int image;
    private String name;
    private String description;

    public NaturalDisaster(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected NaturalDisaster(Parcel in) {
        this.image = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<NaturalDisaster> CREATOR = new Parcelable.Creator<NaturalDisaster>() {
        @Override
        public NaturalDisaster createFromParcel(Parcel source) {
            return new NaturalDisaster(source);
        }

        @Override
        public NaturalDisaster[] newArray(int size) {
            return new NaturalDisaster[size];
        }
    };
}
