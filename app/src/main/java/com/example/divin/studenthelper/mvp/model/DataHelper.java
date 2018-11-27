package com.example.divin.studenthelper.mvp.model;

import com.example.divin.studenthelper.mvp.model.Data.ArrTm;
import com.example.divin.studenthelper.mvp.model.Data.ArrTz;

import java.util.List;

public class DataHelper {
    public DataHelper() {
    }
    public String[] getSpinnerDataTm(List<ArrTm> list){
        String[]arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i).value;
        }
        return arr;
    }
    public int getActivePositionTm(List<ArrTm> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).is_active == 1){
                return i;
            }
        }
        return 0;
    }

    public String[] getSpinnerDataTp(List<ArrTz> list){
        String[]arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i).value;
        }
        return arr;
    }
    public int getActivePositionTz(List<ArrTz> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).is_active == 1){
                return i;
            }
        }
        return 0;
    }
}
