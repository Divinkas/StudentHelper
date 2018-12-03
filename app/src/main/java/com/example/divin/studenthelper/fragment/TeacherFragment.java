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
import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.adapter.TeacherAdapter;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;
import com.example.divin.studenthelper.mvp.presenter.TeacherPresenter;
import com.example.divin.studenthelper.mvp.view.IteacherView;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeacherFragment extends BaseFragment implements IteacherView {
    private Context context;

    @InjectPresenter
    public TeacherPresenter teacherPresenter;

    @BindView(R.id.rv_teacher_list)
    RecyclerView rv_teacher_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacher_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        this.context = getContext();
        teacherPresenter.setContext(this.context);
        rv_teacher_list.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void renderTeachers(List<Teacher> teacherList) {
        rv_teacher_list.setAdapter(new TeacherAdapter(context, teacherList));
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)Objects.requireNonNull(getActivity())).toolbar.setTitle("Викладачі");
    }
}
