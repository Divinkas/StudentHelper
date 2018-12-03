package com.example.divin.studenthelper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class StudentsListAdapter extends RecyclerView.Adapter<StudentsListAdapter.StudentsViewHolder> {
    private Context context;
    private List<StudentInfo> list;
    private boolean[] arr_visit;

    public StudentsListAdapter(Context context, List<StudentInfo> list) {
        this.context = context;
        this.list = list;
        arr_visit = new boolean[list.size()];
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_visit_item, viewGroup, false);
        return new StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tv_student_name.setText(list.get(position).PIB);
        holder.ll_student_item_container.setOnClickListener(v -> {
            if(holder.cbx_student_checked.isChecked()) {
                holder.cbx_student_checked.setChecked(false);
                arr_visit[position] = false;
            }
            else{
                holder.cbx_student_checked.setChecked(true);
                arr_visit[position] = true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public String getVisitedStudents() {
        StringBuilder visited = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            if(arr_visit[i]){
                visited.append(list.get(i).PIB).append(", ");
            }
        }
        return visited.toString();
    }

    class StudentsViewHolder extends RecyclerView.ViewHolder{
        CheckBox cbx_student_checked;
        TextView tv_student_name;
        LinearLayout ll_student_item_container;
        StudentsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_student_name = itemView.findViewById(R.id.tv_student_name);
            cbx_student_checked = itemView.findViewById(R.id.cbx_student_checked);
            ll_student_item_container = itemView.findViewById(R.id.ll_student_item_container);
        }
    }
}
