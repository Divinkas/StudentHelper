package com.example.divin.studenthelper.fragment;

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
import com.example.divin.studenthelper.adapter.Test_result_item_Adapter;
import com.example.divin.studenthelper.mvp.model.Data.ResultTestInfo;
import com.example.divin.studenthelper.mvp.presenter.TestResultatsPresenter;
import com.example.divin.studenthelper.mvp.view.I_test_results_view;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestResultFragment extends BaseFragment implements I_test_results_view {

    private Test_result_item_Adapter adapter;

    @InjectPresenter
    TestResultatsPresenter presenter;

    @BindView(R.id.rv_test_result)
    RecyclerView rv_test_result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.test_result_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        rv_test_result.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.setContext(getContext());
        presenter.load_test_results();
        return view;
    }

    @Override
    public void load_results_by_id(List<ResultTestInfo> list) {
        if(list != null) {
            adapter = new Test_result_item_Adapter(getContext(), list);
        } else {
            adapter = new Test_result_item_Adapter(getContext(), new ArrayList<>());
        }
        rv_test_result.setAdapter(adapter);
    }
}
