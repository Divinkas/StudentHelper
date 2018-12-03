package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.IListStudentsCallback;
import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.IvisitedLectureIdView;

import java.util.List;

@InjectViewState
public class VisitedIdLecturePresenter extends MvpPresenter<IvisitedLectureIdView> implements IListStudentsCallback {
    private Context context;
    private ServerModel serverModel;

    public VisitedIdLecturePresenter() {
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(context);

        }
    }

    public void send_data(String list_student, String data, int id_rozkl){
        serverModel.send_visit(list_student, data, id_rozkl);
    }

    public void loadStudentsByGroupId(int id){
        serverModel.loadListStudentsByKodGroup(id, this);
    }

    @Override
    public void setListStudents(List<StudentInfo> list){
        getViewState().loadListStudents(list);
    }
}
