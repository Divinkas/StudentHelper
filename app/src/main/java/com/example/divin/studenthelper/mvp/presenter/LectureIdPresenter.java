package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.IlectureCallback;
import com.example.divin.studenthelper.mvp.model.Data.LectureItem;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.ILectureIdView;

@InjectViewState
public class LectureIdPresenter extends MvpPresenter<ILectureIdView> implements IlectureCallback {
    private Context context;
    private ServerModel serverModel;
    private FirebaseModel firebaseModel;

    public LectureIdPresenter() {
    }

    public void setContext(Context context){
        if(this.context == null){
            this.context = context;
            serverModel = new ServerModel(this.context);
            firebaseModel = new FirebaseModel(this.context);
        }
    }

    public void loadDataLectureForId(int id){
        serverModel.loadLecuteById(firebaseModel.getUserId(), id, this);
    }

    @Override
    public void lectureLoaded(LectureItem item) {
        getViewState().loadLectureInfo(item);
    }

    public void sendNewDataLecture(int id, int kod_time, int kod_type, String audyt) {
        serverModel.setLectureChanges("save", id, kod_time, kod_type, audyt);
    }
}
