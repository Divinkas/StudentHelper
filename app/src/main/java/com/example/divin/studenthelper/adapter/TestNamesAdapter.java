package com.example.divin.studenthelper.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.TestList;
import com.example.divin.studenthelper.mvp.presenter.ListTestPresenter;

import java.util.List;

public class TestNamesAdapter extends RecyclerView.Adapter<TestViewHolder> {
    private Context context;
    private List<TestList> list;
    private ListTestPresenter presenter;

    public TestNamesAdapter(Context context, List<TestList> list, ListTestPresenter presenter) {
        this.context = context;
        this.list = list;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_name_item, viewGroup, false);
        return new TestViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        if (list.get(position).status == 0){
            holder.ll_test_name_item_container.setBackgroundColor(Color.rgb(239, 130, 80));
        } else {
            holder.ll_test_name_item_container.setBackgroundColor(Color.rgb(159, 255, 135));
        }
        holder.tv_test_name.setText(list.get(position).name);
        holder.tv_test_group_name.setText(list.get(position).group);
        holder.ll_test_name_item_container.setOnClickListener(v -> {
            if (list.get(position).status == 0) {
                presenter.setStatus(true, list.get(position).id);
                holder.ll_test_name_item_container.setBackgroundColor(Color.rgb(214, 255, 204));
                list.get(position).status = 1;

            }
            else{
                presenter.setStatus(false, list.get(position).id);
                holder.ll_test_name_item_container.setBackgroundColor(Color.rgb(255, 204, 181));
                list.get(position).status = 0;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
