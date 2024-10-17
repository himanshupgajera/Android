package com.example.practical12;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView ratingValue;
    private Button submitRatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        ratingBar = findViewById(R.id.ratingBar);
        ratingValue = findViewById(R.id.ratingValue);
        submitRatingButton = findViewById(R.id.submitRatingButton);

        // Set RatingBar change listener
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Update the TextView with the current rating
                ratingValue.setText("Rating: " + rating);
            }
        });

        // Set click listener for submit button
        submitRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                // Show a Toast message for submission
                if (rating > 0) {
                    Toast.makeText(MainActivity.this, "Thank you for rating: " + rating, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please select a rating", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
