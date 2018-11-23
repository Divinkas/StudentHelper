package com.example.divin.studenthelper.fragment;

import com.arellomobile.mvp.MvpAppCompatFragment;

import java.util.Objects;

import butterknife.Unbinder;

public class BaseFragment extends MvpAppCompatFragment {
    public Unbinder unbinder;

    public void setTitle(int title){
        Objects.requireNonNull(getActivity()).setTitle(title);
    }

    public String getFragmentTag() {
        return this.getClass().getSimpleName();
    }
}

