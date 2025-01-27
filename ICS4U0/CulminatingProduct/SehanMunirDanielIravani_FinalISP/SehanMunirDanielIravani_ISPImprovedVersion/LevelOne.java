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
 * The LevelOne class represents the first level of the game application.
 * It displays various slides and handles user interactions during the level.
 *
 *
 * @Author: Daniel Iravani - Passwords 2hrs? , Sehan Munir - 3hrs
 * @Version: 1.0
 * Created on 6/02/2024
 */

// CLASS
public class LevelOne extends JPanel implements MouseMotionListener, MouseListener {
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
 * The custom color of the cursor.
 */
private Color cursorColour = new Color(0, 255, 201, 100);

/**
 * A timer that triggers an action every 1 millisecond.
 */
private Timer timer;

/**
 * A variable that increments every millisecond, used for animation and timing.
 */
private int timingVariable;

/**
 * The current slide being displayed.
 */
private int slide;

/**
 * The current image being displayed.
 */
private BufferedImage currentImage;

/**
 * The image displayed at the beginning of the level.
 */
private BufferedImage imageBeginning;

/**
 * The mission image.
 */
private BufferedImage mission;

/**
 * The mission image when hovered over.
 */
private BufferedImage missionHovered;

/**
 * The statistics image.
 */
private BufferedImage statistics;

/**
 * The statistics image when hovered over.
 */
private BufferedImage statisticsHovered;

/**
 * The stats image.
 */
private BufferedImage stats;

/**
 * The stats image when hovered over on the left.
 */
private BufferedImage statsLeft;

/**
 * The stats image when hovered over on the right.
 */
private BufferedImage statsRight;

/**
 * The slide 4 image.
 */
private BufferedImage slide4;

/**
 * The slide 4 image when hovered over on the left.
 */
private BufferedImage slide4Left;

/**
 * The slide 4 image when hovered over on the right.
 */
private BufferedImage slide4Right;

/**
 * The slide 5 image.
 */
private BufferedImage slide5;

/**
 * The slide 5 image when hovered over on the left.
 */
private BufferedImage slide5Left;

/**
 * The slide 5 image when hovered over on the right.
 */
private BufferedImage slide5Right;

/**
 * The slide 6 image.
 */
private BufferedImage slide6;

/**
 * The slide 6 image when hovered over on the left.
 */
private BufferedImage slide6Left;

/**
 * The slide 6 image when hovered over on the right.
 */
private BufferedImage slide6Right;

/**
 * The slide 7 image.
 */
private BufferedImage slide7;

/**
 * The slide 7 image when hovered over on the left.
 */
private BufferedImage slide7Left;

/**
 * The slide 7 image when hovered over on the right.
 */
private BufferedImage slide7Right;

/**
 * The slide 8 image.
 */
private BufferedImage slide8;

/**
 * The slide 8 image when hovered over on the top left.
 */
private BufferedImage slide81;

/**
 * The slide 8 image when hovered over on the top right.
 */
private BufferedImage slide82;

/**
 * The slide 8 image when hovered over on the bottom.
 */
private BufferedImage slide83;

/**
 * The slide 11 image.
 */
private BufferedImage slide11;

/**
 * The incorrect box image.
 */
private BufferedImage incorrect;

/**
 * The correct box image.
 */
private BufferedImage correct;

/**
 * An array of password images.
 */
private BufferedImage[] passwords;

/**
 * An array of strengths for each password.
 */
private int[] strenghts = {45,6,5,1,10,12,8,1,4,5,6,10,12,13,9,10,10,9,10,10,11,10,35,70,100,85,85,85,85,70,100,100,85,85,80,85,86,95,97,100,80};

/**
 * The number of practice questions left.
 */
private int practiceLeft;

/**
 * A 2D array of questions.
 */
private int[][] questions = new int[50][3];

    // Constructor
    public LevelOne() {
        timingVariable = 0;
        slide = 1;
        addMouseMotionListener(this);
        addMouseListener(this);

        //Load Images
        try {imageBeginning = ImageIO.read(new File("Images/LevelOneBeginning.png"));} catch (IOException e) {}
        try {mission = ImageIO.read(new File("Images/LevelOneMission.png"));} catch (IOException e) {}
        try {missionHovered = ImageIO.read(new File("Images/LevelOneMissionHovered.png"));} catch (IOException e) {}
        try {statistics = ImageIO.read(new File("Images/LevelOneStatistics.png"));} catch (IOException e) {}
        try {statisticsHovered = ImageIO.read(new File("Images/LevelOneStatisticsHover.png"));} catch (IOException e) {}
        try {stats = ImageIO.read(new File("Images/LevelOneStats.png"));} catch (IOException e) {}
        try {statsLeft = ImageIO.read(new File("Images/LevelOneStatsLeft.png"));} catch (IOException e) {}
        try {statsRight = ImageIO.read(new File("Images/LevelOneStatsRight.png"));} catch (IOException e) {}
        try {slide4 = ImageIO.read(new File("Images/LevelOneSlide4.png"));} catch (IOException e) {}
        try {slide4Left = ImageIO.read(new File("Images/LevelOneSlide4Left.png"));} catch (IOException e) {}
        try {slide4Right = ImageIO.read(new File("Images/LevelOneSlide4Right.png"));} catch (IOException e) {}
        try {slide5 = ImageIO.read(new File("Images/LevelOneSlide5.png"));} catch (IOException e) {}
        try {slide5Left = ImageIO.read(new File("Images/LevelOneSlide5Left.png"));} catch (IOException e) {}
        try {slide5Right = ImageIO.read(new File("Images/LevelOneSlide5Right.png"));} catch (IOException e) {}
        try {slide6 = ImageIO.read(new File("Images/LevelOneSlide6.png"));} catch (IOException e) {}
        try {slide6Left = ImageIO.read(new File("Images/LevelOneSlide6Left.png"));} catch (IOException e) {}
        try {slide6Right = ImageIO.read(new File("Images/LevelOneSlide6Right.png"));} catch (IOException e) {}
        try {slide7 = ImageIO.read(new File("Images/LevelOneSlide7.png"));} catch (IOException e) {}
        try {slide7Left = ImageIO.read(new File("Images/LevelOneSlide7Left.png"));} catch (IOException e) {}
        try {slide7Right = ImageIO.read(new File("Images/LevelOneSlide7Right.png"));} catch (IOException e) {}
        try {slide8 = ImageIO.read(new File("Images/LevelOneSlide8.png"));} catch (IOException e) {}
        try {slide81 = ImageIO.read(new File("Images/LevelOneSlide81.png"));} catch (IOException e) {}
        try {slide82 = ImageIO.read(new File("Images/LevelOneSlide82.png"));} catch (IOException e) {}
        try {slide83 = ImageIO.read(new File("Images/LevelOneSlide83.png"));} catch (IOException e) {}
        try {slide11 = ImageIO.read(new File("Images/LevelOneSlide11.png"));} catch (IOException e) {}
        try {incorrect = ImageIO.read(new File("Images/LevelOneIncorrectBox.png"));} catch (IOException e) {}
        try {correct = ImageIO.read(new File("Images/LevelOneCorrectBox.png"));} catch (IOException e) {}
        passwords = new BufferedImage[42];
        for (int i = 0; i < 42; i++){
            String imageName = "Images/pass"+(i+1)+".png";
            try {passwords[i] = ImageIO.read(new File(imageName));} catch (IOException e) { System.out.println("error");}
        }
        practiceLeft = 21;
        for (int i = 0; i < 22; i++){
            questions[i][0] = (int) (Math.random()*42);
            questions[i][1] = (int) (Math.random()*42);
            questions[i][2] = (int) (Math.random()*42);
        }
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timingVariable++;
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
        // 1
        if (timingVariable >= 0 && timingVariable <= 85){
            currentImage = imageBeginning;
            g.drawImage(currentImage, 0, 0, this);
            g.setColor(new Color(0,0,0, 255-(timingVariable*3)));
            g.fillRect(0, 0, 640, 500);
        }
        // 2
        g.setColor(Color.BLACK);
        if (timingVariable >= 85 && timingVariable <= 130){
            g.drawImage(currentImage, 0, 0, this);
        }
        if (timingVariable >= 130 && timingVariable <= 410){
            int num = timingVariable-130;
            g.drawImage(currentImage, 0, 0, this);
            for (int i = 0; i < num; i++){
                int transitionX = (int)(i/16)*40;
                int transitionY = (int)(i%13)*40;
                g.setColor(new Color(18, 82, 43+(i/7)));
                g.fillRect(transitionX, transitionY, 40, 40);
            }
        }
        // 3
        if (timingVariable >= 410){
            if (slide == 1){
                if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                    currentImage = missionHovered;
                } else {
                    currentImage = mission;
                }
                g.drawImage(currentImage, 0, 0, this);
            }
            if (slide == 2){
                if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                    currentImage = statisticsHovered;
                } else {
                    currentImage = statistics;
                }
                g.drawImage(currentImage, 0, 0, this);
            }
            if (slide == 3){
                if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                    currentImage = statsLeft;
                } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                    currentImage = statsRight;
                } else {
                    currentImage = stats;
                }
                g.drawImage(currentImage, 0, 0, this);
            }
            if (slide == 4){
                if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                    currentImage = slide4Left;
                } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                    currentImage = slide4Right;
                } else {
                    currentImage = slide4;
                }
                g.drawImage(currentImage, 0, 0, this);
            }
            if (slide == 5){
                if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                    currentImage = slide5Left;
                } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                    currentImage = slide5Right;
                } else {
                    currentImage = slide5;
                }
                g.drawImage(currentImage, 0, 0, this);
            }
            if (slide == 6){
                if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                    currentImage = slide6Left;
                } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                    currentImage = slide6Right;
                } else {
                    currentImage = slide6;
                }
                g.drawImage(currentImage, 0, 0, this);
            }
            if (slide == 7){
                if (mouseX >= 30 && mouseY >= 421 && mouseX <= 200 && mouseY <= 480){
                    currentImage = slide7Left;
                } else if (mouseX >= 447 && mouseY >= 420 && mouseX <= 600 && mouseY <= 480){
                    currentImage = slide7Right;
                } else {
                    currentImage = slide7;
                }
                g.drawImage(currentImage, 0, 0, this);
            }
            if (slide == 8){
                if (mouseX >= 37 && mouseY >= 200 && mouseX <= 261 && mouseY <= 281){
                    currentImage = slide81;
                } else if (mouseX >= 369 && mouseY >= 200 && mouseX <= 600 && mouseY <= 281){
                    currentImage = slide82;
                } else if (mouseX >= 207 && mouseY >= 300 && mouseX <= 431 && mouseY <= 390){
                    currentImage = slide83;
                } else {
                    currentImage = slide8;
                }
                g.drawImage(currentImage, 0, 0, this);
                g.drawImage(passwords[questions[practiceLeft][0]], 30, 196, 235, 92, this);
                g.drawImage(passwords[questions[practiceLeft][1]], 367, 194, 235, 92, this);
                g.drawImage(passwords[questions[practiceLeft][2]], 203, 296, 235, 92, this);

            }
            if (slide == 9){
                if (mouseX >= 37 && mouseY >= 200 && mouseX <= 261 && mouseY <= 281){
                    currentImage = slide81;
                } else if (mouseX >= 369 && mouseY >= 200 && mouseX <= 600 && mouseY <= 281){
                    currentImage = slide82;
                } else if (mouseX >= 207 && mouseY >= 300 && mouseX <= 431 && mouseY <= 390){
                    currentImage = slide83;
                } else {
                    currentImage = slide8;
                }
                g.drawImage(currentImage, 0, 0, this);
                g.drawImage(passwords[questions[practiceLeft][0]], 30, 196, 235, 92, this);
                g.drawImage(passwords[questions[practiceLeft][1]], 367, 194, 235, 92, this);
                g.drawImage(passwords[questions[practiceLeft][2]], 203, 296, 235, 92, this);
                g.drawImage(correct, 0, 0, this);
            }
            if (slide == 10){
                if (mouseX >= 37 && mouseY >= 200 && mouseX <= 261 && mouseY <= 281){
                    currentImage = slide81;
                } else if (mouseX >= 369 && mouseY >= 200 && mouseX <= 600 && mouseY <= 281){
                    currentImage = slide82;
                } else if (mouseX >= 207 && mouseY >= 300 && mouseX <= 431 && mouseY <= 390){
                    currentImage = slide83;
                } else {
                    currentImage = slide8;
                }
                g.drawImage(currentImage, 0, 0, this);
                g.drawImage(passwords[questions[practiceLeft][0]], 30, 196, 235, 92, this);
                g.drawImage(passwords[questions[practiceLeft][1]], 367, 194, 235, 92, this);
                g.drawImage(passwords[questions[practiceLeft][2]], 203, 296, 235, 92, this);
                g.drawImage(incorrect, 0, 0, this);
            }
            if (slide == 11){
                g.drawImage(slide11, 0, 0, this);
                g.setColor(new Color(0, 61, 35));
                g.fillRect(640-(timingVariable%640),475,25,25);
                g.fillRect(timingVariable%640,0,25,25);
                g.fillRect(0,475-(timingVariable%500),25,25);
                g.fillRect(615,0+(timingVariable%500),25,25);
                g.setColor(new Color(0, 61, 35, 100));
                g.fillRect(640-(timingVariable%640)-25,475,25,25);
                g.fillRect(timingVariable%640+25,0,25,25);
                g.fillRect(0,475-(timingVariable%500)-25,25,25);
                g.fillRect(615,0+(timingVariable%500)+25,25,25);
                g.fillRect(640-(timingVariable%640)+25,475,25,25);
                g.fillRect(timingVariable%640-25,0,25,25);
                g.fillRect(0,475-(timingVariable%500)+25,25,25);
                g.fillRect(615,0+(timingVariable%500)-25,25,25);
                g.setColor(new Color(0, 61, 35, 50));
                g.fillRect(640-(timingVariable%640)-50,475,25,25);
                g.fillRect(timingVariable%640+50,0,25,25);
                g.fillRect(0,475-(timingVariable%500)-50,25,25);
                g.fillRect(615,0+(timingVariable%500)+50,25,25);
                g.fillRect(640-(timingVariable%640)+50,475,25,25);
                g.fillRect(timingVariable%640-50,0,25,25);
                g.fillRect(0,475-(timingVariable%500)+50,25,25);
                g.fillRect(615,0+(timingVariable%500)-50,25,25);
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
        if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480 && slide == 1){
            slide = 2;
        } else if (slide == 2){
            if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                slide = 3;
            }
        } else if (slide == 3){
            if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                slide = 2;
            } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                slide = 4;
            }
        } else if (slide == 4){
            if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                slide = 3;
            } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                slide = 5;
            }
        } else if (slide == 5){
            if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                slide = 4;
            } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                slide = 6;
            }
        } else if (slide == 6){
            if (mouseX >= 30 && mouseY >= 420 && mouseX <= 249 && mouseY <= 480){
                slide = 5;
            } else if (mouseX >= 393 && mouseY >= 420 && mouseX <= 610 && mouseY <= 480){
                slide = 7;
            }
        } else if (slide == 7){
            if (mouseX >= 30 && mouseY >= 421 && mouseX <= 200 && mouseY <= 480){
                slide = 6;
            } else if (mouseX >= 447 && mouseY >= 420 && mouseX <= 600 && mouseY <= 480){
                slide = 8;
            }
        } else if (slide == 8){
            if (mouseX >= 35 && mouseY >= 197 && mouseX <= 260 && mouseY <= 280 && questions[practiceLeft][0] >= questions[practiceLeft][1] && questions[practiceLeft][0] >= questions[practiceLeft][2]){
                slide = 9;
            } else if (mouseX >= 35 && mouseY >= 197 && mouseX <= 260 && mouseY <= 280){
                slide = 10;
            } else if (mouseX >= 370 && mouseY >= 200 && mouseX <= 595 && mouseY <= 282 && questions[practiceLeft][1] >= questions[practiceLeft][0] && questions[practiceLeft][1] >= questions[practiceLeft][2]){
                slide = 9;
            } else if (mouseX >= 370 && mouseY >= 200 && mouseX <= 595 && mouseY <= 282){
                slide = 10;
            } else if (mouseX >= 206 && mouseY >= 300 && mouseX <= 433 && mouseY <= 387 && questions[practiceLeft][2] >= questions[practiceLeft][0] && questions[practiceLeft][2] >= questions[practiceLeft][1]){
                slide = 9;
            } else if (mouseX >= 206 && mouseY >= 300 && mouseX <= 433 && mouseY <= 387){
                slide = 10;
            }
        } else if (slide == 9){
            practiceLeft--;
            if (practiceLeft == -1){
                slide = 11;
            } else {
                slide = 8;
            }
        } else if (slide == 10){
            slide = 8;
        } else if (slide == 11){
            Main.navigationVariable = 1;
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
}