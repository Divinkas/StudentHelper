package com.example.divin.studenthelper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.callback.IshowFragmentLectureById;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.List;

public class ItemLectureAdapter extends RecyclerView.Adapter<ItemLectureAdapter.ItemViewHolder> {
    private Context context;
    private List<RozkladObj> list;
    private IshowFragmentLectureById ishowFragmentLectureById;
    private int kodF;

    ItemLectureAdapter(Context context, List<RozkladObj> list, IshowFragmentLectureById ishowFragmentLectureById, int kodF) {
        this.context = context;
        this.list = list;
        this.ishowFragmentLectureById = ishowFragmentLectureById;
        this.kodF = kodF;
    }

    @NonNull
    @Override
    public ItemLectureAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.para_item, viewGroup, false);
        return new ItemLectureAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLectureAdapter.ItemViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tvAudNumber.setText(list.get(position).audyt);
        holder.tvGroupName.setText(list.get(position).grouName);
        holder.tvNameTeacher.setText(list.get(position).teacherName);
        holder.tvParaName.setText(list.get(position).namePredm);
        holder.tvTimePara.setText(list.get(position).time_val);
        holder.tvTypeZn.setText(list.get(position).typeZanyatya);
        holder.llContainer.setOnClickListener(v -> {
            int id = list.get(position).id;
            if(kodF == 0){
                ishowFragmentLectureById.openFragment(id);
            }else {
                ishowFragmentLectureById.getDataFragment(id, list.get(position).namePredm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView tvParaName, tvAudNumber, tvTimePara, tvGroupName, tvTypeZn, tvNameTeacher;
        LinearLayout llContainer;
        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvParaName = itemView.findViewById(R.id.tvParaName);
            tvAudNumber = itemView.findViewById(R.id.tvAudNumber);
            tvTimePara = itemView.findViewById(R.id.tvTimePara);
            tvGroupName = itemView.findViewById(R.id.tvGroupName);
            tvTypeZn = itemView.findViewById(R.id.tvTypeZn);
            tvNameTeacher = itemView.findViewById(R.id.tvNameTeacher);
            llContainer = itemView.findViewById(R.id.llParaContainer);
        }
    }
}
