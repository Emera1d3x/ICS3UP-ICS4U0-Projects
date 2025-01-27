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
// This is the SeasideBackground.java file. It contains the SeasideBackground class
// which creates the background
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class SeasideBackground
{
    // Variables Required
    private Console c; // Console variable
    // Colours required
    Color darkSkyOne = new Color (77,44,31);
    Color darkSkyTwo = new Color (63,33,18);
    Color darkSkyThree = new Color (47,31,28);
    Color sand = new Color (149,149,77);
    Color sandTexture = new Color (121,121,58);
    Color sandWet = new Color (139,139,67);
    Color water = new Color (61,80,157);
    Color log = new Color (60,37,0);
    Color grassDark = new Color (10,62,17);

    public void draw () // Draws the seaside backgorund
    {
	for (int x = 0 ; x < 10 ; x++) // SUNSET EFFECT
	{
	    c.setColor (darkSkyThree);
	    c.drawRect (0, 0, 640, x);
	}
	for (int x = 0 ; x < 20 ; x++) // SUNSET EFFECT
	{
	    c.setColor (darkSkyTwo);
	    c.drawRect (0, 10, 640, x);
	}
	for (int x = 0 ; x < 90 ; x++) // SUNSET EFFECT
	{
	    c.setColor (darkSkyOne);
	    c.drawRect (0, 30, 640, x);
	}
	for (int x = 0 ; x < 90 ; x++) // SUNSET EFFECT
	{
	    c.setColor (darkSkyOne);
	    c.drawRect (0, 30, 640, x);
	}
	for (int x = 0 ; x < 200 ; x++) // GRASS
	{
	    c.setColor (grassDark);
	    int xa[] = {0,79,249,466,640,640,0};
	    int ya[] = {77+x,62+x,80+x,58+x,50+x,500+x,500+x};
	    c.drawPolygon (xa,ya,7);
	}
	for (int x = 0 ; x < 320 ; x++) // REGULAR SAND
	{
	    c.setColor (sand);
	    int xa[] = {0,143,266,480,640,640,0};
	    int ya[] = {136+x,150+x,121+x,152+x,119+x,500+x,500+x};
	    c.drawPolygon (xa,ya,7);
	}
	for (int x = 0 ; x < 50 ; x++) // SAND TEXTURE
	{
	    c.setColor (sandTexture);
	    c.drawOval (34+x/2,171+x/2,15-x,15-x);
	    c.drawOval (132+x/2,354+x/2,15-x,15-x);
	    c.drawOval (254+x/2,144+x/2,15-x,15-x);
	    c.drawOval (366+x/2,373+x/2,15-x,15-x);
	    c.drawOval (375+x/2,156+x/2,15-x,15-x);
	    c.drawOval (556+x/2,188+x/2,15-x,15-x);
	}
	for (int x = 0 ; x < 54 ; x++) // WET SAND
	{
	    c.setColor (sandWet);
	    c.drawRect (0, 400, 640, x);;
	}
	for (int x = 0 ; x < 46 ; x++) // WATER
	{
	    c.setColor (water);
	    c.drawRect (0, 454, 640, x);;
	}
    }
    public SeasideBackground (Console con) // constructed in MyCreation class
    {
	c = con;
	draw ();
    }
}
