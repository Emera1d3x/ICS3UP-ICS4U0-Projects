// Sehan Munir, Daniel Iravani
// ICS4U0 - Ms. Krasteva
// 2024-06-12

// IMPORTS
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 * The Main class represents the main class of the game application.
 * It initializes and controls the game components and screen transitions.
 *
 * <strong>Course info:</strong>
 * ICS4U0 with V. Krasteva
 *
 * @authors: Sehan Munir, Daniel Iravani
 * @version: 1.0 Final
 * Created on 6/02/2024
 */
// CLASS
public class Main implements ActionListener {
    // Variables
    /**
     * A variable that dictates the current part of the program the user is using.
     */
    static int navigationVariable = 0;

    /**
     * The canvas where everything is drawn.
     */
    static JFrame canvas;

    /**
     * Object to display the splash screen.
     */
    static SplashScreen splashScreen;

    /**
     * Object to display the main menu.
     */
    static MainMenu mainMenu;

    /**
     * Object to display the about screen.
     */
    static About about;

    /**
     * Object to display level one.
     */
    static LevelOne levelOne;

    /**
     * Object to display level two.
     */
    static LevelTwo levelTwo;

    /**
     * Object to display the credits.
     */
    static Credits credits;

    /**
     * Object to display the leaderboard.
     */
    private Leaderboard leaderBoard;

    /**
     * Timer for managing screen transitions.
     */
    private Timer navigationTimer;

    /**
     * Main method to start the game.
     * @param args Command line arguments
     */
    public static void main(String[] args) { 
        Main z = new Main(); // Instance of Main class
        canvas = new JFrame("CyberShield: Training Cave"); // Window for the game
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close window exits the program
        canvas.setSize(650, 538); // Set canvas size
        // Invisible Cursor Trick
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB); // Creates a new image, transparent 16x16
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor"); // Create cursor object with this image
        canvas.getContentPane().setCursor(blankCursor); // Set cursor to canvas
        canvas.setResizable(false); // Set the canvas to not be resizable, this is so the images don't look weird
        canvas.setVisible(true); // Set canvas to be visible
        canvas.setFocusable(true);
        canvas.enableInputMethods(true);
        z.game(); // Start the game
        // Set up the navigation timer to manage screen transitions
        z.navigationTimer = new Timer(1, z); // Check navigationVariable every 100 ms
        z.navigationTimer.start(); // Start timer
        
    }

    /**
     * Start and control the game program.
     */
    public void game() {
        splashScreen = new SplashScreen();
        canvas.add(splashScreen);
        canvas.revalidate();
        Timer splashTimer = new Timer(17000, new ActionListener() { // Set timer for splash screen
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.remove(splashScreen);
                canvas.revalidate();
                showMainMenu(); // Move to main menu after splash screen
            }
        });
        splashTimer.setRepeats(false); // Ensure the timer only fires once
        splashTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleNavigation(); // Call handleNavigation on every timer tick
    }

    /**
     * Show the main menu screen.
     */
    public void showMainMenu() {
        removePreviousScreens(); // Remove previous screens
        mainMenu = new MainMenu(); // Create new instance of main menu
        canvas.add(mainMenu); // Add it to the canvas
        canvas.revalidate();
        canvas.repaint();
    }

    /**
     * Show the about screen.
     */
    public void showAbout() {
        removePreviousScreens();
        about = new About(); // Create new instance of about
        canvas.add(about);
        canvas.revalidate();
        canvas.repaint();
    }

    /**
     * Show level one screen.
     */
    public void showLevelOne() {
        removePreviousScreens();
        levelOne = new LevelOne(); // Create new instance of level one
        canvas.add(levelOne);
        canvas.revalidate();
        canvas.repaint();
    }

    /**
     * Show level two screen.
     */
    public void showLevelTwo() {
        removePreviousScreens();
        levelTwo = new LevelTwo(); // Create new instance of level two
        levelTwo.setFocusable(true);
        levelTwo.setRequestFocusEnabled(true);
        levelTwo.enableInputMethods(true);
        levelTwo.grabFocus();
        canvas.add(levelTwo);
        canvas.revalidate();
        canvas.repaint();
    }

    /**
     * Show the credits screen.
     */
    public void showCredits() {
        removePreviousScreens();
        credits = new Credits(); // Create new instance of credits
        canvas.add(credits);
        canvas.revalidate();
        canvas.repaint();
    }

    /**
     * Show the leaderboard screen.
     */
    public void showLeaderboard() {
        removePreviousScreens();
        leaderBoard = new Leaderboard(); // Create new instance of credits
        leaderBoard.sortLeaderboard();
        canvas.add(leaderBoard);
        canvas.revalidate();
        canvas.repaint();
    }

    /**
     * Remove previous screens from canvas.
     */
    private void removePreviousScreens() {
        // Remove any previous screens, this may help with optimization
        if (mainMenu != null) {canvas.remove(mainMenu);}
        if (about != null) {canvas.remove(about);}
        if (levelOne != null) {canvas.remove(levelOne);}
        if (levelTwo != null) {canvas.remove(levelTwo);}
        if (credits != null) {canvas.remove(credits);}
        if (leaderBoard != null) {canvas.remove(leaderBoard);}
    }

    /**
     * Handle navigation based on navigationVariable.
     */
    private void handleNavigation() {
        switch (navigationVariable) { // Depending on navigationVariable, it chooses what to display, essentially the back bone to the navigation
            case 1:
                showMainMenu();
                navigationVariable=0;
                break;
            case 2:
                showAbout();
                navigationVariable=0;
                break;
            case 3:
                showLevelOne();
                navigationVariable=0;
                break;
            case 4:
                showLevelTwo();
                navigationVariable=0;
                break;
            case 5:
                showCredits();
                navigationVariable = 0;
                break;
            case 6:
                showLeaderboard();
                navigationVariable = 0;
                break;
        }
    }
}
