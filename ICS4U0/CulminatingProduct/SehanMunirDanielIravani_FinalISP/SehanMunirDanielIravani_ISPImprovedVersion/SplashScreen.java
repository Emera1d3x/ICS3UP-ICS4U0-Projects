// IMPORTS
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * The SplashScreen class creates an animated splash screen using a matrix of characters
 * that transition into an image. It implements the ActionListener interface to handle
 * timer events for the animation.
 *
 * @Author: Daniel Iravani - 5hrs, Sehan Munir - 2hrs
 * @Version: 1.0
 * Created on 6/04/2024
 */
public class SplashScreen extends JPanel implements ActionListener {
    /**
     * Possible characters
   */
    private String possibleCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
    /**
     * Matrix grid of characters
   */
    private char[][] characters;
    /**
     * Y positions for each column of characters
   */
    private int[] yPositions;
    /**
     * Timer to create delay for the animation
   */
    private Timer timer;
    /**
     * Y coordinate for a rectangle box that covers the matrix (transition effect)
   */
    private int coverer = 0;
    /**
     * Overlay image to enhance appearance
   */
    private BufferedImage splashScreenVignetteOverlay;
    /**
     * Foreground image of the splash screen
   */
    private BufferedImage splashScreenForeground;
    /**
     * Background image of the splash screen
   */
    private BufferedImage splashScreenBackground;
    /**
     * Logo image for the splash screen
   */
    private BufferedImage splashScreenLogo;
    /**
     * Last image for the splash screen
   */
    private BufferedImage lastScreen;

    /**
     * Constructor for the SplashScreen class.
     * Initializes the character matrix and y positions, loads images, and starts the timer.
     */
    public SplashScreen() {
        characters = new char[32][25]; // Initialize the grid with 32 columns and 25 rows
        yPositions = new int[32]; // Initialize y positions for each column

        // Randomize initial y positions
        for (int i = 0; i < yPositions.length; i++) {
            yPositions[i] = (int)(Math.random() * (25));
        }

        // Load images
        try {splashScreenVignetteOverlay = ImageIO.read(new File("Images/VignetteOverlay.png"));} catch (IOException e) {}
        try {splashScreenForeground = ImageIO.read(new File("Images/SplashScreenBuildingForeground.png"));} catch (IOException e) {}
        try {splashScreenBackground = ImageIO.read(new File("Images/SplashScreenBuildingBackground.png"));} catch (IOException e) {}
        try {splashScreenLogo = ImageIO.read(new File("Images/SplashScreenLogo.png"));} catch (IOException e) {}
        try {lastScreen = ImageIO.read(new File("Images/SplashScreenLastScreen.png"));} catch (IOException e) {}
        // Create and start the timer with a delay of 50 milliseconds
        timer = new Timer(50, this);
        timer.start();
    }

    /**
     * Paints the components of the splash screen, including the character matrix and images.
     * @param g the Graphics object used for drawing
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 640, 500);

        // Draw matrix of characters
        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if (characters[i][j] != ' ') {
                    g.setColor(new Color(0, 255, 76));
                    g.drawString(Character.toString(characters[i][j]), i*20, j*20 + 20);
                }
            }
        }

        // Draw transition cover
        g.setColor(Color.BLACK);
        if (coverer > 55) {
            g.fillRect(0, 0, 130, coverer - 70 + 50);
            g.fillRect(130, 0, 50, coverer - 70 + 20);
            g.fillRect(180, 0, 80, coverer - 70 + 80);
            g.fillRect(260, 0, 80, coverer - 70 + 10);
            g.fillRect(340, 0, 60, coverer - 70 + 32);
            g.fillRect(400, 0, 100, coverer - 70 + 80);
            g.fillRect(500, 0, 160, coverer - 70);
            coverer += 6;
        }

        // Draw second portion of splash screen
        if (coverer >= 560 && coverer < 785) {
            g.setColor(new Color(26, 46, 43, 0 + coverer - 560));
            g.fillRect(0, 0, 640, 500);
        }
        if (coverer >= 785 && coverer < 1010) {
            g.setColor(new Color(26, 46, 43));
            g.fillRect(0, 0, 640, 500);
            if (splashScreenLogo != null) {
                g.drawImage(splashScreenLogo, 0, 0, this);
            }
            g.setColor(new Color(26, 46, 43, 255 + 785 - coverer));
            g.fillRect(0, 0, 640, 500);
        }
        if (coverer > 1010) {
            if (splashScreenLogo != null) {
                g.drawImage(splashScreenLogo, 0, 0, this);
            }
        }
        if (coverer >= 785) {
            if (splashScreenBackground != null) {
                g.drawImage(splashScreenBackground, -1600 + 785 + (coverer / 2), 0, this);
            }
            if (splashScreenForeground != null) {
                g.drawImage(splashScreenForeground, -1600 + coverer, 0, this);
            }
        }
        if (coverer > 1300) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 640, 500);
            g.drawImage(lastScreen,0,0,this);
        }

        // Draw vignette overlay
        if (splashScreenVignetteOverlay != null) {
            g.drawImage(splashScreenVignetteOverlay, 0, 0, this);
        }
    }

    /**
     * Handles timer events to update the animation.
     * @param e the ActionEvent triggered by the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        coverer++; // Increment coverer to update transition

        // Update character matrix
        for (int i = 0; i < yPositions.length; i++) {
            int yPos = yPositions[i];
            if (yPos >= 0 && yPos < characters[i].length) {
                characters[i][yPos] = possibleCharacters.charAt((int)(Math.random() * possibleCharacters.length()));
            }
            yPositions[i]++;
            if (yPositions[i] >= characters[i].length) {
                yPositions[i] = -(int)(Math.random() * (characters[i].length / 2)); // Reset to start above the screen
                for (int j = 0; j < characters[i].length; j++) {
                    characters[i][j] = ' '; // Clear column
                }
            }
        }
        repaint(); // Redraw the frame
    }
}