package com.example.divin.studenthelper;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.studenthelper.mvp.presenter.MainPresenter;
import com.example.divin.studenthelper.mvp.view.ImainView;
import com.example.divin.studenthelper.utils.FragmentViewer;
import com.example.divin.studenthelper.utils.InstallMatherialMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ImainView {
    public static int KOD_ROLE = 4;
    public InstallMatherialMenu installMatherialMenu;
    private FragmentViewer fragmentViewer;

    @InjectPresenter
    public MainPresenter mainPresenter;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.drawerWords)
    DrawerLayout drawerLayout;

    @BindView(R.id.myNavigationView)
    NavigationView myNavigationView;

    @BindView(R.id.fragmentContainer)
    LinearLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;

        if(savedInstanceState == null) {
            fragmentViewer = new FragmentViewer(this);
        }
        installMatherialMenu = new InstallMatherialMenu(this,MainActivity.this, toolbar, drawerLayout,
                        myNavigationView, fragmentContainer, R.string.app_name, fragmentViewer);
        mainPresenter.setContext(this);
    }

    @Override
    public void refreshMenu() {
        installMatherialMenu.refresh(KOD_ROLE);
    }
}
