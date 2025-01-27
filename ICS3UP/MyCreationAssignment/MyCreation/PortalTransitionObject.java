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
// This is the PortalTransitionObject.java file. It contains the PortalTransitionObject class
// which creates a transition of moving to a new scene
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class PortalTransitionObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c; // Console Variable
    Color backgroundColor; // Background Colour (Changes through a loop to have a gradient effect)

    public void draw ()  // All the drawings go inside this method
    {
	for (int x = 0 ; x < 640 ; x++) // Background
	{
	    Color backgroundColor = new Color (47 + (x / 10), 2, 38 + (x / 10)); // Colour of the background changes slightly as loop runs
	    c.setColor (backgroundColor); // Sets current background colour
	    c.drawRect (0, 0, x, 500); // Draws a line multiple times, slightly shifted to the right to create a filled rectangle
	    try // Delay
	    {
		Thread.sleep (3);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }
    public PortalTransitionObject (Console con) // constructed in MyCreation class
    {
	c = con;
	draw ();
    }
}
