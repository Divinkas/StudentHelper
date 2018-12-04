package com.example.divin.studenthelper.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.divin.studenthelper.R;

public class TestViewHolder  extends RecyclerView.ViewHolder{
        LinearLayout ll_test_name_item_container;
        TextView tv_test_name, tv_test_group_name;
        TestViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_test_name = itemView.findViewById(R.id.tv_test_name);
            tv_test_group_name = itemView.findViewById(R.id.tv_test_group_name);
            ll_test_name_item_container = itemView.findViewById(R.id.ll_test_name_item_container);
        }
}

