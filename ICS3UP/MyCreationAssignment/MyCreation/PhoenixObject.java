// FINAL WORK //
// Author: Sehan Munir
// Date: November 10th
// Course: ICS3U
// Teacher: Mrs. Krasteva
/////////////////////////////
// Program:
// This program will create an animation of a boy healing the environment.
// He encounters mythical creatures who help him.
/////////////////////////////
// This is the PhoenixObject.java file. It contains the PhoenixObject class
// which creates an animation of the phoenix moving 
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class PhoenixObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c; // Console variable
    // Colours required
    Color background = new Color (123, 78, 19); // Background colour to redraw background
    Color phoenixHead = new Color (205, 0, 0);
    Color phoenixBeakAndClaws = new Color (205, 134, 0);
    Color phoenixWings = new Color (118, 5, 5);
    Color phoenixBody = new Color (232, 100, 0);

    public void draw () // Draws the object
    {
	int wingPointOne = 130; // This controls a point of the wing flapping up and down
	int wingPointTwo = 35; // This controls a point of the wing flapping up and down
	int wingPointThree = 166; // This controls a point of the wing flapping up and down
	int wingPointFour = 31; // This controls a point of the wing flapping up and down
	for (int x = -75 ; x < 40 ; x++) // MOVEMENT + DRAWING
	{
	    if (x % 5 == 0) // If timed in a specific way
	    {
		wingPointOne = (wingPointOne-130)*-1; // Either change value to 0 or the original
		wingPointTwo = (wingPointTwo-35)*-1; // Either change value to 0 or the original
		wingPointThree = (wingPointThree-166)*-1; // Either change value to 0 or the original
		wingPointFour = (wingPointFour-31)*-1; // Either change value to 0 or the original
	    }
	    try // Timing
	    {
		Thread.sleep (45);
	    }
	    catch (Exception e)
	    {
	    }
	    // Background
	    c.setColor (background);
	    c.fillRect (x, 351, 158, 95);// Refills background to hide past drawing
	    // Character (All of these coordinates are mathematically added with a for loop for the illusion of movement)(x makes the coords move across the screen)
	    // (wingPoints make the wing change coords periodically to give the illusion of wings flapping)
	    c.setColor (phoenixHead); // Phoenix Head
	    c.fillOval (65 + x, 353, 38, 38);
	    c.setColor (phoenixWings); // Phoenix Wings
	    int xa[] = {13 + x+wingPointOne, 60 + x, 70 + x, 53 + x+wingPointTwo};
	    int ya[] = {351, 386, 403, 437};
	    c.fillPolygon (xa, ya, 4);
	    c.setColor (phoenixBody); // Phoenix Body
	    c.fillRect (58 + x, 383, 21, 51);
	    c.setColor (phoenixWings); // Phoenix Wings
	    int xb[] = {0 + x+wingPointThree, 61 + x+wingPointFour, 76 + x, 71 + x};
	    int yb[] = {368, 386, 395, 433};
	    c.fillPolygon (xb, yb, 4);
	    c.setColor (phoenixBeakAndClaws); // Phoenix Beak and Claws
	    int xc[] = {96 + x, 88 + x, 117 + x};
	    int yc[] = {375, 388, 387};
	    c.fillPolygon (xc, yc, 3);
	    c.fillArc (65 + x, 432, 15, 15, 150, -180);
	    c.fillArc (70 + x, 432, 15, 15, 150, -180);
	}
    }
    public PhoenixObject (Console con) // constructed in MyCreation class
    {
	c = con;
	draw ();
    }
}
