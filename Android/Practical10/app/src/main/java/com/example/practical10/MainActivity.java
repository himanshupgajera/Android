package com.example.practical10;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private Switch switchButton;
    private ToggleButton toggleButton;
    private Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        spinner = findViewById(R.id.spinner);
        checkBox = findViewById(R.id.checkbox);
        radioGroup = findViewById(R.id.radioGroup);
        switchButton = findViewById(R.id.switchButton);
        toggleButton = findViewById(R.id.toggleButton);
        showButton = findViewById(R.id.showButton);

        // Set up the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set up the spinner item selection listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Optional: Handle spinner item selection
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Optional: Handle no selection
            }
        });

        // Set up the button click listener
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected items
                String selectedSpinner = spinner.getSelectedItem().toString();
                boolean isChecked = checkBox.isChecked();
                int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioId);
                String selectedRadioText = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "None";
                boolean isSwitchOn = switchButton.isChecked();
                boolean isToggleOn = toggleButton.isChecked();

                // Display the selections
                String message = "Spinner: " + selectedSpinner + "\n" +
                        "Checkbox: " + (isChecked ? "Checked" : "Unchecked") + "\n" +
                        "Radio Button: " + selectedRadioText + "\n" +
                        "Switch: " + (isSwitchOn ? "On" : "Off") + "\n" +
                        "ToggleButton: " + (isToggleOn ? "On" : "Off");

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
