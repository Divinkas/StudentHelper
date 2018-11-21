package com.example.divin.studenthelper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.List;

public class RozkladAdapter extends RecyclerView.Adapter<RozkladAdapter.RozkladViewHolder> {
    private Context context;
    private List<List<RozkladObj>> list;

    @NonNull
    @Override
    public RozkladViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RozkladViewHolder rozkladViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RozkladViewHolder extends RecyclerView.ViewHolder{


        public RozkladViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
