package com.example.divin.studenthelper.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.List;

public interface IteacherRozkladView extends MvpView {
    void renderData(List<List<RozkladObj>> data);
}
