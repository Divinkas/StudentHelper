package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "TypeZn")
public class TypeZn {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String Name;
}
