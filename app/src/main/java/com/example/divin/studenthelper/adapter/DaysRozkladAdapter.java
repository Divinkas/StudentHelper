package com.example.divin.studenthelper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.List;

public class DaysRozkladAdapter extends RecyclerView.Adapter<DaysRozkladAdapter.DaysViewHolder> {
    private Context context;
    private List<RozkladObj> list;

    DaysRozkladAdapter(Context context, List<RozkladObj> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DaysViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.para_item, viewGroup, false);
        return new DaysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaysViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tvAudNumber.setText(list.get(position).audyt);
        holder.tvGroupName.setText(list.get(position).grouName);
        holder.tvNameTeacher.setText(list.get(position).teacherName);
        holder.tvParaName.setText(list.get(position).namePredm);
        holder.tvTimePara.setText(list.get(position).time_val);
        holder.tvTypeZn.setText(list.get(position).typeZanyatya);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DaysViewHolder extends RecyclerView.ViewHolder{
        TextView tvParaName, tvAudNumber, tvTimePara, tvGroupName, tvTypeZn, tvNameTeacher;
        public DaysViewHolder(@NonNull View itemView) {
            super(itemView);
            tvParaName = itemView.findViewById(R.id.tvParaName);
            tvAudNumber = itemView.findViewById(R.id.tvAudNumber);
            tvTimePara = itemView.findViewById(R.id.tvTimePara);
            tvGroupName = itemView.findViewById(R.id.tvGroupName);
            tvTypeZn = itemView.findViewById(R.id.tvTypeZn);
            tvNameTeacher = itemView.findViewById(R.id.tvNameTeacher);
        }
    }
}
