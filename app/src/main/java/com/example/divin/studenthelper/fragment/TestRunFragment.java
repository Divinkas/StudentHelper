package com.example.divin.studenthelper.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.TestItem;
import com.example.divin.studenthelper.mvp.presenter.TestRunPresenter;
import com.example.divin.studenthelper.mvp.view.I_test_run_view;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestRunFragment extends BaseFragment implements I_test_run_view {

    private List<TestItem> test_list;
    private int current_test_position;
    private int count_question;
    private int right_answers;
    private int id_test;

    @InjectPresenter
    TestRunPresenter presenter;

    @BindView(R.id.view_switcher_test)
    ViewSwitcher view_switcher_test;

    @BindView(R.id.tv_progress)
    TextView tv_progress;

    @BindView(R.id.tv_text_question)
    TextView tv_text_question;

    @BindView(R.id.rg_answers)
    RadioGroup rg_answers;

    @BindView(R.id.btn_next_question)
    Button btn_next_question;

    @BindView(R.id.rb_answer_1)
    RadioButton rb_answer_1;

    @BindView(R.id.rb_answer_2)
    RadioButton rb_answer_2;

    @BindView(R.id.rb_answer_3)
    RadioButton rb_answer_3;

    @BindView(R.id.rb_answer_4)
    RadioButton rb_answer_4;

    @OnClick(R.id.btn_next_question)
    void next_q(){
        int answer_position = -1;
        switch (rg_answers.getCheckedRadioButtonId())
        {
            case R.id.rb_answer_1:
                answer_position = 0;
                break;
            case R.id.rb_answer_2:
                answer_position = 1;
                break;
            case R.id.rb_answer_3:
                answer_position = 2;
                break;
            case R.id.rb_answer_4:
                answer_position = 3;
                break;
        }
        check_answer(answer_position);
        render_next_question();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_run_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter.setContext(getContext());
        assert getArguments() != null;
        id_test = getArguments().getInt("id_test");
        presenter.load_testData_by_id(id_test);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)Objects.requireNonNull(getActivity())).toolbar.setTitle("Тестування");
    }

    @Override
    public void load_test_data(List<TestItem> list) {
        if(list.size() > 0){
            test_list = list;
            right_answers = 0;
            current_test_position = 0;
            count_question = list.size();
            render_next_question();
            view_switcher_test.showNext();
        }
    }

    @SuppressLint("SetTextI18n")
    private void set_progress(){
        tv_progress.setText((current_test_position+1)+"/"+count_question);
    }
    private void check_answer(int answer_position){
        if(test_list.get(current_test_position).answers.get(answer_position).status == 1){
            right_answers++;
        }
        current_test_position++;
    }

    @SuppressLint("SetTextI18n")
    private void render_next_question() {
        if(current_test_position < count_question) {
            set_progress();
            tv_text_question.setText(test_list.get(current_test_position).question);
            rb_answer_1.setText(test_list.get(current_test_position).answers.get(0).text_answer);
            rb_answer_2.setText(test_list.get(current_test_position).answers.get(1).text_answer);
            rb_answer_3.setText(test_list.get(current_test_position).answers.get(2).text_answer);
            rb_answer_4.setText(test_list.get(current_test_position).answers.get(3).text_answer);
            rb_answer_1.setChecked(true);
        } else{
            presenter.send_results_test(id_test, (right_answers+"/"+count_question));
            view_switcher_test.showNext();
            show_successful_fragment();
        }
    }

    private void show_successful_fragment() {
        Bundle args = new Bundle();
        args.putInt("id_test", id_test);
        args.putString("result", (right_answers+"/"+count_question));
        SuccessfullFragment fragment = new SuccessfullFragment();
        fragment.setArguments(args);
        ((MainActivity)Objects.requireNonNull(getActivity())).fragmentViewer.showFragment(fragment);
    }
}
