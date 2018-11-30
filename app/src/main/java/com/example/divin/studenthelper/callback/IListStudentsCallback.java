package com.example.divin.studenthelper.callback;

import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;

import java.util.List;

public interface IListStudentsCallback {
    void setListStudents(List<StudentInfo> list);
}
