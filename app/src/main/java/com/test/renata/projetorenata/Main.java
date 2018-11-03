package com.test.renata.projetorenata;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import java.util.ArrayList;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList <View> v = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        Button filtro = (Button) findViewById(R.id.filter);
        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main.this,FilterActivity.class);
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
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(v.size() > 1){
                ReturnLayout();
                /*View i = v.get(v.size()-1);
                v.remove(v.size()-1);
                View j = v.get(v.size()-1);
                //View i = findViewById(R.id.menu);
                //View j = findViewById(R.id.profile);
                j.setVisibility(View.VISIBLE);
                i.setVisibility(View.GONE);
                ChangeNavScreen(R.id.toolbarmain);
                navigationView.setCheckedItem(R.id.menutext);*/
            }else{
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
            addNewLayout(R.id.profile,R.id.toolbarprofile);
        } else if (id == R.id.menutext) {
            addNewLayout(R.id.menu,R.id.toolbarmain);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void addNewLayout(int idlayout,int idbar){
        View i = v.get(v.size()-1);
        v.add(findViewById(idlayout));
        View j = findViewById(idlayout);
        i.setVisibility(View.GONE);
        j.setVisibility(View.VISIBLE);
        ChangeNavScreen(idbar);
    }

    public void ReturnLayout(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View i = v.get(v.size()-1);
        v.remove(v.size()-1);
        View j = v.get(v.size()-1);
        j.setVisibility(View.VISIBLE);
        i.setVisibility(View.GONE);
        if(j.getId() == R.id.profile){
            ChangeNavScreen(R.id.toolbarprofile);
            navigationView.setCheckedItem(R.id.profiletext);
        }else if(j.getId() == R.id.menu){
            ChangeNavScreen(R.id.toolbarmain);
            navigationView.setCheckedItem(R.id.menutext);
        }
    }

    public void ChangeNavScreen(int idbar){
        Toolbar toolbar = (Toolbar) findViewById(idbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
}
