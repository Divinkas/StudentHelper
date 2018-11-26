package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.IgetRoleCallback;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.ImainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<ImainView> implements IgetRoleCallback {
    private Context context;
    private ServerModel serverModel;
    private FirebaseModel firebaseModel;

    public MainPresenter() {
    }

    public void setContext(Context context) {
        if (this.context == null){
            this.context = context;
            serverModel = new ServerModel(context);
            firebaseModel = new FirebaseModel(context);
            serverModel.loadUserRole(firebaseModel.getUserId(), this);
        }
    }

    @Override
    public void checkMenu() {
        getViewState().refreshMenu();
    }
}
