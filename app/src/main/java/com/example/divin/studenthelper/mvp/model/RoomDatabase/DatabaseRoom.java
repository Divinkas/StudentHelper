package com.example.divin.studenthelper.mvp.model.RoomDatabase;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseRoom {
    private static LocalDatabases ourInstance;

    public static LocalDatabases getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = Room.databaseBuilder(context, LocalDatabases.class, "dbStudentHelper").build();
        }
        return ourInstance;
    }

    private DatabaseRoom() {
    }
}
