package com.example.divin.studenthelper.callback;

import com.example.divin.studenthelper.mvp.model.Data.TestItem;

import java.util.List;

public interface I_load_testData_callback {
    void load_data(List<TestItem> list);
}
