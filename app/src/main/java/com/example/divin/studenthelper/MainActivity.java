package com.example.divin.studenthelper;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.mvp.model.Data.Rozklad;
import com.example.divin.studenthelper.mvp.presenter.RozkladPresenter;
import com.example.divin.studenthelper.mvp.view.IrozkladView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity implements IrozkladView {

    @InjectPresenter
    RozkladPresenter rozkladPresenter;

    @BindView(R.id.tvName)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rozkladPresenter.setContext(MainActivity.this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        tvName.setText(user.getDisplayName());
    }

    @Override
    public void renderData(List<Rozklad> data) {

    }


}
