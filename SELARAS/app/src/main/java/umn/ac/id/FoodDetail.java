package umn.ac.id;

import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import umn.ac.id.Database.SQLiteHelper;

public class FoodDetail extends AppCompatActivity {
    private int item = 0;
    private int price = 0;
    TextView sumTextView;
    TextView priceTotalTextView;
    TextView txtName, txtQuantity, txtPrice;
    Button btnAdd, btnCart;
    ActionBar actionBar;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        sqLiteHelper = new SQLiteHelper(this, "FoodDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS CART(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, quantity INTEGER, price INTEGER)");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item < 1) {
                    Toast.makeText(FoodDetail.this, "Maaf anda tidak dapat memesan kurang dari 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    Log.i("TXT PRICE", txtName.getText().toString());
                    sqLiteHelper.insertData(
                            txtName.getText().toString().trim(),
                            txtQuantity.getText().toString().trim(),
                            txtPrice.getText().toString().trim()
                    );
                    Toast.makeText(getApplicationContext(), "Masuk Keranjang!", Toast.LENGTH_SHORT).show();
                    txtQuantity.setText("0");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodDetail.this, CartList.class);
                startActivity(intent);
            }
        });
        String name = getIntent().getStringExtra("name");
        String typs = getIntent().getStringExtra("type");
        int image;
        image = getIntent().getIntExtra("image", -1);
        price = getIntent().getIntExtra("price", -1);
        Log.e("SECOND ACTIVITY", name);

        TextView nameTextView = (TextView)findViewById(R.id.food_name_text_view);
        nameTextView.setText(name);
        TextView type = (TextView)findViewById(R.id.type);
        type.setText(typs);
        ImageView imageView = (ImageView)findViewById(R.id.food_image);
        imageView.setImageResource(image);
        imageView.setVisibility(View.VISIBLE);
        TextView priceTextView = (TextView)findViewById(R.id.price_detail_text_view);
        priceTextView.setText(Integer.toString(price));

        sumTextView = (TextView) findViewById(R.id.sum_text_view);
        priceTotalTextView = (TextView) findViewById(R.id.price_total_text_view);

        //inisialisasi variabel terhadap method increment dan decrement
        Button incrementButton = (Button)findViewById(R.id.increment_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });
        Button decrementButton = (Button) findViewById(R.id.decrement_button);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
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
        private void init() {
            txtName = findViewById(R.id.food_name_text_view);
            txtQuantity = findViewById(R.id.sum_text_view);
            txtPrice = findViewById(R.id.price_total_text_view);
            btnAdd = findViewById(R.id.order_button);
            btnCart = findViewById(R.id.cart_button);
        }
        //method increment
        private void increment () {
            item++;
            sumTextView.setText(Integer.toString(item));
            priceTotalTextView.setText(Integer.toString(sumOfProduct(price)));
        }
        //method decrement
        private void decrement() {
            if (item < 1) {
                Toast.makeText(this, "Maaf anda tidak dapat memesan kurang dari 1", Toast.LENGTH_SHORT).show();
                return;
            }
            item = item - 1;
            sumTextView.setText(Integer.toString(item));
            priceTotalTextView.setText(Integer.toString(sumOfProduct(price)));
        }
        private int sumOfProduct ( int price){
            return item * price;
        }
    }