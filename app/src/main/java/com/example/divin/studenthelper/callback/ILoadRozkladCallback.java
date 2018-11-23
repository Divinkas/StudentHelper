package com.example.divin.studenthelper.callback;

import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;

import java.util.List;

public interface ILoadRozkladCallback {

    void loadData(List<List<RozkladObj>> list);
    
}
