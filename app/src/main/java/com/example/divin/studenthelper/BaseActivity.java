package com.example.divin.studenthelper;

import com.arellomobile.mvp.MvpAppCompatActivity;

public class BaseActivity extends MvpAppCompatActivity {
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else { super.onBackPressed(); }
    }
}
