package com.example.divin.studenthelper.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.divin.studenthelper.MainActivity;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.fragment.BaseFragment;
import com.example.divin.studenthelper.fragment.RozkladFragment;

public class FragmentViewer {
    private MvpAppCompatActivity activity;
    private BaseFragment defaultFragment;
    private FragmentManager fragmentManager;

    public FragmentViewer(MainActivity activity) {
        this.activity = activity;
        defaultFragment = new RozkladFragment();
        fragmentManager = activity.getSupportFragmentManager();
        showDefaultFragment();
    }

    private void showDefaultFragment() {
        clearBackStack();
        showFragment(defaultFragment);
    }

    public void showFragment(BaseFragment fragment){
        if(!isUsedFragment(fragment)) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment, fragment.getFragmentTag())
                    .addToBackStack(fragment.getFragmentTag())
                    .commitAllowingStateLoss();
        } else if(!isTopPosition(fragment, activity.getSupportFragmentManager())){
            fragmentManager.popBackStackImmediate(fragment.getFragmentTag(), 0);
        }
    }

    private boolean isTopPosition(BaseFragment fragment, FragmentManager fm) {
        return fm.findFragmentByTag(fragment.getFragmentTag()).isResumed();
    }

    private boolean isUsedFragment(BaseFragment fragment){
        Fragment newFragment = fragmentManager.findFragmentByTag(fragment.getFragmentTag());
        return newFragment != null;
    }

    private void clearBackStack() {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
        ft.commitAllowingStateLoss();
    }
}
