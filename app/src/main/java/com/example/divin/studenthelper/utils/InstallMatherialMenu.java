package com.example.divin.studenthelper.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.divin.studenthelper.fragment.RozkladFragment;
import com.example.divin.studenthelper.mvp.model.FirebaseModel;

public class InstallMatherialMenu {
    private Context context;
    private MaterialMenuDrawable materialMenu;
    private FirebaseModel firebaseModel;
    private FragmentViewer fragmentViewer;
    private View containerView;
    private BaseActivity activity;

    public InstallMatherialMenu(BaseActivity baseActivity, Context context, Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView, LinearLayout fragmentContainer, int titleText, FragmentViewer fragmentViewer) {
        this.context = context;
        this.fragmentViewer = fragmentViewer;
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
                    Toast.makeText(context, "+", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menuTesting:
                    Toast.makeText(context, "+", Toast.LENGTH_SHORT).show();
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
}
