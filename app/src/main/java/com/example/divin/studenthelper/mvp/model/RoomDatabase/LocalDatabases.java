package com.example.divin.studenthelper.mvp.model.RoomDatabase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.example.divin.studenthelper.mvp.model.Data.CategoryStudents;
import com.example.divin.studenthelper.mvp.model.Data.Days;
import com.example.divin.studenthelper.mvp.model.Data.Group;
import com.example.divin.studenthelper.mvp.model.Data.Para;
import com.example.divin.studenthelper.mvp.model.Data.Predmet;
import com.example.divin.studenthelper.mvp.model.Data.Rozklad;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;
import com.example.divin.studenthelper.mvp.model.Data.TypeZn;

@Database(entities = {CategoryStudents.class, Days.class, Group.class, Para.class,
            Predmet.class, Rozklad.class, Teacher.class, TypeZn.class},
            version = 1,
            exportSchema = false)
public abstract class LocalDatabases extends RoomDatabase {
    public abstract IbaseDao ibaseDao();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
