package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.I_load_testData_callback;
import com.example.divin.studenthelper.mvp.model.Data.TestItem;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.I_test_run_view;

import java.util.List;

@InjectViewState
public class TestRunPresenter extends MvpPresenter<I_test_run_view> implements I_load_testData_callback {
    private Context context;
    private ServerModel serverModel;
    private FirebaseModel firebaseModel;

    public TestRunPresenter() {
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(context);
            firebaseModel = new FirebaseModel(context);
        }
    }

    public void load_testData_by_id(int id_test){
        serverModel.load_test_info(id_test, this);
    }

    @Override
    public void load_data(List<TestItem> list) {
        getViewState().load_test_data(list);
    }

    public void send_results_test(int id_test, String right_answers) {
        serverModel.send_test_result(id_test, right_answers, firebaseModel.getUserId());
    }
}
