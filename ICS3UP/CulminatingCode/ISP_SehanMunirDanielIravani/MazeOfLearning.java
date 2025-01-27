/**
* MAZE OF LEARNING
* Sehan Munir, Daniel Iravani
* Dec 30,2023
* ICS3UP_MS.Krasteva


					   
     introduction --------------> maze ----------> end
				  |                 
				  |                  
				  |                     
				  |                    
				  |                    
				  |
				  |                    
mazeCollisionDetection <---------\/----------> question


*/
// This portion was created by Sehan
//IMPORTS
import hsa.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
///////////////////////////////// Citations and specifics can be found in ProjectMain.java
// This essentially just creates the entire maze section

public class MazeOfLearning extends Thread// Public Class
{
/*
    Global Variable Dictionary

    Variable Type     Name                 Explanation
   --------------------------------------------------------------------------------------------------------------------|
   Console            c                  Console, variable that controls all input and display 
   boolean            playMaze           Whether to play the maze or not. When the maze is completed this turns to false. The 
					 user also has the opportunitiy to not play the maze if they want to (say if they accidentely pressed maze from the main menu)
   --------------------------------------------------------------------------------------------------------------------|

*/
    private Console c;
    boolean playMaze;
    
    public void introduction ()  // Maze Introduction
    {
	// VARIABLES USED
	// Global
	    // boolean playMaze;
	// Local
	    char choiceToPlay; // Gives the user a "confirmation" if they want to play
	    int subtleAnimation = 0; // Used for animation
	    int subtleAnimationAdjuster = 1; // Used for animation
	    Color subtleAnimationColour; // Used for animation
	    Color subtleAnimaionColourTwo = new Color (197,94,46); // Used for animation
	
	// DRAWS IMAGE
	try
	{
	    BufferedImage mazeIntroduction = ImageIO.read(new File("IMAGEfolder\\IMAGEmazeStart.jpg"));
	    c.drawImage(mazeIntroduction,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEmazeStart.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	// GETS INPUT
	while (true) // Subtle Animation (because better UI :\)
	{
	    // Input processing section
	    if (c.isCharAvail()) // Input secttion
	    {
		choiceToPlay = c.getChar();
		if (choiceToPlay == 'a')
		{
		    playMaze = true;
		}
		break;
	    }
	    c.setColour(subtleAnimaionColourTwo);
	    c.fillRect(0,0,10,500);
	    c.fillRect(630,0,10,500);
	    subtleAnimationColour = new Color(196-(int)(subtleAnimation/7), 94-(int)(subtleAnimation/7), 46-(int)(subtleAnimation/7));
	    c.setColour(subtleAnimationColour);
	    c.fillRect(0,250+subtleAnimation,10,10);
	    c.fillRect(0,250-subtleAnimation,10,10);
	    c.fillRect(630,250+subtleAnimation,10,10);
	    c.fillRect(630,250-subtleAnimation,10,10);
	    if (subtleAnimation==250){
		subtleAnimationAdjuster=-1;}
	    if (subtleAnimation==0){
		subtleAnimationAdjuster=1;}
	    subtleAnimation+=subtleAnimationAdjuster;
	    try{Thread.sleep(5);}catch(Exception e){} // timing
	}
	
    }
    public void maze ()  // Maze
    {
	// VARIABLES USED
	// Global
	    // boolean playMaze;
	// Local
	    int playerX = 46; // Stores the player's x axis
	    int playerY = 414; // Stores the player's y axis
	    char movementInput = ' '; // Gets user input for movement
	    int playerModelPhase = 0; // Index of which player model should be displayed
	    final String[] playerModels = {"IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterDown.jpg","IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterUp.jpg","IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterLeft.jpg","IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterRight.jpg"};
	    // Player model image paths
	    final String[] imagePath = {"IMAGEfolder\\IMAGEitems\\IMAGEshark.jpg","IMAGEfolder\\IMAGEitems\\IMAGEtriceratops.jpg","IMAGEfolder\\IMAGEitems\\IMAGEpterodactyl.jpg","IMAGEfolder\\IMAGEitems\\IMAGEtrex.jpg","IMAGEfolder\\IMAGEitems\\IMAGEtrash1.jpg","IMAGEfolder\\IMAGEitems\\IMAGEtrash2.jpg","IMAGEfolder\\IMAGEitems\\IMAGEtrash3.jpg","IMAGEfolder\\IMAGEitems\\IMAGEtrash5.jpg","IMAGEfolder\\IMAGEitems\\IMAGEtrash5.jpg"};
	    // image path for items
	    final String[] itemName = {"shark","triceratop","pterodactyl","trex","trash","trash","trash","trash","trash"};
	    // list of possible items
	    final String[][] potentialPositions = {{"50","80"},{"376","56"},{"316","398"},{"150","252"},{"52","330"},{"51","183"},{"275","181"},{"186","420"},{"536","420"},{"556","294"},{"547","163"}};
	    // list of possible positions the item can be at
	    String[][] itemInformation = new String[7][10]; // Holds every item's information
	    
	    int questionsLeft = 7; // The amount of questions left, if all items have been touched, this allows user to exit the maze
	    
	    /* Visualization of itemInformation with example
		    ImagePath    ItemName         X       Y     found?    (          Multiple Choice Answers         ) Correct Answer Pos
	    Index       0            1            2       3       4             5          6         7          8               9
	      0        ()          trex                          true         trash      shark   triceratop   trex              4
	      1                   trash                         false
	      2                   trash                          true         shark      trash     trex    pterodactly          2
	      3                   shark                          true
	      4                   trash                         false
	      5                pterodactyl                      false
	      6                 triceratop                      false
	    
	    */
	    Color backgroundColour = new Color (248, 236, 214); // Just a colour for refilling background/sandbox
	    
	// REMINDER
	try
	{
	    BufferedImage mazeReminder = ImageIO.read(new File("IMAGEfolder\\IMAGEreminder.jpg"));
	    c.drawImage(mazeReminder,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEreminder.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	
	// GETS INPUT
	c.getChar(); // Gets input to move on
	
	// DRAW IMAGE (MAZE)
	try
	{
	    BufferedImage maze = ImageIO.read(new File("IMAGEfolder\\IMAGEmaze.jpg"));
	    c.drawImage(maze,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEmaze.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	
	// RANDOM ITEM GENERATION
	    // (bank holding information to ensure no duplications)
	    int[] takenA = new int[7];// already taken items
	    int[] takenB = new int[7]; // already taken coordinates
	// For loop that stores information for each row of itemInformation
	for (int i = 0; i < 7; i++)
	{
	    int rand = 0;
	    // Select an image path and item name
	    boolean picked = true;
	    while (picked == true){                        // Generates a new random item
		rand = (int)(Math.random()*9);
		if (!(rand==takenA[0]||rand==takenA[1]||rand==takenA[2]||rand==takenA[3]||rand==takenA[4]||rand==takenA[5]||rand==takenA[6]))  // Ensures it is a unique
		    picked = false;
	    }
	    takenA[i] = rand;
	    itemInformation[i][0] = imagePath[rand];      // Assigns the new random item's image path
	    itemInformation[i][1] = itemName[rand];       // Assigns the new random item's name
	    // Select random coordinates
	    picked = true;
	    while (picked == true){                        // Generates a new random coordinates
		rand = (int)(Math.random()*11);
		if (!(rand==takenB[0]||rand==takenB[1]||rand==takenB[2]||rand==takenB[3]||rand==takenB[4]||rand==takenB[5]||rand==takenB[6]))// Ensures it is a unique
		    picked = false;
	    }
	    takenB[i] = rand;
	    itemInformation[i][2] = potentialPositions[rand][0];      // Assigns the new random item's x axis
	    itemInformation[i][3] = potentialPositions[rand][1];      // Assigns the new random item's y axis
	    // Select found status
	    itemInformation[i][4] = "false";                    // Assigns the new random item find status (its not found yet) ("false" represents not found, "true" represents found)
	    // Select random mutiple choice answers
	    String[] takenC = {"999","999","999","999"}; // already taken multiple choice answers (constraints contained within a specific item)
	    rand = (int)(Math.random()*4) + 1; // Generates a random position to put the real answer
	    String r = "";
	    if (rand == 1)
		r = "1";
	    if (rand == 2)
		r = "2";
	    if (rand == 3)
		r = "3";
	    if (rand == 4)
		r = "4";
	    itemInformation[i][4+rand] = itemInformation[i][1]; // Stores the correct answer
	    itemInformation[i][9] = r; // Stores the correct answer position
	    takenC[rand-1] = itemInformation[i][1];
	    
	    // Adds the 3 filler answers
	    for (int j = 0; j < 4; j++){                        // Generates a random position to put a fake answer
		if (j!=rand-1) // Ensures it is a unique fake answer
		{   
		    picked = true;
		    while (picked==true){
			int randI = (int)(Math.random()*9);
			String randC = itemName[randI];
			if (!(randC.equals(takenC[0])||randC.equals(takenC[1])||randC.equals(takenC[2])||randC.equals(takenC[3])))  // Ensures it is a unique fake answer
			{
			    takenC[j] = randC;
			    picked = false;
			}
		    }
		}
	    }
	    // Stores the multiple choice anwsers 
	    itemInformation[i][5] = takenC[0];
	    itemInformation[i][6] = takenC[1];
	    itemInformation[i][7] = takenC[2];
	    itemInformation[i][8] = takenC[3];
	}
       
	// PLAY
	while (questionsLeft!=0){//and is in correct pos
	    c.setColor(backgroundColour);
	    if (c.isCharAvail()) // Detect Input
	    {
		movementInput = c.getChar(); // Get the input
		// MOVES ACCORDINGLY TO INPUT (mazeCollisionDetection ensures the user stays within the maze)
		if (movementInput == 'w' && mazeCollisionDetection(playerX,playerY-2)) 
		{
		    playerY-=2; // change character position
		    playerModelPhase = 1; // change model phase
		    c.fillRect(playerX,playerY+32,32,2); // Redraw background portion
		}
		if (movementInput == 'a' && mazeCollisionDetection(playerX-2,playerY))
		{
		    playerX-=2; // change character position
		    playerModelPhase = 2; // change model phase
		    c.fillRect(playerX+32,playerY,2,32); // Redraw background portion
		}
		if (movementInput == 's' && mazeCollisionDetection(playerX,playerY+2))
		{
		    playerY+=2; // change character position
		    playerModelPhase = 0; // change model phase
		    c.fillRect(playerX,playerY-2,32,2); // Redraw background portion
		}
		if (movementInput == 'd' && mazeCollisionDetection(playerX+2,playerY))
		{
		    playerX+=2; // change character position
		    playerModelPhase = 3; // change model phase
		    c.fillRect(playerX-2,playerY,2,32); // Redraw background portion
		}
		// Redraw maze borders and player
		try
		{
		BufferedImage mazeBorders = ImageIO.read(new File("IMAGEfolder\\IMAGEmazeBorders.gif"));
		BufferedImage player = ImageIO.read(new File(playerModels[playerModelPhase]));
		c.drawImage(mazeBorders,0,0,null);
		c.drawImage(player,playerX,playerY,null);
		} catch (IOException e){new Message ("Error regarding characterModels!","DOWNLOAD ERROR");}
	    }
	    // Redraw Items
	    try
	    {
		if (itemInformation[0][4].equals("false"))
		{
		    BufferedImage drawing = ImageIO.read(new File(itemInformation[0][0]));
		    c.drawImage(drawing,Integer.parseInt(itemInformation[0][2]),Integer.parseInt(itemInformation[0][3]),null);
		}
		if (itemInformation[1][4].equals("false"))
		{
		    BufferedImage drawing = ImageIO.read(new File(itemInformation[1][0]));
		    c.drawImage(drawing,Integer.parseInt(itemInformation[1][2]),Integer.parseInt(itemInformation[1][3]),null);
		}
		if (itemInformation[2][4].equals("false"))
		{
		    BufferedImage drawing = ImageIO.read(new File(itemInformation[2][0]));
		    c.drawImage(drawing,Integer.parseInt(itemInformation[2][2]),Integer.parseInt(itemInformation[2][3]),null);
		}
		if (itemInformation[3][4].equals("false"))
		{
		    BufferedImage drawing = ImageIO.read(new File(itemInformation[3][0]));
		    c.drawImage(drawing,Integer.parseInt(itemInformation[3][2]),Integer.parseInt(itemInformation[3][3]),null);
		}
		if (itemInformation[4][4].equals("false"))
		{
		    BufferedImage drawing = ImageIO.read(new File(itemInformation[4][0]));
		    c.drawImage(drawing,Integer.parseInt(itemInformation[4][2]),Integer.parseInt(itemInformation[4][3]),null);
		}
		if (itemInformation[5][4].equals("false"))
		{
		    BufferedImage drawing = ImageIO.read(new File(itemInformation[5][0]));
		    c.drawImage(drawing,Integer.parseInt(itemInformation[5][2]),Integer.parseInt(itemInformation[5][3]),null);
		}
		if (itemInformation[6][4].equals("false"))
		{
		    BufferedImage drawing = ImageIO.read(new File(itemInformation[6][0]));
		    c.drawImage(drawing,Integer.parseInt(itemInformation[6][2]),Integer.parseInt(itemInformation[6][3]),null);
		}
	    } catch (IOException e){new Message ("Error regarding characterModels!","DOWNLOAD ERROR");}
	    // IF ITEM IS TOUCHED (go to its question)
	    if (Integer.parseInt(itemInformation[0][2])-30 <= playerX && playerX <= Integer.parseInt(itemInformation[0][2])+30 && Integer.parseInt(itemInformation[0][3])-30 <= playerY && playerY <= Integer.parseInt(itemInformation[0][3])+30&&itemInformation[0][4].equals("false"))
	    {
		question(0,itemInformation);
		itemInformation[0][4] = "true";
	    }
	    if (Integer.parseInt(itemInformation[1][2])-30 <= playerX && playerX <= Integer.parseInt(itemInformation[1][2])+30 && Integer.parseInt(itemInformation[1][3])-30 <= playerY && playerY <= Integer.parseInt(itemInformation[1][3])+30&&itemInformation[1][4].equals("false"))
	    {
		question(1,itemInformation);
		itemInformation[1][4] = "true";
	    }
	    if (Integer.parseInt(itemInformation[2][2])-30 <= playerX && playerX <= Integer.parseInt(itemInformation[2][2])+30 && Integer.parseInt(itemInformation[2][3])-30 <= playerY && playerY <= Integer.parseInt(itemInformation[2][3])+30&&itemInformation[2][4].equals("false"))
	    {
		question(2,itemInformation);
		itemInformation[2][4] = "true";
	    }
	    if (Integer.parseInt(itemInformation[3][2])-30 <= playerX && playerX <= Integer.parseInt(itemInformation[3][2])+30 && Integer.parseInt(itemInformation[3][3])-30 <= playerY && playerY <= Integer.parseInt(itemInformation[3][3])+30&&itemInformation[3][4].equals("false"))
	    {
		question(3,itemInformation);
		itemInformation[3][4] = "true";
	    }
	    if (Integer.parseInt(itemInformation[4][2])-30 <= playerX && playerX <= Integer.parseInt(itemInformation[4][2])+30 && Integer.parseInt(itemInformation[4][3])-30 <= playerY && playerY <= Integer.parseInt(itemInformation[4][3])+30&&itemInformation[4][4].equals("false"))
	    {
		question(4,itemInformation);
		itemInformation[4][4] = "true";
	    }
	    if (Integer.parseInt(itemInformation[5][2])-30 <= playerX && playerX <= Integer.parseInt(itemInformation[5][2])+30 && Integer.parseInt(itemInformation[5][3])-30 <= playerY && playerY <= Integer.parseInt(itemInformation[5][3])+30&&itemInformation[5][4].equals("false"))
	    {
		question(5,itemInformation);
		itemInformation[5][4] = "true";
	    }
	    if (Integer.parseInt(itemInformation[6][2])-30 <= playerX && playerX <= Integer.parseInt(itemInformation[6][2])+30 && Integer.parseInt(itemInformation[6][3])-30 <= playerY && playerY <= Integer.parseInt(itemInformation[6][3])+30&&itemInformation[6][4].equals("false"))
	    {
		question(6,itemInformation);
		itemInformation[6][4] = "true";
	    }
	    // EXIT 
	    if (itemInformation[0][4].equals("true")&&itemInformation[1][4].equals("true")&&itemInformation[2][4].equals("true")&&itemInformation[3][4].equals("true")&&itemInformation[4][4].equals("true")&&itemInformation[5][4].equals("true")&&itemInformation[6][4].equals("true")&&playerY<=100&&playerX>=113&&playerX<=216)
		break;
	}
    }
    private void question (int specificItem, String[][] information)
    {
	// Variables 
	// These are just colours
	Color questionBackground = new Color (200,200,200);
	Color questionOptionOne = new Color (224, 26, 62);
	Color questionOptionTwo = new Color (19, 102, 205);
	Color questionOptionThree = new Color (243, 173, 3);
	Color questionOptionFour = new Color (49, 218, 7);
	Color questionGreyed = new Color (148, 148, 148);
	String displayItem;
	
	// Question Pop Up
	// Container
	for (int i = 0; i < 150; i++)
	{
	    c.setColour(questionBackground);
	    c.fillRoundRect(100,250-i,440,10+(i*2),35,25);
	    try{Thread.sleep(5);}catch(Exception e){}
	}
	// Title
	c.setFont (new Font ("Arial", 1, 32));
	c.setColour(Color.black);
	String prompt = "What did you find???";
	for (int i = 0 ; i <= prompt.length () ; i++)
	{
	    c.drawString (prompt.substring (0, i), 161, 146);
	    try{Thread.sleep (65);}catch (Exception e){}
	} 
	// Option 1
	for (int i = 0; i < 20; i++)
	{
	    c.setColour(questionOptionOne);
	    c.fillRoundRect(135,284-i,179,10+(i*2),5,5);
	    try{Thread.sleep(5);}catch(Exception e){}
	}
	c.setFont (new Font ("Arial", 1, 13));
	c.setColour(Color.black);
	c.drawString ("Press [1] for : " + information[specificItem][5].toUpperCase(), 135, 284+10);
	// Option 2
	for (int i = 0; i < 20; i++)
	{
	    c.setColour(questionOptionTwo);
	    c.fillRoundRect(135+200,284-i,179,10+(i*2),5,5);
	    try{Thread.sleep(5);}catch(Exception e){}
	}
	c.setColour(Color.black);
	c.drawString ("Press [2] for : " + information[specificItem][6].toUpperCase(), 135+200, 284+10);
	// Option 3
	for (int i = 0; i < 20; i++)
	{
	    c.setColour(questionOptionThree);
	    c.fillRoundRect(135,284+62-i,179,10+(i*2),5,5);
	    try{Thread.sleep(5);}catch(Exception e){}
	}
	c.setColour(Color.black);
	c.drawString ("Press [3] for : " + information[specificItem][7].toUpperCase(), 135, 284+62+10);
	// Option 4
	for (int i = 0; i < 20; i++)
	{
	    c.setColour(questionOptionFour);
	    c.fillRoundRect(135+200,284+62-i,179,10+(i*2),5,5);
	    try{Thread.sleep(5);}catch(Exception e){}
	}
	c.setColour(Color.black);
	c.drawString ("Press [4] for : " + information[specificItem][8].toUpperCase(), 135+200, 284+62+10);
	// Image of item
	final String[] imageQuestionDisplayPath = {"IMAGEfolder\\IMAGEitems\\IMAGEbigshark.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigtriceratops.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigpterodactyl.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigtrex.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigtrash1.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigtrash2.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigtrash3.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigtrash5.jpg","IMAGEfolder\\IMAGEitems\\IMAGEbigtrash5.jpg"};
	int chosen = 0;
	if (information[specificItem][1].equals("shark")){
	    chosen = 0;
	} else if (information[specificItem][1].equals("triceratops")){
	    chosen = 1;
	} else if (information[specificItem][1].equals("pterodactyl")){
	    chosen = 2;
	} else if (information[specificItem][1].equals("trex")){
	    chosen = 3;
	} else {
	    chosen = 4;
	}
	// Draws a visual so user can see
	try
	{
	    BufferedImage itemInQuestion = ImageIO.read(new File(imageQuestionDisplayPath[chosen]));
	    c.drawImage(itemInQuestion,259,162,null);
	} catch (IOException e){}
	// Input
	try{Thread.sleep(5);}catch(Exception e){}
	boolean unFinished = true; // while the question has not been answered
	c.setColour(questionGreyed);
	while (unFinished == true)
	{   
	    char input = 'z';
	    if (c.isCharAvail())
	    {
		input = c.getChar();
	    }
	    if (input == '1'&&!information[specificItem][9].equals("1"))
	    {
		c.fillRoundRect(135,284-20,179,10+(20*2),5,5); // grey out incorrect answr
	    } else if (input == '1'&&information[specificItem][9].equals("1")){
		unFinished = false;
	    }
	    if (input == '2'&&!information[specificItem][9].equals("2"))
	    {
		c.fillRoundRect(135+200,284-20,179,10+(20*2),5,5); // grey out incorrect answr
	    } else if (input == '2'&&information[specificItem][9].equals("2")){
		unFinished = false;
	    }
	    if (input == '3'&&!information[specificItem][9].equals("3"))
	    {
		c.fillRoundRect(135,284+62-20,179,10+(20*2),5,5); // grey out incorrect answr
	    } else if (input == '3'&&information[specificItem][9].equals("3")){
		unFinished = false;
	    }
	    if (input == '4'&&!information[specificItem][9].equals("4"))
	    {
		c.fillRoundRect(135+200,284+62-20,179,10+(20*2),5,5); // grey out incorrect answr
	    } else if (input == '4'&&information[specificItem][9].equals("4")){
		unFinished = false;
	    }
	}
	// Leave
	// DRAW IMAGE (MAZE)
	try
	{
	    BufferedImage maze = ImageIO.read(new File("IMAGEfolder\\IMAGEmaze.jpg"));
	    c.drawImage(maze,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEmaze.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
    }
    private boolean mazeCollisionDetection (int xAxis, int yAxis) // Detects if a particular movement can be made
    {
	boolean noRestriciton = true; 
	if ( // all the restrictions
	    ((0-30 < xAxis && xAxis < 113)&&(379-30 < yAxis && yAxis < 406))||
	    ((94-30 < xAxis && xAxis < 110)&&(326-30 < yAxis && yAxis < 402))||
	    ((92-30 < xAxis && xAxis < 354)&&(340-30 < yAxis && yAxis < 350))||
	    ((326-30 < xAxis && xAxis < 359)&&(208-30 < yAxis && yAxis < 395))||
	    ((-60-30 < xAxis && xAxis < 45)&&(0-30 < yAxis && yAxis < 540))||
	    ((592-30 < xAxis && xAxis < 700)&&(0-30 < yAxis && yAxis < 540))||
	    ((-60-30 < xAxis && xAxis < 700)&&(460-30 < yAxis && yAxis < 540))||
	    ((-60-30 < xAxis && xAxis < 700)&&(0-30 < yAxis && yAxis < 50)) || // gate
	    ((328-30 < xAxis && xAxis < 394)&&(208-30 < yAxis && yAxis < 230)) ||
	    ((-30-30 < xAxis && xAxis < 138)&&(263-30 < yAxis && yAxis < 295)) ||
	    ((151-30 < xAxis && xAxis < 225)&&(388-30 < yAxis && yAxis < 415)) ||
	    ((151-30 < xAxis && xAxis < 178)&&(388-30 < yAxis && yAxis < 473)) ||
	    ((275-30 < xAxis && xAxis < 295)&&(392-30 < yAxis && yAxis < 471)) ||
	    ((392-30 < xAxis && xAxis < 410)&&(344-30 < yAxis && yAxis < 465)) ||
	    ((395-30 < xAxis && xAxis < 460)&&(273-30 < yAxis && yAxis < 297)) ||
	    ((443-30 < xAxis && xAxis < 467)&&(298-30 < yAxis && yAxis < 393)) ||
	    ((455-30 < xAxis && xAxis < 597)&&(392-30 < yAxis && yAxis < 415)) ||
	    ((500-30 < xAxis && xAxis < 543)&&(236-30 < yAxis && yAxis < 345)) ||
	    ((506-30 < xAxis && xAxis < 562)&&(328-30 < yAxis && yAxis < 351)) ||
	    ((522-30 < xAxis && xAxis < 700)&&(271-30 < yAxis && yAxis < 289)) ||
	    ((524-30 < xAxis && xAxis < 546)&&(46-30 < yAxis && yAxis < 133)) ||
	    ((445-30 < xAxis && xAxis < 470)&&(38-30 < yAxis && yAxis < 231)) ||
	    ((396-30 < xAxis && xAxis < 449)&&(161-30 < yAxis && yAxis < 171)) ||
	    ((326-30 < xAxis && xAxis < 399)&&(97-30 < yAxis && yAxis < 112)) ||
	    ((326-30 < xAxis && xAxis < 346)&&(106-30 < yAxis && yAxis < 173)) ||
	    ((172-30 < xAxis && xAxis < 349)&&(148-30 < yAxis && yAxis < 175)) ||
	    ((266-30 < xAxis && xAxis < 279)&&(47-30 < yAxis && yAxis < 115)) ||
	    ((107-30 < xAxis && xAxis < 223)&&(87-30 < yAxis && yAxis < 120)) ||
	    ((92-30 < xAxis && xAxis < 117)&&(33-30 < yAxis && yAxis < 99)) ||
	    ((38-30 < xAxis && xAxis < 107)&&(150-30 < yAxis && yAxis < 170)) ||
	    ((95-30 < xAxis && xAxis < 115)&&(170-30 < yAxis && yAxis < 229)) ||
	    ((102-30 < xAxis && xAxis < 267)&&(214-30 < yAxis && yAxis < 231)) ||
	    ((265-30 < xAxis && xAxis < 267)&&(228-30 < yAxis && yAxis < 288)) ||
	    ((214-30 < xAxis && xAxis < 267)&&(273-30 < yAxis && yAxis < 290)) 
	    ) // Condition
	{
	    noRestriciton = false;
	}
	
	return noRestriciton; // return true if player can move in a position, and false if they cannot which will restrict their movement
    }
    public void end ()  // Maze End
    {
	// VARIABLES USED
	// Global
	// Local (Just animation variables)
	    int subtleAnimation = 0;
	    int subtleAnimationAdjuster = 1;
	    Color subtleAnimationColour;
	    Color subtleAnimaionColourTwo = new Color (197,94,46);
	    
	// DRAWS IMAGE
	try
	{
	    BufferedImage mazeEnd = ImageIO.read(new File("IMAGEfolder\\IMAGEmazeEnd.jpg"));
	    c.drawImage(mazeEnd,0,0,null);
	} catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEmazeEnd.jpg exists within IMAGEfolder","DOWNLOAD ERROR");}
	
	// GETS INPUT
	while (true) // Subtle Animation (because better UI :\)
	{
	    // Input processing section
	    if (c.isCharAvail()) // Input secttion
	    {
		break;
	    }
	    c.setColour(subtleAnimaionColourTwo);
	    c.fillRect(0,0,10,500);
	    c.fillRect(630,0,10,500);
	    subtleAnimationColour = new Color(196-(int)(subtleAnimation/7), 94-(int)(subtleAnimation/7), 46-(int)(subtleAnimation/7));
	    c.setColour(subtleAnimationColour);
	    c.fillRect(0,250+subtleAnimation,10,10);
	    c.fillRect(0,250-subtleAnimation,10,10);
	    c.fillRect(630,250+subtleAnimation,10,10);
	    c.fillRect(630,250-subtleAnimation,10,10);
	    if (subtleAnimation==250){
		subtleAnimationAdjuster=-1;}
	    if (subtleAnimation==0){
		subtleAnimationAdjuster=1;}
	    subtleAnimation+=subtleAnimationAdjuster;
	    try{Thread.sleep(5);}catch(Exception e){}
	}
    }
    public MazeOfLearning (Console con)
    {
	c = con;
	introduction();
	if (playMaze==true)
	{
	    maze();
	}
	end();
    }
}
