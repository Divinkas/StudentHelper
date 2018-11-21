package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.IrozkladView;

@InjectViewState
public class RozkladPresenter extends MvpPresenter<IrozkladView> {
    private ServerModel serverModel;
    private Context context;

    public RozkladPresenter() {
    }

    public void setContext(Context context){
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(context);
        }
    }

    public void loadRozklad(){
        serverModel.loadRozklad();
    }
}
