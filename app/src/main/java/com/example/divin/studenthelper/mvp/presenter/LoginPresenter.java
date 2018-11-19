package com.example.divin.studenthelper.mvp.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.studenthelper.callback.IsuccessAuthCallback;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;
import com.example.divin.studenthelper.mvp.model.ServerModel;
import com.example.divin.studenthelper.mvp.view.IauthorizationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@InjectViewState
public class LoginPresenter extends MvpPresenter<IauthorizationView> implements IsuccessAuthCallback {
    private Context context;
    private FirebaseModel firebaseModel;
    private ServerModel serverModel;

    public LoginPresenter() {
    }

    public void setContext(Context context) {
        if(this.context == null){
            this.context = context;
            firebaseModel = new FirebaseModel(context);
            serverModel = new ServerModel(context);
        }
    }
    public void signIn(String login, String password){
        firebaseModel.signIn(login, password, this);
    }

    public boolean isUserAuthorized() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        return user != null;
    }

    @Override
    public void resultAuthentication(boolean isValid) {

    }

    public void addAuthorizeUserToDb() {
        serverModel.sendUserToServer(firebaseModel.getMailUser(), firebaseModel.getUserName(), firebaseModel.getUserId());
    }

}
