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
import java.util.Arrays;
/**
 * The Leaderboard class represents the leaderboard screen of the game application.
 * It displays the top 9 scores from the database and allows the user to navigate back to the main menu.
 *
 * @author Sehan Munir
 * @version 1.0 Final
 * Created on 6/02/2024
 */
// CLASS
public class Leaderboard extends JPanel implements MouseMotionListener, MouseListener {
    // Variables
    /**
     * The x-coordinate of the mouse cursor.
     */
    private int mouseX = 0;

    /**
     * The y-coordinate of the mouse cursor.
     */
    private int mouseY = 0;

    /**
     * The custom cursor color.
     */
    private Color cursorColour = new Color(0, 255, 201, 100);

    /**
     * A timer for constant repainting.
     */
    private Timer timer;

    /**
     * The leaderboard background image.
     */
    private BufferedImage leaderBoardBackground;

    /**
     * A 2D array to store the leaderboard display information.
     */
    private String[][] leaderBoardDisplay = new String[9][2];

    /**
     * A 2D array to store the database information.
     */
    private String[][] database;

    /**
     * A BufferedReader to read from the database file.
     */
    private BufferedReader fileReader;

    // Constructor
    public Leaderboard() {
        addMouseMotionListener(this);
        addMouseListener(this);
        // Load credits image
        try {leaderBoardBackground = ImageIO.read(new File("Images/Leaderboard.png"));} catch (IOException e) {}
        // Read info into database
        try {
            fileReader = new BufferedReader(new FileReader("Database.txt"));
            String text = fileReader.readLine();
            database = new String[Integer.parseInt(text)][2];
            for (int i = 0; i < Integer.parseInt(text); i++){
                String[] parts = (fileReader.readLine()).split(" ");
                database[i][0] = parts[0];
                database[i][1] = parts[1];
            }
        } catch (IOException e){}
        // Set up timer for constant repainting
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
    public void sortLeaderboard(){
      boolean sorted = false;
      while (!sorted) {
        sorted = true;
        for (int i = 1; i < database.length; i++) {
          if (Integer.parseInt(database[i-1][1]) < Integer.parseInt(database[i][1])) {
            String temp = database[i][0];
            database[i][0] = database[i - 1][0];
            database[i - 1][0] = temp;
            temp = database[i][1];
            database[i][1] = database[i - 1][1];
            database[i - 1][1] = temp;
            sorted = false;
          }
        }
      }
      for (int i = 0; i < 9; i++){
        leaderBoardDisplay[i][0] = database[i][0];
        leaderBoardDisplay[i][1] = database[i][1];
      }
    }

    /**
     * Override method for painting components.
     * @param g Graphics object for drawing
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background image
        g.drawImage(leaderBoardBackground, 0, 0, this);
        // Draw leaderboard information
        g.setFont(new Font("DialogInput", Font.PLAIN, 34));
        // Gold
          g.setColor(new Color(255, 214, 0));
          g.drawString(leaderBoardDisplay[0][0],126,147);
          g.drawString(leaderBoardDisplay[0][1],456,147);
        // Silver
          g.setColor(new Color(148, 148, 148));
          g.drawString(leaderBoardDisplay[1][0],126,187);
          g.drawString(leaderBoardDisplay[1][1],456,187);
        // Bronze
          g.setColor(new Color(122, 82, 1));
          g.drawString(leaderBoardDisplay[2][0],126,227);
          g.drawString(leaderBoardDisplay[2][1],456,227);
        // 4 
          g.setColor(new Color(0, 168, 87));
          g.drawString(leaderBoardDisplay[3][0],126,267);
          g.drawString(leaderBoardDisplay[3][1],456,267);
        // 5 
          g.drawString(leaderBoardDisplay[4][0],126,307);
          g.drawString(leaderBoardDisplay[4][1],456,307);
        // 6 
          g.drawString(leaderBoardDisplay[5][0],126,347);
          g.drawString(leaderBoardDisplay[5][1],456,347);
        // 7 
          g.drawString(leaderBoardDisplay[6][0],126,387);
          g.drawString(leaderBoardDisplay[6][1],456,387);
        // 8 
          g.drawString(leaderBoardDisplay[7][0],126,427);
          g.drawString(leaderBoardDisplay[7][1],456,427);
        // 9
          g.drawString(leaderBoardDisplay[8][0],126,467);
          g.drawString(leaderBoardDisplay[8][1],456,467);
        
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