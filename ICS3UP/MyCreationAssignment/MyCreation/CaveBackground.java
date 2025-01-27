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
// This is the CaveBackground.java file. It contains the CaveBackground class
// which creates the background
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class CaveBackground
{
    // Variables Required
    private Console c; // Console Variable
    // Colour Variable Required
    Color caveLight = new Color (53, 53, 53);
    Color caveDark = new Color (30, 30, 30);
    Color variableBlack = new Color (0, 0, 0);
    Color caveRockMedium = new Color (42, 42, 42);
    Color caveRockDark = new Color (15, 15, 15);
    
    public void draw () // Draws background
    {
	for (int x = 0 ; x < 640 ; x++) // CAVE WALL
	{
	    c.setColor (caveDark);
	    c.drawRect (0, 0, x, 500);
	}
	for (int x = 0 ; x < 640 ; x++) // OUTER DARKNESS EFFECT
	{
	    c.setColor (variableBlack);
	    int xa[] = {0, 14, 24, 114, 303, 501, 608, 630, 640, 640, 0};
	    int ya[] = {500 - x, 500 - x, 185 - x, 39 - x, 11 - x, 26 - x, 121 - x, 500 - x, 500 - x, 0 - x, 0 - x};
	    c.drawPolygon (xa, ya, 11);
	}
	for (int x = 0 ; x < 100 ; x++)  // ROCK ONE
	{
	    c.setColor (caveRockDark);
	    int xa[] = {273, 284, 338, 370};
	    int ya[] = {455 + x, 437 + x, 413 + x, 435 + x};
	    c.drawPolygon (xa, ya, 4);
	}
	for (int x = 0 ; x < 100 ; x++)  // ROCK TWO
	{
	    c.setColor (caveLight);
	    int xa[] = {208,236,309,314};
	    int ya[] = {500 + x,456 + x,456 + x,465 + x};
	    c.drawPolygon (xa, ya, 4);
	}
	for (int x = 0 ; x < 100 ; x++)  // ROCK THREE
	{
	    c.setColor (caveRockMedium);
	    int xa[] = {308,322,404,452,455};
	    int ya[] = {500 + x,438 + x,436 + x,471 + x,500 + x};
	    c.drawPolygon (xa, ya, 5);
	}
    }
    public CaveBackground (Console con) // constructed in MyCreation class
    {
	c = con;
	draw ();
    }
}
