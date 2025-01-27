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
// This is the TextBox.java file. It contains the TextBox class
// which creates the frame work for text boxes. The parameters get filled in MyCreation
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class TextBox extends Thread // Extends Thread
{
    // Variables Required
    private Console c; // Console variable
    int textBoxRightCornerX; // Text bot right corner x
    int textBoxRightCornerY; // Text bot right corner y
    int textBoxSizeX; // Text box width
    int textBoxSizeY; // Text box height
    String textBoxText; // Text box text
    // Colours required
    Color textBoxColour1 = new Color (223, 235, 164); // First box
    Color textBoxColour2 = new Color (244, 255, 186); // Second box (for effect)
    Color textColor = new Color (0, 0, 0); // Text colour
    Color background; // Background (dependant on what colour needs to be used to refill background)

    public void draw () // Draws the text box
    {
	c.setFont (new Font ("Arial", 1, 11)); // Sets font
	for (int x = 0 ; x < 1 ; x++) // TextBox
	{
	    c.setColor (textBoxColour1); // Outer Layer of Box
	    c.fillRect (textBoxRightCornerX, textBoxRightCornerY, textBoxSizeX, textBoxSizeY);
	    c.setColor (textBoxColour2); // Outer Layer of Box
	    c.fillRect (textBoxRightCornerX + 7, textBoxRightCornerY + 7, textBoxSizeX - 14, textBoxSizeY - 14);
	    c.setColor (textColor); // String
	    c.drawString (textBoxText, textBoxRightCornerX + 13, textBoxRightCornerY + 20);
	    try // Timing, so the reader has enough time to read
	    {
		Thread.sleep (2300);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColor (background); // Refills background portion required
	c.fillRect (textBoxRightCornerX, textBoxRightCornerY, textBoxSizeX, textBoxSizeY);
    }
    public TextBox (Console con, int x, int y, int xa, int ya, String text, int backgroundColourChange) // contructed and assigned parameter values in MyCreation
    {
	c = con; // Console
	textBoxRightCornerX = x; // Text box right corner x
	textBoxRightCornerY = y; // Text box right corner y
	textBoxSizeX = xa; // X Size
	textBoxSizeY = ya; // Y Size
	textBoxText = text; // Text
	if (backgroundColourChange == 1) // CAVE COLOUR BACKGROUND
	{
	    background = new Color (30, 30, 30);
	}
	else if (backgroundColourChange == 2) // WATER COLOUR BACKGROUND
	{
	    background = new Color (61, 80, 157);
	}
	else // DIRT PATH BACKGROUND
	{
	    background = new Color (123, 78, 19);
	}
	draw (); // Draw text box when parameters are filled
    }
}
