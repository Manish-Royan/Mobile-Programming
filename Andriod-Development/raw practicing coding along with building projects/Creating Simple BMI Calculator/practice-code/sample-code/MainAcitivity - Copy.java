package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Connecting XML layout to the activity (referring to java code)
        setContentView(R.layout.activity_main); // Set the layout for the activity, this line connects the activity to its UI defined in XML


        /*1. Variable Declaration*/
        // This class is in inside "andriod.widget" package
        TextView textResult; // Declare a TextView variable to reference the UI element, it is best to use ID used in XML layout as variable name

        EditText editWeight, editHeightFT, editHeightIn;
        Button buttonCalculate;


        /*2. Variable Initialization - linking the variable to the UI element using findViewById method*/
        //findViewById method is used to get the reference of the UI element by its ID defined in XML layout stored in 'R' class
        editWeight = findViewById(R.id.editWeight); // 'R' is a generated class that contains IDs for all resources in the project
        editHeightFT = findViewById(R.id.editHeightFT);
        editHeightIn = findViewById(R.id.editHeightIn);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textResult = findViewById(R.id.textResult);


        /*3. Setting up event listener for button click*/
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fetching user input from EditText fields and converting to appropriate data types
                /* Remember: EditText's getText() method returns an Editable object, so we need to convert it to String first using toString() method
                 * The getText() method on an EditText returns an Editable object (which implements CharSequence),
                   not a String. To convert it to a String for use with Integer.parseInt(),
                   you call .toString() on the Editable.
                 * This ensures the input is in the correct format for parsing into an integer.
                 */
                int weight = Integer.parseInt(editWeight.getText().toString());  // remember we used `android:inputType="number"`
                int heightFT = Integer.parseInt(editHeightFT.getText().toString());
                int heightIn = Integer.parseInt(editHeightIn.getText().toString());

                // Converting height in feet and inches to total inches
                int totalHeightInches = (heightFT * 12) + heightIn;
                double totalCM = totalHeightInches * 2.54; // 1 inch = 2.54 cm
                double totalM = totalCM / 100; // 1 meter = 100 cm

                // Calculating BMI using the formula: BMI = weight (kg) / (height (m) * height (m))
                double bmi = weight / Math.pow(totalM, 2); // double bmi = weight / (totalM * totalM);

                // Creating Common BMI Result String and displaying it in the TextView
                if (bmi > 25) {
                    textResult.setText("Your BMI is " + String.format("%.2f", bmi) + "\nYou are Overweight");
                } else if (bmi < 18) {
                    textResult.setText("Your BMI is " + String.format("%.2f", bmi) + "\nYou are Underweight");
                } else {
                    textResult.setText("Your BMI is " + String.format("%.2f", bmi) + "\nYou are Healthy");
                }


            }
        });


    }
}