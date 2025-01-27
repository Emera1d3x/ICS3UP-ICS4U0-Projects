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
// This is the EndScreen.java file. It contains the EndScreen class
// which creates an animation and concluding message for the user
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class EndScreen implements Runnable // Implements Runnable
{
    // Variables Required
    private Console c; // Console Variable
    String end = new String ("THE END"); // End Variable Used For Animation
    Color backgroundColor = new Color (0, 0, 0); // Background Colour (Changes through a loop to have a gradient effect)
    Color textColour = new Color (255, 255, 255); // Text Colour (WHITE)

    public void draw ()  // All the drawings go inside this method
    {
	for (int x = 0 ; x < 640 ; x++) // Background
	{
	    Color backgroundColor = new Color (0, 0, 0 + (x / 10)); // Colour of the background changes slightly as loop runs
	    c.setColor (backgroundColor); // Sets current background colour
	    c.drawRect (0, 0, x, 500); // Draws a line multiple times, slightly shifted to the right to create a filled rectangle
	}
	c.setColor (textColour); // Sets colour to text colour
	c.setFont (new Font ("Arial", 1, 60)); // Sets font for title
	for (int x = 0 ; x <= end.length () ; x++) // END ANIMATION LOOP
	{
	    c.drawString (end.substring (0, x), 195, 263); // As loop goes through, another character in string is drawn
	    try // Timing for animated effecte
	    {
		Thread.sleep (150);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setFont (new Font ("Arial", 1, 14)); // Sets to another font
	c.drawString ("Thank you for watching", 474, 470); // Draws the string that displays a concluding message
	c.drawString ("BY SEHAN MUNIR", 514, 485); // Author
    }


    public EndScreen (Console con)  // "main" method which gets contructed in MyCreation class
    {
	c = con;
    }
    public void run () // run(); command
    {
	draw ();
    }
}
