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
// This is the BeginningScreen.java file. It contains the BeginningScreen class
// which creates an animation and confirmation to continue the program
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class BeginningScreen
{
    // Variables Required
    // Parameter Variables
    private Console c; // Console Variable
    // Class Variables
    String titleOne = new String ("Magical Creatures"); // Title Variable Used For Animation
    String titleTwo = new String ("Story"); // Title Variable Used For Animation
    Color backgroundColor = new Color (0, 0, 0); // Background Colour (Changes through a loop to have a gradient effect)
    Color textColour = new Color (255, 255, 255); // Text Colour (WHITE)

    public void draw () // All the drawings go inside this method
    {
	for (int x = 0 ; x < 640 ; x++) // Background
	{
	    Color backgroundColor = new Color (0, 0, 0 + (x / 10)); // Colour of the background changes slightly as loop runs
	    c.setColor (backgroundColor); // Sets current background colour
	    c.drawRect (0, 0, x, 500); // Draws a line multiple times, slightly shifted to the right to create a filled rectangle
	}
	c.setColor (textColour); // Sets colour to text colour
	c.setFont (new Font ("Arial", 1, 60)); // Sets font for title
	for (int x = 0 ; x <= titleOne.length () ; x++) // TITLE TEXT ONE
	{
	    c.drawString (titleOne.substring (0, x), 55, 185); // As loop goes through, another character in string is drawn
	    try // Timing for animated effect
	    {
		Thread.sleep (150);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int x = 0 ; x <= titleTwo.length () ; x++) // TITLE TEXT TWO
	{
	    c.drawString (titleTwo.substring (0, x), 245, 250); // As loop goes through, another character in string is drawn
	    try // Timing for animated effect
	    {
		Thread.sleep (150);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setFont (new Font ("Arial", 1, 14)); // Sets to another font
	c.drawString ("Press any character to start animation", 190, 300); // Draws the string that is used to prompt user to continue program
	c.drawString ("BY SEHAN MUNIR", 514, 485); // Author
	c.getChar (); // Program can only continue past this when user presses character
    }
    public BeginningScreen (Console con) // "main" method which gets contructed in MyCreation class
    {
	c = con;
	draw (); // draws important object
    }
}
