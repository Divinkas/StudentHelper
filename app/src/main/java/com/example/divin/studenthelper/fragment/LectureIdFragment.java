package com.example.divin.studenthelper.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.view.ILectureIdView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LectureIdFragment extends BaseFragment implements ILectureIdView {
    private Context context;

    @BindView(R.id.tvIdLect)
    public TextView tvIdLect;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lecture_id_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();

        assert getArguments() != null;
        if(getArguments().getInt("id_items") > 0){
            tvIdLect.setText("id: " + getArguments().getInt("id_items"));
        }
        return view;

    }
}
