package com.example.divin.studenthelper.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.example.divin.studenthelper.BaseActivity;
import com.example.divin.studenthelper.LoginActivity;
import com.example.divin.studenthelper.R;
import com.example.divin.studenthelper.fragment.BaseFragment;
import com.example.divin.studenthelper.fragment.ListTest_for_Student_Fragment;
import com.example.divin.studenthelper.fragment.RozkladFragment;
import com.example.divin.studenthelper.fragment.TeacherFragment;
import com.example.divin.studenthelper.fragment.TeacherRozkladFragment;
import com.example.divin.studenthelper.fragment.TestManagerFragment;
import com.example.divin.studenthelper.fragment.VisitingFragment;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;

public class InstallMatherialMenu {
    private Context context;
    private MaterialMenuDrawable materialMenu;
    private FirebaseModel firebaseModel;
    private FragmentViewer fragmentViewer;
    private View containerView;
    private BaseActivity activity;
    private  NavigationView navigationView;

    public InstallMatherialMenu(BaseActivity baseActivity, Context context, Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView, LinearLayout fragmentContainer, int titleText, FragmentViewer fragmentViewer) {
        this.context = context;
        this.fragmentViewer = fragmentViewer;
        this.navigationView = navigationView;
        activity = baseActivity;
        containerView = fragmentContainer;
        firebaseModel = new FirebaseModel(context);

        materialMenu = new MaterialMenuDrawable(this.context, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        initNavigationView(navigationView, drawerLayout);

        toolbar.setNavigationIcon(materialMenu);
        toolbar.setTitle(titleText);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(v -> {
            drawerLayout.openDrawer(navigationView);
            materialMenu.animateIconState(Constants.STATE_ARROW);
        });

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                materialMenu.animateIconState(Constants.STATE_ARROW);
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                materialMenu.animateIconState(Constants.STATE_BURGER);
            }

            @Override
            public void onDrawerStateChanged(int i) {
            }
        });
    }
    private void initNavigationView(NavigationView navigationView, DrawerLayout drawerLayout){
        navigationView.addHeaderView(LayoutInflater.from(context).inflate(R.layout.header_menu_navigation, navigationView, false));
        navigationView.inflateMenu(R.menu.navigation_menu);
        TextView tvUser = navigationView.getHeaderView(0).findViewById(R.id.tvUSerName);
        tvUser.setText(firebaseModel.getUserName());

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.menuRozklad:
                    fragmentViewer.showFragment(new RozkladFragment());
                    break;
                case R.id.menuTeachers:
                    fragmentViewer.showFragment(new TeacherFragment());
                    break;
                case R.id.menuVisited:
                    fragmentViewer.showFragment(new VisitingFragment());
                    break;
                case R.id.menuMyLecture:
                    fragmentViewer.showFragment(new TeacherRozkladFragment());
                    break;
                case R.id.menuTesting:
                    fragmentViewer.showFragment(new ListTest_for_Student_Fragment());
                    break;
                case R.id.menuTestingManager:
                    fragmentViewer.showFragment(new TestManagerFragment());
                    break;
                case R.id.menuSetting:
                    Toast.makeText(context, "+", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menuExit:
                    firebaseModel.exit();
                    Intent intent = new Intent(context, LoginActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                    break;
                default:
                    Toast.makeText(context, "listener", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawerLayout.closeDrawer(navigationView);
            return false;
        });
    }

    public void refresh(int kodRole) {
        if(kodRole == 3){
            navigationView.getMenu().setGroupVisible(R.id.menuTeacherGroup, true);
            navigationView.getMenu().setGroupVisible(R.id.menuStudentGroup, false);
        }
        if (kodRole == 2){
            navigationView.getMenu().setGroupVisible(R.id.menuTeacherGroup, false);
            navigationView.getMenu().setGroupVisible(R.id.menuStudentGroup, true);
        }
    }

}
