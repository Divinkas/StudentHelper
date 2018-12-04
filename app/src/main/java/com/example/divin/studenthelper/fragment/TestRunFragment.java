package com.example.divin.studenthelper.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.divin.studenthelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestRunFragment extends BaseFragment {

    @BindView(R.id.tv_text_question)
    TextView tv_text_question;

    @BindView(R.id.rg_answers)
    RadioGroup rg_answers;

    @BindView(R.id.btn_next_question)
    Button btn_next_question;

    @OnClick(R.id.btn_next_question)
    void next_q(){
        switch (rg_answers.getCheckedRadioButtonId())
        {
            case R.id.rb_answer_1:
                tv_text_question.setText("1");
                break;
            case R.id.rb_answer_2:
                tv_text_question.setText("2");
                break;
            case R.id.rb_answer_3:
                tv_text_question.setText("3");
                break;
            case R.id.rb_answer_4:
                tv_text_question.setText("4");
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_run_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        assert getArguments() != null;
        if(getArguments().getInt("id_test") > 0){
            tv_text_question.setText(String.valueOf(getArguments().getInt("id_test")));
        }
    }
}
