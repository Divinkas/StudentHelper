package com.example.divin.studenthelper.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuccessfullFragment extends BaseFragment {
    private int id_test;
    private String result;

    @BindView(R.id.tv_test_result)
    TextView tv_test_result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.result, container, false);
        unbinder = ButterKnife.bind(this, view);
        assert getArguments() != null;
        id_test = getArguments().getInt("id_test");
        result = getArguments().getString("result");

        tv_test_result.setText(result);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)Objects.requireNonNull(getActivity())).toolbar.setTitle("Результати");
    }
}
