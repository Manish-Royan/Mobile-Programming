# BMI Calculator - Android App

A simple BMI (Body Mass Index) Calculator Android application built with Java.


## 📱 About The Project

This is my first Android application developed while learning Android Development. The app calculates BMI based on user input for weight (in kilograms) and height (in feet and inches), then categorizes the result according to WHO standards.

## ✨ Features

- Calculate BMI using weight (kg) and height (feet & inches)
- Automatic conversion from imperial to metric units
- BMI categorization:
  - Underweight (BMI < 18.5)
  - Healthy (BMI 18.5 - 24.9)
  - Overweight (BMI 25 - 29.9)
  - Obese (BMI ≥ 30)
- Input validation and error handling
- **🐾Aesthetic UI with:**
  - Soft pastel color scheme
  - Card-based modern design
  - Smooth rounded corners
  - Beautiful gradient button
  - Color-coded results based on BMI category
  - Emoji icons for visual appeal
  - ScrollView for better usability
- Toast messages for user feedback

## 🛠️ Built With

- **Java** - Programming Language
- **Android Studio** - IDE
- **XML** - UI Layout Design

## 📋 Prerequisites

- Android Studio (latest version recommended)
- Android SDK (API Level 21 or higher)
- JDK 8 or higher

## 🚀 Getting Started

### 📁 File Structure & Setup Instructions

→ Here's where to place each new file in your Android Studio project:
1. XML Layout Files
   Location: `app/src/main/res/layout/activity_main.xml`

```xml: activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/background">

    <LinearLayout
        android:id="@+id/mainLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp"
        android:gravity="center_horizontal"
        tools:context=".MainActivity">

        <!-- App Title with Icon -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="💪 BMI Calculator"
            android:textSize="32sp"
            android:textColor="@color/primary"
            android:textStyle="bold"
            android:layout_marginTop="20dp"
            android:layout_marginBottom="8dp"
            android:fontFamily="sans-serif-medium" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Check your health status"
            android:textSize="14sp"
            android:textColor="@color/text_secondary"
            android:layout_marginBottom="32dp" />

        <!-- Weight Input Card -->
        <androidx.cardview.widget.CardView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="16dp"
            android:elevation="4dp"
            android:backgroundTint="@color/card_background">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="16dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="⚖️ Weight"
                    android:textSize="16sp"
                    android:textColor="@color/primary"
                    android:textStyle="bold"
                    android:layout_marginBottom="8dp" />

                <EditText
                    android:id="@+id/editWeight"
                    android:layout_width="match_parent"
                    android:layout_height="56dp"
                    android:hint="@string/weight_hint"
                    android:inputType="numberDecimal"
                    android:background="@drawable/input_background"
                    android:padding="16dp"
                    android:textSize="18sp"
                    android:textColor="@color/text_primary"
                    android:textColorHint="@color/text_hint" />
            </LinearLayout>
        </androidx.cardview.widget.CardView>

        <!-- Height Input Card -->
        <androidx.cardview.widget.CardView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="24dp"
            android:elevation="4dp"
            android:backgroundTint="@color/card_background">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="16dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="📏 Height"
                    android:textSize="16sp"
                    android:textColor="@color/primary"
                    android:textStyle="bold"
                    android:layout_marginBottom="8dp" />

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal"
                    android:weightSum="2">

                    <EditText
                        android:id="@+id/editHeightFT"
                        android:layout_width="0dp"
                        android:layout_height="56dp"
                        android:layout_weight="1"
                        android:layout_marginEnd="8dp"
                        android:hint="@string/height_hintFT"
                        android:inputType="number"
                        android:background="@drawable/input_background"
                        android:padding="16dp"
                        android:textSize="18sp"
                        android:textColor="@color/text_primary"
                        android:textColorHint="@color/text_hint" />

                    <EditText
                        android:id="@+id/editHeightIn"
                        android:layout_width="0dp"
                        android:layout_height="56dp"
                        android:layout_weight="1"
                        android:layout_marginStart="8dp"
                        android:hint="@string/height_hintIn"
                        android:inputType="number"
                        android:background="@drawable/input_background"
                        android:padding="16dp"
                        android:textSize="18sp"
                        android:textColor="@color/text_primary"
                        android:textColorHint="@color/text_hint" />
                </LinearLayout>
            </LinearLayout>
        </androidx.cardview.widget.CardView>

        <!-- Calculate Button -->
        <Button
            android:id="@+id/buttonCalculate"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:text="✨ Calculate BMI"
            android:textSize="18sp"
            android:textStyle="bold"
            android:textColor="@color/white"
            android:background="@drawable/button_background"
            android:elevation="6dp"
            android:layout_marginBottom="24dp" />

        <!-- Result Card -->
        <androidx.cardview.widget.CardView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:elevation="4dp"
            android:backgroundTint="@color/card_background">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="24dp"
                android:gravity="center">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Your Result"
                    android:textSize="16sp"
                    android:textColor="@color/text_secondary"
                    android:layout_marginBottom="12dp" />

                <TextView
                    android:id="@+id/textResult"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="Enter your details above"
                    android:textSize="20sp"
                    android:textStyle="bold"
                    android:textColor="@color/text_primary"
                    android:gravity="center"
                    android:minHeight="60dp"
                    android:layout_marginTop="8dp" />
            </LinearLayout>
        </androidx.cardview.widget.CardView>

        <!-- Footer -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Made with 💖 while learning Android"
            android:textSize="12sp"
            android:textColor="@color/text_secondary"
            android:layout_marginTop="24dp"
            android:layout_marginBottom="16dp" />

    </LinearLayout>
</ScrollView>
```

2. Colors File
   Location: `app/src/main/res/values/colors.xml`

```xml: colors.xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!-- Base Colors -->
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>

    <color name="primary">#FF6B9BD1</color>
    <color name="primary_dark">#FF5A8AC0</color>
    <color name="accent">#FFFFA5D8</color>

    <!-- Background Colors -->
    <color name="background">#FFF5F7FA</color>
    <color name="card_background">#FFFFFFFF</color>

    <!-- Text Colors -->
    <color name="text_primary">#FF2C3E50</color>
    <color name="text_secondary">#FF7F8C8D</color>
    <color name="text_hint">#FFBDC3C7</color>

    <!-- BMI Category Colors  -->
    <color name="underweight">#FFB3E5FC</color>          <!-- Soft Sky Blue -->
    <color name="healthy">#FFC8E6C9</color>              <!-- Soft Mint Green -->
    <color name="overweight">#FFFFCCBC</color>           <!-- Soft Peach -->
    <color name="obese">#FFFFCDD2</color>                <!-- Soft Pink Red -->

    <!-- Button Gradient Colors -->
    <color name="button_start">#FF6B9BD1</color>
    <color name="button_end">#FF9BCDFF</color>
</resources>
```

3. Drawable Files (NEW - Create these!)
   Location: `app/src/main/res/drawable/`

   ### Create a new folder called drawable if it doesn't exist, then add:
   * `input_background.xml` - for rounded input fields
   ```xml: input_background.xml 
   <?xml version="1.0" encoding="utf-8"?>
   <shape xmlns:android="http://schemas.android.com/apk/res/android"
       android:shape="rectangle">

       <!-- Rounded corners -->
       <corners android:radius="12dp" />

       <!-- Light background -->
       <solid android:color="#FFF5F7FA" />

       <!-- Subtle border -->
       <stroke
           android:width="1dp"
           android:color="#FFE0E0E0" />

   </shape>
   ```
   * `button_background.xml` - for the gradient button
   ```xml: button_background.xml
   <?xml version="1.0" encoding="utf-8"?>
   <shape xmlns:android="http://schemas.android.com/apk/res/android"
       android:shape="rectangle">

       <!-- Rounded corners for modern look -->
       <corners android:radius="30dp" />

       <!-- Beautiful gradient -->
       <gradient
           android:angle="45"
           android:startColor="@color/button_start"
           android:endColor="@color/button_end"
           android:type="linear" />

   </shape>
   ```

4. Add CardView Dependency
   ↳ Since we're using CardView, you need to add it to your build.gradle:
   Location: `app/build.gradle (Module level)`
    ➕ Add this inside the dependencies block:
   ```build.gradle.kts
   gradledependencies {
       // ... your existing dependencies
       implementation 'androidx.cardview:cardview:1.0.0'
   }
   ```

   👆 Then click "Sync Now" when Android Studio prompts you.

5. Strings File
   Location: `res/values/strings.xml`
   ```xml: strings.xml
   <resources>
       <string name="app_name">BMI APP</string>
       <string name="weight_hint">Weight (kg)</string>
       <string name="height_hintFT">Height (Feet)</string>
       <string name="height_hintIn">Height (Inches)</string>
   </resources>
   ```

6. Main_activity: `java/com/example/myfirstapp/MainActivity.java`
```java: MainActivity.java
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
```

## 📸 Screenshots

_Add screenshots of your app here once you take them_

## 💡 What I Learned

While building this project, I learned:

- Android Activity lifecycle
- XML layout design with LinearLayout
- Connecting UI elements to Java code using `findViewById()`
- Event handling with `setOnClickListener()`
- Input validation and error handling
- Working with EditText, Button, and TextView
- Using Toast for user notifications
- Exception handling with try-catch blocks
- String formatting and data type conversions

## 🐛 Known Issues

- None at the moment

## 🔮 Future Enhancements

- [ ] Add metric/imperial unit toggle
- [ ] Save BMI history
- [ ] Add BMI chart visualization
- [ ] Dark mode support
- [ ] Material Design improvements

## 📝 License

This project is open source and available for educational purposes.

## 👤 Author

- GitHub: [Manish-Royan](https://github.com/Manish-Royan)

## 🙏 Acknowledgments

- Thanks to the Android Development community
- Inspired by health and fitness applications

---

### **📝Note:** This is a learning project created during my Android Development journey.