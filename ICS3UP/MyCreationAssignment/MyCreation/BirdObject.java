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
// This is the BirdObject.java file. It contains the BirdObject class
// which creates an animation of birds flying. It is only one drawing,
// but with overloaded methods, it makes there be 3 with unique properties
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class BirdObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c; // This is for console
    private Color birdBody; // This is for the "main" colour of the bird
    private int delay; // This is a special delay for a bird
    private int yDifference; // This changes the positioning of 2 birds that are offsetted
    // Colours required
    Color birdBeak = new Color (225, 165, 59);
    Color birdHead = new Color (225, 74, 38);
    Color birdWings = new Color (140, 71, 54);
    Color background = new Color (10, 104, 200);
    // Variable 
    int flyHigh; // Variable that makes the birds move higher ever iteration of loop

    public void birdObject ()
    {
	for (int x = 30 ; x < 500 ; x += 3) // ANIMATION
	{
	    int wingMovement = 5; // This creates the wing flapping animation
	    if (x % 10 >= 5) // By changing the value from "going up" to "going down" periodically using math
	    {
		wingMovement *= -1;
	    }
	    flyHigh += 1; // This makes the bird go higher
	    c.setColor (birdWings); // BIRD FURTHER WING SECTION
	    int xz[] = {517 - x - 50, 531 - x - 50, 504 - x - 50, 523 - x - 50};
	    int yz[] = {21 + yDifference - flyHigh + 50, 23 + yDifference - flyHigh + 50, 5 + yDifference + (wingMovement * -1) - flyHigh + 50, 13 + yDifference + (wingMovement * -1) - flyHigh + 50};
	    c.fillPolygon (xz, yz, 4);
	    c.setColor (birdBody); // BIRD BODY SECTION
	    int xa[] = {515 - x - 50, 525 - x - 50, 548 - x - 50, 536 - x - 50, 523 - x - 50};
	    int ya[] = {22 + yDifference - flyHigh + 50, 32 + yDifference - flyHigh + 50, 31 + yDifference - flyHigh + 50, 18 + yDifference - flyHigh + 50, 17 + yDifference - flyHigh + 50};
	    c.fillPolygon (xa, ya, 5);
	    c.setColor (birdBeak); // BIRD BEAK SECTION
	    int xb[] = {505 - x - 50, 515 - x - 50, 518 - x - 50};
	    int yb[] = {24 + yDifference - flyHigh + 50, 19 + yDifference - flyHigh + 50, 22 + yDifference - flyHigh + 50};
	    c.fillPolygon (xb, yb, 3);
	    c.setColor (birdHead); // BIRD HEAD SECTION
	    c.fillOval (509 - x - 50, 14 + yDifference - flyHigh + 50, 15, 13);
	    c.setColor (birdWings); // BIRD CLOSER WING SECTION
	    int xc[] = {522 - x - 50, 538 - x - 50, 561 - x - 50, 541 - x - 50};
	    int yc[] = {21 + yDifference - flyHigh + 50, 27 + yDifference - flyHigh + 50, 13 + yDifference + (wingMovement * -1) - flyHigh + 50, 13 + yDifference + (wingMovement * -1) - flyHigh + 50};
	    c.fillPolygon (xc, yc, 4);
	    // Used to delay animation
	    try
	    {
		sleep (45 + delay);
	    }
	    catch (Exception e)
	    {
	    }
	    // Draws back the background (only the part that is distrubed by previous loop's drawings)
	    c.setColor (background); 
	    c.fillRect (504 - x - 50, 5 + yDifference + (wingMovement * -1) - flyHigh + 50, 57, 27);
	}
    }
    public BirdObject (Console con)  // Bird Regular
    {
	c = con;
	birdBody = new Color (149, 149, 149); // Makes the bird body a default colour
    }
    public BirdObject (Console con, int y, Color n)  // Bird + Location Change + Colour Parameter
    {
	c = con;
	birdBody = n; // Makes the bird body the colour defined in MyCreation
	yDifference = y; // Offsets the bird's y axis 
    }
    public BirdObject (Console con, int y, Color n, int t)  // Bird + Location Change + Colour Parameter + Time Parameter
    {
	c = con;
	birdBody = n; // Makes the bird body the colour defined in MyCreation
	yDifference = y; // Offsets the bird's y axis 
	delay = t; // Makes the try catch delay different for uniqueness
    }
    public void run () // Runs the drawing (This is used since this has overloaded methods)
    {
	birdObject ();
    }
}
