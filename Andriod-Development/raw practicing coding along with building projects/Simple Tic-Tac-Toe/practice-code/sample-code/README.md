# Complete program flow from start to finish
💭 Understanding what happens when you run the app and start playing


## 🚀 **PROGRAM STARTUP (When App Launches)**

### **1. onCreate() Method Runs**
```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
}
```

**What happens:**
- `super.onCreate()` → Tells Android to do its basic setup stuff
- `setContentView(R.layout.activity_main)` → This is THE KEY LINE! It loads your XML layout file and displays it on screen. Without this, you'd have a blank screen
- `init()` → Calls your custom method to connect buttons

### **2. init() Method Runs**
```java
private void init() {
    btn1 = findViewById(R.id.btn1);
    btn2 = findViewById(R.id.btn2);
    // ... and so on for all 9 buttons
}
```

**What happens:**
- `findViewById(R.id.btn1)` searches through your XML layout and finds the button with `android:id="@+id/btn1"`
- It returns a reference to that button object
- You store it in `btn1` variable
- Now `btn1` is connected to the actual button on screen!
- This happens for all 9 buttons

**At this point:** Your app is ready! The grid is visible, buttons are clickable, and variables are initialized:
- `count = 0` (no clicks yet)
- `flag = 0` (X goes first)
- `gameOver = false` (game hasn't ended)

---

## 🎯 **USER CLICKS A BUTTON (The Main Game Loop)**

Let's say the user clicks **Button 5** (center button). Here's the complete journey:

### **Step 1: Android Detects the Click**
- Android sees the click on btn5
- It looks at the XML and sees `android:onClick="Check"`
- Android says: "Okay, I need to call the `Check` method in MainActivity"
- Android automatically passes the clicked button as a parameter: `Check(view)`

---

### **Step 2: Check() Method Starts**
```java
public void Check(View view) {
```

The `view` parameter contains the button that was clicked (in this case, btn5).

---

### **Step 3: Game Over Check**
```java
if (gameOver) {
    return;
}
```

**Logic:** If someone already won or it's a draw, `gameOver = true`, so this immediately exits the method. No more clicks allowed!

**First click:** `gameOver = false`, so we continue...

---

### **Step 4: Cast View to Button**
```java
Button btnCurrent = (Button) view;
```

**Why?** The parameter comes in as a generic `View` (parent class), but we need `Button` features like `getText()` and `setText()`. So we **cast** (convert) it to a Button.

**Now:** `btnCurrent` is specifically btn5.

---

### **Step 5: Check if Button Already Clicked**
```java
if (!btnCurrent.getText().toString().equals("")) {
    Toast.makeText(this, "Button already clicked!", Toast.LENGTH_SHORT).show();
    return;
}
```

**Logic:**
- `btnCurrent.getText()` gets the text from the button
- `.toString()` converts it to a String
- `.equals("")` checks if it's empty
- `!` means "NOT"

**Translation:** "If the button is NOT empty (already has X or O), show a warning and exit"

**First click on btn5:** It's empty, so we continue...

---

### **Step 6: Increment Click Counter**
```java
count++;
```

**Simple:** Count goes from 0 to 1. This tracks total moves made.

---

### **Step 7: Determine X or O**
```java
if (flag == 0) {
    btnCurrent.setText("X");
    flag = 1;
} else {
    btnCurrent.setText("O");
    flag = 0;
}
```

**Logic:**
- **First click:** `flag = 0`, so we set button text to "X" and change flag to 1
- **Second click:** `flag = 1`, so we set button text to "O" and change flag back to 0
- **Third click:** `flag = 0` again, so "X"...

**This alternates turns!** Flag is like a light switch: 0 = X's turn, 1 = O's turn.

**After this step:** Button 5 now shows "X" on screen! 🎉

---

### **Step 8: Check for Winner (Only After 5 Clicks)**
```java
if (count >= 5) {
```

**Why 5?** The minimum moves to win Tic-Tac-Toe is 5 (X plays 3 times, O plays 2 times). Before 5 moves, winning is impossible, so we skip this whole section to save processing.

**First 4 clicks:** This entire block is skipped, method ends, wait for next click.

**5th click and beyond:** Let's go deeper...

---

### **Step 9: Read All Button Texts**
```java
b1 = btn1.getText().toString();
b2 = btn2.getText().toString();
// ... all 9 buttons
```

**What happens:** We grab the current text from every button and store them in variables `b1` through `b9`. This gives us a "snapshot" of the board.

**Example board state:**
```
b1="X"  b2="O"  b3="X"
b4=""   b5="X"  b6="O"
b7=""   b8=""   b9=""
```

---

### **Step 10: Check All Winning Combinations**

Now comes the exciting part! We check all 8 possible ways to win:

#### **Row 1:**
```java
if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
    announceWinner(b1);
}
```

**Logic breakdown:**
- `b1.equals(b2)` → Is button 1 the same as button 2?
- `&&` → AND (both conditions must be true)
- `b2.equals(b3)` → Is button 2 the same as button 3?
- `!b1.equals("")` → Is button 1 NOT empty?

**Why the empty check?** Without it, three empty buttons ("" == "" == "") would be detected as a win!

**If all true:** All three buttons in row 1 have the same symbol (X or O), so someone won! Call `announceWinner(b1)` and pass the winner's symbol.

#### **Then it checks:**
- Row 2: `b4 == b5 == b6`
- Row 3: `b7 == b8 == b9`
- Column 1: `b1 == b4 == b7`
- Column 2: `b2 == b5 == b8`
- Column 3: `b3 == b6 == b9`
- Diagonal 1: `b1 == b5 == b9` (top-left to bottom-right)
- Diagonal 2: `b3 == b5 == b7` (top-right to bottom-left)

**It uses `else if`** which means: "If the first condition is true, skip all others." As soon as a winning combination is found, it stops checking.

---

### **Step 11: Check for Draw**
```java
else if (count == 9) {
    announceDraw();
}
```

**Logic:** If we've checked all 8 winning conditions and none matched, BUT all 9 buttons are filled (`count == 9`), then it's a draw!

---

## 🎊 **WINNER ANNOUNCED**

```java
private void announceWinner(String winner) {
    gameOver = true;
    Toast.makeText(this, "Player " + winner + " wins! 🎉", Toast.LENGTH_LONG).show();
}
```

**What happens:**
1. `gameOver = true` → Sets the flag so no more buttons can be clicked
2. `Toast.makeText()` → Creates a popup message
   - `this` → The current activity (MainActivity)
   - `"Player " + winner + " wins!"` → Builds the message (if winner is "X", it says "Player X wins!")
   - `Toast.LENGTH_LONG` → How long to show it (2-3 seconds)
3. `.show()` → Actually displays the Toast on screen

**Game ends!** No more clicks work because of the `gameOver` check at the start of `Check()`.

---

## 🤝 **DRAW ANNOUNCED**

```java
private void announceDraw() {
    gameOver = true;
    Toast.makeText(this, "It's a Draw! 🤝", Toast.LENGTH_LONG).show();
}
```

Same as winner, but different message!

---

## 📊 **COMPLETE FLOW SUMMARY**

```
App Starts
   ↓
onCreate() called
   ↓
setContentView() loads XML layout → Grid appears on screen
   ↓
init() connects button variables to XML buttons
   ↓
[APP READY - Waiting for clicks]
   ↓
User clicks btn5
   ↓
Android calls Check(btn5)
   ↓
Check if game over? → No, continue
   ↓
Cast view to Button → btnCurrent = btn5
   ↓
Is button empty? → Yes, continue
   ↓
count++ → count = 1
   ↓
flag == 0? → Yes, set "X" and flag = 1
   ↓
count >= 5? → No (only 1 click), skip winner check
   ↓
[END - Wait for next click]
   ↓
[After 5th click, winner checking begins...]
   ↓
Read all button texts (b1-b9)
   ↓
Check Row 1 → No match
   ↓
Check Row 2 → No match
   ↓
... keep checking ...
   ↓
Check Diagonal 1 → MATCH! b1="X", b5="X", b9="X"
   ↓
announceWinner("X")
   ↓
gameOver = true
   ↓
Show Toast: "Player X wins! 🎉"
   ↓
[GAME OVER - No more clicks work]
```

---

## 🔑 **KEY CONCEPTS RECAP**

1. **onClick in XML** connects button clicks to Java methods
2. **findViewById()** links XML elements to Java variables
3. **flag** alternates between players (0 and 1, like a toggle switch)
4. **count** tracks total moves to optimize winner checking
5. **gameOver** prevents clicks after the game ends
6. **equals()** compares strings (button texts)
7. **Toast** shows temporary messages to the user
8. **Casting** converts generic View to specific Button type
