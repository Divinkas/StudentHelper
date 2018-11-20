package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Rozklad")
public class Rozklad {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int kodDay;
    public int kodNamePredm;
    public int kodTypeZn;
    public int kodPara;
    public int kodCategoryStudents;
    public String auditoriya;
    public boolean isActive;

}
