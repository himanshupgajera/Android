package com.example.practical8;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button coffeeButton;
    private ImageView coffeeImageView;

    // Define constants for menu item IDs
    private static final int AMERICANO_ID = R.id.americano;
    private static final int LATTE_ID = R.id.latte;
    private static final int ESPRESSO_ID = R.id.espresso;
    private static final int CAPPUCCINO_ID = R.id.cappuccino;
    private static final int MOCHA_ID = R.id.mocha;
    private static final int SKINNY_LATTE_ID = R.id.skinny_latte;
    private static final int ESPRESSO_CORRETTO_ID = R.id.espresso_corretto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffeeButton = findViewById(R.id.coffeeButton);
        coffeeImageView = findViewById(R.id.coffeeImageView);

        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
    }

    private void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.coffee_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                String coffeeName = item.getTitle().toString();
                int imageResId = 0;

                // Use if-else instead of switch
                if (itemId == AMERICANO_ID) {
                    imageResId = R.drawable.americano; // Replace with actual drawable resource
                } else if (itemId == LATTE_ID) {
                    imageResId = R.drawable.latte; // Replace with actual drawable resource
                } else if (itemId == ESPRESSO_ID) {
                    imageResId = R.drawable.espresso; // Replace with actual drawable resource
                } else if (itemId == CAPPUCCINO_ID) {
                    imageResId = R.drawable.cappuccino; // Replace with actual drawable resource
                } else if (itemId == MOCHA_ID) {
                    imageResId = R.drawable.mocha; // Replace with actual drawable resource
                } else if (itemId == SKINNY_LATTE_ID) {
                    imageResId = R.drawable.skinny_latte; // Replace with actual drawable resource
                } else if (itemId == ESPRESSO_CORRETTO_ID) {
                    imageResId = R.drawable.espresso_corretto; // Replace with actual drawable resource
                }

                // Update the ImageView with the selected coffee image
                if (imageResId != 0) {
                    coffeeImageView.setImageResource(imageResId);
                }

                // Show a Toast message with coffee name
                Toast.makeText(MainActivity.this, "Selected: " + coffeeName, Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        popupMenu.show();
    }
}
