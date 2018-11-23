package com.example.divin.studenthelper;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.adapter.RozkladAdapter;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
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

    @BindView(R.id.rvListRozklad)
    RecyclerView rvListRozklad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rozkladPresenter.setContext(MainActivity.this);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        rozkladPresenter.loadRozklad();
        rvListRozklad.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void renderData(List<List<RozkladObj>> data) {
        rvListRozklad.setAdapter(new RozkladAdapter(this, data));
    }


}
