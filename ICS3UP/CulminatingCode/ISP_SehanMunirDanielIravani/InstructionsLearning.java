/**
* INSTRUCTIONS AND LEARNING
* Sehan Munir, Daniel Iravani
* Dec 30,2023
* ICS3UP_MS.Krasteva
*/

// This portion was created by Sehan

//IMPORTS
import hsa.*; // Console and Error Message
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class InstructionsLearning extends Thread // Public Class
{
    private Console c; // Console
    int pageNumber = 0; // The page number, controls what image is being displayed
    public void frontCover ()  // Front Cover
    {
	try
	{
	    BufferedImage frontCover = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEfrontCover.jpg"));
	    c.drawImage(frontCover,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEfrontCover.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	} while (pageNumber==0);
    }
    public void pageOne ()  // Page 1
    {
	// draws the image
	try
	{
	    BufferedImage pageOne = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEpageOne.jpg"));
	    c.drawImage(pageOne,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEpageOne.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	    if (pageChange == 'z')
		pageNumber--;
	} while (pageNumber==1);
    }
    public void pageTwo ()  // Page 2
    {
	// draws the image
	try
	{
	    BufferedImage pageTwo = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEpageTwo.jpg"));
	    c.drawImage(pageTwo,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEpageTwo.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	    if (pageChange == 'z')
		pageNumber--;
	} while (pageNumber==2);
    }
    public void pageThree ()  // Page 3
    {
	// draws the image
	try
	{
	    BufferedImage pageThree = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEpageThree.jpg"));
	    c.drawImage(pageThree,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEpageThree.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	    if (pageChange == 'z')
		pageNumber--;
	} while (pageNumber==3);
    }
    public void pageFour ()  // Page 4
    {
	try // draws the image
	{
	    BufferedImage pageFour = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEpageFour.jpg"));
	    c.drawImage(pageFour,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEpageFour.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	    if (pageChange == 'z')
		pageNumber--;
	} while (pageNumber==4);
    }
    public void pageFive ()  // Page 5
    {
	try// draws the image
	{
	    BufferedImage pageFive = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEpageFive.jpg"));
	    c.drawImage(pageFive,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEpageFive.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	    if (pageChange == 'z')
		pageNumber--;
	} while (pageNumber==5);
    }
    public void pageSix ()  // Page 6
    {
	try// draws the image
	{
	    BufferedImage pageSix = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEpageSix.jpg"));
	    c.drawImage(pageSix,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEpageSix.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	    if (pageChange == 'z')
		pageNumber--;
	} while (pageNumber==6);
    }
    public void backCover ()  // Back Cover
    {
	try
	{// draws the image
	    BufferedImage backCover = ImageIO.read(new File("IMAGEfolder\\IMAGElearning\\IMAGEbackCover.jpg"));
	    c.drawImage(backCover,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEbackCover.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	do // Allows user to change pages
	{
	    char pageChange = c.getChar();
	    if (pageChange == 'x')
		pageNumber++;
	    if (pageChange == 'z')
		pageNumber--;
	} while (pageNumber==7);
    }
    public InstructionsLearning (Console con)
    {
	c = con;
	// Controls the pages flow
	while (pageNumber != 8)
	{
	    if (pageNumber == 0)
		frontCover ();
	    if (pageNumber == 1)
		pageOne ();
	    if (pageNumber == 2)
		pageTwo ();
	    if (pageNumber == 3)
		pageThree ();
	    if (pageNumber == 4)
		pageFour ();
	    if (pageNumber == 5)
		pageFive ();
	    if (pageNumber == 6)
		pageSix ();
	    if (pageNumber == 7)
		backCover ();
	} // When pageNumber is 8 (or in other words option is to go to mainMenu, go to mainMenu)
    }
}
