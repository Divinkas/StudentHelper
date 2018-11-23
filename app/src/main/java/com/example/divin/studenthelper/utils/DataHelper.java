package com.example.divin.studenthelper.utils;

import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    public DataHelper() {
    }

    public List<List<RozkladObj>> getRozkladObeckts(List<RozkladObj> list){
        List<List<RozkladObj>> daysList = new ArrayList<>();
        int day = 0;
        List<RozkladObj> listRozklad = new ArrayList<>();
        for (int i = 0; i < list.size(); i++ ){
            if(i == 0){
                day = list.get(i).kodDay;
            }
            if(day != list.get(i).kodDay){
                day = list.get(i).kodDay;
                daysList.add(listRozklad);
                listRozklad = new ArrayList<>();
                listRozklad.add(list.get(i));
            }
            else {
                listRozklad.add(list.get(i));
            }
        }
        daysList.add(listRozklad);

        return daysList;
    }
}
