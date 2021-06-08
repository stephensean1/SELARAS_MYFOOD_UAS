package umn.ac.id;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileAnggota extends AppCompatActivity {

    private Button btnback2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_anggota);

        btnback2 = findViewById(R.id.btn_back2);
        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileAnggota.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}