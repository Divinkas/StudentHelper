package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.mvp.view.IrozkladView;

@InjectViewState
public class RozkladPresenter extends MvpPresenter<IrozkladView> {

    private Context context;

    public RozkladPresenter() {
    }

    public void setContext(Context context){
        if(this.context == null){
            this.context = context;
        }
    }
}
