/**
* INTRODUCTION ANIMATION
* Sehan Munir, Daniel Iravani
* Dec 30,2023
* ICS3UP_MS.Krasteva
*/
// This animation was created by Daniel, structure by Sehan
//IMPORTS
import hsa.*; // Console and Error Message
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class IntroductionAnimation extends Thread// Public Class
{
private Console c;
    public void draw ()  // Draws
    {
	firstScene ();
	// DRAWS IMAGE
	try
	{
	    BufferedImage credits = ImageIO.read (new File ("IMAGEfolder\\IMAGEstart.jpg"));
	    c.drawImage (credits, 0, 0, null);
	}
	catch (IOException e)
	{
	    new Message ("Image CANNOT load, ensure IMAGEstart.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");
	}
	// INPUT TO MOVE ON
	char leaveInput = c.getChar ();
    } // And main method controls next method flow


    public void firstScene ()
    {
	// Coordinates Information

	//Teacher Coordinates
	int tx = 8;
	int ty = 147;

	//First Boy Coordinates
	int fbx = 212;
	int fby = 208;
	int finalfbx = 159;
	int finalfby = 400;
	int finalfbx2 = 180;
	int finalfby2 = 132;

	//First Girl Coordinates
	int fgx = 461;
	int fgy = 218;
	int finalfgx = 364;
	int finalfgy = 317;
	int finalfgx2 = 561;
	int finalfgy2 = 160;

	//Second Girl Coordinates
	int sgx = 381;
	int sgy = 258;
	int finalsgx = 207;
	int finalsgy = 317;
	int finalsgx2 = 279;
	int finalsgy2 = 132;

	//Main Boy Coordinates
	int mbx = 521;
	int mby = 315;
	int finalmbx = 453;
	int finalmbx2 = 160;
	int finalmby2 = 198;

	// Drawing
	try
	{
	    // Declaration
	    BufferedImage background = ImageIO.read (new File ("IMAGEfolder\\IMAGEsplash1.jpg"));
	    BufferedImage teacher = ImageIO.read (new File ("IMAGEfolder\\IMAGEteacher.gif"));
	    BufferedImage toy1 = ImageIO.read (new File ("IMAGEfolder\\IMAGEtoy1.gif"));
	    BufferedImage toy2 = ImageIO.read (new File ("IMAGEfolder\\IMAGEtoy2.gif"));
	    BufferedImage boy = ImageIO.read (new File ("IMAGEfolder\\IMAGEchild.gif"));
	    BufferedImage girl1 = ImageIO.read (new File ("IMAGEfolder\\IMAGEgirl1.gif"));
	    BufferedImage girl2 = ImageIO.read (new File ("IMAGEfolder\\IMAGEgirl2.gif"));
	    BufferedImage main = ImageIO.read (new File ("IMAGEfolder\\IMAGEmainchild.gif"));
	    BufferedImage main2 = ImageIO.read (new File ("IMAGEfolder\\IMAGEmainchild2.gif"));

	    //First Boy While Loop
	    while (fbx > finalfbx && fby < finalfby)
	    {
		fbx--;
		fby += 2;
		c.drawImage (background, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (toy1, 486, 395, null);
		c.drawImage (toy2, 512, 421, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main, mbx, mby, null);
		try
		{
		    Thread.sleep (25);
		}
		catch (Exception e)
		{
		}
	    }

	    //Second Girl While Loop
	    while (sgx > finalsgx && sgy < finalsgy)
	    {
		sgx -= 2;
		sgy++;
		c.drawImage (background, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (toy1, 486, 395, null);
		c.drawImage (toy2, 512, 421, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main, mbx, mby, null);
		try
		{
		    Thread.sleep (25);
		}
		catch (Exception e)
		{
		}
	    }

	    //First Girl While Loop
	    while (fgx > finalfgx && fgy < finalfgy)
	    {
		fgx--;
		fgy++;
		c.drawImage (background, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (toy1, 486, 395, null);
		c.drawImage (toy2, 512, 421, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main, mbx, mby, null);
		try
		{
		    Thread.sleep (25);
		}
		catch (Exception e)
		{
		}
	    }


	    //Main Boy While Loop
	    while (mbx > finalmbx)
	    {
		mbx--;
		c.drawImage (background, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (toy1, 486, 395, null);
		c.drawImage (toy2, 512, 421, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main2, mbx, mby, null);
		try
		{
		    Thread.sleep (25);
		}
		catch (Exception e)
		{
		}
	    }

	    for (int i = 0 ; i < 600 ; i++)
	    {
		tx--;
		fbx--;
		sgx--;
		fgx--;
		mbx--;
		c.drawImage (background, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (toy1, 486, 395, null);
		c.drawImage (toy2, 512, 421, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main2, mbx, mby, null);
		try
		{
		    Thread.sleep (10);
		}
		catch (Exception e)
		{
		}
	    }
	}
	catch (IOException e)
	{
	}

	secondScene ();
    }


    public void secondScene ()
    {



	// Coordinates Information

	//Teacher Coordinates
	int tx = 8;
	int ty = 147;

	//First Boy Coordinates
	int fbx = 212;
	int fby = 208;
	int finalfbx = 159;
	int finalfby = 400;
	int finalfbx2 = 180;
	int finalfby2 = 132;

	//First Girl Coordinates
	int fgx = 461;
	int fgy = 218;
	int finalfgx = 364;
	int finalfgy = 317;
	int finalfgx2 = 561;
	int finalfgy2 = 160;

	//Second Girl Coordinates
	int sgx = 381;
	int sgy = 258;
	int finalsgx = 207;
	int finalsgy = 317;
	int finalsgx2 = 279;
	int finalsgy2 = 132;

	//Main Boy Coordinates
	int mbx = 521;
	int mby = 315;
	int finalmbx = 453;
	int finalmbx2 = 160;
	int finalmby2 = 198;

	c.clear ();
	
	try
	{
	    // Declaration
	    BufferedImage background2 = ImageIO.read (new File ("IMAGEfolder\\IMAGEsplash2.jpg"));
	    BufferedImage background = ImageIO.read (new File ("IMAGEfolder\\IMAGEsplash1.jpg"));
	    BufferedImage teacher = ImageIO.read (new File ("IMAGEfolder\\IMAGEteacher.gif"));
	    BufferedImage toy1 = ImageIO.read (new File ("IMAGEfolder\\IMAGEtoy1.gif"));
	    BufferedImage toy2 = ImageIO.read (new File ("IMAGEfolder\\IMAGEtoy2.gif"));
	    BufferedImage boy = ImageIO.read (new File ("IMAGEfolder\\IMAGEchild.gif"));
	    BufferedImage girl1 = ImageIO.read (new File ("IMAGEfolder\\IMAGEgirl1.gif"));
	    BufferedImage girl2 = ImageIO.read (new File ("IMAGEfolder\\IMAGEgirl2.gif"));
	    BufferedImage main = ImageIO.read (new File ("IMAGEfolder\\IMAGEmainchild.gif"));
	    BufferedImage main2 = ImageIO.read (new File ("IMAGEfolder\\IMAGEmainchild2.gif"));

	    tx = 700;
	    fbx = 800;
	    fby = 317;
	    sgx = 900;
	    sgy = 317;
	    fgx = 1000;
	    fgy = 317;
	    mbx = 1100;
	    mby = 317;


	    for (int i = 0 ; i < 650 ; i++)
	    {
		tx--;
		fbx--;
		sgx--;
		fgx--;
		mbx--;
		c.drawImage (background2, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main2, mbx, mby, null);
		try
		{
		    Thread.sleep (10);
		}
		catch (Exception e)
		{
		}
	    }

	    //First Boy While Loop
	    while (fbx < finalfbx2 || fby > finalfby2)
	    {
		fbx++;
		fby -= 2;
		c.drawImage (background2, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main, mbx, mby, null);
		try
		{
		    Thread.sleep (15);
		}
		catch (Exception e)
		{
		}
	    }

	    //Second Girl While Loop
	    while (sgx > finalsgx2 || sgy > finalsgy2)
	    {
		sgx --;
		sgy-=2;
		c.drawImage (background2, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main, mbx, mby, null);
		try
		{
		    Thread.sleep (15);
		}
		catch (Exception e)
		{
		}
	    }

	    //First Girl While Loop
	    while (fgx < finalfgx2 || fgy > finalfgy2)
	    {
		fgx++;
		fgy--;
		c.drawImage (background2, 0, 0, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		c.drawImage (main, mbx, mby, null);
		try
		{
		    Thread.sleep (15);
		}
		catch (Exception e)
		{
		}
	    }


	    //Main Boy While Loop
	    while (mbx > finalmbx2 || mby > finalmby2)
	    {
		mbx-=2;
		mby--;
		c.drawImage (background2, 0, 0, null);
		c.drawImage (main2, mbx, mby, null);
		c.drawImage (teacher, tx, ty, null);
		c.drawImage (boy, fbx, fby, null);
		c.drawImage (girl1, fgx, fgy, null);
		c.drawImage (girl2, sgx, sgy, null);
		try
		{
		    Thread.sleep (15);
		}
		catch (Exception e)
		{
		}
	    }


	}
	catch (IOException e)
	{
	}



    }

    public IntroductionAnimation (Console con)
    {
	c = con;
	draw();
    }
}
