package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MetodePembayaran extends AppCompatActivity {
    LinearLayout bt_bca, bt_bri, bt_mandiri, kk_mastercard, kk_visa, ib_bca, s_indomaret, s_alfamart;
    String traveller, bank_nama, payment_code, product_schedule_id, coupon_code, pay_total, firstname, lastname, cust_id, product_id, product_price, product_name, product_model, product_qty, product_total, telephone, email, traveller_more, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metode_pembayaran);

        ImageButton btnback = (ImageButton) findViewById(R.id.trans_btn_back_pay);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final LinearLayout lay_expand_transfer = (LinearLayout) findViewById(R.id.lay_collapse_bank_transfer);
        final LinearLayout lay_expand_kk = (LinearLayout) findViewById(R.id.lay_collapse_kk);
        final LinearLayout lay_expand_klikpays = (LinearLayout) findViewById(R.id.lay_collapse_ib);
        final LinearLayout lay_expand_swalayan = (LinearLayout) findViewById(R.id.lay_collapse_swalayan);

        final ImageView btn_expand_transfer = (ImageView) findViewById(R.id.collapse_bank_transfer);
        final ImageView btn_expand_transfer_on = (ImageView) findViewById(R.id.collapse_bank_transfer_on);

        final ImageView btn_expand_kk = (ImageView) findViewById(R.id.collapse_kk);
        final ImageView btn_expand_kk_on = (ImageView) findViewById(R.id.collapse_kk_on);

        final ImageView btn_expand_klikpays = (ImageView) findViewById(R.id.collapse_ib);
        final ImageView btn_expand_klikpays_on = (ImageView) findViewById(R.id.collapse_ib_on);

        final ImageView btn_expand_swalayan = (ImageView) findViewById(R.id.collapse_swalayan);
        final ImageView btn_expand_swalayan_on = (ImageView) findViewById(R.id.collapse_swalayan_on);

        final LinearLayout expand_transfer = (LinearLayout) findViewById(R.id.expand_transfer);
        final LinearLayout expand_kk = (LinearLayout) findViewById(R.id.expand_kk);
        final LinearLayout expand_klikpays = (LinearLayout) findViewById(R.id.expand_ib);
        final LinearLayout expand_swalayan = (LinearLayout) findViewById(R.id.expand_swalayan);

        bt_bca = (LinearLayout) findViewById(R.id.payment_transfer_bca);
        bt_bri = (LinearLayout) findViewById(R.id.payment_transfer_bri);
        bt_mandiri = (LinearLayout) findViewById(R.id.payment_transfer_mandiri);
        kk_mastercard = (LinearLayout) findViewById(R.id.payment_kk_mastercard);
        kk_visa = (LinearLayout) findViewById(R.id.payment_kk_visa);
        ib_bca = (LinearLayout) findViewById(R.id.payment_ib_bca);
        s_indomaret = (LinearLayout) findViewById(R.id.payment_swalayan_indomaret);
        s_alfamart = (LinearLayout) findViewById(R.id.payment_swalayan_alfamart);

        lay_expand_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer_on.setVisibility(View.VISIBLE);
                bt_bri.setVisibility(View.VISIBLE);
                bt_bca.setVisibility(View.VISIBLE);
                bt_mandiri.setVisibility(View.VISIBLE);

                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);

                expand_klikpays.setVisibility(View.GONE);
                btn_expand_klikpays.setVisibility(View.VISIBLE);
                btn_expand_klikpays_on.setVisibility(View.GONE);
                ib_bca.setVisibility(View.INVISIBLE);

                expand_swalayan.setVisibility(View.GONE);
                btn_expand_swalayan.setVisibility(View.VISIBLE);
                btn_expand_swalayan_on.setVisibility(View.GONE);
                s_indomaret.setVisibility(View.INVISIBLE);
                s_alfamart.setVisibility(View.INVISIBLE);

            }
        });

        btn_expand_transfer_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);
            }
        });

        lay_expand_kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk.setVisibility(View.GONE);
                btn_expand_kk_on.setVisibility(View.VISIBLE);
                kk_mastercard.setVisibility(View.VISIBLE);
                kk_visa.setVisibility(View.VISIBLE);

                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);

                expand_klikpays.setVisibility(View.GONE);
                btn_expand_klikpays.setVisibility(View.VISIBLE);
                btn_expand_klikpays_on.setVisibility(View.GONE);
                ib_bca.setVisibility(View.INVISIBLE);

                expand_swalayan.setVisibility(View.GONE);
                btn_expand_swalayan.setVisibility(View.VISIBLE);
                btn_expand_swalayan_on.setVisibility(View.GONE);
                s_indomaret.setVisibility(View.INVISIBLE);
                s_alfamart.setVisibility(View.INVISIBLE);
            }
        });

        btn_expand_kk_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);
            }
        });

        lay_expand_klikpays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                expand_klikpays.setVisibility(View.VISIBLE);
                btn_expand_klikpays.setVisibility(View.GONE);
                btn_expand_klikpays_on.setVisibility(View.VISIBLE);
                ib_bca.setVisibility(View.VISIBLE);

                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);

                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);

                expand_swalayan.setVisibility(View.GONE);
                btn_expand_swalayan.setVisibility(View.VISIBLE);
                btn_expand_swalayan_on.setVisibility(View.GONE);
                s_indomaret.setVisibility(View.INVISIBLE);
                s_alfamart.setVisibility(View.INVISIBLE);

            }
        });

        btn_expand_klikpays_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_klikpays.setVisibility(View.GONE);
                btn_expand_klikpays.setVisibility(View.VISIBLE);
                btn_expand_klikpays_on.setVisibility(View.GONE);
                ib_bca.setVisibility(View.INVISIBLE);
            }
        });

        lay_expand_swalayan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                expand_swalayan.setVisibility(View.VISIBLE);
                btn_expand_swalayan.setVisibility(View.GONE);
                btn_expand_swalayan_on.setVisibility(View.VISIBLE);
                s_indomaret.setVisibility(View.VISIBLE);
                s_alfamart.setVisibility(View.VISIBLE);

                expand_transfer.setVisibility(View.GONE);
                btn_expand_transfer.setVisibility(View.VISIBLE);
                btn_expand_transfer_on.setVisibility(View.GONE);
                bt_bri.setVisibility(View.INVISIBLE);
                bt_bca.setVisibility(View.INVISIBLE);
                bt_mandiri.setVisibility(View.INVISIBLE);

                expand_kk.setVisibility(View.GONE);
                btn_expand_kk.setVisibility(View.VISIBLE);
                btn_expand_kk_on.setVisibility(View.GONE);
                kk_mastercard.setVisibility(View.INVISIBLE);
                kk_visa.setVisibility(View.INVISIBLE);

                expand_klikpays.setVisibility(View.GONE);
                btn_expand_klikpays.setVisibility(View.VISIBLE);
                btn_expand_klikpays_on.setVisibility(View.GONE);
                ib_bca.setVisibility(View.INVISIBLE);

            }
        });

        btn_expand_swalayan_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand_swalayan.setVisibility(View.GONE);
                btn_expand_swalayan.setVisibility(View.VISIBLE);
                btn_expand_swalayan_on.setVisibility(View.GONE);
                s_indomaret.setVisibility(View.INVISIBLE);
                s_alfamart.setVisibility(View.INVISIBLE);

            }
        });

        bt_bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

        bt_bri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

        bt_mandiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

        kk_mastercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

        kk_visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

        ib_bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

        s_indomaret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

        s_alfamart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MetodePembayaran.this,KonfirmasiPembayaran.class);
                startActivity(intent);
            }
        });

    }
}