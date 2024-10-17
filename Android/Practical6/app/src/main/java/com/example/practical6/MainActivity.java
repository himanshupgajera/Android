package com.example.practical6;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private static final int BCA_ID = R.id.bca;
    private static final int MCA_ID = R.id.mca;
    private static final int BBA_ID = R.id.bba;
    private static final int MBA_ID = R.id.mba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SPPU Courses");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == BCA_ID) {
            Toast.makeText(this, "BCA Courses selected..", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == MCA_ID) {
            Toast.makeText(this, "MCA Courses selected..", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == BBA_ID) {
            Toast.makeText(this, "BBA Courses selected..", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == MBA_ID) {
            Toast.makeText(this, "MBA Courses selected..", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
