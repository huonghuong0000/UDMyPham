package com.example.udmypham.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.udmypham.R;
import com.example.udmypham.adapter.ProductAdapter;
import com.example.udmypham.adapter.categoryAdapter;
import com.example.udmypham.model.category;
import com.example.udmypham.model.product;
import com.example.udmypham.util.CheckConnection;
import com.example.udmypham.util.server;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView;
    DrawerLayout drawerLayout;
    ArrayList<category> arrLoaiSP;
    categoryAdapter categoryAdapter;
    int id = 0;
    String name = "";
    String image = "";

    //mảng sp
    ArrayList<product> arrayProduct;
    ProductAdapter productAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ViewFlipper();
            GetDuLieuCategory();
            GetDLProductNew();
            CatchOnItemListView();
        }else {
            CheckConnection.Show_thongbao(getApplicationContext(), "Kiểm tra lại kết nối của bạn!!!");
            finish();
        }

    }

    private void CatchOnItemListView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0: {
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        } else {
                            CheckConnection.Show_thongbao(getApplicationContext(), "Kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case 2:{
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                            intent.putExtra("idloaiSP");
                        } else {
                            CheckConnection.Show_thongbao(getApplicationContext(), "Kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                }
            }
        });
    }

    private void GetDLProductNew() {
        RequestQueue requestQueue = Volley.newRequestQueue(this.getApplicationContext());
//        final String url = "http://192.168.43.154/MyPham/getproductnew.php";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server.DuongDanProductNew, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response != null){
                    int id = 0;
                    int id_category=0;
                    String NameSP = "";
                    Integer PriceSP= 0;
                    String Image = "";
                    String Detail = "";
                    for (int i=0; i<response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            id_category = jsonObject.getInt("id_category");
                            NameSP = jsonObject.getString("name");
                            PriceSP = jsonObject.getInt("price");
                            Image = jsonObject.getString("image");
                            Detail = jsonObject.getString("detail");
                            arrayProduct.add(new product(id,id_category,NameSP,PriceSP,Image,Detail));
                            productAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDuLieuCategory() {
        RequestQueue requestQueue = Volley.newRequestQueue(this.getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(server.DuongdanCategorry, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    for (int i=0; i<response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            //lấy dl ra
                            id = jsonObject.getInt("id");
                            name = jsonObject.getString("name");
                            image = jsonObject.getString("image");
                            arrLoaiSP.add(new category(id, name, image));
                            categoryAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    arrLoaiSP.add(4, new category(0, "Liên hệ", "https://i.ibb.co/QpDzZBJ/t-i-xu-ng.png" ));
                    arrLoaiSP.add(5, new category(0, "Thông tin", "https://i.ibb.co/2KWFwjX/pngtree-electronic-contact-icon-design-png-image-4456931.jpg" +
                            ""));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.Show_thongbao(getApplicationContext(), error.toString());

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void ViewFlipper(){
//        int[] arrqoangcao = { R.drawable.qoangcao, R.drawable.son, R.drawable.son2, R.drawable.phan};
//        for (int i=0; i<arrqoangcao.length; i++){
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(arrqoangcao[i]);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
        ArrayList<String> quangcao = new ArrayList<>();
        quangcao.add("https://i.ibb.co/HLvrNjW/phan.jpg");
        quangcao.add("https://i.ibb.co/vsCBtnn/son2.jpg");
        quangcao.add("https://i.ibb.co/FqxtmBW/son.jpg");
        for (int i=0; i<quangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext())
                    .load(quangcao.get(i))
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
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
        arrLoaiSP = new ArrayList<>();
        arrLoaiSP.add(0,new category(0,"Home", "https://i.ibb.co/D7W56cN/Website-and-programming-28-512.png" ));
        categoryAdapter = new categoryAdapter(arrLoaiSP, getApplicationContext());
        listView.setAdapter(categoryAdapter);
        arrayProduct = new ArrayList<>();
        productAdapter = new ProductAdapter(getApplicationContext(), arrayProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(productAdapter);
    }

}
