package com.example.jesusalejandro.spaceapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "lists")
public class ListsRoom {
    @PrimaryKey
    @ColumnInfo(name = "list_id")
    private String listId;

    @ColumnInfo(name = "list_name")
    private String listName;

    @ColumnInfo(name = "list_elements")
    private List<String> listElements;

    @ColumnInfo(name = "last_update")
    private Date listUpdate;

//    @Ignore
//    ListsRoom()


}
