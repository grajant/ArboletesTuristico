package com.glego.arboletesturistico;

import android.support.v4.app.ListFragment;
import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


public class PlacesActivity extends DrawerActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    /**
     *  Strings to store names of bars, hotels and tourist attractions
     *  */
    private String title;
    private String nameTab1;
    private String nameTab2;
    private String nameTab3;

    private String option;

    /**
     * Fragments attributes to replace depending on what option has to be displayed
     */
    private ListFragment tab1Fragment;
    private ListFragment tab2Fragment;
    private ListFragment tab3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        // Get extra from home in order to know which option was selected
        extras = getIntent().getExtras();
        option = extras.getString("option");

        // Set strings values depending on selected option
        if (option.equals("hotel")){

        }else if (option.equals("bar")){

        }else if (option.equals("tour")){

        }
        title = getString(R.string.places);
        nameTab1 = getString(R.string.hotel_title);
        nameTab2 = getString(R.string.restaurant_title);
        nameTab3 = getString(R.string.tour_title);
        tab1Fragment = new HotelListFragment();
        tab2Fragment = new RestaurantListFragment();
        tab3Fragment = new AttractionListFragment();

        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_home; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_places, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home_menu) {
            Intent intent = new Intent(PlacesActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

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
    }

    /** Method to set names to all string variables **/
    private void setStringNames(String _title, String _nameTab1, String _nameTab2, String _nameTab3){
        title = _title;
        nameTab1 = _nameTab1;
        nameTab2 = _nameTab2;
        nameTab3 = _nameTab3;
    }

    /** Method to set fragments to every tab **/
    private void setFragments(int option){

    }
}
