package com.example.aplikasipenduduk;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;


public class MainActivity extends AppCompatActivity {
    private EditText etNIK, etNama, etJenisKelamin, etTempatTanggalLahir, etAlamat, etEmail, etTelepon;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNIK = findViewById(R.id.etNIK);
        etNama = findViewById(R.id.etNAMA);
        AutoCompleteTextView etJenisKelamin = findViewById(R.id.etJenisKelamin);
        etTempatTanggalLahir = findViewById(R.id.etTempatTanggalLahir);
        etAlamat = findViewById(R.id.etAlamat);
        etEmail = findViewById(R.id.etEmail);
        etTelepon = findViewById(R.id.etTelepon);
        btnSubmit = findViewById(R.id.btnDetail);

        String[] jenisKelaminArray = {"Laki-laki", "Perempuan"};
        ArrayAdapter<String> jenisKelaminAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, jenisKelaminArray);
        etJenisKelamin.setAdapter(jenisKelaminAdapter);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nik = etNIK.getText().toString();
                String nama = etNama.getText().toString();
                if (!nik.isEmpty() && !nama.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("NIK", nik);
                    intent.putExtra("Nama", nama);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "NIK dan Nama harus diisi!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("NIK", etNIK.getText().toString());
                intent.putExtra("Nama", etNama.getText().toString());
                intent.putExtra("JenisKelamin", etJenisKelamin.getText().toString());
                intent.putExtra("TempatTanggalLahir", etTempatTanggalLahir.getText().toString());
                intent.putExtra("Alamat", etAlamat.getText().toString());
                intent.putExtra("Email", etEmail.getText().toString());
                intent.putExtra("Telepon", etTelepon.getText().toString());
                startActivity(intent);
            }
        });
    }
}