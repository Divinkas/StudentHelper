package com.example.divin.studenthelper.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.adapter.StudentsListAdapter;
import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;
import com.example.divin.studenthelper.mvp.presenter.VisitedIdLecturePresenter;
import com.example.divin.studenthelper.mvp.view.IvisitedLectureIdView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VisitedIdLectureFragment extends BaseFragment implements IvisitedLectureIdView {

    @InjectPresenter
    VisitedIdLecturePresenter presenter;

    @BindView(R.id.tv_visited_para_name)
    TextView tv_visited_para_name;

    @BindView(R.id.apcEt_date_value)
    AppCompatEditText apcEt_date_value;

    @BindView(R.id.rv_list_students)
    RecyclerView rv_list_students;

    @BindView(R.id.btn_save_visited)
    Button btn_save_visited;

    private Context context;
    private int id_lect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.visited_id_lecture, container, false);
        unbinder = ButterKnife.bind(this, view);
        this.context = getContext();
        presenter.setContext(context);

        rv_list_students.setLayoutManager(new LinearLayoutManager(context));

        assert getArguments() != null;
        if(getArguments().getInt("id_items") > 0){
            id_lect =  getArguments().getInt("id_items");
            presenter.loadStudentsByGroupId(id_lect);
        }

        return view;
    }

    @Override
    public void loadListStudents(List<StudentInfo> list) {
        assert getArguments() != null;
        tv_visited_para_name.setText(getArguments().getString("para_name"));
        rv_list_students.setAdapter(new StudentsListAdapter(context, list));
    }
}
