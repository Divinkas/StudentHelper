package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Para")
public class Para {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int kodPredm;
    public int kodTeacher;
    public String timeStart;
    public String timeEnd;


}
