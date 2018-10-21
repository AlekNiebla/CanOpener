package com.example.jesusalejandro.spaceapp;

public class MyLists {

    private String title;

    public MyLists(){
        title="";

    }

    public MyLists(String listTitle)
    {
        title=listTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
