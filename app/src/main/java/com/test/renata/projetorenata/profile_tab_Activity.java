package com.test.renata.projetorenata;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class profile_tab_Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter_profile mSectionsPagerAdapter_profile;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_tab);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter_profile = new SectionsPagerAdapter_profile(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager_profile = (ViewPager) findViewById(R.id.container_profile);
        mViewPager_profile.setAdapter(mSectionsPagerAdapter_profile);

        TabLayout tabLayout_profile = (TabLayout) findViewById(R.id.tabs_profile);

        mViewPager_profile.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_profile));
        tabLayout_profile.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager_profile));

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment_profile extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER_profile = "section_number";

        public PlaceholderFragment_profile() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment_profile newInstance(int sectionNumber) {
            PlaceholderFragment_profile fragment = new PlaceholderFragment_profile();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER_profile, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_profile_tab, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter_profile extends FragmentPagerAdapter {

        public SectionsPagerAdapter_profile(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment_profile.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 1;
        }
    }
}
