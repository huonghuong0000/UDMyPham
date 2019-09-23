package com.example.udmypham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.tbarHome);
        recyclerView = findViewById(R.id.recyclerView);
        viewFlipper = findViewById(R.id.ViewFlipper);
        navigationView = findViewById(R.id.navigationView);
        listView = findViewById(R.id.lvHome);
    }
}
