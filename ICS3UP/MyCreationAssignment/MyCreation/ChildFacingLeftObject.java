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
// This is the ChildFacingLeftObject.java file. It contains the ChildFacingLeftObject class
// which creates an animation of the child looking in the left direction and moving
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class ChildFacingLeftObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c; // Parameter for Console
    private int movementDifference; // Parameter that changes how long the character moves for
    private int xAxisDifference; // Positioning of the object
    private int yAxisDifference; // Positioning of the object
    // Colours
    Color childHat = new Color (0, 210, 255); 
    Color childRed = new Color (255, 0, 0);
    Color childDarkRed = new Color (197, 0, 0);
    Color childArmsAndLegs = new Color (99, 0, 255);
    Color childHead = new Color (255, 255, 255);
    Color childEyes = new Color (0, 0, 0);
    Color background; // This colour changes based on what colour is required to make it seem like animation

    public void draw () // Character Drawing
    {
	int legsMovement = 5; // This variable is used to make the illusion of the character's leg moving
	for (int x = -50; x < 610 - movementDifference ; x += 3) // Loop that a variable change, which makes character move
	{
	    if (x % 5 == 0) // This makes the illusion of the character's leg moving
	    {
		legsMovement *= -1;
	    }
	    try // Timing so viewer can see frame by frame
	    {
		Thread.sleep (45); // Delay amount
	    }
	    catch (Exception e)
	    {
	    }
	    // Important portion of background is redrawn
	    c.setColor (background); // Colour
	    c.fillRect (-45 - x - xAxisDifference, 361 + yAxisDifference, 54, 103); // Rectangle covering portion
	    // Character
	    c.setColor (childHead); // The head
	    c.fillOval (-30 - x - xAxisDifference, 377 + yAxisDifference, 35, 35);
	    c.setColor (childHat); // The hat
	    int xa[] = {0 - x - xAxisDifference, -12 - x - xAxisDifference, -21 - x - xAxisDifference, -36 - x - xAxisDifference, -42 - x - xAxisDifference, -5 - x - xAxisDifference};
	    int ya[] = {367 + yAxisDifference, 362 + yAxisDifference, 367 + yAxisDifference, 368 + yAxisDifference, 375 + yAxisDifference, 381 + yAxisDifference};
	    c.fillPolygon (xa, ya, 6);
	    c.setColor (childEyes); // The eyes
	    c.drawLine (-15 - x - xAxisDifference, 381 + yAxisDifference, -17 - x - xAxisDifference, 387 + yAxisDifference);
	    c.drawLine (-22 - x - xAxisDifference, 379 + yAxisDifference, -24 - x - xAxisDifference, 385 + yAxisDifference);
	    c.setColor (childRed); // The shirt
	    c.fillRect (-14 - x - xAxisDifference, 408 + yAxisDifference, 13, 32);
	    c.setColor (childDarkRed);
	    c.fillRect (-12 - x - xAxisDifference, 408 + yAxisDifference, 5, 32);
	    c.setColor (childArmsAndLegs); // The arms and legs
	    c.fillRect (-7 - x - xAxisDifference, 408 + yAxisDifference, 7, 21);
	    c.fillRect (-22 - x - xAxisDifference, 408 + yAxisDifference, 7, 21);
	    c.fillRect (-17 - x - xAxisDifference + legsMovement, 439 + yAxisDifference, 6, 24);  // The leg has the legsMovement variable so illusion works
	    c.fillRect (-7 - x - xAxisDifference + (legsMovement * -1), 440 + yAxisDifference, 6, 24); // The leg has the legsMovement variable so illusion works
	} // End of character animation
	try // Final Timing
	{
	    Thread.sleep (70); // Delay amount
	}
	catch (Exception e)
	{
	}
    }
    public ChildFacingLeftObject (Console con, int spacing, int backgroundColourChange, int a, int b) // Gets contructed with proper parameters in MyCreation class
    { // Contains parameter for console, amount of for loop iterations (changes how much a character moves), changes background redrawing colour to match the one being used in scene, specific X axis change, specific Y axis change
	// Transfers MyCreation's parameters to variables in this class
	c = con; // Console
	movementDifference = spacing; // Amount of iterations of the loop
	xAxisDifference = a; // X axis change
	yAxisDifference = b; // Y axis change
	// Background Colours
	if (backgroundColourChange == 1) // If in cave background, 
	{
	    background = new Color (30, 30, 30); // Cave background colour
	}
	else if (backgroundColourChange == 2) // If in sand background, 
	{
	    background = new Color (149, 149, 77); // Cave background colour
	}
	else // If in backgrounds with a dirt path,
	{
	    background = new Color (123, 78, 19); // Dirt Path background colour
	}
	draw(); // Draws the object accounting for the specific parameters required
    }
}
