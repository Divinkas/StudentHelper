package com.example.divin.studenthelper.mvp.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.callback.IListStudentsCallback;
import com.example.divin.studenthelper.callback.ILoadRozkladCallback;
import com.example.divin.studenthelper.callback.ILoadTeachersCallback;
import com.example.divin.studenthelper.callback.ISynchronizeCallback;
import com.example.divin.studenthelper.callback.IgetRoleCallback;
import com.example.divin.studenthelper.callback.IlectureCallback;
import com.example.divin.studenthelper.mvp.model.Data.LectureItem;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
import com.example.divin.studenthelper.mvp.model.Data.Rozklad_server_object;
import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;
import com.example.divin.studenthelper.mvp.model.Data.UserRoleValue;
import com.example.divin.studenthelper.retofit.IserverSender;
import com.example.divin.studenthelper.retofit.RetrofitClient;
import com.example.divin.studenthelper.utils.DataHelper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ServerModel {
    private Context context;
    private IserverSender iserverSender;
    private DataHelper dataHelper;

    public ServerModel(Context context) {
        this.context = context;
        Retrofit retrofit = RetrofitClient.getInstance();
        iserverSender = retrofit.create(IserverSender.class);
        dataHelper = new DataHelper();
    }

    public void loadUserRole(String ident, IgetRoleCallback igetRoleCallback){
        Observer<UserRoleValue>observer = new Observer<UserRoleValue>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(UserRoleValue userRoleValue) {
                MainActivity.KOD_ROLE = userRoleValue.kod_roles;
                igetRoleCallback.checkMenu();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        iserverSender
                .getUserRole(ident)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void sendUserToServer(String mail, String name, String id) {
        if(name.isEmpty()){ name = "newUser"; }
        iserverSender.addUserToDatabases(mail, name, id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful())
//                    Toast.makeText(context, "+", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void checkDatabaseVersion(ISynchronizeCallback iSynchronizeCallback) {

    }

    public void installNewDatabase() {

    }

    public void loadRozklad(ILoadRozkladCallback iLoadRozkladCallback){
        Observer<Rozklad_server_object> observer = new Observer<Rozklad_server_object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Rozklad_server_object rozklad_server_object) {
                iLoadRozkladCallback.loadData(dataHelper.getRozkladObeckts(rozklad_server_object.rozkladObj));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        iserverSender
                .getRozklad(1,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void loadTeacher(ILoadTeachersCallback iLoadTeachersCallback) {
        Observer<List<Teacher>> observer = new Observer<List<Teacher>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Teacher> teacherList) {
                iLoadTeachersCallback.loadTeachers(teacherList);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        iserverSender
                .getTeachers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void loadTeacherRozklad(String userId, ILoadRozkladCallback iLoadRozkladCallback) {
        Observer<Rozklad_server_object> observer = new Observer<Rozklad_server_object>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Rozklad_server_object rozklad_server_object) {
                iLoadRozkladCallback.loadData(dataHelper.getRozkladObeckts(rozklad_server_object.rozkladObj));
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
        iserverSender
                .getTeacherRozkl(userId, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void loadLecuteById(String userId, int id, IlectureCallback ilectureCallback) {
        Observer<LectureItem> observer = new Observer<LectureItem>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LectureItem lectureItem) {
                ilectureCallback.lectureLoaded(lectureItem);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        iserverSender
                .getLectureDataById(userId, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public void setLectureChanges(String save, int id, int kod_time, int kod_type, String audyt) {
        iserverSender.sendLectureChanges(save, id, kod_time, kod_type, audyt).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, "Зміни збережено!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void loadListStudentsByKodGroup(int id, IListStudentsCallback callback){
        Observer<List<StudentInfo>> observer = new Observer<List<StudentInfo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<StudentInfo> studentInfos) {
                callback.setListStudents(studentInfos);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        iserverSender
                .getListStudentByGroupId(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}




