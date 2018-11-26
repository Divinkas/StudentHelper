package com.example.divin.studenthelper.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;

import java.util.List;

public interface IteacherView extends MvpView {
    void renderTeachers(List<Teacher> teacherList);
}
