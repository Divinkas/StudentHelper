package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.ILoadTeachersCallback;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.IteacherView;

import java.util.List;

@InjectViewState
public class TeacherPresenter extends MvpPresenter<IteacherView> implements ILoadTeachersCallback {
    private Context context;
    private ServerModel serverModel;

    public TeacherPresenter() {
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(this.context);
            load();
        }
    }

    @Override
    public void loadTeachers(List<Teacher> teacherList) {
        getViewState().renderTeachers(teacherList);
    }

    private void load(){
        serverModel.loadTeacher(this);
    }
}
