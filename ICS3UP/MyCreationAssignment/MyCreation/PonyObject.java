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
// This is the PonyObject.java file. It contains the PonyObject class
// First time it is used, the parameters are set so an unhealthy looking pony walks
// on screen, and the second time is a healthy pony
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class PonyObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c;
    private boolean health;
    Color background = new Color (30, 30, 30); // Background colour to redraw background
    // Healthy Colours
    Color healthyFur = new Color (255, 121, 219);
    Color healthyBody = new Color (215, 180, 204);
    Color healthyNose = new Color (255, 121, 121);
    Color healthyHorn = new Color (180, 210, 215);
    Color vines; //  Vine colour changes to reveal itself for an effect
    Color flowerStem; //  Flower colours change to reveal itself for an effect
    Color flowerPinkPetals;
    Color flowerBluePetals;
    // Unhealthy Colours
    Color unhealthyFur = new Color (178, 82, 154);
    Color unhealthyBody = new Color (183, 152, 175);
    Color unhealthyNose = new Color (151, 76, 76);
    Color unhealthyHorn = new Color (115, 136, 139);
    Color unhealthyMark = new Color (135, 84, 122);

    public void draw () // Draws all objects
    {
	int legsMovement = 15; // Controls Leg Movement
	int xAxisSpot = 640; // Just a shift in x axis (to help me code quicker)
	int yAxisSpot = 364; // Just a shift in y axis (to help me code quicker)
	for (int x = 0 ; x < 200 ; x++) // MOVEMENT + DRAWING
	{
	    xAxisSpot -= x; // xAxis spot gets reduced to shift over the object
	    if (x % 12 == 0) // Makes it look like the legs are moving forward periodically
	    {
		legsMovement *= -1;
	    }
	    // Refills background portion where needed
	    c.setColor (background);
	    c.fillRect (0 + xAxisSpot, 0 + yAxisSpot, 167, 146);
	    if (health == false) // If the pony is on unhealthy mode
	    { // draw pony but with unhealthy colours
		c.setColor (unhealthyHorn); // Pony Horn
		int xz[] = {0 + xAxisSpot, 47 + xAxisSpot, 35 + xAxisSpot};
		int yz[] = {0 + yAxisSpot, 29 + yAxisSpot, 41 + yAxisSpot};
		c.fillPolygon (xz, yz, 3);
		c.setColor (unhealthyBody); // Pony Body
		int xa[] = {31 + xAxisSpot, 138 + xAxisSpot, 141 + xAxisSpot + legsMovement, 116 + xAxisSpot + legsMovement, 116 + xAxisSpot, 88 + xAxisSpot, 83 + xAxisSpot + legsMovement, 58 + xAxisSpot + legsMovement, 53 + xAxisSpot, 55 + xAxisSpot, 22 + xAxisSpot, 13 + xAxisSpot};
		int ya[] = {47 + yAxisSpot, 91 + yAxisSpot, 141 + yAxisSpot, 141 + yAxisSpot, 103 + yAxisSpot, 103 + yAxisSpot, 141 + yAxisSpot, 141 + yAxisSpot, 100 + yAxisSpot, 72 + yAxisSpot, 93 + yAxisSpot, 73 + yAxisSpot};
		c.fillPolygon (xa, ya, 12);
		c.setColor (unhealthyFur); // Pony Fur
		c.fillOval (23 + xAxisSpot, 20 + yAxisSpot, 61, 61);
		c.fillOval (44 + xAxisSpot, 61 + yAxisSpot, 110, 54);
		c.setColor (unhealthyNose); // Pony Nose
		c.fillOval (0 + xAxisSpot, 54 + yAxisSpot, 21, 21);
		c.setColor (unhealthyMark); // Pony Mark
		for (int a = 0 ; a < 4 ; a++) // Just a for loop to draw multiple lines conveying hurt
		{
		    c.drawLine (33 + xAxisSpot, 30 + yAxisSpot + (a * 4), 40 + xAxisSpot, 40 + yAxisSpot + (a * 4)); // Draws line in 4 positions (which all move togther with the pony)
		}
	    }
	    else // If the pony is on healthy mode
	    { // draw pony but with unhealthy colours
		c.setColor (healthyHorn); // Pony Horn
		int xz[] = {0 + xAxisSpot, 47 + xAxisSpot, 35 + xAxisSpot};
		int yz[] = {0 + yAxisSpot, 29 + yAxisSpot, 41 + yAxisSpot};
		c.fillPolygon (xz, yz, 3);
		c.setColor (healthyBody); // Pony Body
		int xa[] = {31 + xAxisSpot, 138 + xAxisSpot, 141 + xAxisSpot + legsMovement, 116 + xAxisSpot + legsMovement, 116 + xAxisSpot, 88 + xAxisSpot, 83 + xAxisSpot + legsMovement, 58 + xAxisSpot + legsMovement, 53 + xAxisSpot, 55 + xAxisSpot, 22 + xAxisSpot, 13 + xAxisSpot};
		int ya[] = {47 + yAxisSpot, 91 + yAxisSpot, 141 + yAxisSpot, 141 + yAxisSpot, 103 + yAxisSpot, 103 + yAxisSpot, 141 + yAxisSpot, 141 + yAxisSpot, 100 + yAxisSpot, 72 + yAxisSpot, 93 + yAxisSpot, 73 + yAxisSpot};
		c.fillPolygon (xa, ya, 12);
		c.setColor (healthyFur); // Pony Fur
		c.fillOval (23 + xAxisSpot, 20 + yAxisSpot, 61, 61);
		c.fillOval (44 + xAxisSpot, 61 + yAxisSpot, 110, 54);
		c.setColor (healthyNose); // Pony Nose
		c.fillOval (0 + xAxisSpot, 54 + yAxisSpot, 21, 21);
		// Colour Slowly Changing for effect (as the loop progress, these colours start seeming to appear in true form)
		vines = new Color (30 + (int) (x / 100), 30 + (int) (x / 1.2), 30);
		flowerStem = new Color (30 + (int) (x / 100), 30 + (int) (x / 1.2), 30);
		flowerPinkPetals = new Color (30 + (int) (x / 1.0309), 30, 30 + (int) (x / 1.207189));
		flowerBluePetals = new Color (30 + (int) (x / 1.0869), 30 + (int) (x / 0.904), 30 + (int) (x / 0.8888));
		// Vines
		c.setColor (vines); // Vinces
		int xy[] = {69, 111, 117, 132, 158, 116, 130, 167, 141, 174, 122, 71, 98, 94, 61, 91, 54};
		int yy[] = {117, 162, 118, 163, 159, 185, 211, 186, 225, 279, 233, 240, 219, 192, 214, 171, 136};
		c.fillPolygon (xy, yy, 17);
		// Flower
		c.setColor (flowerStem); // stem
		c.fillRect (64 + 198, 309 + 132, 5, 14);
		c.setColor (flowerPinkPetals); // petals
		c.fillOval (60 + 198, 283 + 132, 14, 28);
		c.fillOval (53 + 198, 290 + 132, 28, 14);
		c.setColor (flowerBluePetals); // middle circle bit
		c.fillOval (62 + 198, 292 + 132, 9, 9);
	    }
	    try // Timing for animation effect
	    {
		Thread.sleep (15);
	    }
	    catch (Exception e)
	    {
	    }
	    xAxisSpot = 640; //  Resets xAxisSpot (this is a variable that helped me with position when translating plan coordinates to coordinates on screen while in animation form)
	}
	try // More timing after the pony is done being animated
	{
	    Thread.sleep (1159);
	}
	catch (Exception e)
	{
	}
    }
    public PonyObject (Console con, boolean healthChooser)  // assigned parameters and constructed in MyCreation class (healthChooser chooses healthy or unhealthy, which gets translated into this class's variable and drawn accordingly)
    {
	c = con;
	health = healthChooser; // This allows MyCreation to choose what health type it is on in a specific scene
	// In draw, true draws a healthy pony, while false draws an unhealthy one
	draw ();
    }
}
