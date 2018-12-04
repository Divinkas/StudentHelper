package com.example.divin.studenthelper.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.callback.I_open_test_callback;
import com.example.divin.studenthelper.mvp.model.Data.TestList;

import java.util.List;

public class TestName_student_Adapter extends RecyclerView.Adapter<TestViewHolder> {
    private Context context;
    private List<TestList> list;
    private I_open_test_callback callback;

    public TestName_student_Adapter(Context context, List<TestList> list, I_open_test_callback callback) {
        this.context = context;
        this.list = list;
        this.callback = callback;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_name_item, viewGroup, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.setIsRecyclable(false);
        holder.tv_test_name.setText(list.get(position).name);
        holder.tv_test_group_name.setText(list.get(position).group);
        holder.ll_test_name_item_container.setOnClickListener(v -> callback.open_test_by_id(list.get(position).id));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
