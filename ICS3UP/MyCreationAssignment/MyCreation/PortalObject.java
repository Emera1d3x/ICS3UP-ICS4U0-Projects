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
// This is the PortalObject.java file. It contains the PortalObject class
// which creates an animation of a portal opening and closing
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// CLASS
public class PortalObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c;
    // Colours Required
    Color portalDarkPurple = new Color (47, 2, 38);
    Color portalPurple = new Color (94, 3, 76);
    Color portalLightPurple = new Color (172, 0, 139);
    Color sand = new Color (149, 149, 77);

    public void portalObject () // Draws portal
    {
	for (int x = 0 ; x < 250 ; x++) // PORTAL
	{
	    c.setColor (portalDarkPurple); // Dark portal portion animated
	    c.drawOval (560, 281 - (x / 2), 62, x);
	    try // Delay
	    {
		Thread.sleep (2);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int x = 0 ; x < 205 ; x++) // PORTAL
	{
	    c.setColor (portalPurple); // Regular portal portion animated
	    c.drawOval (567, 281 - (x / 2), 49, x);
	    try // Delay
	    {
		Thread.sleep (3);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int x = 0 ; x < 170 ; x++) // PORTAL
	{
	    c.setColor (portalLightPurple); // Light portal portion animated
	    c.drawOval (574, 281 - (x / 2), 36, x);
	    try // Delay
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	try // More delay
	{
	    Thread.sleep (165);
	}
	catch (Exception e)
	{
	}
	for (int x = 0 ; x < 250 ; x++) // COVER UP (Portal closing)
	{
	    c.setColor (sand); // Sand colour (to refill background)
	    c.drawOval (560 + x / 2, 156 + x / 2, 62 - x, 250 - x); // Only fills important portions
	    try // Delay
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }
    public PortalObject (Console con) // constructed in MyCreation class
    {
	c = con;
    }
    public void run () // run command
    {
	portalObject ();
    }
}
