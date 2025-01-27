/**
* GAME OF TESTING
* Sehan Munir, Daniel Iravani
* Dec 30,2023
* ICS3UP_MS.Krasteva


					   
     beginGame --------------> playGame ----------> storeScore ----------> loseScreen (allows user to return to main menu)
				|                       |
				|                       |
				|                       |
				|                       |
				|                       |
			       \/                       \/
 collisionDetection <-------  level()           score stored in (scores.txt)
				|
				|
				|
				|
			       \/
			     question
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
// This essentially just creates the entire game section


public class GameOfTesting extends Thread // Public Class
{
    private Console c;
    boolean startGame = true;
    String userName = " ";
    boolean characterStatus = true;
    int userScore = 1;
    Color timerAndScore = new Color (162, 88, 60); // just a colour used
/*
    Global Variable Dictionary

    Variable Type     Name                 Explanation
   --------------------------------------------------------------------------------------------------------------------|
   Console            c                  Console, variable that controls all input and display 
   boolean            startGame          Moves on to the game when user decides to start
   String             userName           Essential information that identifies the person playing, it will be used to store the user's information too
   boolean            characterStatus    Controls whether the character has lost or not. If characterStatus is false, the game ends
   int                userScore          Along with userName, it is another essential information that will show up in the leaderboards. The higher this variable gets (through game progression), the harder the game is (more objects appear)
   --------------------------------------------------------------------------------------------------------------------|

*/
    public void beginGame ()  // Draws
    {
	// Variables
	// userName   stores the user's name and is an identification
	// userNameLength used for error trapping (20 character contraint)
	// unavailableCharacters is used to store characters that should not be used
	// incorrectCharacters sees how many characters are incorrect
	
	// Draws beginning image
	try
	{
	    BufferedImage reminder = ImageIO.read (new File ("IMAGEfolder\\IMAGEreminder.jpg"));
	    c.drawImage (reminder, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEreminder.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}
	// Input to move on 
	c.getChar ();
	// Game start image
	try
	{
	    BufferedImage gameStart = ImageIO.read (new File ("IMAGEfolder\\IMAGEgameStart.jpg"));
	    c.drawImage (gameStart, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEgameStart.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}
	// Takes name input
	while (true)
	{
	    // Erases bad input
	    c.setCursor (14, 20);
	    c.print (' ', userName.length ());
	    c.setCursor (14, 20);
	    // input
	    userName = c.readLine ();
	    int userNameLength = userName.length ();
	    int incorrectCharacters = 0; // The amount of incorrect characters inputted - should be 0 to work
	    String unavailableCharacters = new String ("\\/:*?\"<>|; 1234567890"); // unavailable characters that may crash computer or program
	    // Checks if input has any bad characters
	    for (int i = 0 ; i < userName.length () ; i++)
	    { // checks through every character
		for (int j = 0 ; j < 20 ; j++)
		{ // checks to see if no matches with any unavailableCharacters
		    if (userName.charAt (i) == unavailableCharacters.charAt (j))
		    { // if the character is matching with a disallowed one,
			incorrectCharacters++; // report it by adding to a variable
		    }
		}
	    }
	    // Error message for too long user name
	    if (userNameLength > 20)
	    {
		new Message ("Name length must be under 21", "INPUT ERROR");
	    }
	    // Error message for bad characters
	    if (incorrectCharacters != 0)
	    {
		new Message ("Unavailable characters have been added!", "INPUT ERROR");
	    }
	    // If these contraints are kept, move on
	    if (incorrectCharacters == 0 && userNameLength < 21)
	    { // incorrectCharacter variable count is at 0 and length is fine, meaning no errors
		break;
	    } // else, error message and the loop continues
	}
	// Draws game sand box
	try
	{
	    BufferedImage gameSandbox = ImageIO.read (new File ("IMAGEfolder\\IMAGEgameSandbox.jpg"));
	    c.drawImage (gameSandbox, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEgameSandbox.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}
    }


    public void playGame ()  // Draws
    {
	// Variables
	// beginTime   stores at what time the game begins
	// timePasssed stores current time, if current time is 60 seconds after the beginning, the game ends
	
	long beginTime = System.currentTimeMillis ();
	long timePassed;
	// While the game is going on
	while (characterStatus == true)
	{
	    // Timer redraw and shows user the score
	    c.setColour (timerAndScore);
	    c.fillRect (131, 18, 55, 30);
	    c.setColour (Color.black);
	    c.setFont (new Font ("Arial", 1, 17));
	    c.drawString (Integer.toString (userScore), 135, 42);
	    // the level section (this creates the correct amount of objects, allows character to move, checks for when character touches and such)
	    level (); 
	    // after a level is done, if the time is too long,
	    timePassed = (System.currentTimeMillis () - beginTime) / 1000;
	    if (timePassed >= 60)
	    {
		characterStatus = false; // end game
	    }
	    // the game can also end through level(), when garbage is touched or question is incorrectly answered
	}
    }
    private void level ()
    {
	// Variables
	// int           playerX         stores player x axis
	// int           playerY         stores player y axis
	// char          movementInput   listens for input and does things accordingly
	// int           playerModelPhase points to which index of playerModels should be displayed
	// String[]     playerModels    stores the image path to the correct model 
	// "objects"
	// int          amountBones    the amount of bones that spawn based on what level you are on
	// int          amountTrash    the amount of trash that spawn based on what level you are on
	// String[][]   bonesInformation     stores every bone's information (more detail is shown below)
	// String[][]   trashInformation     stores every trash's information (more detail is shown below)
	// int          bonesLeft             the amount of bones left, if 0 then the level has been passed, score will be updated, and new level will be generated
       
	int playerX = 262;
	int playerY = 206;
	char movementInput = ' ';
	int playerModelPhase = 0;
	final String[] playerModels = {"IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterDown.jpg", "IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterUp.jpg", "IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterLeft.jpg", "IMAGEfolder\\IMAGEcharacter\\IMAGEcharacterRight.jpg"};

	// Create objects
	int amountBones = (int) (userScore * 1.3);
	int amountTrash = (int) (userScore * 0.46);
	String[] [] bonesInformation = new String [amountBones] [10];
	String[] [] trashInformation = new String [amountTrash] [4];
	
	/*
	----------------------------------------------------------------------------------------------------------------------------------------
	  - Visualization of bones with example
		    ImagePath    ItemName         X       Y     found?    (          Multiple Choice Answers         ) Correct Answer Pos
	    Index       0            1            2       3       4             5          6         7          8               9
	(     0                    trex                          false        trex       shark  triceratop pterodactly          1
	      1                 pterodactyl                      false        trex       shark  triceratop pterodactly          4
	      2                    trex                          false        trex       shark  triceratop pterodactly          1
	      3                   shark                          false        trex       shark  triceratop pterodactly          2
	bones 4                 triceratop                       false        trex       shark  triceratop pterodactly          3
	      .
	      .
	      .
	   )  .
	----------------------------------------------------------------------------------------------------------------------------------------
	  - Visualization of bones with example
		    ImagePath     X       Y      found?
	    Index       0         1       2        3
	(     0                                  false
	      1                                  false
	      2                                  false
	      3                                  false
	trash 4                                  false
	      .
	      .
	      .
	   )  .
	----------------------------------------------------------------------------------------------------------------------------------------
	    */
	// IMAGE PATHS
	final String[] bonesImagePath = {"IMAGEfolder\\IMAGEitems\\IMAGEshark.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEtriceratops.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEpterodactyl.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEtrex.jpg"};
	final String[] bonesName = {"shark", "triceratops", "pterodactyl", "trex"};
	final String[] trashImagePath = {"IMAGEfolder\\IMAGEitems\\IMAGEtrash1.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEtrash2.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEtrash3.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEtrash5.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEtrash5.jpg"};

	// Fills in bone information
	for (int i = 0 ; i < amountBones ; i++)
	{
	    // Pick a random bone
	    int rand = (int) (Math.random () * 4);
	    // Image path given
	    bonesInformation [i] [0] = bonesImagePath [rand];
	    // Item name given
	    bonesInformation [i] [1] = bonesName [rand];
	    // This tells us how to convert an integer to a string (Official Info) https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
	    rand = (int) (Math.random () * (472)) + 55; // X Axis
	    bonesInformation [i] [2] = Integer.toString (rand);
	    rand = (int) (Math.random () * (276)) + 80; // Y Axis
	    bonesInformation [i] [3] = Integer.toString (rand);
	    bonesInformation [i] [4] = "false"; // Found status given
	    // Multiple choice answers given
	    bonesInformation [i] [5] = "shark";
	    bonesInformation [i] [6] = "triceratops";
	    bonesInformation [i] [7] = "pterodactyl";
	    bonesInformation [i] [8] = "trex";
	    // Answer position given
	    if (bonesInformation [i] [1].equals ("shark"))
		bonesInformation [i] [9] = "1";
	    if (bonesInformation [i] [1].equals ("triceratops"))
		bonesInformation [i] [9] = "2";
	    if (bonesInformation [i] [1].equals ("pterodactyl"))
		bonesInformation [i] [9] = "3";
	    if (bonesInformation [i] [1].equals ("trex"))
		bonesInformation [i] [9] = "4";
	}
	// Fills information for all trash
	for (int i = 0 ; i < amountTrash ; i++)
	{
	    // Pick a random trash
	    int rand = (int) (Math.random () * 5);
	    // Image path given
	    trashInformation [i] [0] = trashImagePath [rand];
	    // Picks coordinates
	    rand = (int) (Math.random () * (472)) + 55; // X Axis
	    trashInformation [i] [1] = Integer.toString (rand);
	    rand = (int) (Math.random () * (276)) + 80; // Y Axis
	    trashInformation [i] [2] = Integer.toString (rand);
	    // Found status
	    trashInformation [i] [3] = "false";
	}
	int bonesLeft = amountBones; // Amount of bones left on a particular level
	
	// First player drawing
	try
	{
	    BufferedImage player = ImageIO.read (new File (playerModels [playerModelPhase]));
	    c.drawImage (player, playerX, playerY, null);
	}catch (IOException e){new Message ("Error regarding characterModels!", "DOWNLOAD ERROR"); }
	
	// Allows user to play the level
	// while there is still bones left to catch and characterStatus (or lose) is not false
	while (bonesLeft != 0 && characterStatus)
	{
	    // REDRAW OBJECTS
	    try
	    {
		for (int i = 0 ; i < amountBones ; i++) // Go through every bone
		{
		    if (bonesInformation [i] [4].equals ("false")) // Draw bones that have not been found
		    {
			BufferedImage image = ImageIO.read (new File (bonesInformation [i] [0]));
			c.drawImage (image, Integer.parseInt (bonesInformation [i] [2]), Integer.parseInt (bonesInformation [i] [3]), null);
		    }
		}
		for (int i = 0 ; i < amountTrash ; i++) // Draws every trash
		{
		    BufferedImage image = ImageIO.read (new File (trashInformation [i] [0]));
		    c.drawImage (image, Integer.parseInt (trashInformation [i] [1]), Integer.parseInt (trashInformation [i] [2]), null);
		}
		BufferedImage player = ImageIO.read (new File (playerModels [playerModelPhase]));
		c.drawImage (player, playerX, playerY, null);
	    }catch (IOException e){new Message ("IMAGE NOT FOUND!", "DOWNLOAD ERROR");}

	    // Used to recolour background
	    Color backgroundColour = new Color (248, 236, 214);
	    c.setColour (backgroundColour);
	    // If there is input
	    if (c.isCharAvail ())
	    {
		c.setColor (backgroundColour);
		movementInput = c.getChar (); // Get the input
		// Moves the character accordingly (ensures that the character doesn't go out of bounds)
		if (movementInput == 'w' && collisionDetection (playerX, playerY - 2))
		{
		    playerY -= 2; // change character position
		    playerModelPhase = 1; // change model phase
		    c.fillRect (playerX, playerY + 32, 32, 2); // Redraw background portion
		}
		if (movementInput == 'a' && collisionDetection (playerX - 2, playerY))
		{
		    playerX -= 2; // change character position
		    playerModelPhase = 2; // change model phase
		    c.fillRect (playerX + 32, playerY, 2, 32); // Redraw background portion
		}
		if (movementInput == 's' && collisionDetection (playerX, playerY + 2))
		{
		    playerY += 2; // change character position
		    playerModelPhase = 0; // change model phase
		    c.fillRect (playerX, playerY - 2, 32, 2); // Redraw background portion
		}
		if (movementInput == 'd' && collisionDetection (playerX + 2, playerY))
		{
		    playerX += 2; // change character position
		    playerModelPhase = 3; // change model phase
		    c.fillRect (playerX - 2, playerY, 2, 32); // Redraw background portion
		}
		// Redraws character models
		try
		{
		    BufferedImage player = ImageIO.read (new File (playerModels [playerModelPhase]));
		    c.drawImage (player, playerX, playerY, null);
		}catch (IOException e){ new Message ("Error regarding characterModels!", "DOWNLOAD ERROR");}
	    }
	    // If a bone is touched
	    for (int i = 0 ; i < amountBones ; i++)
	    {
		if (Integer.parseInt (bonesInformation [i] [2]) - 30 <= playerX && playerX <= Integer.parseInt (bonesInformation [i] [2]) + 30 && Integer.parseInt (bonesInformation [i] [3]) - 30 <= playerY && playerY <= Integer.parseInt (bonesInformation [i] [3]) + 30 && bonesInformation [i] [4].equals ("false"))
		{
		    question (bonesInformation, i); // Question pop up
		    bonesInformation [i] [4] = "true";
		}
	    }
	    // If trash is touched
	    for (int i = 0 ; i < amountTrash ; i++)
	    {
		if (Integer.parseInt (trashInformation [i] [1]) - 30 <= playerX && playerX <= Integer.parseInt (trashInformation [i] [1]) + 30 && Integer.parseInt (trashInformation [i] [2]) - 30 <= playerY && playerY <= Integer.parseInt (trashInformation [i] [2]) + 30)
		{
		    characterStatus = false; // end game
		}
	    }
	    int z = 0;
	    for (int i = 0 ; i < amountBones ; i++)
	    {
		if (bonesInformation [i] [4].equals ("false"))
		{
		    z++;
		}
		bonesLeft = z;
	    }
	}
	// If all bones are touched
	if (bonesLeft == 0)
	{
	    userScore++; // the userScore goes up and a new level will be generated back in playGame()
	}
    }
    private void question (String[] [] information, int specific) // When a question is used, it takes all information, and the particular specific bone answer
    {
	// Variables
	// Colour variables - used to draw the pop up
	Color questionBackground = new Color (200, 200, 200);
	Color questionOptionOne = new Color (224, 26, 62);
	Color questionOptionTwo = new Color (19, 102, 205);
	Color questionOptionThree = new Color (243, 173, 3);
	Color questionOptionFour = new Color (49, 218, 7);
	// Variables
	// (explained below with their declaration)
	// Question Pop Up
	// Container
	for (int i = 0 ; i < 150 ; i++)
	{
	    c.setColour (questionBackground);
	    c.fillRoundRect (100, 250 - i, 440, 10 + (i * 2), 35, 25);
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	// Title
	c.setFont (new Font ("Arial", 1, 32));
	c.setColour (Color.black);
	String prompt = "What did you find???"; // Prompts user
	for (int i = 0 ; i <= prompt.length () ; i++) // Draws title in stylized way
	{
	    c.drawString (prompt.substring (0, i), 161, 146);
	    try
	    {
		Thread.sleep (65);
	    }
	    catch (Exception e)
	    {
	    }
	}
	// Option 1
	for (int i = 0 ; i < 20 ; i++)
	{
	    c.setColour (questionOptionOne);
	    c.fillRoundRect (135, 284 - i, 179, 10 + (i * 2), 5, 5);
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setFont (new Font ("Arial", 1, 13));
	c.setColour (Color.black);
	c.drawString ("Press [1] for : " + information [specific] [5].toUpperCase (), 135, 284 + 10);
	// Option 2
	for (int i = 0 ; i < 20 ; i++)
	{
	    c.setColour (questionOptionTwo);
	    c.fillRoundRect (135 + 200, 284 - i, 179, 10 + (i * 2), 5, 5);
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColour (Color.black);
	c.drawString ("Press [2] for : " + information [specific] [6].toUpperCase (), 135 + 200, 284 + 10);
	// Option 3
	for (int i = 0 ; i < 20 ; i++)
	{
	    c.setColour (questionOptionThree);
	    c.fillRoundRect (135, 284 + 62 - i, 179, 10 + (i * 2), 5, 5);
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColour (Color.black);
	c.drawString ("Press [3] for : " + information [specific] [7].toUpperCase (), 135, 284 + 62 + 10);
	// Option 4
	for (int i = 0 ; i < 20 ; i++)
	{
	    c.setColour (questionOptionFour);
	    c.fillRoundRect (135 + 200, 284 + 62 - i, 179, 10 + (i * 2), 5, 5);
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColour (Color.black);
	c.drawString ("Press [4] for : " + information [specific] [8].toUpperCase (), 135 + 200, 284 + 62 + 10);
	
	// Image paths
	final String[] imageQuestionDisplayPath = {"IMAGEfolder\\IMAGEitems\\IMAGEbigshark.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEbigtriceratops.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEbigpterodactyl.jpg", "IMAGEfolder\\IMAGEitems\\IMAGEbigtrex.jpg"};
	int chosen = 0; // the particular image needed
	if (information [specific] [1].equals ("shark"))
	{
	    chosen = 0;
	}
	else if (information [specific] [1].equals ("triceratops"))
	{
	    chosen = 1;
	}
	else if (information [specific] [1].equals ("pterodactyl"))
	{
	    chosen = 2;
	}
	else if (information [specific] [1].equals ("trex"))
	{
	    chosen = 3;
	}
	// displays the image
	try
	{
	    BufferedImage itemInQuestion = ImageIO.read (new File (imageQuestionDisplayPath [chosen]));
	    c.drawImage (itemInQuestion, 259, 162, null);
	}catch (IOException e){}
	// while the user has not answer or has gotten the question correct
	boolean notAnswered = true;
	while (characterStatus && notAnswered) // get the users answer
	{
	    char input = 'z'; // input
	    if (c.isCharAvail ()) // if something is being pressed,
	    {
		input = c.getChar (); // get input
		// the ifs check if the answer is wrong and ends the game
		// the if elses check if the answser is correct, and leaves the loop
		if (input == '1' && !information [specific] [1].equals ("shark"))
		{
		    characterStatus = false;
		}
		else if (input == '1' && information [specific] [1].equals ("shark"))
		{
		    notAnswered = false;
		}
		if (input == '2' && !information [specific] [1].equals ("triceratops"))
		{
		    characterStatus = false;
		}
		else if (input == '2' && information [specific] [1].equals ("triceratops"))
		{
		    notAnswered = false;
		}
		if (input == '3' && !information [specific] [1].equals ("pterodactyl"))
		{
		    characterStatus = false;
		}
		else if (input == '3' && information [specific] [1].equals ("pterodactyl"))
		{
		    notAnswered = false;
		}
		if (input == '4' && !information [specific] [1].equals ("trex"))
		{
		    characterStatus = false;
		}
		else if (input == '4' && information [specific] [1].equals ("trex"))
		{
		    notAnswered = false;
		}
	    }
	}
	try
	{
	    BufferedImage gameSandbox = ImageIO.read (new File ("IMAGEfolder\\IMAGEgameSandbox.jpg"));
	    c.drawImage (gameSandbox, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEgameSandbox.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}
	// Redraws timer and score
	c.setColour (timerAndScore);
	c.fillRect (131, 18, 55, 30);
	c.fillRect(562,416,60,65);
	c.setColour (Color.black);
	c.setFont (new Font ("Arial", 1, 17));
	c.drawString (Integer.toString (userScore), 135, 42);
    }
    private boolean collisionDetection (int xAxis, int yAxis) // RETURN METHOD, takes in the desired x and y, and returns if it is possible or if it goes out of bounds
    {
	// Variables
	//boolean noRestriction   returns true if there is no restrictions, false if it is (in level, it ends up disallowing particular movement)
	boolean noRestriction = true;
	if ((xAxis < 50) || (593 < xAxis + 30) || (yAxis < 76) || (400 < yAxis + 30))
	    noRestriction = false;
	return noRestriction; // return
    }


    public void storeScore ()  // Stores the score
    {
	try // Stores the score
	{
	    String checker = ""; // Checks if there is information on a particular line or not
	    BufferedReader oldStorage = new BufferedReader (new FileReader ("scores.txt"));
	    while ((checker = oldStorage.readLine ()) != null) // skips past all the proir scores/data
	    {
	    }
	    oldStorage.close ();
	    BufferedReader doublechecker = new BufferedReader (new FileReader ("scores.txt"));
	    PrintWriter adder = new PrintWriter (new BufferedWriter (new FileWriter ("scores.txt", true))); // essentially adds to the bottom of the txt file
	    while ((checker = doublechecker.readLine ()) != null) // if not empty, add enter, if empty don't add new line
	    {
		adder.println (); // adds information
	    }
	    adder.print (userName + " " + userScore); // adds information
	    adder.close ();

	}catch (IOException e){ new Message ("SCORE CANNOT BE STORED", "DOWNLOAD ERROR");}
    }


    public void loseScreen ()  // Draws
    {
	try // lose drawing
	{
	    BufferedImage gameEnd = ImageIO.read (new File ("IMAGEfolder\\IMAGEgameEnd.jpg"));
	    c.drawImage (gameEnd, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEgameEnd.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}
	// DISPLAYS SCORE
	c.setFont (new Font ("Arial", 1, 35));
	c.setColour (Color.black);
	c.drawString (Integer.toString (userScore), 194, 210);
	// INPUT TO LEAVE
	c.getChar ();
    }


    public GameOfTesting (Console con)
    {
	c = con;
	beginGame ();
	playGame ();
	storeScore ();
	loseScreen ();
    }
}
