package com.example.divin.studenthelper.fragment;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.adapter.TeacherLectureAdapter;
import com.example.divin.studenthelper.callback.IshowFragmentLectureById;
import com.example.divin.studenthelper.mvp.model.Constant;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
import com.example.divin.studenthelper.mvp.presenter.TeacherRozladPresenter;
import com.example.divin.studenthelper.mvp.view.IteacherRozkladView;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VisitingFragment extends BaseFragment implements IteacherRozkladView, IshowFragmentLectureById {
    private Context context;

    @InjectPresenter
    public TeacherRozladPresenter presenter;

    @BindView(R.id.rvListRozklad)
    RecyclerView rvListRozklad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rozklad_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        presenter.setContext(context);
        rvListRozklad.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void renderData(List<List<RozkladObj>> data) {
        rvListRozklad.setAdapter(new TeacherLectureAdapter(context, data, this, Constant.VISIST_KOD));
    }

    @Override
    public void openFragment(int id) {
    }

    @Override
    public void getDataFragment(int id, String namePara) {
        Bundle args = new Bundle();
        args.putInt("id_items", id);
        args.putString("para_name", namePara);
        VisitedIdLectureFragment fragment = new VisitedIdLectureFragment();
        fragment.setArguments(args);
        ((MainActivity) Objects.requireNonNull(getActivity())).fragmentViewer.showFragment(fragment);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadRozklad();
        ((MainActivity)Objects.requireNonNull(getActivity())).toolbar.setTitle("Відвідування");
    }
}
