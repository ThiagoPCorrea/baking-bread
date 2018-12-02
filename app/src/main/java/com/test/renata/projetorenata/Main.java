package com.test.renata.projetorenata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MotionEvent;


import java.util.ArrayList;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<View> v = new ArrayList<>();
    private static Context MainContext;

    //Activity_tab
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private Main.SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);
        Button filtro = (Button) findViewById(R.id.filter);
        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main.this, FilterActivity.class);
                startActivity(i);
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.menutext);
        v.add(findViewById(R.id.menu));
        navigationView.setNavigationItemSelectedListener(this);
        //Tab Activity
        mSectionsPagerAdapter = new Main.SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        ////////////////////////////////////////////////////////////


        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (v.size() > 1) {
                ReturnLayout();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profiletext) {
            addNewLayout(R.id.profile, R.id.toolbarprofile);
        } else if (id == R.id.menutext) {
            addNewLayout(R.id.menu, R.id.toolbarmain);
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addNewLayout(int idlayout, int idbar) {
        View i = v.get(v.size() - 1);
        v.add(findViewById(idlayout));
        View j = findViewById(idlayout);
        i.setVisibility(View.GONE);
        j.setVisibility(View.VISIBLE);
        ChangeNavScreen(idbar);
    }

    public void ReturnLayout() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View i = v.get(v.size() - 1);
        v.remove(v.size() - 1);
        View j = v.get(v.size() - 1);
        j.setVisibility(View.VISIBLE);
        i.setVisibility(View.GONE);
        if (j.getId() == R.id.profile) {
            ChangeNavScreen(R.id.toolbarprofile);
            navigationView.setCheckedItem(R.id.profiletext);
        } else if (j.getId() == R.id.menu) {
            ChangeNavScreen(R.id.toolbarmain);
            navigationView.setCheckedItem(R.id.menutext);
        }
    }

    public void ChangeNavScreen(int idbar) {
        Toolbar toolbar = (Toolbar) findViewById(idbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }


    //Activity_tab
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static Main.PlaceholderFragment newInstance(int sectionNumber) {
            Main.PlaceholderFragment fragment = new Main.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_card_view_tab, container, false);
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
                ImageView image = rootView.findViewById(R.id.Card_image);
                image.setImageResource(R.drawable.bolo_de_cenoura);
                TextView textPrincipal = rootView.findViewById(R.id.Card_text_NomeComida);
                textPrincipal.setText("Bolo de Cenoura");
                TextView textCategoria = rootView.findViewById(R.id.Card_NomeCategoria);
                textCategoria.setText("Doce");
                TextView textTime = rootView.findViewById(R.id.Card_TempoPreparo);
                textTime.setText("2 Horas");
                CardView food = rootView.findViewById(R.id.cardView);
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainContext,ComidaActivity.class);
                        startActivity(i);
                    }
                });
                ImageButton rightButton = rootView.findViewById(R.id.rightCardbutton);
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                return rootView;
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                ImageView image = rootView.findViewById(R.id.Card_image);
                image.setImageResource(R.drawable.coxinha);
                TextView textPrincipal = rootView.findViewById(R.id.Card_text_NomeComida);
                textPrincipal.setText("Coxinha de Frango");
                TextView textCategoria = rootView.findViewById(R.id.Card_NomeCategoria);
                textCategoria.setText("Salgado");
                TextView textTime = rootView.findViewById(R.id.Card_TempoPreparo);
                textTime.setText("3 Horas");
                CardView food = rootView.findViewById(R.id.cardView);
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent i = new Intent(MainContext,ComidaActivity.class);
                        //startActivity(i);
                    }
                });
                ImageButton rightButton = rootView.findViewById(R.id.rightCardbutton);
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                return rootView;
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){
                ImageView image = rootView.findViewById(R.id.Card_image);
                image.setImageResource(R.drawable.panqueca_de_frango);
                TextView textPrincipal = rootView.findViewById(R.id.Card_text_NomeComida);
                textPrincipal.setText("Panqueca de Frango");
                TextView textCategoria = rootView.findViewById(R.id.Card_NomeCategoria);
                textCategoria.setText("Salgado");
                TextView textTime = rootView.findViewById(R.id.Card_TempoPreparo);
                textTime.setText("50 Minutos");
                CardView food = rootView.findViewById(R.id.cardView);
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainContext,FilterActivity.class);
                        //startActivity(i);
                    }
                });
                ImageButton rightButton = rootView.findViewById(R.id.rightCardbutton);
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                return rootView;
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 4){
                ImageView image = rootView.findViewById(R.id.Card_image);
                image.setImageResource(R.drawable.torta_holandesa);
                TextView textPrincipal = rootView.findViewById(R.id.Card_text_NomeComida);
                textPrincipal.setText("Torta Holandesa");
                TextView textCategoria = rootView.findViewById(R.id.Card_NomeCategoria);
                textCategoria.setText("Doce");
                TextView textTime = rootView.findViewById(R.id.Card_TempoPreparo);
                textTime.setText("2 Horas");
                CardView food = rootView.findViewById(R.id.cardView);
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainContext,FilterActivity.class);
                        //startActivity(i);
                    }
                });
                ImageButton rightButton = rootView.findViewById(R.id.rightCardbutton);
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                return rootView;
            }
            return rootView;
        }
    }

        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                return Main.PlaceholderFragment.newInstance(position + 1);
            }

            @Override
            public int getCount() {
                return 4;
            }
        }
        ///////////////////////////////////////
}