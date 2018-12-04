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
import com.example.divin.studenthelper.adapter.TestNamesAdapter;
import com.example.divin.studenthelper.mvp.model.Data.TestList;
import com.example.divin.studenthelper.mvp.presenter.ListTestPresenter;
import com.example.divin.studenthelper.mvp.view.I_test_list_view;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListTestFragment extends BaseFragment implements I_test_list_view {

    @BindView(R.id.rv_access_test_list)
    RecyclerView rv_access_test_list;

    @InjectPresenter
    ListTestPresenter presenter;

    private Context context;
    private TestNamesAdapter adapter;

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
        adapter = new TestNamesAdapter(getContext(), list, presenter);
        rv_access_test_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_access_test_list.setAdapter(adapter);
    }
}
