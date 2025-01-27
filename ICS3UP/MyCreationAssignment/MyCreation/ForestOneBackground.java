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
// This is the ForestOneBackground.java file. It contains the ForestOneBackground class
// which creates the background
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class ForestOneBackground
{
    // Variables Required
    private Console c; // Console variable
    // Colour Varables
    Color rock = new Color (176, 176, 176);
    Color dirtPath = new Color (123, 78, 19);
    Color treeStemOne = new Color (84, 53, 7);
    Color treeStemTwo = new Color (44, 30, 5);
    Color log = new Color (60, 37, 0);
    Color grassLight = new Color (19, 123, 35);
    Color grassDark = new Color (10, 62, 17);
    Color sky = new Color (10, 104, 200);
    Color sunLight = new Color (218, 217, 3);
    Color sunDark = new Color (218, 172, 3);
    Color treeLeaves = new Color (0, 255, 85);
    Color textColour = new Color (255, 255, 255);

    public void draw () // Draws background
    {
	for (int x = 0 ; x < 640 ; x++) // SKY
	{
	    c.setColor (sky);
	    c.drawRect (0, 0, x, 500);
	}
	for (int x = 0 ; x < 275 ; x++) // DARK GRASS
	{
	    c.setColor (grassDark);
	    int xa[] = {0, 190, 277, 351, 425, 550, 628, 640, 640, 0};
	    int ya[] = {255 + x, 255 + x, 276 + x, 251 + x, 280 + x, 280 + x, 268 + x, 250 + x, 500, 500};
	    c.drawPolygon (xa, ya, 10);
	}
	for (int x = 0 ; x < 208 ; x++) // LIGHT GRASS
	{
	    c.setColor (grassLight);
	    int xa[] = {0, 85, 277, 343, 427, 584, 640, 640, 0};
	    int ya[] = {292 + x, 310 + x, 300 + x, 308 + x, 295 + x, 297 + x, 303 + x, 500, 500};
	    c.drawPolygon (xa, ya, 9);
	}
	for (int x = 0 ; x < 190 ; x++) // DIRT PATH
	{
	    c.setColor (dirtPath);
	    int xa[] = {0, 114, 216, 329, 416, 522, 586, 640, 640, 0};
	    int ya[] = {325 + x, 347 + x, 315 + x, 348 + x, 310 + x, 356 + x, 310 + x, 325 + x, 500, 500};
	    c.drawPolygon (xa, ya, 10);
	}
	for (int x = 0 ; x < 145 ; x++) // SUN DARK
	{
	    c.setColor (sunDark);
	    c.drawOval (425 + x / 2, 0 + x / 2, 145 - x, 145 - x);
	}
	for (int x = 0 ; x < 121 ; x++) // SUN LIGHT
	{
	    c.setColor (sunLight);
	    c.drawOval (437 + x / 2, 11 + x / 2, 121 - x, 121 - x);
	}
	for (int x = 0 ; x < 14 ; x++) // LIGHT TREE 1
	{
	    c.setColor (treeStemOne);
	    c.drawRect (68, 123, x, 187);
	}
	for (int x = 0 ; x < 19 ; x++) // LIGHT TREE 2
	{
	    c.setColor (treeStemOne);
	    c.drawRect (277, 85, x, 247);
	}
	for (int x = 0 ; x < 23 ; x++) // LIGHT TREE 3
	{
	    c.setColor (treeStemOne);
	    c.drawRect (528, 208, x, 143);
	}
	for (int x = 0 ; x < 17 ; x++) // DARK TREE 1
	{
	    c.setColor (treeStemTwo);
	    c.drawRect (165, 219, x, 93);
	}
	for (int x = 0 ; x < 32 ; x++) // DARK TREE 2
	{
	    c.setColor (treeStemTwo);
	    c.drawRect (373, 207, x, 102);
	}
	for (int x = 0 ; x < 100 ; x++) // TREE LEAVES 1
	{
	    c.setColor (treeLeaves);
	    int xa[] = {64, 92, 138, 137, 27, 24};
	    int ya[] = {85, 82, 177, 235, 228, 165};
	    c.drawPolygon (xa, ya, 6);
	    c.drawLine (27, (int) (228 - x / 1.6), 137, (int) (235 - x / 1.6));
	    c.drawLine (64, 85 + x, 92, 82 + x);
	    c.drawLine (24, (int) (165 + x / 1.6), 64, (int) (85 + x / 1.6));
	    c.drawLine (92, (int) (82 + x / 1.6), 138, (int) (177 + x / 1.6));
	    c.drawLine (45, (int) (130 + x / 1.6), 109, (int) (133 + x / 1.6));
	}
	for (int x = 0 ; x < 65 ; x++) // TREE LEAVES 2
	{
	    c.setColor (treeLeaves);
	    int xa[] = {236 + x, 239 + x, 386 - x, 386 - x, 365, 298};
	    int ya[] = {130, 162, 163, 124, 99 + x, 98 + x};
	    c.drawPolygon (xa, ya, 6);
	}
	for (int x = 0 ; x < 31 ; x++) // TREE LEAVES 3
	{
	    c.setColor (treeLeaves);
	    int xa[] = {513 + x, 514 + x, 570 - x, 573 - x, 537};
	    int ya[] = {198, 242, 241, 201, 185 + x};
	    c.drawPolygon (xa, ya, 5);
	}
	for (int x = 0 ; x < 132 ; x++) // LOG 1
	{
	    c.setColor (log);
	    c.drawRect (103, 314, x, 30);
	}
	for (int x = 0 ; x < 182 ; x++) // LOG 2
	{
	    c.setColor (log);
	    c.drawRect (318, 315, x, 25);
	}
	for (int x = 0 ; x < 35 ; x++) // ROCK 1
	{
	    c.setColor (rock);
	    c.drawOval (296 + x / 2, 354 + x / 2, 35 - x, 9 - x);
	}
	for (int x = 0 ; x < 53 ; x++) // ROCK 2
	{
	    c.setColor (rock);
	    c.drawOval (14 + x / 2, 460 + x / 2, 53 - x, 20 - x);
	}
	for (int x = 0 ; x < 57 ; x++) // ROCK 3
	{
	    c.setColor (rock);
	    c.drawOval (185 + x / 2, 478 + x / 2, 57 - x, 13 - x);
	}
	for (int x = 0 ; x < 49 ; x++) // ROCK 3
	{
	    c.setColor (rock);
	    c.drawOval (476 + x / 2, 472 + x / 2, 49 - x, 14 - x);
	}
	c.setColor (textColour); // my name in corner
	c.setFont (new Font("Arial", 1, 14));
	c.drawString ("SEHAN MUNIR", 534, 485);
    }
    public ForestOneBackground (Console con) // constructed in MyCreation class
    {
	c = con;
	draw ();
    }
}
