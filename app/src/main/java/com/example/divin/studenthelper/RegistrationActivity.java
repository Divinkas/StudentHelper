package com.example.divin.studenthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.mvp.presenter.AuthPresenter;
import com.example.divin.studenthelper.mvp.view.IauthorizationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistrationActivity extends MvpAppCompatActivity implements IauthorizationView {

    @InjectPresenter
    AuthPresenter registrationPresenter;

    @BindView(R.id.apcEtLoginForRegistration)
    AppCompatEditText apcEtLoginForRegistration;

    @BindView(R.id.apcEtPasswordForRegistration)
    AppCompatEditText apcEtPasswordForRegistration;

    @BindView(R.id.btnRegistration)
    Button btnRegistration;


    @OnClick(R.id.btnRegistration)
    void registration() {
        if (!Objects.requireNonNull(apcEtLoginForRegistration.getText()).toString().isEmpty()
                && !Objects.requireNonNull(apcEtPasswordForRegistration.getText()).toString().isEmpty()) {
            registrationPresenter.registrationByMail(apcEtLoginForRegistration.getText().toString(),
                    apcEtPasswordForRegistration.getText().toString());
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();
            if(user == null) {
                mAuth.createUserWithEmailAndPassword(apcEtLoginForRegistration.getText().toString(),
                        apcEtPasswordForRegistration.getText().toString())
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                successAuth(true);
                            } else {
                                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                                successAuth(false);
                            }
                        });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle(R.string.registration_title_text);
        ButterKnife.bind(this);

        registrationPresenter.setContext(RegistrationActivity.this);

    }

    @Override
    public void successAuth(boolean isSuccess) {
        if (isSuccess){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
