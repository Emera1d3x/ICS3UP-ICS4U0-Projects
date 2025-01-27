/**
* This program displays a bead loom design inspired by the indigenous art style and as a recogniction of inuit lifestyle
* @author Sehan Munir, Hyrbod Ghashghaeesaadi
* Oct. 16,2023
* ICS3UP MS. Krasteva
*/

//IMPORTS
import java.awt.*;
import hsa.Console;

public class SehanHyrbodVirtualLoom // Public Class
{
    // Variable Declarations
    // Colours
    Color consoleBackground = new Color (173, 194, 224); // Console Background colour
    Color introText = new Color (0, 0, 0);
    Color colourBackground = new Color (4, 155, 224); // Background Colours (for design)
    Color colourBorder = new Color (0, 0, 0);
    Color colourBorder2 = new Color (3, 117, 166);
    Color colourVignetteColours;
    Color colourDarkBrown = new Color (99, 51, 8); // Wood Log Colours (for design)
    Color colourBrown = new Color (143, 76, 14);
    Color colourDarkRed = new Color (214, 9, 19); // Fire and Cloud Colours (for design)
    Color colourRed = new Color (255, 0, 8);
    Color colourLightRed = new Color (255, 77, 82);
    Color colourOrange = new Color (255, 153, 0);
    Color colourLightOrange = new Color (255, 184, 77);
    Color colourYellow = new Color (255, 234, 0);
    Color colourLightYellow = new Color (255, 243, 150);
    Color colourLighterYellow = new Color (255, 247, 182);
    Color colourLightCloud = new Color (255, 255, 255);
    Color colourDarkCloud = new Color (180, 180, 180);
    Color colour; // Parameter for complex design being displayed row by row
    // Console Variable
    Console z; // Console Variable
   
    private SehanHyrbodVirtualLoom ()
    {
	z = new Console ("Bead Loom Design by Sehan and Hyrbod"); // (640 by 500 default)
    }
    
    public void title(){
   
	z.setColour (consoleBackground); // Background Colour
	z.fillRect (0, 0, 650, 500); // Fill background    
	z.setColour (introText); // Text Colour
	z.setFont (new Font ("Perpetua", 1, 55)); // Title Font
	z.drawString ("Virtual Bead Loom", 105, 150); // Title
    }   
     public void intro () // Introduces user to program
    {
	title();
	z.setFont (new Font ("Perpetua", 1, 30)); // Names and Date Font
	z.drawString ("By: Hyrbod G and Sehan M", 150, 190); // Names
	z.drawString ("October 16, 2023", 210, 370); // Date
	z.setFont (new Font ("Franklin Gothic Book", 1, 20)); // Description Font
	z.drawString ("Our design takes inspiration from Indigenous", 120, 250); // Description
	z.drawString ("culture, using components such as logs, fire", 120, 270); // Description
	z.drawString ("water and nature. The bead loom demonstrates", 120, 290); // Description
	z.drawString ("nature clashing against each other.", 120, 310); // Description
	z.drawString ("Press any key to reveal the bead loom", 145, 420); // Prompts user to move on to next screen
	z.getChar (); // User input confirming moving to next screen
	z.clear (); // Clear entire screen and move on to the drawing(); method
    }


    private void pixel (int xAxis, int yAxis, int amount, Color colour)  // Fire and Cloud output, uses parameters and displays "block by block"
    {
	z.setColour (colour); // Sets to parameter assigned colour
	for (int number = 1 ; number <= amount ; number++) // This is used in the case when multiple blocks have the same colour beside eachother
	{
	    z.fillRect (xAxis + (number * 10), yAxis, 10, 10); // Top Left output
	    z.fillRect (xAxis + (number * 10), 490 - yAxis, 10, 10); // Flipping to Top Right output
	    z.fillRect (650 - xAxis - (number * 10), yAxis, 10, 10); // Flipping to Bottom Right output
	    z.fillRect (650 - xAxis - (number * 10), 490 - yAxis, 10, 10); // Flipping to Bottom Left output
	    try // Timing for block by block placement effect
	    {
		Thread.sleep (35);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public void drawing () // Drawing method, contains all information needed to display drawing
    {
	// Console Background
	z.setColour (consoleBackground);
	z.fillRect (0, 0, 640, 500);
	// Background (By colour)
	z.setColour (colourBackground); // Sets Colour
	for (int a = 0 ; a <= 39 ; a++) // Moves pixel to next row
	{
	    for (int b = 0 ; b <= 39 ; b++)
	    {
		z.fillRect (130 + (b * 10), 50 + (a * 10), 10, 10); // Pixel drawn column by column
		try // Timing
		{
		    Thread.sleep (2);
		}
		catch (Exception e)
		{
		}
	    }
	}
	// Border #1 (By colour)
	z.setColour (colourBorder); // Sets Colour
	for (int c = 0 ; c <= 38 ; c++)
	{
	    z.fillRect (130 + (int) (c * 10), 50, 10, 10);
	    z.fillRect (520 - (int) (c * 10), 440, 10, 10);
	    z.fillRect (130, 440 - (c * 10), 10, 10);
	    z.fillRect (520, 50 + (c * 10), 10, 10);
	    try // Timing
	    {
		Thread.sleep (15);
	    }
	    catch (Exception e)
	    {
	    }
	}
	// Wood Logs (By colour)
	z.setColour (colourDarkBrown); // Sets Colour
	for (int d = 0 ; d <= 35 ; d++)
	{
	    z.setColour (colourDarkBrown); // Sets Colour
	    z.fillRect (260 + (d / 3 * 10), 70 + (d / 1 * 10), 10, 10);
	    z.fillRect (370 - (d / 3 * 10), 70 + (d / 1 * 10), 10, 10);
	    z.fillRect (500 - (d / 1 * 10), 180 + (d / 3 * 10), 10, 10);
	    z.fillRect (500 - (d / 1 * 10), 290 - (d / 3 * 10), 10, 10);
	    z.fillRect (390 - (d / 3 * 10), 420 - (d / 1 * 10), 10, 10);
	    z.fillRect (280 + (d / 3 * 10), 420 - (d / 1 * 10), 10, 10);
	    z.fillRect (150 + (d / 1 * 10), 310 - (d / 3 * 10), 10, 10);
	    z.fillRect (150 + (d / 1 * 10), 200 + (d / 3 * 10), 10, 10);
	    try // Timing
	    {
		Thread.sleep (45);
	    }
	    catch (Exception e)
	    {
	    }
	}
	z.setColour (colourBrown); // Sets Colour
	for (int d = 0 ; d <= 35 ; d++)
	{
	    z.fillRect (270 + (d / 3 * 10), 70 + (d / 1 * 10), 10, 10);
	    z.fillRect (380 - (d / 3 * 10), 70 + (d / 1 * 10), 10, 10);
	    z.fillRect (500 - (d / 1 * 10), 190 + (d / 3 * 10), 10, 10);
	    z.fillRect (500 - (d / 1 * 10), 300 - (d / 3 * 10), 10, 10);

	    try // Timing
	    {
		Thread.sleep (45);
	    }
	    catch (Exception e)
	    {
	    }
	}
	// Border #2 (By colour)
	z.setColour (colourBorder2); // Sets Colour
	for (int f = 0 ; f <= 36 ; f++)
	{
	    try // Timing
	    {
		Thread.sleep (35);
	    }
	    catch (Exception e)
	    {
	    }
	    // Border
	    z.fillRect (140 + (int) (f * 10), 60, 10, 10);
	    z.fillRect (510 - (int) (f * 10), 430, 10, 10);
	    z.fillRect (140, 430 - (f * 10), 10, 10);
	    z.fillRect (510, 60 + (f * 10), 10, 10);
	    // Diagonals
	    z.fillRect (290 + ((f / 10) * 10), 70 + ((f / 10) * 10), 10, 10);
	    z.fillRect (360 - ((f / 10) * 10), 70 + ((f / 10) * 10), 10, 10);
	    z.fillRect (150 + ((f / 10) * 10), 210 + ((f / 10) * 10), 10, 10);
	    z.fillRect (150 + ((f / 10) * 10), 280 - ((f / 10) * 10), 10, 10);
	    z.fillRect (290 + ((f / 10) * 10), 420 - ((f / 10) * 10), 10, 10);
	    z.fillRect (360 - ((f / 10) * 10), 420 - ((f / 10) * 10), 10, 10);
	    z.fillRect (500 - ((f / 10) * 10), 210 + ((f / 10) * 10), 10, 10);
	    z.fillRect (500 - ((f / 10) * 10), 280 - ((f / 10) * 10), 10, 10);

	}
	// Vignette Colour (By colour)
	for (int g = 0 ; g <= 10 ; g++)
	{
	    colourVignetteColours = new Color (0, 15, 74);
	    z.setColour (colourVignetteColours); ////////////
	    z.fillRect (140, 60 + (g * 4), 10, 10);
	    z.fillRect (140 + (g * 4), 60, 10, 10);
	    z.fillRect (140, 430 - (g * 4), 10, 10);
	    z.fillRect (140 + (g * 4), 430, 10, 10);
	    z.fillRect (510, 430 - (g * 4), 10, 10);
	    z.fillRect (510 - (g * 4), 430, 10, 10);
	    z.fillRect (510, 60 + (g * 4), 10, 10);
	    z.fillRect (510 - (g * 4), 60, 10, 10);
	    z.fillRect (140, 240 - (g * 3), 10, 10);
	    z.fillRect (140, 250 + (g * 3), 10, 10);
	    z.fillRect (510, 240 - (g * 3), 10, 10);
	    z.fillRect (510, 250 + (g * 3), 10, 10);
	    z.fillRect (320 - (g * 3), 60, 10, 10);
	    z.fillRect (330 + (g * 3), 60, 10, 10);
	    z.fillRect (320 - (g * 3), 430, 10, 10);
	    z.fillRect (330 + (g * 3), 430, 10, 10);
	    colourVignetteColours = new Color (0, 15, 149);
	    z.setColour (colourVignetteColours); ////////////
	    z.fillRect (150, 70 + (g * 2), 10, 10);
	    z.fillRect (150 + (g * 2), 70, 10, 10);
	    z.fillRect (150, 420 - (g * 2), 10, 10);
	    z.fillRect (150 + (g * 2), 420, 10, 10);
	    z.fillRect (500, 420 - (g * 2), 10, 10);
	    z.fillRect (500 - (g * 2), 420, 10, 10);
	    z.fillRect (500, 70 + (g * 2), 10, 10);
	    z.fillRect (500 - (g * 2), 70, 10, 10);

	    z.fillRect (150, 240 - (g * 2), 10, 10);
	    z.fillRect (150, 250 + (g * 2), 10, 10);
	    z.fillRect (500, 240 - (g * 2), 10, 10);
	    z.fillRect (500, 250 + (g * 2), 10, 10);
	    z.fillRect (320 - (g * 2), 70, 10, 10);
	    z.fillRect (330 + (g * 2), 70, 10, 10);
	    z.fillRect (320 - (g * 2), 420, 10, 10);
	    z.fillRect (330 + (g * 2), 420, 10, 10);
	    colourVignetteColours = new Color (0, 15, 199);
	    z.setColour (colourVignetteColours); ////////////
	    z.fillRect (160, 80, 10, 10);
	    z.fillRect (160, 410, 10, 10);
	    z.fillRect (490, 410, 10, 10);
	    z.fillRect (490, 80, 10, 10);
	    z.fillRect (160, 240 - g, 10, 10);
	    z.fillRect (160, 250 + g, 10, 10);
	    z.fillRect (490, 240 - g, 10, 10);
	    z.fillRect (490, 250 + g, 10, 10);
	    z.fillRect (320 - g, 80, 10, 10);
	    z.fillRect (330 + g, 80, 10, 10);
	    z.fillRect (320 - g, 410, 10, 10);
	    z.fillRect (330 + g, 410, 10, 10);
	    colourVignetteColours = new Color (0, 15, 236);
	    z.setColour (colourVignetteColours); ////////////
	    z.fillRect (170, 240, 10, 10);
	    z.fillRect (170, 250, 10, 10);
	    z.fillRect (480, 240, 10, 10);
	    z.fillRect (480, 250, 10, 10);
	    z.fillRect (320, 90, 10, 10);
	    z.fillRect (330, 90, 10, 10);
	    z.fillRect (320, 400, 10, 10);
	    z.fillRect (330, 400, 10, 10);
	    try // Timing
	    {
		Thread.sleep (65);
	    }
	    catch (Exception e)
	    {
	    }
	}
	
	// Information so pixel(); can output correctly (usage of parameters). Each row of command represents the rows of comand displayed on screen.
	// This part goes row by row rather than colour by colour (for effeciency)
	pixel(220,90,2,colourLightCloud); pixel(240,90,1,colourDarkCloud);
	pixel(190,100,5,colourLightCloud); pixel(240,100,1,colourDarkCloud);
	pixel(180,110,5,colourLightCloud);pixel(230,110,2,colourDarkCloud);
	pixel(170,120,4,colourLightCloud);pixel(210,120,3,colourDarkCloud);pixel(310,120,1,colourDarkRed);
	pixel(170,130,4,colourLightCloud);pixel(210,130,2,colourDarkCloud);pixel(300,130,1,colourDarkRed);pixel(310,130,1,colourLightRed);
	pixel(170,140,3,colourLightCloud);pixel(200,140,1,colourDarkCloud);pixel(300,140,1,colourDarkRed);pixel(310,140,1,colourRed);
	pixel(160,150,3,colourLightCloud);pixel(190,150,2,colourDarkCloud);pixel(300,150,1,colourDarkRed);pixel(310,150,1,colourRed);
	pixel(160,160,2,colourLightCloud);pixel(180,160,2,colourDarkCloud);pixel(290,160,1,colourDarkRed);pixel(300,160,2,colourRed);
	pixel(170,170,2,colourDarkCloud);pixel(240,170,5,colourDarkRed);pixel(290,170,2,colourRed);pixel(310,170,1,colourOrange);
	pixel(230,180,1,colourDarkRed);pixel(240,180,1,colourLightRed);pixel(250,180,5,colourRed);pixel(300,180,1,colourOrange);pixel(310,180,1,colourLightOrange);
	pixel(210,190,2,colourDarkRed);pixel(230,190,1,colourLightRed);pixel(240,190,1,colourRed);pixel(250,190,4,colourOrange);pixel(290,190,1,colourRed);pixel(300,190,1,colourOrange);pixel(310,190,1,colourYellow);
	pixel(230,200,1,colourDarkRed);pixel(240,200,2,colourRed);pixel(260,200,4,colourOrange);pixel(300,200,1,colourLightOrange);pixel(310,200,1,colourYellow);
	pixel(240,210,1,colourDarkRed);pixel(250,210,2,colourRed);pixel(270,210,1,colourOrange);pixel(280,210,1,colourYellow);pixel(290,210,1,colourLightOrange);pixel(300,210,2,colourYellow);
	pixel(230,220,1,colourDarkRed);pixel(240,220,3,colourRed);pixel(270,220,1,colourOrange);pixel(280,220,1,colourLightOrange);pixel(290,220,2,colourYellow);pixel(310,220,1,colourLightYellow);
	pixel(200,230,3,colourDarkRed);pixel(230,230,2,colourRed);pixel(250,230,2,colourOrange);pixel(270,230,1,colourLightOrange);pixel(280,230,2,colourYellow);pixel(300,230,1,colourLightYellow);pixel(310,230,1,colourLighterYellow);
	pixel(190,240,1,colourDarkRed);pixel(200,240,1,colourLightRed);pixel(210,240,3,colourRed);pixel(240,240,1,colourOrange);pixel(250,240,1,colourLightOrange);pixel(260,240,3,colourYellow);pixel(290,240,1,colourLightYellow);pixel(300,240,2,colourLighterYellow);
	
	// Our names
	z.setFont (new Font ("Perpetua", 1, 15));
	z.drawString ("By: Hyrbod G and Sehan M", 30, 465);
    }



    public static void main (String[] args)  // Output
    {
	SehanHyrbodVirtualLoom result = new SehanHyrbodVirtualLoom ();
	result.intro();
	result.drawing ();
    } //Main method close
} //Class close
