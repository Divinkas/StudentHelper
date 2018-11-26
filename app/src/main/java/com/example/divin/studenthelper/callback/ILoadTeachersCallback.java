package com.example.divin.studenthelper.callback;

import com.example.divin.studenthelper.mvp.model.Data.Teacher;

import java.util.List;

public interface ILoadTeachersCallback {
    void loadTeachers(List<Teacher> teacherList);
}
