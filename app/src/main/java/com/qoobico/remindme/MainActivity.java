package com.qoobico.remindme;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by Aleksandr on 20.01.2016.
 * Main activuty
 */
public class MainActivity extends AppCompatActivity {


    // Here we introduce our general viarables, elements
    public static final int LAYOUT=R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        //we insert a toolbar to the layout
        initToolbar();
        //we add content to navigation bar
        initNavigationView();

    }

    private void initToolbar() {
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
   }

    //method for navigation view filling
    private void initNavigationView() {
    drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
    }
}
