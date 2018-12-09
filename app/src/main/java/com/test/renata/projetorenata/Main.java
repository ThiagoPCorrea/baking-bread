package com.test.renata.projetorenata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.CardView;
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

import circList.CircularLinkedList;
import circList.ListaInstance;
import elementos.Receita;


import java.util.ArrayList;

import circList.CircularLinkedList;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<View> v = new ArrayList<>();
    //private static CircularLinkedList<Receita> receita;
    private static CircularLinkedList<Receita> receitaprincipal;
    private static CircularLinkedList<Receita> receitanew;
    private static CircularLinkedList<Receita> receitarecomend;
    private static CircularLinkedList<Receita> receitafavorita;
    private static CircularLinkedList<Receita> receitayour;
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
    ///////////////////////////////////////////////////////////
    //Profile Pager//
    private SectionsPagerAdapter_profile mSectionsPagerAdapter_profile;
    private ViewPager mViewPager_profile;

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
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ///////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////
        //Profile Pager//
        mSectionsPagerAdapter_profile = new SectionsPagerAdapter_profile(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager_profile = (ViewPager) findViewById(R.id.container_profile);
        mViewPager_profile.setAdapter(mSectionsPagerAdapter_profile);

        TabLayout tabLayout_profile = (TabLayout) findViewById(R.id.tabs_profile);

        mViewPager_profile.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_profile));
        tabLayout_profile.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager_profile));
        /////////////////////////////////////////////
        ///listas receitas///
        receitaprincipal = ListaInstance.init1();
        receitanew = ListaInstance.init2();
        receitarecomend = ListaInstance.init3();
        receitafavorita = ListaInstance.init4();
        receitayour = ListaInstance.init5();
        /////////////////////////////
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

    public static void UpdateCard(CircularLinkedList<Receita> receita, View rootView,boolean profile ){
        if(!profile){
            ImageView image = rootView.findViewById(R.id.Card_image);
            image.setImageResource(R.drawable.bolo_de_cenoura);
            TextView textPrincipal = rootView.findViewById(R.id.Card_text_NomeComida);
            textPrincipal.setText(receita.element().getNome());
            TextView textCategoria = rootView.findViewById(R.id.Card_NomeCategoria);
            textCategoria.setText(receita.element().getCategoria());
            TextView textTime = rootView.findViewById(R.id.Card_TempoPreparo);
            textTime.setText(receita.element().getTempo());
        }else{
            ImageView image = rootView.findViewById(R.id.profile_Card_image);
            image.setImageResource(R.drawable.bolo_de_cenoura);
            TextView textPrincipal = rootView.findViewById(R.id.profile_Card_text_NomeComida);
            textPrincipal.setText(receita.element().getNome());
            TextView textCategoria = rootView.findViewById(R.id.profile_Card_NomeCategoria);
            textCategoria.setText(receita.element().getCategoria());
            TextView textTime = rootView.findViewById(R.id.profile_Card_TempoPreparo);
            textTime.setText(receita.element().getTempo());
        }
        
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
            final View rootView = inflater.inflate(R.layout.fragment_card_view_tab, container, false);
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){

                //receita = ListaInstance.init1();
                UpdateCard(receitaprincipal,rootView,false);
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
                        Receita aux = receitaprincipal.remove();
                        receitaprincipal.add(aux);
                        UpdateCard(receitaprincipal,rootView,false);
                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Receita aux = receitaprincipal.removeLast();
                        receitaprincipal.addFirst(aux);
                        UpdateCard(receitaprincipal,rootView,false);
                    }
                });
                return rootView;
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){

                //receita = ListaInstance.init2();

                UpdateCard(receitanew,rootView,false);
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
                        Receita aux = receitanew.remove();
                        receitanew.add(aux);
                        UpdateCard(receitanew,rootView,false);
                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Receita aux = receitanew.removeLast();
                        receitanew.addFirst(aux);
                        UpdateCard(receitanew,rootView,false);
                    }
                });
                return rootView;
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){

                //receita = ListaInstance.init3();

                UpdateCard(receitarecomend,rootView,false);
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
                        Receita aux = receitarecomend.remove();
                        receitarecomend.add(aux);
                        UpdateCard(receitarecomend,rootView,false);
                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Receita aux = receitarecomend.removeLast();
                        receitarecomend.addFirst(aux);
                        UpdateCard(receitarecomend,rootView,false);
                    }
                });
                return rootView;
            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 4){

                //receita = ListaInstance.init4();

                UpdateCard(receitafavorita,rootView,false);
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
                        Receita aux = receitafavorita.remove();
                        receitafavorita.add(aux);
                        UpdateCard(receitafavorita,rootView,false);
                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Receita aux = receitafavorita.removeLast();
                        receitafavorita.addFirst(aux);
                        UpdateCard(receitafavorita,rootView,false);
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
        ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    //profile pager
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
                final View rootView = inflater.inflate(R.layout.fragment_profile_tab, container, false);

                //receita = ListaInstance.init5();

                UpdateCard(receitayour,rootView,true);

                CardView food = rootView.findViewById(R.id.profile_cardView);
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainContext,ComidaActivity.class);
                        startActivity(i);
                    }
                });
                ImageButton rightButton = rootView.findViewById(R.id.profile_rightCardbutton);
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Receita aux = receitayour.remove();
                        receitayour.add(aux);
                        UpdateCard(receitayour,rootView,true);
                    }
                });
                ImageButton leftButton = rootView.findViewById(R.id.profile_leftCardbutton);
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Receita aux = receitayour.removeLast();
                        receitayour.addFirst(aux);
                        UpdateCard(receitayour,rootView,true);
                    }
                });
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