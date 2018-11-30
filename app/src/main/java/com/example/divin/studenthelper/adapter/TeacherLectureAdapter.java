package com.example.divin.studenthelper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.callback.IshowFragmentLectureById;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.List;

public class TeacherLectureAdapter  extends RecyclerView.Adapter<TeacherLectureAdapter.TeacherLectViewHolder> {
    private Context context;
    private List<List<RozkladObj>> list;
    private IshowFragmentLectureById callback;
    private int kodF;

    public TeacherLectureAdapter(Context context, List<List<RozkladObj>> list, IshowFragmentLectureById ishowFragmentLectureById, int kodF) {
        this.context = context;
        this.list = list;
        this.callback = ishowFragmentLectureById;
        this.kodF = kodF;
    }

    @NonNull
    @Override
    public TeacherLectureAdapter.TeacherLectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_rozkl, viewGroup, false);
        return new TeacherLectureAdapter.TeacherLectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherLectureAdapter.TeacherLectViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tvNameDay.setText(list.get(position).get(0).dayName);
        holder.rvListRozklad.setLayoutManager(new LinearLayoutManager(context));
        holder.rvListRozklad.setAdapter(new ItemLectureAdapter(context, list.get(position), callback, kodF));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TeacherLectViewHolder extends RecyclerView.ViewHolder{
        TextView tvNameDay;
        RecyclerView rvListRozklad;

        TeacherLectViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameDay = itemView.findViewById(R.id.tvNameDay);
            rvListRozklad = itemView.findViewById(R.id.rvListRozklad);
        }
    }
}