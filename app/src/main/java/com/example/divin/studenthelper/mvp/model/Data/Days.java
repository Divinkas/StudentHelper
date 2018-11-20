package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Days")
public class Days {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String Name;
}
