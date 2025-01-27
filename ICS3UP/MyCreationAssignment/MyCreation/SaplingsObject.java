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
// This class contains the saplings.
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class SaplingsObject extends Thread // Extends Thread
{
    // Private Variable that control values that come from MyCreation
    private Console c; // Console variable
    private Color background; // Which background is in effect variable
    private int xChooser; // Where is the sapling starting
    private int yChooser; // Where is the sapling starting
    private int xMovementChooser; // How much is it moving
    private int yMovementChooser; // How much is it moving
    private boolean treeGrowth; // Does the tree grow or not?
    // Variables Required
    // Colour variables
    Color saplingLeaf = new Color (182, 229, 107);
    Color saplingStem = new Color (131, 185, 37);
    Color potDark = new Color (62, 1, 1);
    Color pot = new Color (82, 1, 1);
    Color dirt = new Color (123, 78, 19);
    Color treeLog = new Color (84, 53, 7);
    Color treeLeaves = new Color (18, 201, 119);
    int direction; // Direction where the sapling will travel

    public void saplingsObject () // Draws sapling
    {
	for (int x = 0 ; x != xMovementChooser ; x += (1 * (direction))) // SAPLINGS MOVEMENT
	{
	    // Object
	    c.setColor (dirt);  // The dirt (its an actual element in the sapling)
	    c.fillOval (6 + xChooser + x, 44 + yChooser, 20, 6);
	    c.setColor (pot); // The pot
	    int xz[] = {7 + xChooser + x, 28 + xChooser + x, 22 + xChooser + x, 11 + xChooser + x};
	    int yz[] = {52 + yChooser, 52 + yChooser, 62 + yChooser, 62 + yChooser};
	    c.fillPolygon (xz, yz, 4);
	    c.setColor (saplingStem); // The stem
	    c.fillRect (12 + xChooser + x, 27 + yChooser, 8, 20);
	    c.setColor (potDark); // The pot
	    c.fillArc (4 + xChooser + x, 49 + yChooser, 23, 7, 0, 180);
	    c.setColor (saplingLeaf); // The leaves
	    int xa[] = {5 + xChooser + x, 10 + xChooser + x, 15 + xChooser + x, 21 + xChooser + x};
	    int ya[] = {1 + yChooser, 23 + yChooser, 31 + yChooser, 20 + yChooser};
	    c.fillPolygon (xa, ya, 4);
	    int xb[] = {20 + xChooser + x, 30 + xChooser + x, 48 + xChooser + x, 27 + xChooser + x};
	    int yb[] = {31 + yChooser, 31 + yChooser, 11 + yChooser, 19 + yChooser};
	    c.fillPolygon (xb, yb, 4);
	    // Used to delay animation
	    try
	    {
		sleep (25);
	    }
	    catch (Exception e)
	    {
	    }
	    //Background Refiller
	    c.setColor (background); // Background coloour (dependant)
	    c.fillRect (4 + xChooser + x, 1 + yChooser, 44, 61); // Refills background only where needed
	}
	if (treeGrowth == true) // If the tree is required to grow
	{
	    // Create a growing animation
	    for (int x = 0 ; x < 200 ; x++)
	    {
		c.setColor (treeLog); // Tree log
		c.fillRect (xChooser + xMovementChooser, yChooser - x, 25, x); // As loop moves through, makes a growing effect
		try // Delay for effect
		{
		    sleep (15);
		}
		catch (Exception e)
		{
		}
	    } 
	    for (int x = 0 ; x < 70 ; x++)
	    {
		c.setColor (treeLeaves); // Tree leaves (As the loop goes through, makes a "growing" effect for the trees
		int xc[] = {xChooser + xMovementChooser - (x / 3), xChooser + xMovementChooser - x, xChooser + xMovementChooser, xChooser + xMovementChooser + x, xChooser + xMovementChooser + (x / 3) };
		int yc[] = {yChooser - 200 + (x / 4), yChooser - 200 - (x / 4), yChooser - 200 - x , yChooser - 200 - (x / 4), yChooser - 200 + (x / 4) };
		c.fillPolygon (xc, yc, 5);
		try // Delay for animation effect
		{
		    sleep (15);
		}
		catch (Exception e)
		{
		}
	    }
	}
    }
    public SaplingsObject (Console con, int x, int y, int xMovement, int yMovement, boolean backgroundPicker, boolean directionChooser)  // Sapling informatins get filled in MyCreation
    {
	c = con; // Console variable
	xChooser = x; // Changes X axis
	yChooser = y; //  Changes Y Axis
	xMovementChooser = xMovement; // Changes X Axis movement
	yMovementChooser = yMovement; // Changes Y Axis movement
	if (backgroundPicker == false)               // Used to fill in using the correct background colour
	{ // If it requires sand
	    background = new Color (149, 149, 77); // Make background refiller sand colour
	    treeGrowth = backgroundPicker;

	}
	else
	{ // If it requires dirt
	    background = new Color (123, 78, 19); // Make background refiller dirt colour
	    treeGrowth = backgroundPicker;
	}
	if (directionChooser == true) // This chooses which direction the sapling will go
	{
	    direction = -1;
	}
	else
	{
	    direction = 1;
	}
    }
    public void run () // Gets called in MyCreation class, + all the parameters 
    {
	saplingsObject ();
    }
}
