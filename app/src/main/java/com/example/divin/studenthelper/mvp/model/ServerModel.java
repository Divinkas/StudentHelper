package com.example.divin.studenthelper.mvp.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.divin.studenthelper.callback.ISynchronizeCallback;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
import com.example.divin.studenthelper.mvp.model.Data.Rozklad_server_object;
import com.example.divin.studenthelper.retofit.IserverSender;
import com.example.divin.studenthelper.retofit.RetrofitClient;

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

    public ServerModel(Context context) {
        this.context = context;
        Retrofit retrofit = RetrofitClient.getInstance();
        iserverSender = retrofit.create(IserverSender.class);
    }

    public void sendUserToServer(String mail, String name, String id) {
        iserverSender.addUserToDatabases(mail, name, id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful())
                    Toast.makeText(context, "+", Toast.LENGTH_SHORT).show();
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

    public void loadRozklad(){
        Observer<Rozklad_server_object> observer = new Observer<Rozklad_server_object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Rozklad_server_object rozklad_server_object) {

                List<RozkladObj> rozkladObjs = rozklad_server_object.rozkladObj;
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
}




