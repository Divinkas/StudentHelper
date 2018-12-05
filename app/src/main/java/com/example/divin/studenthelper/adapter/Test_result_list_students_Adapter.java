package com.example.divin.studenthelper.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.ResultTest;

import java.util.List;

public class Test_result_list_students_Adapter
        extends RecyclerView.Adapter<Test_result_list_students_Adapter.Test_result_list_students_ViewHolder> {
    private Context context;
    private List<ResultTest> list;

    public Test_result_list_students_Adapter(Context context, List<ResultTest> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Test_result_list_students_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_result_item_by_id, viewGroup, false);
        return new Test_result_list_students_ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Test_result_list_students_ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tv_student_name_result.setText(list.get(position).name_student+" ("+list.get(position).date_z+")");
        holder.tv_student_result.setText(list.get(position).result);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Test_result_list_students_ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_student_name_result, tv_student_result;
        Test_result_list_students_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_student_name_result = itemView.findViewById(R.id.tv_student_name_result);
            tv_student_result = itemView.findViewById(R.id.tv_student_result);
        }
    }
}
