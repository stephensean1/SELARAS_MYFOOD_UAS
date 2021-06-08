package umn.ac.id;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button pesanAplikasi;
    private Button pesanTelephone;
    private Button lihatRestoran;
    private Button profileKu;
    private Button profileanggota;

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[]={R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14};

        v_flipper = findViewById(R.id.v_flipper);

        for (int image : images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);


        pesanAplikasi = findViewById(R.id.btn_pesan_aplikasi);
        pesanAplikasi.setOnClickListener(this);

        pesanTelephone = findViewById(R.id.btn_pesan_telephone);
        pesanTelephone.setOnClickListener(this);

        lihatRestoran = findViewById(R.id.btn_lokasi_restoran);
        lihatRestoran.setOnClickListener(this);

        profileKu = findViewById(R.id.btn_profileku);
        profileKu.setOnClickListener(this);

        profileanggota = findViewById(R.id.btn_profileanggota);
        profileanggota.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pesan_aplikasi:
                Intent moveIntent = new Intent(MainActivity.this, DaftarMenu.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_pesan_telephone:
                String phoneNumber = "081317130882";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_lokasi_restoran:
                Intent moveIntent2 = new Intent(MainActivity.this, RuteRestoran.class);
                startActivity(moveIntent2);
                break;

            case R.id.btn_profileku:
                Intent profile = new Intent(MainActivity.this, ProfileKu.class);
                startActivity(profile);
                break;

            case R.id.btn_profileanggota:
                Intent profileanggota1 = new Intent(MainActivity.this, ProfileAnggota.class);
                startActivity(profileanggota1);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                Intent intent1 = new Intent(MainActivity.this, Login.class);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}