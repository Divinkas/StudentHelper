package com.example.divin.studenthelper.mvp.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.divin.studenthelper.retofit.IserverSender;
import com.example.divin.studenthelper.retofit.RetrofitClient;

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
}
/*
Observer<Void> observer = new Observer<Void>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Void aVoid) {
                iserverSender.addUserToDatabases(mail, name, id).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observable<Void> observable = new Observable<Void>() {
            @Override
            protected void subscribeActual(Observer<? super Void> observer) {
                observer.onNext(Void);
            }
        };
        observable
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
 */