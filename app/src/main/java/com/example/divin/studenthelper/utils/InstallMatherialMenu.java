package com.example.divin.studenthelper.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.example.divin.studenthelper.R;

public class InstallMatherialMenu {
    private Context context;
    private MaterialMenuDrawable materialMenu;
    private FragmentViewer fragmentViewer;
    private View containerView;

    public InstallMatherialMenu(Context context, Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView, LinearLayout fragmentContainer, int titleText, FragmentViewer fragmentViewer) {
        this.context = context;
        this.fragmentViewer = fragmentViewer;
        containerView = fragmentContainer;

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

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
//                case R.id.openLearn:
//                    fragmentViewer.showFragment(new TestingManagerFragment());
//                    break;
//                case R.id.addNewTheme:
//                    fragmentViewer.showFragment(new NewThemeFragment());
//                    break;
//                case R.id.openNewWord:
//                    fragmentViewer.showFragment(new NewWordFragment());
//                    break;
//                case R.id.openMyWords:
//                    fragmentViewer.showFragment(new MyWordsFragment());
//                    break;
                default:
                    Toast.makeText(context, "listener", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawerLayout.closeDrawer(navigationView);
            return false;
        });
    }
}
