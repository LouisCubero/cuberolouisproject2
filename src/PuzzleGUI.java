import javax.swing.*;
import java.awt.*;

/**
 * This class represents the GUI for a word puzzle game.
 */
public class PuzzleGUI {
    private String letters;
    private String[] solutions;
    public int score;
    private JTextArea guessedWordsArea;
    public JTextArea sortedWordsArea;
    private JLabel scoreLabel;

    /**
     * Constructs a PuzzleGUI object with the given letters and solutions.
     *
     * @param letters   The letters available for the game.
     * @param solutions The solutions to the puzzle.
     */
    public PuzzleGUI(String letters, String[] solutions) {
        this.letters = letters;
        this.solutions = solutions;
        this.score = 0;
    }

    /**
     * Sets up and displays the game GUI.
     */
    public void startGame() {
        JFrame frame = new JFrame("Word Puzzle Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(Box.createVerticalGlue());
        JLabel wordBankLabel = new JLabel("Letters to use:");
        wordBankLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(wordBankLabel);
        JLabel lettersLabel = new JLabel(letters);
        lettersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(lettersLabel);
        leftPanel.add(Box.createVerticalGlue());

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        guessedWordsArea = new JTextArea(10, 20);
        guessedWordsArea.setEditable(false);
        JScrollPane guessedWordsScrollPane = new JScrollPane(guessedWordsArea);
        rightPanel.add(new JLabel("Guessed Words:"));
        rightPanel.add(guessedWordsScrollPane);

        sortedWordsArea = new JTextArea(10, 20);
        sortedWordsArea.setEditable(false);
        JScrollPane sortedWordsScrollPane = new JScrollPane(sortedWordsArea);
        rightPanel.add(new JLabel("Sorted Words:"));
        rightPanel.add(sortedWordsScrollPane);

        scoreLabel = new JLabel("Score: " + score);
        rightPanel.add(scoreLabel);

        frame.add(leftPanel);
        frame.add(rightPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Adds a guessed word to the GUI.
     *
     * @param word The word guessed by the player.
     */
    public void addGuessedWord(String word) {
        guessedWordsArea.append(word + "\n");
    }

    /**
     * Increases the player's score and updates the score label in the GUI.
     */
    public void increaseScore(int pointsToAdd) {
        score+=pointsToAdd;
        scoreLabel.setText("Score: " + score);
    }

    /**
     * Updates the TextArea with the contents of the sorted list.
     *
     * @param sortedListContents The contents of the sorted list.
     */
    public void updateSortedWordsArea(String sortedListContents) {
        sortedWordsArea.setText(sortedListContents);
    }
}