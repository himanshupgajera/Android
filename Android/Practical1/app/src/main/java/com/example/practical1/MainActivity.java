package com.example.practical1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView lifecycleStatusTextView;
    private StringBuilder lifecycleStatusBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifecycleStatusTextView = findViewById(R.id.lifecycleStatusTextView);
        lifecycleStatusBuilder = new StringBuilder();

        Log.d(TAG, "onCreate called");
        updateLifecycleStatus("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
        updateLifecycleStatus("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
        updateLifecycleStatus("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
        updateLifecycleStatus("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
        updateLifecycleStatus("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart called");
        updateLifecycleStatus("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
        updateLifecycleStatus("onDestroy");
    }

    // Helper method to update the TextView and append lifecycle status
    private void updateLifecycleStatus(String status) {
        lifecycleStatusBuilder.append(status).append("\n");
        lifecycleStatusTextView.setText(lifecycleStatusBuilder.toString());
    }
}
