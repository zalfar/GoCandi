package com.example.projekakhir.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projekakhir.R;
import com.example.projekakhir.models.Hewan;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_HEWAN = "extra_hewan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView name = findViewById(R.id.tv_name_detail);
        TextView description = findViewById(R.id.tv_desc_detail);
        TextView ordo = findViewById(R.id.tv_ordo_detail);
        TextView kelas = findViewById(R.id.tv_kelas_detail);

        Hewan hewan = getIntent().getParcelableExtra(EXTRA_HEWAN);

        Glide.with(this).load(hewan.getPhoto()).into(imageView);
        name.setText(hewan.getName());
        description.setText(hewan.getDescription());
        ordo.setText(hewan.getOrdo());
        kelas.setText(hewan.getKelas());
    }
}