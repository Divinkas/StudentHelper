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
import com.example.divin.studenthelper.adapter.TestName_student_Adapter;
import com.example.divin.studenthelper.callback.I_open_test_callback;
import com.example.divin.studenthelper.mvp.model.Data.TestList;
import com.example.divin.studenthelper.mvp.presenter.ListTest_for_student_Presenter;
import com.example.divin.studenthelper.mvp.view.I_test_list_view;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListTest_for_Student_Fragment extends BaseFragment implements I_test_list_view, I_open_test_callback {

    @BindView(R.id.rv_access_test_list)
    RecyclerView rv_access_test_list;

    @InjectPresenter
    ListTest_for_student_Presenter presenter;

    private Context context;
    private TestName_student_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.access_test_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter.setContext(getContext());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)Objects.requireNonNull(getActivity())).toolbar.setTitle("Список тестів");
    }

    @Override
    public void load_data(List<TestList> list) {
        adapter = new TestName_student_Adapter(getContext(), list, this);
        rv_access_test_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_access_test_list.setAdapter(adapter);
    }

    @Override
    public void open_test_by_id(int id_test) {
        Bundle args = new Bundle();
        args.putInt("id_test", id_test);
        TestRunFragment fragment = new TestRunFragment();
        fragment.setArguments(args);
        ((MainActivity) Objects.requireNonNull(getActivity())).fragmentViewer.showFragment(fragment);

    }
}
