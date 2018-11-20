package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Teacher")
public class Teacher {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String PIB;
    public String image;
    public String mail;
    public double rating;
}
