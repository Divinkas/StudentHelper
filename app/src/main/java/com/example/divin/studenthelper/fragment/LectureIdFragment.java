package com.example.divin.studenthelper.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ViewSwitcher;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.LectureItem;
import com.example.divin.studenthelper.mvp.model.DataHelper;
import com.example.divin.studenthelper.mvp.presenter.LectureIdPresenter;
import com.example.divin.studenthelper.mvp.view.ILectureIdView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LectureIdFragment extends BaseFragment implements ILectureIdView {
    private Context context;
    Animation slide_out_right, slide_in_left;
    private DataHelper dataHelper;
    private int idTime = 0;
    private int idType = 0;

    @InjectPresenter
    public LectureIdPresenter presenter;

    @BindView(R.id.swNextScreen)
    public ViewSwitcher swNextScreen;

    @BindView(R.id.etAudytValue)
    public EditText etAudytValue;

    @BindView(R.id.spTimePara)
    public Spinner spTimePara;

    @BindView(R.id.spTypePara)
    public Spinner spTypePara;

    @BindView(R.id.btnSaveChanged)
    public Button btnSaveChanged;

    @OnClick(R.id.btnSaveChanged)
    void sendChangedData(){
        if(!etAudytValue.getText().toString().isEmpty()){
            assert getArguments() != null;
            presenter.sendNewDataLecture(getArguments().getInt("id_items"), idTime, idType, etAudytValue.getText().toString());
        }
        else{
            //-----
        }
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lecture_id_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        presenter.setContext(context);
        dataHelper = new DataHelper();

        assert getArguments() != null;
        if(getArguments().getInt("id_items") > 0){
            presenter.loadDataLectureForId(getArguments().getInt("id_items"));
        }
        slide_out_right = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
        slide_in_left = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        return view;

    }

    @Override
    public void loadLectureInfo(LectureItem item) {
        etAudytValue.setText(item.audyt);

        ArrayAdapter<String> time_adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, dataHelper.getSpinnerDataTm(item.arr_tm));
        time_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTimePara.setAdapter(time_adapter);
        idTime = dataHelper.getActivePositionTm(item.arr_tm);
        spTimePara.setSelection(idTime);

        ArrayAdapter<String> type_adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, dataHelper.getSpinnerDataTp(item.arr_tz));
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTypePara.setAdapter(type_adapter);
        idType = dataHelper.getActivePositionTz(item.arr_tz);
        spTypePara.setSelection(idType);

        //listeners
        spTimePara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idTime = item.arr_tm.get(position).id_time;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spTypePara.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idType  = item.arr_tz.get(position).id_tp;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        nextScreen();
    }

    private void nextScreen(){
        swNextScreen.setOutAnimation(slide_out_right);
        swNextScreen.setInAnimation(slide_in_left);
        swNextScreen.showNext();
    }
}
