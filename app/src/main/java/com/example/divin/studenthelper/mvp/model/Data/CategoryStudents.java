package com.example.divin.studenthelper.mvp.model.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "CategoryStudents")
public class CategoryStudents {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nm;
}
