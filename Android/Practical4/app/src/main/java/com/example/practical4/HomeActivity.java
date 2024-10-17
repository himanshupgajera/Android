package com.example.practical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button circleButton = findViewById(R.id.circleButton);
        Button rectangleButton = findViewById(R.id.rectangleButton);
        Button triangleButton = findViewById(R.id.triangleButton);

        circleButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CircleActivity.class);
            startActivity(intent);
        });

        rectangleButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, RectangleActivity.class);
            startActivity(intent);
        });

        triangleButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, TriangleActivity.class);
            startActivity(intent);
        });
    }
}

