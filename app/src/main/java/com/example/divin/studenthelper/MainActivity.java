package com.example.divin.studenthelper;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.mvp.model.Data.Rozklad;
import com.example.divin.studenthelper.mvp.presenter.RozkladPresenter;
import com.example.divin.studenthelper.mvp.view.IrozkladView;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements IrozkladView {

    @InjectPresenter
    RozkladPresenter rozkladPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rozkladPresenter.setContext(MainActivity.this);
    }

    @Override
    public void renderData(List<Rozklad> data) {

    }


}
