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
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.List;

public class RozkladAdapter extends RecyclerView.Adapter<RozkladAdapter.RozkladViewHolder> {
    private Context context;
    private List<List<RozkladObj>> list;

    public RozkladAdapter(Context context, List<List<RozkladObj>> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RozkladViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_rozkl, viewGroup, false);
        return new RozkladViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RozkladViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tvNameDay.setText(list.get(position).get(0).dayName);
        holder.rvListRozklad.setLayoutManager(new LinearLayoutManager(context));
        holder.rvListRozklad.setAdapter(new DaysRozkladAdapter(context, list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RozkladViewHolder extends RecyclerView.ViewHolder{
        TextView tvNameDay;
        RecyclerView rvListRozklad;

        RozkladViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameDay = itemView.findViewById(R.id.tvNameDay);
            rvListRozklad = itemView.findViewById(R.id.rvListRozklad);
        }
    }
}
