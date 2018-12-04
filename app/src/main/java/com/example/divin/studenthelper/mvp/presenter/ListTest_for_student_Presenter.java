package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.I_list_test_load_callback;
import com.example.divin.studenthelper.mvp.model.Data.TestList;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.I_test_list_view;

import java.util.List;

@InjectViewState
public class ListTest_for_student_Presenter extends MvpPresenter<I_test_list_view> implements I_list_test_load_callback {
    private Context context;
    private ServerModel serverModel;
    private FirebaseModel firebaseModel;

    public ListTest_for_student_Presenter() {
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(context);
            firebaseModel = new FirebaseModel(context);
            serverModel.load_access_test(firebaseModel.getUserId(), this);
        }
    }

    @Override
    public void load_list(List<TestList> list) {
        getViewState().load_data(list);
    }
}
