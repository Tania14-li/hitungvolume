package com.tania2.hitungvolume;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private EditText etPanjang,etLebar, etTinggi;
    private TextView tvHasil;
    private Button btnHitung;
    private VolumeViewModel volumeViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan UI dengan id
        etPanjang = findViewById(R.id.et_panjang);
        etLebar = findViewById(R.id.et_lebar);
        etTinggi = findViewById(R.id.et_tinggi);
        tvHasil = findViewById(R.id.tv_hasil);
        btnHitung = findViewById(R.id.btn_hitung);


        // Inisialisasi ViewModel
        volumeViewModel = new ViewModelProvider(this).get(VolumeViewModel.class);

        // Observasi perubahan data volume
        volumeViewModel.getVolume().observe(this, hasil -> {
            if (hasil != null) {
                tvHasil.setText("Volume: " + hasil);
            }
        });

        //menambahkan aksi klik pada  dengan setOnClickListener try and catch
        btnHitung.setOnClickListener(v -> {
            try {
                // mengambil data dari edit text, lalu di edit menggunakkan trim dan diubah dari string menjadi int dengan parseInt
                int panjang = Integer.parseInt(etPanjang.getText().toString().trim());
                int lebar = Integer.parseInt(etLebar.getText().toString().trim());
                int tinggi = Integer.parseInt(etTinggi.getText().toString().trim());

                // rumus perhitungan volume
                volumeViewModel.updateVolume(panjang * lebar * tinggi);

                //jika input tidak sesuai maka sistem akan menampilkan text input tidak valid
            } catch (NumberFormatException e) {
                tvHasil.setText("Input tidak valid");
            }
        });

    }
}