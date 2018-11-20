package com.example.divin.studenthelper.mvp.model;

import android.content.Context;

import com.example.divin.studenthelper.callback.ISynchronizeCallback;
import com.example.divin.studenthelper.mvp.model.RoomDatabase.DatabaseRoom;
import com.example.divin.studenthelper.mvp.model.RoomDatabase.LocalDatabases;

import io.reactivex.Observable;
import io.reactivex.Observer;

import static com.example.divin.studenthelper.mvp.model.Constant.LOCAL_DATABASE_VERSION;

public class RoomModel implements ISynchronizeCallback {
    private Context context;
    private LocalDatabases database;
    private ServerModel serverModel;

    public RoomModel(Context context) {
        this.context = context;
        database = DatabaseRoom.getInstance(context);
        serverModel = new ServerModel(context);
    }

    public void synchronizeDatabases(){
        serverModel.checkDatabaseVersion(this);
    }

    @Override
    public void setDatabaseVersion(int serverVersion) {
        if (LOCAL_DATABASE_VERSION != serverVersion){
            clearLocalDatabase();
            serverModel.installNewDatabase();
        }
    }

    private void clearLocalDatabase() {

    }
}
