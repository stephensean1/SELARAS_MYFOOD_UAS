package umn.ac.id;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import umn.ac.id.Adapter.FoodAdapter;
import umn.ac.id.Models.Food;

public class DaftarMenu extends AppCompatActivity {

    //Menampilkan Gambar
    public static final int REQUEST_CODE = 1;

    //Nilai variabel akan diambil dari FoodAdapter
    FoodAdapter adapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("PIZZA","Asal Makanan : \nItalia", R.drawable.a1, 50000));
        foods.add(new Food("SATE SAPI","Asal Makanan : \nIndonesian", R.drawable.a2, 35000));
        foods.add(new Food("MATABRAK TELOR","Asal Makanan : \nArab Saudi", R.drawable.a3, 40000));
        foods.add(new Food("BAKSO","Asal Makanan : \nTiongkok", R.drawable.a4, 30000));
        foods.add(new Food("NASI GORENG","Asal Makanan : \nTionghoa", R.drawable.a5, 25000));
        foods.add(new Food("TEMPE GORENG","Asal Makanan : \nIndonesian", R.drawable.a6, 20000));

        //menghubungkan data dengan view
        adapter = new FoodAdapter(this, foods);
        ListView orderListView = (ListView)findViewById(R.id.order_list_view);
        orderListView.setAdapter(adapter);
        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(DaftarMenu.this,FoodDetail.class);

                Food currentFood = foods.get(position);
                Log.e("FOOD NAME",currentFood.getFoodName());
                i.putExtra("image",currentFood.getmImageResouce());
                i.putExtra("name",currentFood.getFoodName());
                i.putExtra("type",currentFood.getType());
                i.putExtra("price",currentFood.getFoodPrice());
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                Intent i = new Intent(DaftarMenu.this,CartList.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}