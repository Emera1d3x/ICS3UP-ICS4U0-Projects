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
 * The Credits class represents the credits screen of the game application.
 * It displays credits information and handles mouse events for interaction.
 *
 *
 * @Author: Sehan Munir - 30min
 * @Version: 1.0 Final
 * Created on 6/08/2024
 */
// CLASS
public class Credits extends JPanel implements MouseMotionListener, MouseListener {
    // Variables
    /**
     * The X position of the mouse
   */
    private int mouseX = 0;
    /**
     * The Y position of the mouse
   */
    private int mouseY = 0;
    /**
     * Cursor colour
   */
    private Color cursorColour = new Color(0, 255, 201, 100);
    /**
     * Timer
   */
    private Timer timer;
    /**
     * Credit Image with credits information
   */
    private BufferedImage creditsImage;

    // Constructor
    public Credits() {
        addMouseMotionListener(this);
        addMouseListener(this);
        // Load credits image
        try {creditsImage = ImageIO.read(new File("Images/Credits.png"));} catch (IOException e) {}
        // Set up timer for constant repainting
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    /**
     * Override method for painting components.
     * @param g Graphics object for drawing
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background image
        g.drawImage(creditsImage, 0, 0, this);
        // Draw custom cursor
        g.setColor(cursorColour);
        g.fillRect(mouseX-6, mouseY-6, 12, 12);
        g.fillRect(mouseX-6, mouseY, 12, 12);
        g.fillRect(mouseX-6, mouseY-12, 12, 12);
        g.fillRect(mouseX, mouseY-6, 12, 12);
        g.fillRect(mouseX-12, mouseY-6, 12, 12);
    }

    /**
     * Override method for handling mouse movement.
     * @param e MouseEvent containing mouse position
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        // Update mouse position
        mouseX = e.getX();
        mouseY = e.getY();
    }

    /**
     * Override method for handling mouse dragging.
     * Ensures constant repaint even during drag.
     * @param e MouseEvent containing mouse position
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    // Unused mouse event methods
    @Override
    public void mousePressed(MouseEvent e) {
        // Set navigation variable to return to the main menu
        Main.navigationVariable = 1;
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}