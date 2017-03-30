package com.glego.arboletesturistico;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class DrawerActivity extends AppCompatActivity {

    protected DrawerLayout fullLayout;
    protected Bundle extras;
    protected Toolbar toolbar;
    protected NavigationView navigationView;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        /**
         * This is going to be our actual root layout.
         */
        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer, null);
        /**
         * {@link FrameLayout} to inflate the child's view. We could also use a {@link android.view.ViewStub}
         */
        FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        /**
         * Note that we don't pass the child's layoutId to the parent,
         * instead we pass it our inflated layout.
         */
        super.setContentView(fullLayout);

        /** Create a toolbar and check whether child set Toolbar
         * option or not.
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (useToolbar()){
            toolbar.setTitle(toolbarTitle());
            setSupportActionBar(toolbar);
        }else
            toolbar.setVisibility(View.GONE);

        /** Set the Drawer toggle **/
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupNavigationDrawerContent();
        }

        setupNavigationDrawerContent();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, fullLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        fullLayout.addDrawerListener(toggle);

        toggle.syncState();

        TextView email = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textView);
        TextView username = (TextView) navigationView.getHeaderView(0).findViewById(R.id.user_drawer);
        email.setText(extras.getString("email"));
        username.setText(extras.getString("username"));
    }

    protected String toolbarTitle(){
        return "";
    }


    /**
     * Helper method that can be used by child classes to
     * specify that they don't want a {@link Toolbar}
     * @return true
     */
    protected boolean useToolbar()
    {
        return true;
    }

    @Override
    public void onBackPressed() {
        if (fullLayout.isDrawerOpen(GravityCompat.START)) {
            fullLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    protected void setupNavigationDrawerContent() {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        // Handle navigation view item clicks here.
                        //Intent intent;
                        Handler handler = new Handler();
                        switch (item.getItemId()) {
                            case R.id.home_menu:
                                fullLayout.closeDrawer(GravityCompat.START);
                                // Check whether current activity is Home
                                if (!item.isChecked()) {
                                    intent = putExtras(MainActivity.class);
                                    handler.postDelayed(delay, 150);
                                    item.setChecked(true);      // Start activity after some delay
                                }
                                break;
                            case R.id.menu_profile:
                                fullLayout.closeDrawer(GravityCompat.START);
                                // Check whether current activity is Profile
                                if (!item.isChecked()) {
                                    intent = putExtras(ProfileActivity.class);
                                    handler.postDelayed(delay, 150);    // Start activity after some delay
                                    item.setChecked(true);
                                }
                                break;
                            case R.id.logout_menu:
                                fullLayout.closeDrawer(GravityCompat.START);
                                item.setChecked(true);
                                intent = new Intent(DrawerActivity.this, LoginActivity.class);
                                handler.postDelayed(delay, 150);    // Start activity after some delay
                                break;
                            case R.id.hotels_menu:
                                fullLayout.closeDrawer(GravityCompat.START);
                                intent = putExtras(PlacesActivity.class);
                                intent.putExtra("option", "hotel");
                                handler.postDelayed(delay, 150);    // Start activity after some delay
                                break;
                            case R.id.restaurants_menu:
                                fullLayout.closeDrawer(GravityCompat.START);
                                intent = putExtras(PlacesActivity.class);
                                intent.putExtra("option", "restaurant");
                                handler.postDelayed(delay, 150);    // Start activity after some delay
                                break;
                            case R.id.tourist_menu:
                                fullLayout.closeDrawer(GravityCompat.START);
                                intent = putExtras(PlacesActivity.class);
                                intent.putExtra("option", "tour");
                                handler.postDelayed(delay, 150);    // Start activity after some delay
                                break;
                        }
                        return true;
                    }
                });
    }
    protected Intent intent;
    protected Runnable delay = new Runnable() {
        @Override
        public void run() {
            startActivity(intent);
            finish();
        }
    };
    protected Intent putExtras(Class className){
        Intent intent = new Intent(this, className);
        intent.putExtra("username", extras.getString("username"));
        intent.putExtra("email", extras.getString("email"));
        return intent;
    }
}
