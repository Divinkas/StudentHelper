package com.example.divin.studenthelper.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.divin.studenthelper.mvp.model.Data.TestItem;

import java.util.List;

public interface I_test_run_view extends MvpView {
    void load_test_data(List<TestItem> list);
}
