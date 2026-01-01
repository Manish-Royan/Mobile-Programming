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