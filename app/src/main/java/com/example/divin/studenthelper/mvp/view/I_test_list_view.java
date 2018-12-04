package com.example.divin.studenthelper.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.divin.studenthelper.mvp.model.Data.TestList;

import java.util.List;

public interface I_test_list_view extends MvpView {
    void load_data(List<TestList> list);
}
