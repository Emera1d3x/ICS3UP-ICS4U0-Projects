// IMPORTS
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;
import java.io.*;
/**
 * This class represents the main class of the game application.
 * It displays the main menu with interactive options.
 * Users can navigate to different parts of the application by interacting with the menu.
 * The main menu features a custom cursor and animated elements.
 * 
 * 
 * @Author: Daniel Iravani - 2hrs, Sehan Munir - 3hrs, Shared - 2hrs45min?
 * @Version: 1.0 Final
 * Created on 6/01/2024
 */
// CLASS
public class MainMenu extends JPanel implements MouseMotionListener, MouseListener {
    // Variables
     private int mouseX = 0; // Mouse x coordinate
    private int mouseY = 0; // Mouse y coordinate
    private Color backgroundColour = new Color(0, 0, 0); // Background color
    private Color cursorColour = new Color(0, 255, 201, 100); // Custom cursor color
    private Color light = new Color(187, 183, 0, 19); // Light effect color
    private int lightMovement = 670; // Light movement variable
    private BufferedImage mainMenuImage; // Current background image
    private BufferedImage mainMenuLeaderboard;
    private BufferedImage mainMenuLeaderboardHover;
    private Timer timer; // Timer for animation
    /**
     * Constructor for the MainMenu class.
     * Sets up mouse listeners, loads the default background image, and starts the timer.
     */
    public MainMenu() {
        addMouseMotionListener(this);
        addMouseListener(this);
        try {mainMenuImage = ImageIO.read(new File("Images/MainMenuDefault.png"));} catch (IOException e) {} // Default background image
        try {mainMenuLeaderboard = ImageIO.read(new File("Images/MainMenuLeaderBoard.png"));} catch (IOException e) {} // Default leaderboard image
        try {mainMenuLeaderboardHover = ImageIO.read(new File("Images/MainMenuLeaderBoardHover.png"));} catch (IOException e) {} // Hover leaderboard image
        Main.navigationVariable = 1; // Indicates the current section of the program
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
    /**
     * @Override Paints the components of the main menu, including the background image, custom cursor, and light effect.
     * @param g the Graphics object used for drawing
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background
        g.setColor(backgroundColour);
        g.fillRect(0, 0, 640, 500);
        // Draw the background image
        if (mainMenuImage != null) {
            g.drawImage(mainMenuImage, 0, 0, this);
        }
        // Draw Leaderboard (this is part of improved version)
        if (mouseX >= 492 && mouseY >= 297 && mouseX <= 603 && mouseY <= 347){
            g.drawImage(mainMenuLeaderboardHover, 0, 0, this);
        } else {
            g.drawImage(mainMenuLeaderboard, 0, 0, this);
        }
        // Draw the custom cursor
        g.setColor(cursorColour);
        g.fillRect(mouseX - 6, mouseY - 6, 12, 12);
        g.fillRect(mouseX - 6, mouseY, 12, 12);
        g.fillRect(mouseX - 6, mouseY - 12, 12, 12);
        g.fillRect(mouseX, mouseY - 6, 12, 12);
        g.fillRect(mouseX - 12, mouseY - 6, 12, 12);
        // Draw the ray of light effect
        g.setColor(light);
        lightMovement -= 5;
        if (lightMovement < -950) {
            lightMovement = 670;
        }
        for (int i = -30; i < 640; i += 10) {
            g.fillRect(i, lightMovement + i, 30, 30);
        }
    }
    /**
     * @Override - Ensure variables mouseX and mouseY always has accurate coordinates
     *  when mouse is in a 
     * @param - MouseEvent e - passes a MouseEvent object which contains information about the mouse such as its x and y coordinates
     */
    public void mouseMoved(MouseEvent e) {
        // Update mouse position
        mouseX = e.getX(); // Update mouseX
        mouseY = e.getY(); // Update mouseY
        // Show proper background image according to mouse position
        if (mouseY>=343&&mouseY<=393){
            try {mainMenuImage = ImageIO.read(new File("Images/MainMenuCredits.png"));} catch (IOException i) {}
        } else if (mouseY>=287&&mouseY<=342){
            try {mainMenuImage = ImageIO.read(new File("Images/MainMenuLevel2.png"));} catch (IOException i) {}
        } else if (mouseY>=232&&mouseY<=286) {
            try {mainMenuImage = ImageIO.read(new File("Images/MainMenuLevel1.png"));} catch (IOException i) {}
        } else if (mouseY>=184&&mouseY<=231) {
            try {mainMenuImage = ImageIO.read(new File("Images/MainMenuAbout.png"));} catch (IOException i) {}
        } else {
            try {mainMenuImage = ImageIO.read(new File("Images/MainMenuDefault.png"));} catch (IOException i) {}
        }
    }
    /**
     * @Override - Calls mouseMoved method when mouse is dragged to update mouse coordinates and background image.
     * @param e the MouseEvent containing information about the mouse position
     */
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    /**
     * @Override - Handles mouse press events to navigate to different sections of the application.
     * @param e the MouseEvent containing information about the mouse position
     */
    public void mousePressed(MouseEvent e) {
        if (mouseY >= 343 && mouseY <= 393) {
            Main.navigationVariable = 5;
        } else if (mouseX >= 492 && mouseY >= 297 && mouseX <= 603 && mouseY <= 347){
            Main.navigationVariable = 6;
        } else if (mouseY >= 287 && mouseY <= 342) {
            Main.navigationVariable = 4;
        } else if (mouseY >= 232 && mouseY <= 286) {
            Main.navigationVariable = 3;
        } else if (mouseY >= 184 && mouseY <= 231) {
            Main.navigationVariable = 2;
        }
    }

    // Empty implementations for unused MouseListener methods
    /**
     * @Override - Empty implemenetations for unused MouseListener methods
     */
    public void mouseReleased(MouseEvent e) {}
    /**
     * @Override - Empty implemenetations for unused MouseListener methods
     */
    public void mouseClicked(MouseEvent e) {}
    /**
     * @Override - Empty implemenetations for unused MouseListener methods
     */
    public void mouseEntered(MouseEvent e) {}
    /**
     * @Override - Empty implemenetations for unused MouseListener methods
     */
    public void mouseExited(MouseEvent e) {}
    
}
