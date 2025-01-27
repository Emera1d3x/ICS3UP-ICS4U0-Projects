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
// This is the PegasusObject.java file. It contains the PegasusObject class
// which creates an animation a pegasus moving on 
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class PegasusObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c; // Console variable
    // Colours required
    Color background = new Color (149,149,77);
    Color pegasusNose = new Color (150,0,0);
    Color pegasusBody = new Color (53,7,7);
    Color pegasusBackLeg = new Color (38,3,3);
    Color pegasusEye = new Color (10,0,0);
    Color pegasusWing = new Color (78,51,51);

    public void draw () // Draws the pegasus
    {
	int wingPointOne = 100; // This controls a point of the wing flapping up and down
	int wingPointTwo = 100; // This controls a point of the wing flapping up and down
	int legsMovement = 15; // This is the amount the leg will move extra
	for (int x = -75 ; x < 41 ; x++) // MOVEMENT + DRAWING
	{
	    if (x % 8 == 0) // If timed in a specific way
	    {
		wingPointOne = (wingPointOne-100)*-1; // Either change value to 0 or 100
		wingPointTwo = (wingPointTwo-100)*-1; // Either change value to 0 or 100
	    }
	    if (x % 5 == 0) // This controls how the leg moves
	    {
		legsMovement *= -1;
	    }
	    try // Timing
	    {
		Thread.sleep (45);
	    }
	    catch (Exception e)
	    {
	    }
	    int y = 230;
	    // Background
	    c.setColor (background);
	    c.fillRect (8+x,8+y,185,123); // Refills background to hide past drawing
	    // Character // Variables are added to coordinates to move the drawing and some dynamic ones are used to move legs and wings
	    c.setColor (pegasusBackLeg); // Pegasus Back Legs Code
	    c.fillRect (96+x,84+y,12,43);
	    c.fillRect (63+x,84+y,12,43);
	    c.setColor (pegasusBody); // Pegasus Body Code
	    int xa[] = {145+x,170+x,156+x,190+x,186+x,144+x,107+x,80+x+legsMovement,63+x+legsMovement,84+x,66+x,47+x+legsMovement,24+x+legsMovement,76+x,140+x};
	    int ya[] = {24+y,23+y,44+y,46+y,67+y,62+y,88+y,131+y,129+y,88+y,88+y,129+y,127+y,46+y,40+y};
	    c.fillPolygon (xa, ya, 15);
	    c.setColor (pegasusEye); // Pegasus Eyes Code
	    c.fillArc(138+x,43+y,17,14,0,180);
	    c.setColor (pegasusNose); // Pegasus Nose Code
	    c.fillOval(185+x,44+y,10,12);
	    c.setColor (pegasusWing); // Pegasus Wing Code
	    int xb[] = {22+x,96+x,129+x,85+x};
	    int yb[] = {8+y+wingPointOne,15+y+wingPointOne,63+y,65+y};
	    c.fillPolygon (xb, yb, 4);
	}
    }
    public PegasusObject (Console con) // constructed in MyCreation class
    {
	c = con;
	draw ();
    }
}
