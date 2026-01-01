# 🎮 Tic-Tac-Toe Android App

A simple and cute Tic-Tac-Toe game built with Java for Android. Perfect for beginners learning Android development!

## 📱 Features

- ✨ Clean UI design
- 🎯 Two-player gameplay (X and O)
- 🏆 Automatic win detection
- 🤝 Draw detection
- 🔄 Reset game functionality

## 📸 Screenshots

![Tic-Tac-Toe Game](screenshots/game_screenshot.png)
*Add your screenshots here after taking them from the app*

## 🎮 How to Play

1. Launch the app
2. Player X goes first
3. Tap any empty square to place your mark
4. Players alternate turns (X and O)
5. First player to get 3 in a row (horizontal, vertical, or diagonal) wins!
6. If all squares are filled with no winner, it's a draw
7. Click **Restart** button to play again


## 🛠️ Technologies Used

- **Language:** Java
- **IDE:** Android Studio
- **Min SDK:** API 21 (Android 5.0)
- **Target SDK:** API 34 (Android 14)

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- [Android Studio](https://developer.android.com/studio) (latest version recommended)
- JDK 8 or higher
- Android SDK

## 🚀 Getting Started
→ Here's where to place each new file in your Android Studio project:
### 1. XML Layout Files
   Location: `app/src/main/res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:background="#FFF5F8FA"
    android:padding="20dp"
    tools:context=".MainActivity">

    <!-- Title -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="🎮 Tic-Tac-Toe"
        android:textSize="36sp"
        android:textStyle="bold"
        android:textColor="#FF5A8FD1"
        android:layout_marginBottom="10dp"
        android:fontFamily="sans-serif-medium"/>

    <!-- Current Player Display -->
    <TextView
        android:id="@+id/playerTurnText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Player X's Turn"
        android:textSize="20sp"
        android:textColor="#FF2E3A59"
        android:layout_marginBottom="30dp"
        android:fontFamily="sans-serif"/>

    <!-- Game Board -->
    <androidx.cardview.widget.CardView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:cardCornerRadius="20dp"
        app:cardElevation="8dp"
        android:layout_marginBottom="30dp">

        <GridLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:columnCount="3"
            android:rowCount="3"
            android:padding="15dp"
            android:background="#FFFFFFFF">

            <!-- Row 1 -->
            <Button
                android:id="@+id/btn1"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <Button
                android:id="@+id/btn2"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <Button
                android:id="@+id/btn3"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <!-- Row 2 -->
            <Button
                android:id="@+id/btn4"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <Button
                android:id="@+id/btn5"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <Button
                android:id="@+id/btn6"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <!-- Row 3 -->
            <Button
                android:id="@+id/btn7"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <Button
                android:id="@+id/btn8"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>

            <Button
                android:id="@+id/btn9"
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:textSize="40sp"
                android:textStyle="bold"
                android:textColor="#FF2E3A59"
                android:background="@drawable/button_bg"
                android:onClick="Check"
                android:layout_margin="5dp"/>
        </GridLayout>
    </androidx.cardview.widget.CardView>

    <!-- Restart Button -->
    <Button
        android:id="@+id/restartButton"
        android:layout_width="200dp"
        android:layout_height="60dp"
        android:text="🔄 Restart Game"
        android:textSize="18sp"
        android:textStyle="bold"
        android:textColor="#FFFFFFFF"
        android:background="@drawable/restart_button_bg"
        android:onClick="restartGame"
        android:elevation="4dp"/>

</LinearLayout>
```

### 2. Drawable Files (NEW - Create these!)
   Location: `app/src/main/res/drawable/`

i. **button_bg.xml**
```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- Save this file as: res/drawable/button_bg.xml -->
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Pressed state -->
    <item android:state_pressed="true">
        <shape android:shape="rectangle">
            <solid android:color="#FFE3F2FD"/>
            <corners android:radius="15dp"/>
            <stroke android:width="2dp" android:color="#FF5A8FD1"/>
        </shape>
    </item>
    
    <!-- Default state -->
    <item>
        <shape android:shape="rectangle">
            <solid android:color="#FFF5F8FA"/>
            <corners android:radius="15dp"/>
            <stroke android:width="2dp" android:color="#FFB0BEC5"/>
        </shape>
    </item>
</selector>
```

ii. **restart_button_bg.xml**
```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- Save this file as: res/drawable/restart_button_bg.xml -->
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Pressed state -->
    <item android:state_pressed="true">
        <shape android:shape="rectangle">
            <solid android:color="#FF4A7FC0"/>
            <corners android:radius="30dp"/>
        </shape>
    </item>
    
    <!-- Default state -->
    <item>
        <shape android:shape="rectangle">
            <gradient
                android:startColor="#FF5A8FD1"
                android:endColor="#FF7BA8E8"
                android:angle="135"/>
            <corners android:radius="30dp"/>
        </shape>
    </item>
</selector>
```

### 3. Main_activity: `java/com/example/tictactoe/MainActivity.java`
```java
package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Initialize buttons
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView playerTurnText;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int count = 0; // To count number of clicks
    int flag = 0; // For Player X and O (0 = X's turn, 1 = O's turn)
    boolean gameOver = false; // Track if game has ended

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(); // Finding buttons to Initialize them
    }

    private void init() {
        // Initialize game buttons
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        
        // Initialize player turn text
        playerTurnText = findViewById(R.id.playerTurnText);
    }

    public void Check(View view) {
        // Don't allow moves if game is over
        if (gameOver) {
            Toast.makeText(this, "Game is over! Please restart.", Toast.LENGTH_SHORT).show();
            return;
        }

        Button btnCurrent = (Button) view; // Check which button is clicked
        
        // Don't allow clicking the same button twice
        if (!btnCurrent.getText().toString().equals("")) {
            Toast.makeText(this, "Already taken! Choose another.", Toast.LENGTH_SHORT).show();
            return;
        }

        count++; // Increment count on each click

        // Set X or O based on current player
        if (flag == 0) {
            btnCurrent.setText("X");
            btnCurrent.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
            flag = 1;
            playerTurnText.setText("Player O's Turn");
        } else {
            btnCurrent.setText("O");
            btnCurrent.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            flag = 0;
            playerTurnText.setText("Player X's Turn");
        }

        if (count >= 5) { // Start checking when 5 buttons are clicked
            // Getting text from buttons
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            // Check for all winning conditions
            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                // Row 1
                announceWinner(b1);
            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                // Row 2
                announceWinner(b4);
            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                // Row 3
                announceWinner(b7);
            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                // Column 1
                announceWinner(b1);
            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                // Column 2
                announceWinner(b2);
            } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                // Column 3
                announceWinner(b3);
            } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                // Diagonal 1
                announceWinner(b1);
            } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                // Diagonal 2
                announceWinner(b3);
            } else if (count == 9) {
                // If all buttons are clicked and no winner, it's a draw
                announceDraw();
            }
        }
    }

    private void announceWinner(String winner) {
        gameOver = true;
        playerTurnText.setText("🎉 Player " + winner + " Wins!");
        playerTurnText.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        Toast.makeText(this, "Congratulations Player " + winner + "! 🎉", Toast.LENGTH_LONG).show();
    }

    private void announceDraw() {
        gameOver = true;
        playerTurnText.setText("🤝 It's a Draw!");
        playerTurnText.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        Toast.makeText(this, "It's a Draw! Well played! 🤝", Toast.LENGTH_LONG).show();
    }

    // Restart game method (called by restart button)
    public void restartGame(View view) {
        count = 0;
        flag = 0;
        gameOver = false;
        
        // Clear all buttons
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        
        // Reset player turn text
        playerTurnText.setText("Player X's Turn");
        playerTurnText.setTextColor(getResources().getColor(android.R.color.black));
        
        Toast.makeText(this, "Game Restarted! Let's play again! 🎮", Toast.LENGTH_SHORT).show();
    }
}
```

## 🎨 Code Overview

### `MainActivity.java`
Contains the main game logic:
- `Check()` - Handles button clicks and player turns
- `announceWinner()` - Displays winner message
- `announceDraw()` - Displays draw message
- `restartGame()` - Resets the game board

### `activity_main.xml`
Defines the UI layout:
- GridLayout with 9 buttons (3x3 grid)
- Restart button
- Title and current player display


## 📝 License

This project is open source and available for educational purposes.

## 👤 Author

- GitHub: [Manish-Royan](https://github.com/Manish-Royan)

### **📝Note:** This is a learning project created during my Android Development journey.