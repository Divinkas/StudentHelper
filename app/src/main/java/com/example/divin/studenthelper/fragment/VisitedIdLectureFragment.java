package com.example.divin.studenthelper.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.adapter.StudentsListAdapter;
import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;
import com.example.divin.studenthelper.mvp.presenter.VisitedIdLecturePresenter;
import com.example.divin.studenthelper.mvp.view.IvisitedLectureIdView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private StudentsListAdapter adapter;


    @OnClick(R.id.btn_save_visited)
    void click_send_visited(){
        if (!Objects.requireNonNull(apcEt_date_value.getText()).toString().isEmpty()){
            String data = apcEt_date_value.getText().toString();
            String list_student = adapter.getVisitedStudents();
            if(list_student.length() == 0){
                list_student = "Присутніх не було!";
            }
            int id_roz = Objects.requireNonNull(getArguments()).getInt("id_items");
            presenter.send_data(list_student, data, id_roz);

        } else {
            apcEt_date_value.setError("Дата проведення заняття!");
        }
    }


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
        Calendar c = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = df.format(c.getTime());
        apcEt_date_value.setText(formattedDate);
        //DateFormat.getDateTimeInstance().format(new Date())
        apcEt_date_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()){
                    apcEt_date_value.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return view;
    }

    @Override
    public void loadListStudents(List<StudentInfo> list) {
        assert getArguments() != null;
        tv_visited_para_name.setText(getArguments().getString("para_name"));
        adapter = new StudentsListAdapter(context, list);
        rv_list_students.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        assert getArguments() != null;
        ((MainActivity)Objects.requireNonNull(getActivity())).toolbar.setTitle(getArguments().getString("para_name"));
    }
}
