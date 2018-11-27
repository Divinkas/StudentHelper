package com.example.divin.studenthelper.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.divin.studenthelper.mvp.model.Data.LectureItem;

public interface ILectureIdView extends MvpView {
    void loadLectureInfo(LectureItem item);
}
