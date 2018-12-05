package com.example.divin.studenthelper.callback;

import com.example.divin.studenthelper.mvp.model.Data.ResultTestInfo;

import java.util.List;

public interface I_load_result_callback {
    void result_access(List<ResultTestInfo> list);
}
