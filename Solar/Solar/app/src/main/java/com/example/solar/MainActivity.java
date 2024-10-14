package com.example.solar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        PlanetaDao planetaDao = new PlanetaDao();
        PlanetaAdapter planetaAdapter = new PlanetaAdapter(this, R.layout.item_planeta, planetaDao.planetas);
        listView.setAdapter(planetaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, Integer.toString(i), Toast.LENGTH_SHORT).show();

            }
        });
    }
}