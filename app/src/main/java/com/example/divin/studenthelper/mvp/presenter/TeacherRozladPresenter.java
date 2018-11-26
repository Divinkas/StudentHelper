package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.ILoadRozkladCallback;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.IteacherRozkladView;

import java.util.List;

@InjectViewState
public class TeacherRozladPresenter extends MvpPresenter<IteacherRozkladView> implements ILoadRozkladCallback {
    private Context context;
    private ServerModel serverModel;
    private FirebaseModel firebaseModel;


    public TeacherRozladPresenter() {
    }

    @Override
    public void loadData(List<List<RozkladObj>> list) {
        getViewState().renderData(list);
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(context);
            firebaseModel = new FirebaseModel(context);
        }
    }

    public void loadRozklad() {
        serverModel.loadTeacherRozklad(firebaseModel.getUserId(), this);
    }
}
