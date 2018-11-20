package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Predmet")
public class Predmet {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String Name;

}
