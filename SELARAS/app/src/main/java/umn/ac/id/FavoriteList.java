package umn.ac.id;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import umn.ac.id.Adapter.FavListAdapter;
import umn.ac.id.Database.SQLiteHelper;
import umn.ac.id.Models.Fav;

public class FavoriteList extends AppCompatActivity {
    ListView listView;
    public TextView totalPricetv;
    ArrayList<Fav> list = new ArrayList<Fav>();
    FavListAdapter adapter = null;
    ActionBar actionBar;

    //Database SQLite
    SQLiteHelper helper;

    //Database Firebase
    FirebaseDatabase database;
    DatabaseReference requests;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_list);
        Button btnOrder = (Button) findViewById(R.id.btnPesan);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Firebase
        database = FirebaseDatabase.getInstance();
        requests = database.getReference("Cart");

        listView = (ListView) findViewById(R.id.listView);
        totalPricetv = findViewById(R.id.total);
        int total = 0;
        String totalPrice = null;

        list = new ArrayList<>();
        adapter = new FavListAdapter(this, R.layout.cart_item, list);
        listView.setAdapter(adapter);

        helper = new SQLiteHelper(this, "FoodDB.sqlite", null, 1);

        //get all data from sqlite
        Cursor cursor = helper.getData("SELECT ID, NAME, QUANTITY, PRICE FROM CART");
        Cursor cursor1 = helper.getData("SELECT * FROM CART");

        list.clear();

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String quantity = cursor.getString(2);
                String price = cursor.getString(3);
                Log.e("price: ", price);
                total = total + Integer.parseInt(price);
                Log.e("pricetotal: ", String.valueOf(total));
                list.add(new Fav(id, name, quantity, price));
            } while (cursor.moveToNext());
        }

        totalPricetv.setText(String.valueOf(total));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FavoriteList.this);
                final int pos = position;
                builder.setTitle("Dialog Hapus").setMessage("Apakah anda ingin menhapus item ini ?").setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("CART ID =", list.get(pos).toString());
                        Fav fav = list.get(pos);
                        helper.deleteData(fav.getId());
                        list.remove(pos);
                        adapter.notifyDataSetChanged();
                        listView.invalidateViews();
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }
}