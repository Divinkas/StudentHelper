package com.example.divin.studenthelper.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.ResultTest;
import com.example.divin.studenthelper.mvp.model.Data.ResultTestInfo;

import java.util.ArrayList;
import java.util.List;

public class Test_result_item_Adapter extends RecyclerView.Adapter<Test_result_item_Adapter.Test_result_item_ViewHolder> {
    private Context context;
    private List<ResultTestInfo> list;

    public Test_result_item_Adapter(Context context, List<ResultTestInfo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Test_result_item_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_result_item, viewGroup, false);
        return new Test_result_item_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Test_result_item_ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tv_test_name_result.setText(list.get(position).test_name);
        holder.tv_name_group.setText(list.get(position).group_name);
        holder.rv_test_result_by_id.setLayoutManager(new LinearLayoutManager(context));
        holder.rv_test_result_by_id.setAdapter(new Test_result_list_students_Adapter(context, get_list(position)));
        if (list.get(position).status == 1){ holder.ll_result_container.setBackgroundColor(Color.rgb(214, 255, 204)); }
        else{ holder.ll_result_container.setBackgroundColor(Color.rgb(255, 204, 181)); }
    }

    private List<ResultTest> get_list(int position) {
        if (list.get(position).result_test != null){
            return list.get(position).result_test;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Test_result_item_ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout ll_result_container;
        RecyclerView rv_test_result_by_id;
        TextView tv_test_name_result, tv_name_group;
        Test_result_item_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_test_name_result = itemView.findViewById(R.id.tv_test_name_result);
            rv_test_result_by_id = itemView.findViewById(R.id.rv_test_result_by_id);
            ll_result_container = itemView.findViewById(R.id.ll_result_container);
            tv_name_group = itemView.findViewById(R.id.tv_name_group);
        }
    }
}
