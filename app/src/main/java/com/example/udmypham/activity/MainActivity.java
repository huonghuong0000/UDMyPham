package com.example.udmypham.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.v7.Toolbar;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udmypham.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionBar();
    }

    private  void  ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setCollapseIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.tbarHome);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        viewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        listView = (ListView) findViewById(R.id.lvHome);
        drawerLayout = (DrawerLayout) findViewById(R.id.brawlayout);
    }
}
