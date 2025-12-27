package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements as instance variables
    private EditText editWeight, editHeightFT, editHeightIn;
    private Button buttonCalculate;
    private TextView textResult;


    // We want to change color according to BMI result
    LinearLayout color_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for the activity
        // This connects the activity to its UI defined in XML
        setContentView(R.layout.activity_main);

        // Initialize UI elements by linking them to XML IDs
        // findViewById retrieves the view object by its ID from the R class
        editWeight = findViewById(R.id.editWeight);
        editHeightFT = findViewById(R.id.editHeightFT);
        editHeightIn = findViewById(R.id.editHeightIn);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textResult = findViewById(R.id.textResult);
        color_layout = findViewById(R.id.mainLayout);


        // Set up click listener for the calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    /**
     * Method to calculate BMI
     * Separated into its own method for better code organization
     */
    private void calculateBMI() {
        // Get text from EditText fields
        String weightStr = editWeight.getText().toString().trim();
        String heightFTStr = editHeightFT.getText().toString().trim();
        String heightInStr = editHeightIn.getText().toString().trim();

        // Validate input - check if any field is empty
        if (weightStr.isEmpty() || heightFTStr.isEmpty() || heightInStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return; // Exit the method if validation fails
        }

        try {
            // Parse string input to numbers
            // parseInt converts String to int
            // parseDouble converts String to double (for decimal numbers)
            double weight = Double.parseDouble(weightStr);
            int heightFT = Integer.parseInt(heightFTStr);
            int heightIn = Integer.parseInt(heightInStr);

            // Validate that values are positive
            if (weight <= 0 || heightFT < 0 || heightIn < 0) {
                Toast.makeText(this, "Please enter valid positive values", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert height from feet and inches to meters
            int totalHeightInches = (heightFT * 12) + heightIn;

            // Check if height is reasonable (at least 1 foot)
            if (totalHeightInches == 0) {
                Toast.makeText(this, "Height cannot be zero", Toast.LENGTH_SHORT).show();
                return;
            }

            double totalCM = totalHeightInches * 2.54; // 1 inch = 2.54 cm
            double totalM = totalCM / 100; // 1 meter = 100 cm

            // Calculate BMI using formula: BMI = weight (kg) / height² (m²)
            double bmi = weight / Math.pow(totalM, 2);

            // Determine BMI category and display result
            String category;
            if (bmi < 18.5) {
                category = "Underweight";
                color_layout.setBackgroundColor(getResources().getColor(R.color.underweight));

            } else if (bmi < 25) {
                category = "Healthy";
                color_layout.setBackgroundColor(getResources().getColor(R.color.healthy));
            } else if (bmi < 30) {
                category = "Overweight";
                color_layout.setBackgroundColor(getResources().getColor(R.color.overweight));
            } else {
                category = "Obese";
                color_layout.setBackgroundColor(getResources().getColor(R.color.obese));
            }

            // Format and display the result
            // String.format("%.2f", bmi) formats the BMI to 2 decimal places
            String result = String.format("Your BMI is %.2f\nYou are %s", bmi, category);
            textResult.setText(result);

        } catch (NumberFormatException e) {
            // This catches errors when parsing fails (e.g., user enters letters)
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }
}