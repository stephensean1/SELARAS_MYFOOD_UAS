package umn.ac.id;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import umn.ac.id.Adapter.CartListAdapter;
import umn.ac.id.Database.SQLiteHelper;
import umn.ac.id.Models.Cart;
import umn.ac.id.Models.Request;


public class CartList extends AppCompatActivity {
    ListView listView;
    public TextView totalPricetv;
    ArrayList<Cart> list = new ArrayList<Cart>();
    CartListAdapter adapter = null;
    ActionBar actionBar;

    //Database SQLite
    SQLiteHelper helper;

    //Database Firebase
    FirebaseDatabase database;
    DatabaseReference requests;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        Button btnOrder = (Button)findViewById(R.id.btnPesan);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Firebase
        database = FirebaseDatabase.getInstance();
        requests = database.getReference("Cart");

        listView = (ListView)findViewById(R.id.listView);
        totalPricetv = findViewById(R.id.total);
        int total = 0;
        String totalPrice = null;

        list = new ArrayList<>();
        adapter = new CartListAdapter(this, R.layout.cart_item, list);
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
                list.add(new Cart(id, name, quantity, price));
            } while (cursor.moveToNext());
        }

        totalPricetv.setText(String.valueOf(total));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CartList.this);
                final int pos = position;
                builder.setTitle("Dialog Hapus").setMessage("Apakah anda ingin menhapus item ini ?").setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("CART ID =", list.get(pos).toString());
                        Cart cart = list.get(pos);
                        helper.deleteData(cart.getId());
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
        // Order
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartList.this,DialogOrder.class);
                startActivity(intent);
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
}