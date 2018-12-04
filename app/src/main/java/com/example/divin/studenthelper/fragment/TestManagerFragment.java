package com.example.divin.studenthelper.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestManagerFragment extends BaseFragment {

    @BindView(R.id.btn_open_test_by_id)
    Button btn_open_test_by_id;

    @BindView(R.id.btn_show_test_results)
    Button btn_show_test_results;

    @OnClick(R.id.btn_show_test_results)
    void show_test_result(){

    }

    @OnClick(R.id.btn_open_test_by_id)
    void open_test_by_id(){
        ((MainActivity)Objects.requireNonNull(getActivity())).fragmentViewer.showFragment(new ListTestFragment());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_manager_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)Objects.requireNonNull(getActivity())).toolbar.setTitle("Тест менеджер");
    }
}
