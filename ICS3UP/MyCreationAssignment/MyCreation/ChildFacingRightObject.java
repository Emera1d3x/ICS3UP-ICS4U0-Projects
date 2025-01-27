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
// This is the ChildFacingRightObject.java file. It contains the ChildFacingRightObject class
// which creates an animation of the child looking in the right direction and moving
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class ChildFacingRightObject extends Thread // Extends Thread
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
	for (int x = -50 ; x < 610 - movementDifference ; x += 3) // Loop that a variable change, which makes character move
	{
	    int y = 360;
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
	    c.fillRect (-3 + x + xAxisDifference,3 + y + yAxisDifference,44,102); // Rectangle covering portion
	    // Character
	    c.setColor (childHead); // The head
	    c.fillOval (4 + x + xAxisDifference, 17 + y + yAxisDifference, 35, 35);
	    c.setColor (childHat); // The hat
	    int xa[] = {0 + x + xAxisDifference, 12 + x + xAxisDifference, 21 + x + xAxisDifference, 36 + x + xAxisDifference, 42 + x + xAxisDifference, 5 + x + xAxisDifference};
	    int ya[] = {7 + y + yAxisDifference, 2 + y + yAxisDifference, 7 + y + yAxisDifference, 8 + y + yAxisDifference, 15 + y + yAxisDifference, 21 + y + yAxisDifference};
	    c.fillPolygon (xa, ya, 6);
	    c.setColor (childEyes); // The eyes
	    c.drawLine (20 + x + xAxisDifference, 21 + y + yAxisDifference, 22 + x + xAxisDifference, 27 + y + yAxisDifference);
	    c.drawLine (27 + x + xAxisDifference, 19 + y + yAxisDifference, 29 + x + xAxisDifference, 25 + y + yAxisDifference);
	    c.setColor (childRed); // The shirt
	    c.fillRect (14 + x + xAxisDifference, 48 + y + yAxisDifference, 13, 32);
	    c.setColor (childDarkRed);
	    c.fillRect (12 + x + xAxisDifference, 48 + y + yAxisDifference, 5, 32);
	    c.setColor (childArmsAndLegs); // The arms and legs
	    c.fillRect (13 + x + xAxisDifference, 47 + y + yAxisDifference, 7, 21);
	    c.fillRect (28 + x + xAxisDifference, 47 + y + yAxisDifference, 7, 21);
	    c.fillRect (12 + x + xAxisDifference + (legsMovement * -1) + 3, 79 + y + yAxisDifference, 6, 24);  // The leg has the legsMovement variable so illusion works
	    c.fillRect (23 + x + xAxisDifference + legsMovement - 3, 80 + y + yAxisDifference, 6, 24);  // The leg has the legsMovement variable so illusion works
	} // End of character animation
	try // Final Timing
	{
	    Thread.sleep (1159); // Delay amount
	}
	catch (Exception e)
	{
	}
    }


    public ChildFacingRightObject (Console con, int spacing, int backgroundColourChange, int a, int b) // Gets contructed with proper parameters in MyCreation class
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
	draw (); // Draws the object accounting for the specific parameters required
    }
}
