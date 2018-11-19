package com.example.divin.studenthelper.mvp.model;

import android.content.Context;
import android.widget.Toast;

import com.example.divin.studenthelper.callback.IsuccessAuthCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class FirebaseModel {
    private Context context;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    public FirebaseModel(Context context) {
        this.context = context;
        mAuth = FirebaseAuth.getInstance();

    }

    public void signUp(String email, String password, IsuccessAuthCallback isuccessAuthCallback){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        isuccessAuthCallback.resultAuthentication(true);
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                        isuccessAuthCallback.resultAuthentication(false);
                    }
           });
    }

    public void signIn(String email, String password, IsuccessAuthCallback isuccessAuthCallback){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        isuccessAuthCallback.resultAuthentication(true);
                    } else {
                        Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        isuccessAuthCallback.resultAuthentication(false);
                    }

                });
    }

    public String getMailUser(){
        user = mAuth.getCurrentUser();
        assert user != null;
        return user.getEmail();
    }

    public String getUserId(){
        user = mAuth.getCurrentUser();
        assert user != null;
        return user.getUid();
    }

    public String getUserName(){
        user = mAuth.getCurrentUser();
        assert user != null;
        return user.getDisplayName();
    }
}
