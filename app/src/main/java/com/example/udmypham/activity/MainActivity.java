package com.example.udmypham.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.udmypham.R;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

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
        ViewFlipper();
    }

    private void ViewFlipper(){
        int[] arrqoangcao = { R.drawable.qoangcao, R.drawable.qoangcao, R.drawable.qoangcao};
        for (int i=0; i<arrqoangcao.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(arrqoangcao[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
//        ArrayList<String> quangcao = new ArrayList<>();
//        quangcao.add("https://bom.to/kpbbr");
//        quangcao.add("https://bom.to/kpbbr");
//        quangcao.add("https://bom.to/kpbbr");
//        for (int i=0; i<quangcao.size(); i++){
//            ImageView imageView = new ImageView(getApplicationContext());
//            Picasso.get().load(quangcao.get(i)).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.silde_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.tbarHome);
        recyclerView =  findViewById(R.id.recyclerView);
        viewFlipper = findViewById(R.id.ViewFlipper);
        navigationView =  findViewById(R.id.navigationView);
        listView =  findViewById(R.id.lvHome);
        drawerLayout =  findViewById(R.id.brawlayout);
    }

}
