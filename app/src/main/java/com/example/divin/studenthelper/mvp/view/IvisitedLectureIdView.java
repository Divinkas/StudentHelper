package com.example.divin.studenthelper.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;

import java.util.List;

public interface IvisitedLectureIdView extends MvpView {
    void loadListStudents(List<StudentInfo> list);
}
