package com.glego.arboletesturistico;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.glego.arboletesturistico.Fragments.AttractionListFragment;
import com.glego.arboletesturistico.Fragments.HotelListFragment;
import com.glego.arboletesturistico.Fragments.RestaurantListFragment;


public class PlacesActivity extends DrawerActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private static int menu_places = 2;
    private static int menu_hotel = 0;
    private static int menu_restaurant = 1;
    private static int menu_attractions = 2;
    /**
     *  Strings to store names of bars, hotels and tourist attractions
     *  */
    private int position;

    private String option;

    private MenuItem menuItem;
    /**
     * Fragments attributes to replace depending on what option has to be displayed
     */
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        // Get extra from home in order to know which option was selected
        extras = getIntent().getExtras();
        option = extras.getString("option");

        if (navigationView != null) {
            setupNavigationDrawerContent();
        }

        setupNavigationDrawerContent();
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            // Set fragment depending on selected option
            if (option.equals("hotel")){
                listFragment = new HotelListFragment();
                checkMenuOption(menu_hotel);
            }else if (option.equals("restaurant")){
                listFragment = new RestaurantListFragment();
                checkMenuOption(menu_restaurant);
            }else if (option.equals("tour")){
                listFragment = new AttractionListFragment();
                checkMenuOption(menu_attractions);
            }

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, listFragment).commit();
            setupWindowAnimations();
        }
    }

    private void checkMenuOption(int menu){
        SubMenu subMenu = navigationView.getMenu().getItem(menu_places).getSubMenu();
        menuItem = subMenu.getItem(menu);
        menuItem.setChecked(true);
    }

    @Override
    protected void setupNavigationDrawerContent() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Handler handler = new Handler();
                switch (item.getItemId())
                {
                    case R.id.home_menu:
                        fullLayout.closeDrawer(GravityCompat.START);
                        item.setChecked(true);
                        intent = putExtras(MainActivity.class);
                        handler.postDelayed(delayActivity, 150);    // Start activity after some delay
                        break;
                    case R.id.menu_profile:
                        fullLayout.closeDrawer(GravityCompat.START);
                        item.setChecked(true);
                        intent = putExtras(ProfileActivity.class);
                        handler.postDelayed(delayActivity, 150);    // Start activity after some delay
                        break;
                    case R.id.logout_menu:
                        fullLayout.closeDrawer(GravityCompat.START);
                        intent = new Intent(PlacesActivity.this, LoginActivity.class);
                        handler.postDelayed(delayActivity, 150);    // Start activity after some delay
                        break;
                    case R.id.hotels_menu:
                        position = 0;
                        menuItem.setChecked(false);
                        item.setChecked(true);
                        fullLayout.closeDrawer(GravityCompat.START);
                        handler.postDelayed(delay, 300);
                        break;
                    case R.id.restaurants_menu:
                        position = 1;
                        menuItem.setChecked(false);
                        item.setChecked(true);
                        fullLayout.closeDrawer(GravityCompat.START);
                        handler.postDelayed(delay, 300);
                        break;
                    case R.id.tourist_menu:
                        position = 2;
                        menuItem.setChecked(false);
                        item.setChecked(true);
                        fullLayout.closeDrawer(GravityCompat.START);
                        handler.postDelayed(delay, 300);
                        break;
                }
                return true;
            }
        });
    }

    private Runnable delayActivity = new Runnable() {
        @Override
        public void run() {
            startActivity(intent);
            finish();
        }
    };
    protected Runnable delay = new Runnable() {
        @Override
        public void run() {
            setFragments(position);
        }
    };

    /** Method to set fragments to every tab **/
    private void setFragments(int position){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                listFragment = new HotelListFragment();
                fragmentTransaction.replace(R.id.fragment_container, listFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                listFragment = new RestaurantListFragment();
                fragmentTransaction.replace(R.id.fragment_container, listFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                listFragment = new AttractionListFragment();
                fragmentTransaction.replace(R.id.fragment_container, listFragment);
                fragmentTransaction.commit();
        }
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setEnterTransition(slide);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
