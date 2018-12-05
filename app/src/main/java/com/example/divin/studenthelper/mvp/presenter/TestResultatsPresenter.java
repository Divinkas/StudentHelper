package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.I_load_result_callback;
import com.example.divin.studenthelper.mvp.model.Data.ResultTestInfo;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.I_test_results_view;

import java.util.List;

@InjectViewState
public class TestResultatsPresenter extends MvpPresenter<I_test_results_view> implements I_load_result_callback {
    private Context context;
    private ServerModel serverModel;
    private FirebaseModel firebaseModel;

    public TestResultatsPresenter() {
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(this.context);
            firebaseModel = new FirebaseModel(this.context);
        }
    }

    public void load_test_results(){
        serverModel.load_test_results(firebaseModel.getUserId(), this);
    }

    @Override
    public void result_access(List<ResultTestInfo> list) {
        getViewState().load_results_by_id(list);
    }
}
