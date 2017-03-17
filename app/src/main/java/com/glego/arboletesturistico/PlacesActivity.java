package com.glego.arboletesturistico;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.os.Bundle;
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
    /**
     *  Strings to store names of bars, hotels and tourist attractions
     *  */
    private String title;
    private String nameTab1;
    private String nameTab2;
    private String nameTab3;

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
        //option = extras.getString("option");

        // Set strings values depending on selected option
        /*if (option.equals("hotel")){

        }else if (option.equals("bar")){

        }else if (option.equals("tour")){

        }*/

        nameTab1 = getString(R.string.hotel_title);
        nameTab2 = getString(R.string.restaurant_title);
        nameTab3 = getString(R.string.tour_title);
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
            HotelListFragment firstFragment = new HotelListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            //firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
            SubMenu subMenu = navigationView.getMenu().getItem(menu_places).getSubMenu();
            menuItem = subMenu.getItem(menu_hotel);
            menuItem.setChecked(true);
        }
    }

    @Override
    protected void setupNavigationDrawerContent() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.hotels_menu:
                        menuItem.setChecked(false);
                        item.setChecked(true);
                        fullLayout.closeDrawer(GravityCompat.START);
                        setFragments(0);
                        break;
                    case R.id.restaurants_menu:
                        menuItem.setChecked(false);
                        item.setChecked(true);
                        fullLayout.closeDrawer(GravityCompat.START);
                        setFragments(1);
                        break;
                    case R.id.tourist_menu:
                        menuItem.setChecked(false);
                        item.setChecked(true);
                        fullLayout.closeDrawer(GravityCompat.START);
                        setFragments(2);
                        break;
                }
                return true;
            }
        });
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    /*public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public ListFragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return tab1Fragment;
                case 1:
                    return tab2Fragment;
                case 2:
                    return tab3Fragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return nameTab1;
                case 1:
                    return nameTab2;
                case 2:
                    return nameTab3;
            }
            return null;
        }
    }*/

    /** Method to set names to all string variables **/
    private void setStringNames(String _title, String _nameTab1, String _nameTab2, String _nameTab3){
        title = _title;
        nameTab1 = _nameTab1;
        nameTab2 = _nameTab2;
        nameTab3 = _nameTab3;
    }

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

    @Override
    protected void onPause() {
        Toast.makeText(this, "Pause state", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {


        Toast.makeText(this, "Resume state", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Stop state", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Destroyed state", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
