package com.example.aplikasipenduduk;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        String nik = getIntent().getStringExtra("NIK");
        String nama = getIntent().getStringExtra("Nama");
        String jenisKelamin = getIntent().getStringExtra("JenisKelamin");
        String tempatTanggalLahir = getIntent().getStringExtra("TempatTanggalLahir");
        String alamat = getIntent().getStringExtra("Alamat");
        String email = getIntent().getStringExtra("Email");
        String telepon = getIntent().getStringExtra("Telepon");
        TextView textView = findViewById(R.id.textView);
        textView.setText("NIK: " + nik + "\n" +
                "Nama: " + nama + "\n" +
                "Jenis Kelamin: " + jenisKelamin + "\n" +
                "Tempat Tanggal Lahir: " + tempatTanggalLahir + "\n" +
                "Alamat: " + alamat + "\n" +
                "Email: " + email + "\n" +
                "Telepon: " + telepon);
    }
}
