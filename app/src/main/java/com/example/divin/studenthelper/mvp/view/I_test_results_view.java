package com.example.divin.studenthelper.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.divin.studenthelper.mvp.model.Data.ResultTestInfo;

import java.util.List;

public interface I_test_results_view extends MvpView {
    void load_results_by_id(List<ResultTestInfo> list);
}
