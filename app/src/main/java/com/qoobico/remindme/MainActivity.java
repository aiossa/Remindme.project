package com.qoobico.remindme;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.qoobico.remindme.adapter.TabsFragmentAdapter;

/**
 * Created by Aleksandr on 20.01.2016.
 * Main activuty
 */
public class MainActivity extends AppCompatActivity {


    // Here we introduce our general viarables, elements
    private static final int LAYOUT=R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    //private TableLayout tableLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        //we insert a toolbar to the layout
        initToolbar();
        //we add content to navigation bar
        initNavigationView();
        //we need this method to introduce tabs (view pager)
        initTabs();


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

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }

    //method for navigation view filling
    private void initNavigationView() {
    drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,
                R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=  (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.actionNotificationItem:
                        showNotificationTab();


                }



                return true;
            }
        });
    }

    //introduce method for notification opening
    private void showNotificationTab(){
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }


}
