package com.example.practical11;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ProgressBar progressBar;
    private TextView seekBarValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        seekBar = findViewById(R.id.seekBar);
        progressBar = findViewById(R.id.progressBar);
        seekBarValue = findViewById(R.id.seekBarValue);

        // Set up SeekBar change listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update ProgressBar and TextView as SeekBar is changed
                progressBar.setProgress(progress);
                seekBarValue.setText("SeekBar Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: You can implement behavior when touch starts
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: You can implement behavior when touch stops
            }
        });
    }
}
