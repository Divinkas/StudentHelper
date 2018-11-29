package com.example.divin.studenthelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.mvp.presenter.LoginPresenter;
import com.example.divin.studenthelper.mvp.view.IauthorizationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;
import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MvpAppCompatActivity implements IauthorizationView {
    private static final int RC_SIGN_IN = 228;

    @InjectPresenter
    LoginPresenter loginPresenter;

    @BindView(R.id.apcEtLogin)
    AppCompatEditText apcEtLogin;

    @BindView(R.id.apcEtPassword)
    AppCompatEditText apcEtPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.tvOpenRegistration)
    TextView tvOpenRegistration;

    @BindView(R.id.btnSingInGoogle)
    SignInButton btnSingInGoogle;

    @OnClick(R.id.btnSingInGoogle)
    void singInGoogle(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @OnClick(R.id.tvOpenRegistration)
    void openRegActivity(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnLogin)
    void clickLogin(){
        if(Objects.requireNonNull(apcEtLogin.getText()).toString().isEmpty() || Objects.requireNonNull(apcEtPassword.getText()).toString().isEmpty()){
            if(apcEtPassword.getText().toString().isEmpty()){
                apcEtPassword.setError("Введіть пароль!");
            }
            if(apcEtLogin.getText().toString().isEmpty()){
                apcEtLogin.setError("Введіть логін!");
            }
        } else {
            //loginPresenter.signIn(apcEtLogin.getText().toString(), apcEtPassword.getText().toString());
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();
            if(user == null) {
                mAuth.signInWithEmailAndPassword(apcEtLogin.getText().toString(), apcEtPassword.getText().toString())
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                openMainActivity();
                            } else {
                                Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                successAuth(false);
                            }

                        });
            }
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                assert account != null;
                AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signInWithCredential(credential)
                        .addOnCompleteListener(LoginActivity.this, task2 -> {
                            setContentView(R.layout.activity_main);
                            if (task2.isSuccessful()) {
                                Toast.makeText(this, "Авторизовано", Toast.LENGTH_SHORT).show();
                                openMainActivity();
                            }
                            else{
                                setContentView(R.layout.activity_login);
                            }
                        });
            } catch (ApiException ignored) {
                Toast.makeText(this, "Авторизация провалена!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login_title);
        ButterKnife.bind(this);

        loginPresenter.setContext(LoginActivity.this);
        if(loginPresenter.isUserAuthorized()){
            loginPresenter.addAuthorizeUserToDb();
            openMainActivity();
        }
        setListeners();

    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setListeners(){
        apcEtLogin.addTextChangedListener(getTextWatcher(apcEtLogin));
        apcEtPassword.addTextChangedListener(getTextWatcher(apcEtPassword));
    }

    private TextWatcher getTextWatcher(AppCompatEditText appCompatEditText){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(!Objects.requireNonNull(appCompatEditText.getText()).toString().isEmpty()){
                    appCompatEditText.setError(null);
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
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
