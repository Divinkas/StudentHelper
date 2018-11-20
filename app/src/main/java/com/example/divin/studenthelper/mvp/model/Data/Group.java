package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Group")
public class Group {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int Name;

}
