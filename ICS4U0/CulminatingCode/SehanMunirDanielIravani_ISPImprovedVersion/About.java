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
 * The About class represents the about screen of the game application.
 * It displays about information and handles mouse events for interaction.
 *
 *
 * @Author: Sehan Munir, Daniel Iravani
 * @Version: 1.0 Final
 * Created on 6/08/2024
 */
// CLASS
public class About extends JPanel implements MouseMotionListener, MouseListener {
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
     * Regular Image with information
   */
    private BufferedImage regular;
    /**
     * Image with information + highlighted part
   */
    private BufferedImage highlighted;
    // Constructor
    public About() {
        addMouseMotionListener(this);
        addMouseListener(this);
        // assign image to image variable - read it from file
        try {regular = ImageIO.read(new File("Images/About1.png"));} catch (IOException e) {}
        try {highlighted = ImageIO.read(new File("Images/About2.png"));} catch (IOException e) {}
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
    /**
     * @Override - All graphics are done here
     * @param - Graphics g, a graphics parameter in which the drawing occurs.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw The Image
        if (mouseX > 20 && mouseX < 250 && mouseY > 430 && mouseY < 490){
            g.drawImage(highlighted, 0, 0, this);
        } else {
            g.drawImage(regular, 0, 0, this);
        }
        // Draw The Cursor
        g.setColor(cursorColour);
        g.fillRect(mouseX-6, mouseY-6, 12, 12);
        g.fillRect(mouseX-6, mouseY, 12, 12);
        g.fillRect(mouseX-6, mouseY-12, 12, 12);
        g.fillRect(mouseX, mouseY-6, 12, 12);
        g.fillRect(mouseX-12, mouseY-6, 12, 12);
    }
    /**
     * @Override - Ensure variables mouseX and mouseY always has accurate coordinates
     *  when mouse is in a 
     * @param - MouseEvent e - passes a MouseEvent object which contains information about the mouse such as its x and y coordinates
     */
    public void mouseMoved(MouseEvent e) {
        // Update mouse position
        mouseX = e.getX();
        mouseY = e.getY();
    }/**
     * @Override - Ensures program still repaints constantly and looks for mouse coordinates, 
     * even if dragged
     * @param - MouseEvent e - not useful here, but useful in mouseMoved method, e contains useful information about the mouse such as its x and y coordinates
     */
    public void mouseDragged(MouseEvent e){mouseMoved(e);}
    /**
     * @Override - Handles mouse press events, when this happens it goes back to main
     */
    public void mousePressed(MouseEvent e) {
        if (mouseX > 20 && mouseX < 250 && mouseY > 430 && mouseY < 490){
            Main.navigationVariable = 1;
        }
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
