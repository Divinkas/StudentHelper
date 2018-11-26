package com.example.divin.studenthelper.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.adapter.RozkladAdapter;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
import com.example.divin.studenthelper.mvp.presenter.TeacherRozladPresenter;
import com.example.divin.studenthelper.mvp.view.IrozkladView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeacherRozkladFragment extends BaseFragment implements IrozkladView {
    private Context context;

    @InjectPresenter
    public TeacherRozladPresenter presenter;

    @BindView(R.id.rvListRozklad)
    RecyclerView rvListRozklad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rozklad_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        presenter.setContext(context);
        presenter.loadRozklad();
        rvListRozklad.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void renderData(List<List<RozkladObj>> data) {
        rvListRozklad.setAdapter(new RozkladAdapter(context, data));
    }
}
