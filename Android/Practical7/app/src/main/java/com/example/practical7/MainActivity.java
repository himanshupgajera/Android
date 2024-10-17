package com.example.practical7;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String textToManipulate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textToManipulate = textView.getText().toString();

        // Register the TextView for context menu
        registerForContextMenu(textView);
    }

    // Create the context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Action");
        menu.add(0, v.getId(), 0, "Cut");
        menu.add(0, v.getId(), 0, "Copy");
        menu.add(0, v.getId(), 0, "Paste");
        menu.add(0, v.getId(), 0, "Select All");
        menu.add(0, v.getId(), 0, "Bold");
        menu.add(0, v.getId(), 0, "Italic");
    }

    // Handle context menu item clicks
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip;

        switch (item.getTitle().toString()) {
            case "Cut":
                clip = ClipData.newPlainText("text", textView.getText().toString());
                clipboard.setPrimaryClip(clip);
                textView.setText("");
                Toast.makeText(this, "Text Cut", Toast.LENGTH_SHORT).show();
                return true;

            case "Copy":
                clip = ClipData.newPlainText("text", textView.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
                return true;

            case "Paste":
                if (clipboard.hasPrimaryClip() && clipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    ClipData.Item item1 = clipboard.getPrimaryClip().getItemAt(0);
                    String pasteData = item1.getText().toString();
                    textView.setText(pasteData);
                    Toast.makeText(this, "Text Pasted", Toast.LENGTH_SHORT).show();
                }
                return true;

            case "Select All":
                textView.setText(textToManipulate); // Simulating select all functionality
                Toast.makeText(this, "Text Selected", Toast.LENGTH_SHORT).show();
                return true;

            case "Bold":
                toggleBold();
                return true;

            case "Italic":
                toggleItalic();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    private void toggleBold() {
        if (textView.getTypeface().getStyle() == Typeface.BOLD) {
            textView.setTypeface(null, Typeface.NORMAL);
            Toast.makeText(this, "Text Unbolded", Toast.LENGTH_SHORT).show();
        } else {
            textView.setTypeface(null, Typeface.BOLD);
            Toast.makeText(this, "Text Bolded", Toast.LENGTH_SHORT).show();
        }
    }

    private void toggleItalic() {
        if (textView.getTypeface().getStyle() == Typeface.ITALIC) {
            textView.setTypeface(null, Typeface.NORMAL);
            Toast.makeText(this, "Text Unitalicized", Toast.LENGTH_SHORT).show();
        } else {
            textView.setTypeface(null, Typeface.ITALIC);
            Toast.makeText(this, "Text Italicized", Toast.LENGTH_SHORT).show();
        }
    }
}
