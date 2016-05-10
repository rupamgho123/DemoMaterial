package com.example.demomaterial;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends BaseActivity implements ActivityFragementInteractionListener {

    private ActionBarDrawerToggle mDrawerToggle;

    private static DisplayMetrics displayMetrics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayMetrics = getResources().getDisplayMetrics();
        setContentView(R.layout.base_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);

        setupDrawerLayoutWidth(drawerLayout);
        openFragment1();
    }

    public void toggleDrawerLayout() {
        if (!mDrawerToggle.isDrawerIndicatorEnabled()) {
            onBackPressed();
        } else if (drawerLayout != null) {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) drawerLayout.closeDrawer(Gravity.LEFT);
            else {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        }
    }


    private void setupDrawerLayoutWidth(DrawerLayout drawerLayout) {
        NavigationView navigationView = (NavigationView) drawerLayout.findViewById(R.id.flyout_navigation_view);
        int drawerWidth = displayMetrics.widthPixels - dpToPx(48);
        navigationView.setMinimumWidth(drawerWidth);
    }

    public static int dpToPx(int dp) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
        if (px < 1.0f) {
            px = 0;
        }
        return (int) px;
    }


    public void openFragment1() {
        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, Fragment1.getInstance()).commit();
    }

    public void openFragment2() {
        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, Fragment2.getInstance()).commit();
    }

    @Override
    public void initToolBar(Toolbar toolbar) {
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        };

        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                    onBackPressed();
                    return;
                }
                toggleDrawerLayout();
            }
        });

        drawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void lockOrUnlockDrawer(boolean doLock) {
        if(drawerLayout!=null) {
            if (doLock) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.LEFT);
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.LEFT);
            }
        }
    }
}
