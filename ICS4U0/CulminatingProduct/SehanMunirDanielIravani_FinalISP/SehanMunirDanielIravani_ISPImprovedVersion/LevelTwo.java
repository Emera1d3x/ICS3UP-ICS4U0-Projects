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
 * The LevelTwo class represents the first level of the game application.
 * It displays various slides and handles user interactions during the level.
 *
 *
 * @Author: Daniel Iravani - Emails 2hrs?, Sehan Munir - >6hrs (I really wanted to use keylistener for a cool input, and keylistener really did not want to be focused)
 * @Version: 1.0
 * Created on 6/02/2024
 */
// CLASS
public class LevelTwo extends JPanel implements MouseMotionListener, MouseListener {
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
    * Custom cursor colour.
   */
    private Color cursorColour = new Color(0, 255, 201, 100);
    /**
    * Variable that constantly calls repaint, essentially a constant controller of frames.
   */
    private Timer timer;
    /**
    * Ensure scripted events are timed properly
   */
    private int timingVariable;
    /**
    * Integer that represents what slide/segment that the user is on. 
   */
    private int slide;
    /**
    * Image variables that changes, represents the current image
   */
    private BufferedImage currentImage;
    /**
    * Image variable that holds the start screen
   */
    private BufferedImage startScreen;
    /**
    * Integer that represents timer for the email game.
   */
    private int startTime;
    /**
    * Image variable representing the current image.
   */
    private int currentEmail;
    /**
    * The amount of points the user has
   */
    private int points;
    /**
    * Image variable the represents the end screen.
   */
    private BufferedImage endScreen;
    /**
    * Every single email in order, boolean represents true = safe, false = dangerous
   */
    private boolean[] safeNotSafe = new boolean[33];
    /**
    * Image variable that shows up when you get an email correct
   */
    private BufferedImage correctImage;
    /**
    * Every single email image is in [][0] and the wrong screen is in [][1]
   */
    private BufferedImage[][] emails = new BufferedImage[33][2];
    /**
    * Image variable representing save score
   */
    private BufferedImage saveScoreImage;
    /**
    * Error image
   */
    private BufferedImage errorLength;
    /**
    * Error image
   */
    private BufferedImage errorSpace;
    /**
    * Boolean true if there is an error length with input for name
   */
    private boolean errorLengthHelper;
    /**
    * Boolean true if there is a space in input for name
   */
    private boolean errorSpaceHelper;
    /**
    * User inputs save name
   */
    private String saveName = "";
    /**
    * Constantly repaint until userinput (at the very end).
   */
    private boolean work;
    // Constructor
    public LevelTwo() {
        slide = 0;
        points = 0;
        work = true;
        timingVariable = 0;
        this.grabFocus();
        for (int i = 0; i < 22; i++){
            safeNotSafe[i] = false;
            String fileName = "Images/Emails/EMAILnumber"+(i+1)+".png";
            String fileNameWrong = "Images/Emails/EMAILnumber"+(i+1)+"wrong.png";
            try {emails[i][0] = ImageIO.read(new File(fileName));} catch (IOException e) {}
            try {emails[i][1] = ImageIO.read(new File(fileNameWrong));} catch (IOException e) {}
        }
        for (int i = 22; i < 33; i++){
            safeNotSafe[i] = true;
            String fileName = "Images/Emails/EMAILnumber"+(i+1)+".png";
            String fileNameWrong = "Images/LevelTwoIncorrectBox.png";
            try {emails[i][0] = ImageIO.read(new File(fileName));} catch (IOException e) {}
            try {emails[i][1] = ImageIO.read(new File(fileNameWrong));} catch (IOException e) {}
        }
        addMouseMotionListener(this);
        addMouseListener(this);
        try {correctImage = ImageIO.read(new File("Images/LevelTwoCorrectBox.png"));} catch (IOException e) {}
        try {startScreen = ImageIO.read(new File("Images/LevelTwoStartScreen.png"));} catch (IOException e) {}
        try {endScreen = ImageIO.read(new File("Images/LevelTwoEnd.png"));} catch (IOException e) {}
        try {saveScoreImage = ImageIO.read(new File("Images/SaveScoreBackground.png"));} catch (IOException e) {}
        try {errorSpace = ImageIO.read(new File("Images/SaveScoreErrorSpace.png"));} catch (IOException e) {}
        try {errorLength = ImageIO.read(new File("Images/SaveScoreErrorLength.png"));} catch (IOException e) {}
        timer = new Timer(1, new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                timingVariable++;
                if (work){
                    repaint(); 
                }
            }
        });
        timer.start();
    }
    /**
     * @Override - All graphics are done here
     * @param - Graphics g, a graphics parameter in which the drawing occurs.
     */
    public void paintComponent(Graphics g) {
        // Draw The Background
        g.setColor(Color.RED);
        g.fillRect(0, 0, 640, 400);
        // 1
        if (timingVariable >= 0 && timingVariable <= 85){
            currentImage = startScreen;
            g.drawImage(currentImage, 0, 0, this);
            g.setColor(new Color(0,0,0, 255-(timingVariable*3)));
            g.fillRect(0, 0, 640, 500);
        }
        // 2
        if (timingVariable >= 85 && timingVariable <= 130){
            currentImage = startScreen;
            g.drawImage(currentImage, 0, 0, this);
        }
        // 3 
        if (timingVariable >= 130 && timingVariable <= 410){
            int num = timingVariable-130;
            g.drawImage(currentImage, 0, 0, this);
            for (int i = 0; i < num; i++){
                int transitionX = (int)(i%16)*40;
                int transitionY = (int)(i/13)*40;
                g.setColor(new Color(18, 82, 43+(i/7)));
                g.fillRect(transitionY, transitionX, 40, 40);
            }
        } else if (timingVariable >= 410) {
            if (slide == 0){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions1Right.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions1.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            } else if (slide == 1){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions2Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions2Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions2.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            } else if (slide == 2){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions3Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions3Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions3.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            } else if (slide == 3){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions4Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions4Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions4.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            } else if (slide == 4){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions5Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions5Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions5.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            }  else if (slide == 5){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions6Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions6Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions6.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            }  else if (slide == 6){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions7Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions7Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions7.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            }  else if (slide == 7){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions8Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions8Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions8.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
            }  else if (slide == 8){
                if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions9Right.png"));} catch (IOException e) {}
                } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions9Left.png"));} catch (IOException e) {}
                } else {
                    try {currentImage = ImageIO.read(new File("Images/LevelTwoInstructions9.png"));} catch (IOException e) {}
                }
                g.drawImage(currentImage, 0, 0, this);
                startTime = 0;
            } else if (slide == 9){
                startTime++;
                if (startTime > 6000){ //////////////////////////
                    slide = 12;
                } else {
                    g.drawImage(emails[currentEmail][0], 0, 0, this);
                    g.setColor(new Color(138, 0, 0));
                    g.setFont(new Font("Times Nesw Roman", Font.BOLD, 22));
                    g.drawString("Time Left: " + (60-(startTime/100)), 443, 73);
                    g.setColor(new Color(0, 179, 54));
                    g.setFont(new Font("Times New Roman", Font.BOLD, 55));
                    if (points > 9){
                        g.drawString(Integer.toString(points), 289, 492);
                    } else {
                        g.drawString(Integer.toString(points), 309, 492);
                    }
                    if (mouseX >= 11 && mouseY >= 413 && mouseX <= 186 && mouseY <= 481){
                        g.setColor(new Color(0, 255, 132, 61));
                        g.fillRect(11,413,186-11+5,481-413);
                    } else if (mouseX >= 432 && mouseY >= 413 && mouseX <= 611 && mouseY <= 481){
                        g.setColor(new Color(114, 5, 5, 61));
                        g.fillRect(432,413,186-11+5,481-413);
                    }
                }
            } else if (slide == 10){
                startTime++;
                if (startTime > 6000){
                    slide = 12;
                } else {
                    g.drawImage(emails[currentEmail][0], 0, 0, this);
                    g.setColor(new Color(138, 0, 0));
                    g.setFont(new Font("Times New Roman", Font.BOLD, 22));
                    g.drawString("Time Left: " + (60-(startTime/100)), 443, 73);
                    g.setColor(new Color(0, 179, 54));
                    g.setFont(new Font("Times New Roman", Font.BOLD, 55));
                    if (points > 9){
                        g.drawString(Integer.toString(points), 289, 492);
                    } else {
                        g.drawString(Integer.toString(points), 309, 492);
                    }
                }
                g.drawImage(correctImage, 0, 0, this);
            } else if (slide == 11){
                startTime++;
                if (startTime > 6000){
                    slide = 12;
                } else {
                    g.drawImage(emails[currentEmail][0], 0, 0, this);
                    g.setColor(new Color(138, 0, 0));
                    g.setFont(new Font("Times New Roman", Font.BOLD, 22));
                    g.drawString("Time Left: " + (60-(startTime/100)), 443, 73);
                    g.setColor(new Color(0, 179, 54));
                    g.setFont(new Font("Times New Roman", Font.BOLD, 55));
                    if (points > 9){
                        g.drawString(Integer.toString(points), 289, 492);
                    } else {
                        g.drawString(Integer.toString(points), 309, 492);
                    }
                }
                g.drawImage(emails[currentEmail][1], 0, 0, this);
            } else if (slide == 12){
                g.drawImage(endScreen, 0, 0, this);
                g.setColor(new Color(0, 158, 82));
                g.setFont(new Font("Times New Roman", Font.BOLD, 95));
                if (points > 9){
                    g.drawString(Integer.toString(points), 269, 277);
                } else {
                    g.drawString(Integer.toString(points), 296, 277);
                }
            } else if (slide == 13){
                errorLengthHelper = false;
                errorSpaceHelper = false;
                g.drawImage(saveScoreImage, 0, 0, this);
                if (saveName.contains(" ")){
                    errorSpaceHelper = true;
                }
                if (saveName.length()>15){
                    errorLengthHelper = true;
                }
                if (errorSpaceHelper){
                    g.drawImage(errorSpace, 0, 0, this);
                }
                if (errorLengthHelper){
                    g.drawImage(errorLength, 0, 0, this);
                }
            }
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
     * This method gets input for leaderboard name
     */
    public void getInput(){
        while (true)
        {
            try
            {
                saveName = JOptionPane.showInputDialog (null, "To gain a spot on the leaderboard, enter your name. \n No Spaces! \n Do not exceed 15 characters!", "Save Score", JOptionPane.DEFAULT_OPTION);
                if (saveName.length () > 16){
                    throw new IllegalArgumentException ("Your name can be at most 15 characters long!");
                }
                if (saveName.length () == 0){
                    throw new IllegalArgumentException ("Your name must be at least 1 character long!");
                }
                if (saveName.contains(" ")){
                    throw new IllegalArgumentException ("No Spaces!");
                }
                break;
            }
            catch (IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        BufferedReader fileReader;
        PrintWriter outputData;
        String[] database;
        int amountLines = 0;
        try {
            fileReader = new BufferedReader(new FileReader("Database.txt"));
            String text = fileReader.readLine();
            amountLines = Integer.parseInt(text);
            database = new String[amountLines];
            for (int i = 0; i < amountLines; i++){
                database[i] = fileReader.readLine();
            }
            fileReader.close();
            outputData = new PrintWriter(new BufferedWriter(new FileWriter("Database.txt")));
            outputData.println((amountLines+1));
            for (int i = 0; i < amountLines; i++){
                outputData.println(database[i]);
            }
            outputData.println(saveName + " " + points);
            outputData.close();
        } catch (IOException e){}
        Main.navigationVariable = 1;
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
    }
    /**
     * @Override - Ensures program still repaints constantly and looks for mouse coordinates, 
     * even if dragged
     * @param - MouseEvent e - not useful here, but useful in mouseMoved method, e contains useful information about the mouse such as its x and y coordinates
     */
    public void mouseDragged(MouseEvent e){mouseMoved(e);}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {
        if (slide == 0){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 1;
            }
        } else if (slide == 1){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 2;
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 0;
            }
        } else if (slide == 2){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 3;
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 1;
            }
        } else if (slide == 3){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 4;
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 2;
            }
        }  else if (slide == 4){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 5;
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 3;
            }
        }  else if (slide == 5){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 6;
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 4;
            }
        }  else if (slide == 6){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 7;
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 5;
            }
        }  else if (slide == 7){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 8;
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 6;
            }
        } else if (slide == 8){
            if (mouseX >= 406 && mouseY >= 419 && mouseX <= 620 && mouseY <= 480){
                slide = 9;
                currentEmail = (int)(Math.random()*33);
            } else if (mouseX >= 41 && mouseY >= 419 && mouseX <= 261 && mouseY <= 480){
                slide = 7;
            }
        } else if (slide == 9){
            if (mouseX >= 10 && mouseY >= 413 && mouseX <= 191 && mouseY <= 485 && safeNotSafe[currentEmail] == true){
                slide = 10;
                points++;
            } else if (mouseX >= 10 && mouseY >= 413 && mouseX <= 191 && mouseY <= 485 && safeNotSafe[currentEmail] == false){
                slide = 11;
            }
            if (mouseX >= 431 && mouseY >= 413 && mouseX <= 608 && mouseY <= 479 && safeNotSafe[currentEmail] == false){
                slide = 10;
                points++;
            } else if (mouseX >= 431 && mouseY >= 413 && mouseX <= 608 && mouseY <= 479 && safeNotSafe[currentEmail] == true){
                slide = 11;
            }
        } else if (slide == 10){
            currentEmail = (int)(Math.random()*33);
            slide = 9;
        } else if (slide == 11){
            currentEmail = (int)(Math.random()*33);
            slide = 9;
        } else if (slide == 12){
            slide = 13;
        } else if (slide == 13){
            getInput();
            timer.stop();
            if (saveName.length()>0&&!errorLengthHelper&&!errorSpaceHelper){
                Main.navigationVariable = 1;
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}