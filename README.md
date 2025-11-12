# 🪨📄✂️ Rock, Paper, Scissors Game (Java GUI)

A visually enhanced and interactive **Rock, Paper, Scissors** game built with **Java Swing**.  
This version includes **button icons**, a **scoreboard**, and a **replay feature** — making it both fun and polished!

---

## 🎮 Features

✅ **Graphical User Interface (GUI)** using Java Swing  
✅ **Rock, Paper, Scissors buttons with icons**  
✅ **Scoreboard** showing player and computer scores  
✅ **First to 5 wins ends the game**  
✅ **Play Again / Quit dialog box** after game over  
✅ Clean, centered, and responsive layout  

---

## 🖼️ Preview

> The game window displays three buttons (Rock, Paper, Scissors), each with its own icon.  
> When you click a button, the computer chooses randomly — and the result, along with scores, updates instantly.

---

## 🧠 Game Logic

1. The player chooses **Rock**, **Paper**, or **Scissors**.  
2. The computer makes a random choice.  
3. The winner for each round is determined:
   - 🪨 **Rock beats Scissors**
   - 📄 **Paper beats Rock**
   - ✂️ **Scissors beats Paper**
   - Same choice → Tie  
4. The first to **reach 5 wins** is declared the game winner.  
5. A dialog appears asking if you want to **Play Again** or **Quit**.

---

## ⚙️ Installation & Setup

### 1. Prerequisites
- Java JDK 8 or higher installed  
- A Java IDE (VS Code, IntelliJ, Eclipse) or terminal  

### 2. Clone or Download
```bash
git clone https://github.com/your-username/RockPaperScissors-Java.git
cd RockPaperScissors-Java

### 3. Add Images

Place these images in the same folder as your .java file:

rock.png

paper.png

scissors.png

### 4. Compile the Program

### 5. Run the Game

## 🧩 Code Structure
File	Description
RockPaperScissors.java	Main game file containing GUI setup, logic, and event handling
rock.png	Rock icon for Rock button
paper.png	Paper icon for Paper button
scissors.png	Scissors icon for Scissors button

## 🪄 Example Gameplay

Your Choice: Paper
Computer's Choice: Rock
Result: You Win 🎉
Score — You: 4 | Computer: 2

When either score reaches 5:

You win the game! 🏆
Do you want to play again?

## 🛠️ Technologies Used

Java Swing — GUI framework

AWT — Layout management and event handling

Java Random — For computer move generation

## 📈 Possible Improvements

Add sound effects for clicks and wins

Display winner animations

Include dark/light mode toggle

Use emojis instead of image icons (for portability)

## 👤 Author
**Exra Nerpio**  
📧 [nerpio.exra@gmail.com]  
💻 GitHub: [AceGit00123](https://github.com/AceGit00123)

---

## 🪪 License

This project is open-source and free to use for educational purposes.
