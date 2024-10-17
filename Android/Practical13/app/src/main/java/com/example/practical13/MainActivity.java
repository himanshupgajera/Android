package com.example.practical13;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private EditText editTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextResult = findViewById(R.id.editTextResult);

        // Get all buttons and set click listeners
        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.buttonPlus, R.id.buttonMinus,
                R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonEqual, R.id.buttonClear
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(buttonClickListener);
        }
    }

    // Click listener for buttons
    private final View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            String buttonText = button.getText().toString();

            switch (buttonText) {
                case "C":
                    editTextResult.setText("");
                    break;
                case "=":
                    calculateResult();
                    break;
                default:
                    editTextResult.append(buttonText);
                    break;
            }
        }
    };

    private void calculateResult() {
        String expression = editTextResult.getText().toString();
        try {
            double result = evaluateExpression(expression);
            editTextResult.setText(String.valueOf(result));
        } catch (Exception e) {
            editTextResult.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {
        // Simple expression evaluation using a stack
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    sb.append(expression.charAt(i++));
                }
                values.push(Double.parseDouble(sb.toString()));
                i--; // Adjust for the extra increment
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    private double applyOperation(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}