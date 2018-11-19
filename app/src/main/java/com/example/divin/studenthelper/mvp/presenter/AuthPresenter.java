package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.IsuccessAuthCallback;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.view.IauthorizationView;

@InjectViewState
public class AuthPresenter extends MvpPresenter<IauthorizationView> implements IsuccessAuthCallback {
    private Context context;
    private FirebaseModel firebaseModel;

    public AuthPresenter() {
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            firebaseModel = new FirebaseModel(this.context);
        }
    }

    public void registrationByMail(String new_login, String new_password) {
        firebaseModel.signUp(new_login, new_password, this);
    }

    @Override
    public void resultAuthentication(boolean isValid) {
            getViewState().successAuth(isValid);
    }
}
