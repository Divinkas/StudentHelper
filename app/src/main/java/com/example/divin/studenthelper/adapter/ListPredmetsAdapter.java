package com.example.divin.studenthelper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.PredmetList;

import java.util.List;

public class ListPredmetsAdapter extends RecyclerView.Adapter<ListPredmetsAdapter.ListPredmetHolder> {
    private Context context;
    private List<PredmetList> predmets;

    ListPredmetsAdapter(Context context, List<PredmetList> predmets) {
        this.context = context;
        this.predmets = predmets;
    }

    @NonNull
    @Override
    public ListPredmetHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.predmet_item_list_teacher, viewGroup, false);
        return new ListPredmetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPredmetHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tvPredmetTeacherName.setText(predmets.get(position).name_predmet);
    }

    @Override
    public int getItemCount() {
        return predmets.size();
    }

    class ListPredmetHolder extends RecyclerView.ViewHolder {
        TextView tvPredmetTeacherName;
        ListPredmetHolder(@NonNull View itemView) {
            super(itemView);
            tvPredmetTeacherName = itemView.findViewById(R.id.tv_teacher_predmet_name);
        }
    }
}
