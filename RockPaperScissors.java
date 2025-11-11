import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class RockPaperScissors extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel, playerChoiceLabel, computerChoiceLabel, scoreLabel;
    private Random random;
    private int playerScore = 0;
    private int computerScore = 0;

    public RockPaperScissors() {
        // Window setup
        setTitle("Rock, Paper, Scissors Game");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        random = new Random();

        // Title label
        JLabel titleLabel = new JLabel("🪨📄✂️ Rock, Paper, Scissors", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 22));
        add(titleLabel, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 20, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Load icons
        ImageIcon rockIcon = resizeIcon(new ImageIcon("images/rock.jpg"), 60, 60);
        ImageIcon paperIcon = resizeIcon(new ImageIcon("images/paper.png"), 60, 60);
        ImageIcon scissorsIcon = resizeIcon(new ImageIcon("images/scissor.png"), 60, 60);

        // Buttons with icons
        rockButton = new JButton("Rock", rockIcon);
        paperButton = new JButton("Paper", paperIcon);
        scissorsButton = new JButton("Scissors", scissorsIcon);

        // Button styles
        JButton[] buttons = {rockButton, paperButton, scissorsButton};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Poppins", Font.BOLD, 14));
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);
            btn.setFocusPainted(false);
            btn.setBackground(Color.WHITE);
            btn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
            btn.addActionListener(this);
        }

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Results panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(4, 1, 0, 5));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        playerChoiceLabel = new JLabel("Your Choice: ", SwingConstants.CENTER);
        computerChoiceLabel = new JLabel("Computer's Choice: ", SwingConstants.CENTER);
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Poppins", Font.BOLD, 16));

        scoreLabel = new JLabel("Score — You: 0 | Computer: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Poppins", Font.PLAIN, 14));

        resultPanel.add(playerChoiceLabel);
        resultPanel.add(computerChoiceLabel);
        resultPanel.add(resultLabel);
        resultPanel.add(scoreLabel);

        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Helper method to resize icons
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        int computerIndex = random.nextInt(3);
        String computerChoice = choices[computerIndex];
        String playerChoice = "";

        if (e.getSource() == rockButton) playerChoice = "Rock";
        else if (e.getSource() == paperButton) playerChoice = "Paper";
        else if (e.getSource() == scissorsButton) playerChoice = "Scissors";

        playerChoiceLabel.setText("Your Choice: " + playerChoice);
        computerChoiceLabel.setText("Computer's Choice: " + computerChoice);

        String result = getWinner(playerChoice, computerChoice);
        resultLabel.setText("Result: " + result);
        scoreLabel.setText("Score — You: " + playerScore + " | Computer: " + computerScore);

        checkGameOver();
    }

    private String getWinner(String player, String computer) {
        if (player.equals(computer)) return "It's a Tie!";
        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper"))) {
            playerScore++;
            return "You Win 🎉";
        } else {
            computerScore++;
            return "Computer Wins 😢";
        }
    }

    private void checkGameOver() {
        if (playerScore == 5 || computerScore == 5) {
            String winner = playerScore == 5 ? "You win the game! 🏆" : "Computer wins the game! 🤖";
            int option = JOptionPane.showConfirmDialog(
                this,
                winner + "\n\nDo you want to play again?",
                "Game Over",
                JOptionPane.YES_NO_OPTION
            );

            if (option == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                JOptionPane.showMessageDialog(this, "Thanks for playing!");
                System.exit(0);
            }
        }
    }

    private void resetGame() {
        playerScore = 0;
        computerScore = 0;
        resultLabel.setText("Result: ");
        playerChoiceLabel.setText("Your Choice: ");
        computerChoiceLabel.setText("Computer's Choice: ");
        scoreLabel.setText("Score — You: 0 | Computer: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissors());
    }
}
