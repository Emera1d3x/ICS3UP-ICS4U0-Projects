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
// This is the FireObject.java file. It contains the FireObject class
// which creates an animation of fire changing between 2 colour sets
// and dissappearing when timed to match when fire is meant to be gone
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
import java.lang.*;
// PUBLIC CLASS
public class FireObject extends Thread // Extends Thread
{
    // Variables Required
    private Console c; // Parameter for Console
    // Colours
    // Colours used for flames
    Color fireRed = new Color (255, 0, 0);
    Color fireOrange = new Color (255, 127, 0);
    Color fireYellow = new Color (246, 255, 0);
    Color fireLightYellow = new Color (255, 255, 255);
    // Colours used to cover up flames
    Color sky = new Color (10, 104, 200);
    Color grassDark = new Color (10, 62, 17);
    Color grassLight = new Color (19, 123, 35);
    Color treeStemTwo = new Color (44, 30, 5);
    Color log = new Color (60, 37, 0);
    Color treeLeaves = new Color (0, 255, 85);

    public void draw ()  // Character Drawing
    {

	for (int x = 0 ; x < 50 ; x++) // The loop that times everything correctly
	{
	    if ((x % 2 == 0) && (x <= 35)) // When in stage one and timed in increments, draw flames
	    {
		c.setColor (fireRed);
		int xa[] = {53, 66, 79, 85, 101, 104, 114, 125, 130, 115, 82, 69, 46, 28};
		int ya[] = {156, 168, 118, 175, 146, 184, 185, 161, 197, 224, 224, 215, 222, 196};
		c.fillPolygon (xa, ya, 14);
		int xb[] = {297, 326, 302, 339, 358, 386, 373, 394, 374, 324};
		int yb[] = {58, 53, 9, 29, 47, 26, 71, 66, 96, 94};
		c.fillPolygon (xb, yb, 10);
		int xc[] = {270, 301, 305, 346, 339, 375, 366};
		int yc[] = {147, 117, 136, 114, 137, 120, 151};
		c.fillPolygon (xc, yc, 7);
		int xd[] = {92, 108, 116, 137, 154, 158, 99};
		int yd[] = {290, 294, 264, 289, 264, 301, 305};
		c.fillPolygon (xd, yd, 7);
		int xe[] = {109, 118, 150, 127, 181, 176, 215, 214};
		int ye[] = {336, 327, 334, 318, 330, 317, 334, 342};
		c.fillPolygon (xe, ye, 8);
		int xf[] = {378, 392, 400, 388, 389, 379, 382};
		int yf[] = {291, 300, 263, 237, 260, 259, 276};
		c.fillPolygon (xf, yf, 7);
		int xg[] = {433, 450, 460, 471, 496, 495, 440};
		int yg[] = {297, 304, 296, 305, 297, 314, 312};
		c.fillPolygon (xg, yg, 7);
		int xh[] = {518, 535, 531, 550, 546, 565, 562, 522};
		int yh[] = {205, 193, 217, 203, 221, 214, 235, 235};
		c.fillPolygon (xh, yh, 8);
		c.setColor (fireOrange);
		int xi[] = {51, 65, 79, 82, 99, 98, 112, 95, 59, 41};
		int yi[] = {166, 178, 157, 189, 177, 197, 198, 218, 208, 196};
		c.fillPolygon (xi, yi, 10);
		int xj[] = {280, 297, 305, 335, 337, 357};
		int yj[] = {144, 130, 141, 126, 142, 148};
		c.fillPolygon (xj, yj, 6);
		int xk[] = {316, 337, 329, 351, 371, 364, 377, 364, 332};
		int yk[] = {67, 60, 32, 60, 48, 73, 79, 90, 83};
		c.fillPolygon (xk, yk, 9);
		int xl[] = {105, 104, 116, 121, 139, 149, 155};
		int yl[] = {301, 298, 294, 279, 292, 278, 296};
		c.fillPolygon (xl, yl, 7);
		int xm[] = {155, 207, 204, 189, 187, 147};
		int ym[] = {336, 339, 335, 328, 335, 325};
		c.fillPolygon (xm, ym, 6);
		int xn[] = {388, 396, 391, 384};
		int yn[] = {267, 263, 294, 286};
		c.fillPolygon (xn, yn, 4);
		int xo[] = {447, 462, 466, 491, 491};
		int yo[] = {312, 302, 308, 306, 310};
		c.fillPolygon (xo, yo, 5);
		int xp[] = {522, 556, 559, 543, 541, 531, 529, 520};
		int yp[] = {230, 232, 223, 227, 214, 220, 203, 209};
		c.fillPolygon (xp, yp, 8);
		c.setColor (fireYellow);
		int xq[] = {54, 73, 75, 90, 93, 64};
		int yq[] = {183, 182, 192, 193, 207, 200};
		c.fillPolygon (xq, yq, 6);
		int xr[] = {333, 355, 352};
		int yr[] = {77, 67, 82};
		c.fillPolygon (xr, yr, 3);
		int xs[] = {527, 537, 535};
		int ys[] = {227, 228, 221};
		c.fillPolygon (xs, ys, 3);
		try
		{
		    Thread.sleep (1000);
		}
		catch (Exception e)
		{
		}

	    }
	    else if (x <= 35) // When in stage one and timed in increments, draw flames with slightly different colours
	    {
		c.setColor (fireOrange);
		int xa[] = {53, 66, 79, 85, 101, 104, 114, 125, 130, 115, 82, 69, 46, 28};
		int ya[] = {156, 168, 118, 175, 146, 184, 185, 161, 197, 224, 224, 215, 222, 196};
		c.fillPolygon (xa, ya, 14);
		int xb[] = {297, 326, 302, 339, 358, 386, 373, 394, 374, 324};
		int yb[] = {58, 53, 9, 29, 47, 26, 71, 66, 96, 94};
		c.fillPolygon (xb, yb, 10);
		int xc[] = {270, 301, 305, 346, 339, 375, 366};
		int yc[] = {147, 117, 136, 114, 137, 120, 151};
		c.fillPolygon (xc, yc, 7);
		int xd[] = {92, 108, 116, 137, 154, 158, 99};
		int yd[] = {290, 294, 264, 289, 264, 301, 305};
		c.fillPolygon (xd, yd, 7);
		int xe[] = {109, 118, 150, 127, 181, 176, 215, 214};
		int ye[] = {336, 327, 334, 318, 330, 317, 334, 342};
		c.fillPolygon (xe, ye, 8);
		int xf[] = {378, 392, 400, 388, 389, 379, 382};
		int yf[] = {291, 300, 263, 237, 260, 259, 276};
		c.fillPolygon (xf, yf, 7);
		int xg[] = {433, 450, 460, 471, 496, 495, 440};
		int yg[] = {297, 304, 296, 305, 297, 314, 312};
		c.fillPolygon (xg, yg, 7);
		int xh[] = {518, 535, 531, 550, 546, 565, 562, 522};
		int yh[] = {205, 193, 217, 203, 221, 214, 235, 235};
		c.fillPolygon (xh, yh, 8);
		c.setColor (fireYellow);
		int xi[] = {51, 65, 79, 82, 99, 98, 112, 95, 59, 41};
		int yi[] = {166, 178, 157, 189, 177, 197, 198, 218, 208, 196};
		c.fillPolygon (xi, yi, 10);
		int xj[] = {280, 297, 305, 335, 337, 357};
		int yj[] = {144, 130, 141, 126, 142, 148};
		c.fillPolygon (xj, yj, 6);
		int xk[] = {316, 337, 329, 351, 371, 364, 377, 364, 332};
		int yk[] = {67, 60, 32, 60, 48, 73, 79, 90, 83};
		c.fillPolygon (xk, yk, 9);
		int xl[] = {105, 104, 116, 121, 139, 149, 155};
		int yl[] = {301, 298, 294, 279, 292, 278, 296};
		c.fillPolygon (xl, yl, 7);
		int xm[] = {155, 207, 204, 189, 187, 147};
		int ym[] = {336, 339, 335, 328, 335, 325};
		c.fillPolygon (xm, ym, 6);
		int xn[] = {388, 396, 391, 384};
		int yn[] = {267, 263, 294, 286};
		c.fillPolygon (xn, yn, 4);
		int xo[] = {447, 462, 466, 491, 491};
		int yo[] = {312, 302, 308, 306, 310};
		c.fillPolygon (xo, yo, 5);
		int xp[] = {522, 556, 559, 543, 541, 531, 529, 520};
		int yp[] = {230, 232, 223, 227, 214, 220, 203, 209};
		c.fillPolygon (xp, yp, 8);
		c.setColor (fireLightYellow);
		int xq[] = {54, 73, 75, 90, 93, 64};
		int yq[] = {183, 182, 192, 193, 207, 200};
		c.fillPolygon (xq, yq, 6);
		int xr[] = {333, 355, 352};
		int yr[] = {77, 67, 82};
		c.fillPolygon (xr, yr, 3);
		int xs[] = {527, 537, 535};
		int ys[] = {227, 228, 221};
		c.fillPolygon (xs, ys, 3);
		try
		{
		    Thread.sleep (1000);
		}
		catch (Exception e)
		{
		}
	    }
	    else // When flames are meant to go out, refill background
	    {
		c.setColor (treeLeaves);
		int xa[] = {53, 66, 79, 85, 101, 104, 114, 125, 130, 115, 82, 69, 46, 28};
		int ya[] = {156, 168, 118, 175, 146, 184, 185, 161, 197, 224, 224, 215, 222, 196};
		c.fillPolygon (xa, ya, 14);
		c.setColor (sky);
		int xb[] = {297, 326, 302, 339, 358, 386, 373, 394, 374, 324};
		int yb[] = {58, 53, 9, 29, 47, 26, 71, 66, 96, 94};
		c.fillPolygon (xb, yb, 10);
		c.setColor (treeLeaves);
		int xc[] = {270, 301, 305, 346, 339, 375, 366};
		int yc[] = {147, 117, 136, 114, 137, 120, 151};
		c.fillPolygon (xc, yc, 7);
		c.setColor (grassDark);
		int xd[] = {92, 108, 116, 137, 154, 158, 99};
		int yd[] = {290, 294, 264, 289, 264, 301, 305};
		c.fillPolygon (xd, yd, 7);
		c.setColor (log);
		int xe[] = {109, 118, 150, 127, 181, 176, 215, 214};
		int ye[] = {336, 327, 334, 318, 330, 317, 334, 342};
		c.fillPolygon (xe, ye, 8);
		c.setColor (treeStemTwo);
		int xf[] = {378, 392, 400, 388, 389, 379, 382};
		int yf[] = {291, 300, 263, 237, 260, 259, 276};
		c.fillPolygon (xf, yf, 7);
		c.setColor (grassLight);
		int xg[] = {433, 450, 460, 471, 496, 495, 440};
		int yg[] = {297, 304, 296, 305, 297, 314, 312};
		c.fillPolygon (xg, yg, 7);
		c.setColor (treeLeaves);
		int xh[] = {518, 535, 531, 550, 546, 565, 562, 522};
		int yh[] = {205, 193, 217, 203, 221, 214, 235, 235};
		c.fillPolygon (xh, yh, 8);
		try
		{
		    Thread.sleep (50);
		}
		catch (Exception e)
		{
		}
	    }
	}
    }


    public FireObject (Console con) // constructed in MyCreation class
    {
	c = con; // Console
    }
    public void run () // allows for run(); command
    {
	draw (); // Draws the object accounting for the specific parameters required
    }
}
