package com.example.divin.studenthelper.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherHolder> {
    private Context context;
    private List<Teacher> teacherList;
    private RequestOptions options;

    public TeacherAdapter(Context context, List<Teacher> teacherList) {
        this.context = context;
        this.teacherList = teacherList;
        options = new RequestOptions()
                .centerCrop()
                .error(R.drawable.user_default);
    }

    @NonNull
    @Override
    public TeacherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.teacher_item_card, viewGroup, false);
        return new TeacherHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TeacherHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tvNameTeacher.setText(teacherList.get(position).name);
        holder.tv_teacher_rating.setText("Рейтинг: " + teacherList.get(position).reyting);
        holder.tv_teacher_mail.setText(teacherList.get(position).mail);
        Glide.with(context).load(teacherList.get(position).imagesUrl).apply(options).into(holder.img_teacher);
        holder.rv_lecture_list.setLayoutManager(new LinearLayoutManager(context));
        if(teacherList.get(position).predmet_list.size() != 0){
            holder.rv_lecture_list.setAdapter(new ListPredmetsAdapter(context, teacherList.get(position).predmet_list));
        } else { holder.rv_lecture_list.setAdapter(new ListPredmetsAdapter(context, new ArrayList<>())); }
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    class TeacherHolder extends RecyclerView.ViewHolder{
        TextView tvNameTeacher,tv_teacher_rating, tv_teacher_mail;
        RecyclerView rv_lecture_list;
        CircleImageView img_teacher;

        TeacherHolder(@NonNull View itemView) {
            super(itemView);
            img_teacher = itemView.findViewById(R.id.img_teacher);
            tv_teacher_rating = itemView.findViewById(R.id.tv_teacher_rating);
            tvNameTeacher = itemView.findViewById(R.id.tvNameTeacher);
            rv_lecture_list = itemView.findViewById(R.id.rv_lecture_list);
            tv_teacher_mail = itemView.findViewById(R.id.tv_teacher_mail);
        }
    }
}
