package com.example.divin.studenthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.mvp.presenter.AuthPresenter;
import com.example.divin.studenthelper.mvp.view.IauthorizationView;

import java.util.Objects;

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
