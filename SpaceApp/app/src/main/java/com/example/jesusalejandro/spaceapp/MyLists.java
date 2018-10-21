package com.example.jesusalejandro.spaceapp;

public class MyLists {

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
}
