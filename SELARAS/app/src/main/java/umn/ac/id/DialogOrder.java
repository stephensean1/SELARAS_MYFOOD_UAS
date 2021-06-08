package umn.ac.id;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import androidx.appcompat.app.ActionBar;

import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import umn.ac.id.Models.Request;

public class DialogOrder extends AppCompatActivity {

    private EditText nama;
    private EditText notelepon;
    private EditText alamat;
    private Button method_button;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_order);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        nama = findViewById(R.id.nama_pemesan);
        notelepon = findViewById(R.id.nomor_telepon);
        alamat = findViewById(R.id.alamat_pengiriman);
        method_button = findViewById(R.id.method_button);

        method_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getNama = nama.getText().toString();
                String getNotelepon = notelepon.getText().toString();
                String getAlamat = alamat.getText().toString();

                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("Nama",getNama);
                hashMap.put("No telepon",getNotelepon);
                hashMap.put("Alamat pengiriman",getAlamat);
                databaseReference.child("DataOrderUser")
                        .child(getNama)
                        .setValue(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(DialogOrder.this, "Data pemesan berhasil disimpan", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(DialogOrder.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                Intent intent = new Intent(DialogOrder.this,MetodePembayaran.class);
                startActivity(intent);

            }
        });

       /* @Override
        public void onBackPressed() {
            super.onBackPressed();
        }
        private void showAlertDialog() {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(CartList.this);
            View mView = getLayoutInflater().inflate(R.layout.activity_dialog_order, null);
            final EditText mName = (EditText) mView.findViewById(R.id.edit_nama_pemesan);
            final EditText mTlp = (EditText) mView.findViewById(R.id.edit_tlp_pemesan);
            final EditText mAddress = (EditText) mView.findViewById(R.id.edit_alamat_pemesan);
            final Button mNext = (Button) mView.findViewById(R.id.method_button);

            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

            mNext.setOnClickListener((v)-> {
                Request request = new Request(
                        mName.getText().toString().trim(),
                        mTlp.getText().toString().trim(),
                        mAddress.getText().toString().trim(),
                        totalPricetv.getText().toString(),
                        list);
            });*/

    }
}