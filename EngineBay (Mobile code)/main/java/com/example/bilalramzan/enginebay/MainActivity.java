package com.example.bilalramzan.enginebay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FrameLayout frame;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


            //Floating Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                final PackageManager pm=getPackageManager();
                final List<ResolveInfo> matches=pm.queryIntentActivities(i,0);
                ResolveInfo best=null;
                for(final ResolveInfo info:matches)
                    if (info.activityInfo.packageName.endsWith(".gm") || info.activityInfo.name.toLowerCase().contains("gmail"))
                        best=info;
                                if (best!=null)
                                    i.setClassName(best.activityInfo.packageName,best.activityInfo.name);
                startActivity(i);
                Snackbar.make(view, "Leave a Message.....  Please!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

         navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FM=getSupportFragmentManager();
        FT=FM.beginTransaction();

        FT=FM.beginTransaction();
        FT.replace(R.id.ContainerView,new Home()).commit();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        //if (id == R.id.action_settings) {
            return true;
       // }

       // return super.onOptionsItemSelected(item);
    }

 //   private void displayselectedscreen(int id)
   // {


    //}

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentTransaction ftrans;
        int id = item.getItemId();  // displayselectedscreen(id);

        if (id == R.id.nav_home)
        {
            ftrans=FM.beginTransaction();
            ftrans.replace(R.id.ContainerView,new Home()).commit();

        }
        else if (id == R.id.nav_gallery)
        {
            ftrans=FM.beginTransaction();
            ftrans.replace(R.id.ContainerView,new Gallery()).commit();
        }
        else if (id == R.id.nav_reserve)
        {
            ftrans=FM.beginTransaction();
            TabFragment tf=new TabFragment();
            ftrans.replace(R.id.ContainerView,new Available_tab1()).commit();
        }

        else if (id == R.id.nav_share)
        {
            ftrans=FM.beginTransaction();

            ftrans.replace(R.id.ContainerView,new Terms()).commit();
        }
        else if (id == R.id.nav_about)
        {
            ftrans=FM.beginTransaction();

            ftrans.replace(R.id.ContainerView,new About()).commit();
        }
        else if (id == R.id.nav_signout)
        {
            AlertDialog.Builder AD=new AlertDialog.Builder(MainActivity.this);
            AD.setTitle("Confirm SignOut");
            AD.setMessage("Are you sure you want to signOut?");
            AD.setIcon(R.drawable.ic_logout_black);
            AD.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    Intent i=new Intent(getApplicationContext(),firstActivity.class);
                    startActivity(i);
                }
            });

            AD.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AD.show();
        }
       DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
