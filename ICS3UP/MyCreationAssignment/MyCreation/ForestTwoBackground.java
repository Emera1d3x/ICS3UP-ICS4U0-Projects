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
// This is the ForestTwoBackground.java file. It contains the ForestTwoBackground class
// which creates the background
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class ForestTwoBackground
{
    // Variables Required
    private Console c; // Console variable
    // Colours required
    Color sky = new Color (10, 104, 200);
    Color skyLighter = new Color (31, 123, 216);
    Color grassDark = new Color (10, 62, 17);
    Color grassLight = new Color (19, 123, 35);
    Color dirtPath = new Color (123, 78, 19);
    Color sunLight = new Color (218, 217, 3);
    Color sunDark = new Color (218, 172, 3);
    Color flowerStem = new Color (0, 255, 85);
    Color flowerPinkPetals = new Color (224, 30, 183);
    Color flowerBluePetals = new Color (214, 251, 255);
    Color flowerYellowPetals = new Color (227, 255, 35);
    Color log = new Color (60, 37, 0);
    Color treeStemOne = new Color (84, 53, 7);
    Color caveLighter = new Color (70, 70, 70);
    Color caveLight = new Color (53, 53, 53);
    Color caveDark = new Color (30, 30, 30);
    Color textColour = new Color (255, 255, 255);

    public void draw ()
    {
	for (int x = 0 ; x < 640 ; x++) // SKY
	{
	    c.setColor (sky);
	    c.drawRect (0, 0, x, 500);
	}
	for (int x = 0 ; x < 350 ; x++) // DARK GRASS
	{
	    c.setColor (grassDark);
	    int xa[] = {0, 121, 264, 432, 640, 640, 0};
	    int ya[] = {252 + x, 258 + x, 201 + x, 253 + x, 253 + x, 500, 500};
	    c.drawPolygon (xa, ya, 7);
	}
	for (int x = 0 ; x < 350 ; x++) // LIGHT GRASS
	{
	    c.setColor (grassLight);
	    int xa[] = {0, 124, 226, 349, 640, 640, 0};
	    int ya[] = {298 + x, 311 + x, 272 + x, 287 + x, 287 + x, 500, 500};
	    c.drawPolygon (xa, ya, 7);
	}
	for (int x = 0 ; x < 350 ; x++) // DIRT PATH
	{
	    c.setColor (dirtPath);
	    int xa[] = {0, 127, 226, 343, 640, 640, 0};
	    int ya[] = {351 + x, 335 + x, 310 + x, 341 + x, 341 + x, 500, 500};
	    c.drawPolygon (xa, ya, 7);
	}
	for (int x = 0 ; x < 150 ; x++) // SUN DARK
	{
	    c.setColor (sunDark);
	    c.drawOval (35 + x / 2, 11 + x / 2, 150 - x, 150 - x);
	}
	for (int x = 0 ; x < 125 ; x++) // SUN LIGHT
	{
	    c.setColor (sunLight);
	    c.drawOval (48 + x / 2, 21 + x / 2, 125 - x, 125 - x);
	}
	for (int x = 0 ; x < 5 ; x++) // FLOWER 1 STEM
	{
	    c.setColor (flowerStem);
	    c.drawRect (64, 309, x, 14);
	}
	for (int x = 0 ; x < 6 ; x++) // FLOWER 2 STEM
	{
	    c.setColor (flowerStem);
	    c.drawRect (153, 305, x, 17);
	}
	for (int x = 0 ; x < 14 ; x++) // PINK PETALS
	{
	    c.setColor (flowerPinkPetals);
	    c.drawOval (60 + x / 2, 283 + x / 2, 14 - x, 28 - x);
	    c.drawOval (53 + x / 2, 290 + x / 2, 28 - x, 14 - x);
	}
	for (int x = 0 ; x < 9 ; x++) // WHITE & BLUE PETALS
	{
	    c.setColor (flowerBluePetals);
	    c.drawOval (62 + x / 2, 292 + x / 2, 9 - x, 9 - x);
	    c.drawOval (150 + x / 2, 287 + x / 2, 9 - x, 23 - x);
	    c.setColor (flowerYellowPetals);
	    c.drawOval (140 + x / 2, 293 + x / 2, 26 - x, 9 - x);
	}
	for (int x = 0 ; x < 30 ; x++) // SKY LINES
	{
	    c.setColor (skyLighter);
	    c.drawLine (450 + x, 0, 545 + x, 156);
	    c.drawLine (550 + x, 0, 591 + x, 120);
	}
	for (int x = 0 ; x < 90 ; x++) // CHOPPED TREE
	{
	    c.setColor (treeStemOne);
	    c.drawRect (278, 172, x, 178);
	}
	for (int x = 0 ; x < 19 ; x++) // LOG
	{
	    c.setColor (log);
	    c.drawLine (264, 201 + x, 434, 318 + x);
	}
	for (int x = 0 ; x < 275 ; x++) // CAVE OUTER LAYER
	{
	    c.setColor (caveLighter);
	    int xa[] = {640, 533, 464, 411};
	    int ya[] = {90 + x, 155 + x, 246 + x, 500 + x};
	    c.drawPolygon (xa, ya, 4);
	}
	for (int x = 0 ; x < 275 ; x++) // CAVE MIDDLE LAYER
	{
	    c.setColor (caveLight);
	    int xa[] = {640, 556, 493, 500, 640};
	    int ya[] = {119 + x, 205 + x, 396 + x, 500 + x, 500 + x};
	    c.drawPolygon (xa, ya, 5);
	}
	for (int x = 0 ; x < 275 ; x++) // CAVE INNER LAYER
	{
	    c.setColor (caveDark);
	    int xa[] = {640, 555, 583, 640};
	    int ya[] = {223 + x, 303 + x, 500 + x, 500 + x};
	    c.drawPolygon (xa, ya, 4);
	}
	c.setColor (textColour); // my name in corner
	c.setFont (new Font ("Arial", 1, 14));
	c.drawString ("SEHAN MUNIR", 534, 485);
	try // Final Timing
	{
	    Thread.sleep (1159); // Delay amount
	}
	catch (Exception e)
	{
	}
    }
    public ForestTwoBackground (Console con) // constructed in MyCreation class
    {
	c = con;
	draw ();
    }
}
