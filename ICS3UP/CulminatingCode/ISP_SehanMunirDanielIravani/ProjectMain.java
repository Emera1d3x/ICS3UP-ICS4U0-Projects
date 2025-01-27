/*
*   ICS3 CULMINATING
*   Sehan Munir, Daniel Iravani
*   Dec 30,2023
*   ICS3UP_MS.Krasteva
*/

/* BASIC PROGRAM FLOW //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				    (INSTRUCTIONS & REGULAR LEARNING BOOK)
							 /\
							 |     (MAZE OF LEARNING)
							 |           /\
							 |        ___/
							 |    ___/
							\/   \/
		(INTRODUCTION ANIMATION) ---------> (MAIN MENU) <------------------->(GAME OF TESTING)----> [add scores to]{scores.txt}
						   /\   /\   \__
						   /     |      \__
						  /      |         \__
					      ___/       |            \
					     \/          |            \/
				    (LEADERBOARD)        |          (EXIT)
				     /\                  |
				     /                   \/
				    /                (CREDITS)
				   /
       [gives scores from]{scores.txt}(return method)

*/ ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// CITATIONS
/*
	@GameOfTesting Line: 517
	https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
	(This helped me quickly append/add information at the bottom of a text file (the second parameter to file writer))
	PrintWriter adder = new PrintWriter (new BufferedWriter (new FileWriter ("scores.txt", true)));
	
	@GameOfTesting Line: 169
	https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
	(This tells us how to convert an integer to a string)
	bonesInformation [i] [2] = Integer.toString (rand);
	
	@Various different places
	https://hsa.larry.science/hsa/console
	(This tells us how to quickly find out if a char is being pressed)
	c.isCharAvail(); - boolean output

*/
// This portion was created by Sehan
//IMPORTS
import hsa.*; // Console and Error Message
import javax.swing.*;
import java.awt.*;
import java.awt.image.*; // Helps with image
import java.io.*;
import javax.imageio.ImageIO; // Helps with image
import java.util.*; // Utilities such as buffered reader

public class ProjectMain // Public Class
{
/*
    Global Variable Dictionary

    Variable Type     Name                 Explanation
   --------------------------------------------------------------------------------------------------------------------|
   Console            c                  Console, variable that controls all input and display 
   int              choice               Controls the sub sections of the program where the user visits
   Colour           transitionColour     Just a colour used for some animation effects when travelling through main menu
   --------------------------------------------------------------------------------------------------------------------|

*/
    Console c; // Console Declaration
    int choice = 0; // Choice, this variable controls methods that the main menu declares
    Color transitionColour = new Color (197, 94, 46); // Colour for animation effects when changing screens
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void introductionAnimation ()  // Plays an animation
    {
	IntroductionAnimation conA = new IntroductionAnimation (c); // Creates Introduction Animation
	
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void instructionsLearning ()  // Creation of InstructionsLearning
    {
	// Variables
	// i is used in a for loop to create a transition effect when entering instructions learning
	// i is used in a for loop to create a transition effecet when exiting instructions learning
	// ii is used in a for loop to create a transition effecet when exiting instructions learning
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 640 ; i++)
	{
	    int coordsX[] = {i, i, i + 30, i + 1, i + 30, i + 1, i + 30, i + 1, i + 30, i + 1, i + 30, i + 1, i + 30};
	    int coordsY[] = {0, 500, 500, 450, 400, 350, 300, 250, 200, 150, 100, 50, 0};
	    c.fillPolygon (coordsX, coordsY, 13);
	    transitionColour = new Color (197 - ((int) i / 7), 94 - ((int) i / 7), 46);
	    c.setColour (transitionColour);
	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	transitionColour = new Color (197, 94, 46); // Resets transition colour

	// CREATION
	InstructionsLearning conC = new InstructionsLearning (c);

	// TRANSITION
	transitionColour = new Color (3, 215, 252);
	c.setColour (transitionColour);
	for (int i = 0 ; i < 50 ; i++)
	{
	    for (int ii = 0 ; ii < 64 ; ii++)
	    {
		c.fillRect (ii * 10, i * 10, 10, 10);
		try
		{
		    Thread.sleep (1);
		}
		catch (Exception e)
		{
		}
	    }
	    transitionColour = new Color (3, 215, 252 - (i * 3));
	    c.setColour (transitionColour);
	}
	transitionColour = new Color (197, 94, 46);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void mazePractice ()  // Creation of MazeOfLearning
    {
	// Variables
	// i is used in a for loop to create a transition effect when entering maze of learning
	// i is used in a for loop to create a transition effect when exiting maze of learning
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 64 ; i++)
	{
	    for (int ii = 0 ; ii < 50 ; ii++)
	    {
		c.fillRect (i * 10, ii * 10, 10, 10);
		try
		{
		    Thread.sleep (1);
		}
		catch (Exception e)
		{
		}
	    }
	    transitionColour = new Color (197 - (i), 94 - (i), 46);
	    c.setColour (transitionColour);
	}
	transitionColour = new Color (197, 94, 46);

	//CREATION
	MazeOfLearning conD = new MazeOfLearning (c);
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 64 ; i++)
	{
	    for (int ii = 0 ; ii < 50 ; ii++)
	    {
		c.fillRect (i * 10, ii * 10, 10, 10);
		try
		{
		    Thread.sleep (1);
		}
		catch (Exception e)
		{
		}
	    }
	    transitionColour = new Color (197 - (i), 94 - (i), 46);
	    c.setColour (transitionColour);
	}
	transitionColour = new Color (197, 94, 46);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void gameTesting ()  // Creation of Game
    {
	// Variables
	// i is used in a for loop to create a transition effect when entering game
	// i is used in a for loop to create a transition effect when exiting game
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 400 ; i++)
	{
	    c.drawOval (-150 + i, -150 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-151 + i, -150 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-149 + i, -150 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-150 + i, -151 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-150 + i, -149 + i, 940 - (i * 2), 800 - (i * 2));
	    transitionColour = new Color (197 - ((int) i / 5), 94 - ((int) i / 5), 46);
	    c.setColour (transitionColour);
	    try
	    {
		Thread.sleep (3);
	    }
	    catch (Exception e)
	    {
	    }
	}
	transitionColour = new Color (197, 94, 46);

	// CREATION
	GameOfTesting conE = new GameOfTesting (c);
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 400 ; i++)
	{
	    c.drawOval (-150 + i, -150 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-151 + i, -150 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-149 + i, -150 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-150 + i, -151 + i, 940 - (i * 2), 800 - (i * 2));
	    c.drawOval (-150 + i, -149 + i, 940 - (i * 2), 800 - (i * 2));
	    transitionColour = new Color (197 - ((int) i / 5), 94 - ((int) i / 5), 46);
	    c.setColour (transitionColour);
	    try
	    {
		Thread.sleep (3);
	    }
	    catch (Exception e)
	    {
	    }
	}
	transitionColour = new Color (197, 94, 46);
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void leaderboard ()  // The leaderboard
    {
	// Variables
	// i is used in a for loop to create a transition effect when entering leaderboard
	// String[] topTen is used to store the top 10 score's information
	// int amountOfLines is used to help get the scores and eventually store it 
	// String[] unsortedData is used to store the file data in an array where it is easier to modify/use
	// leaveInput is so the user can leave the program. If their leaveInput is a, it "nullifies" the scores
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 64 ; i++)
	{
	    for (int ii = 0 ; ii < 50 ; ii++)
	    {
		c.fillRect ((i * 10) + (ii * 10), (ii * 10), 10, 10);
		c.fillRect (((-i) * 10) + (ii * 10), (ii * 10), 10, 10);
		try
		{
		    Thread.sleep (1);
		}
		catch (Exception e)
		{
		}
	    }
	    transitionColour = new Color (197 - (i), 94 - (i), 46);
	    c.setColour (transitionColour);
	}
	transitionColour = new Color (197, 94, 46);
	
	// DRAWS BACKGROUND
	try
	{
	    BufferedImage leaderboard = ImageIO.read (new File ("IMAGEfolder\\IMAGEleaderboard.jpg")); 
	    c.drawImage (leaderboard, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEleaderboard.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}
	
	// DISPLAY LEADERBOARD
	//      STEP ONE : initialize topTen array
	String[] topTen = new String [20]; // Declaration
	for (int i = 0 ; i < 20 ; i += 2) // For loop that goes through the array and sets a default value
	{
	    topTen [i] = "EMPTY";
	    topTen [i + 1] = "0";
	}
	//      STEP TWO: Checks the amount of lines that exist
	int amountOfLines = 0; // Declare and initialize amountOfLines so it can help with the leaderboard process
	try
	{
	    BufferedReader checker = new BufferedReader (new FileReader ("scores.txt"));
	    while (checker.readLine () != null) // Essentially get the amount of lines and gives an idea of how much data there is
	    {
		amountOfLines++;
	    }
	}catch (IOException e){}
	//      STEP THREE: Put everything into an unsortedData
	String[] unsortedData = new String [amountOfLines * 2]; // This variable converts all the information from txt file to array
	try
	{
	    BufferedReader reader = new BufferedReader (new FileReader ("scores.txt"));
	    // Read Every Line
	    for (int i = 0 ; i < amountOfLines * 2 ; i += 2)
	    {
		// Read the line
		String currentLine = reader.readLine (); // Stores the line so it can modify
		int separationPoint = currentLine.indexOf (' '); // "scores.txt" store data so that the userName and userScore is seperated by a space
		String theName = currentLine.substring (0, separationPoint); // "extract" the name portion of the line
		String theScore = currentLine.substring (separationPoint + 1); // "extract" the score portion of the line
		unsortedData [i] = theName; // Put it into the data (in a very specific way/pattern so it can be accessed later)
		unsortedData [i + 1] = theScore; // Put it into the data (in a very specific way/pattern so it can be accessed later)
	    }
	    reader.close ();
	}catch (IOException e){}
	//      STEP FOUR: Sorting and giving correct information to topTen so it is ready to be displayed
	for (int i = 0 ; i < amountOfLines * 2 ; i += 2) // For loop that goes through all file data to see if it can go into the top ten
	{
	    String currentName = unsortedData [i]; // current user's name
	    String currentScore = unsortedData [i + 1]; // current user's score

	    for (int j = 0 ; j < 20 ; j += 2) // goes through the top 10 list to see if it can fit anywhere
	    {
		if (Integer.parseInt (currentScore) > Integer.parseInt (topTen [j + 1])) // if it can (essentially if the score is higher than a top 10 one,)
		{
		    // Swap the names and scores
		    String swapperName = topTen [j]; // swapperName is just for helping purposes
		    String swapperScore = topTen [j + 1]; //swapperScore is just for helping purposes
		    topTen [j + 1] = currentScore;
		    topTen [j] = currentName;
		    currentName = swapperName;
		    currentScore = swapperScore;
		}
	    } // through this loop it recursively sorts by moving scores down the list (say i get a third place score, this for loop moves everything down)
	}
	//      STEP FIVE: Display
	c.setFont (new Font ("Arial", 1, 15)); // Font chosen
	for (int i = 1 ; i < 11 ; i++) // Prints the places
	{
	    c.drawString (Integer.toString (i), 153, 165 + (i * 20)); // Prints the places
	} 
	// Prints all the information
	c.drawString (topTen [0], 280, 165 + (1 * 20));
	c.drawString (topTen [1], 451, 165 + (1 * 20));
	c.drawString (topTen [2], 280, 165 + (2 * 20));
	c.drawString (topTen [3], 451, 165 + (2 * 20));
	c.drawString (topTen [4], 280, 165 + (3 * 20));
	c.drawString (topTen [5], 451, 165 + (3 * 20));
	c.drawString (topTen [6], 280, 165 + (4 * 20));
	c.drawString (topTen [7], 451, 165 + (4 * 20));
	c.drawString (topTen [8], 280, 165 + (5 * 20));
	c.drawString (topTen [9], 451, 165 + (5 * 20));
	c.drawString (topTen [10], 280, 165 + (6 * 20));
	c.drawString (topTen [11], 451, 165 + (6 * 20));
	c.drawString (topTen [12], 280, 165 + (7 * 20));
	c.drawString (topTen [13], 451, 165 + (7 * 20));
	c.drawString (topTen [14], 280, 165 + (8 * 20));
	c.drawString (topTen [15], 451, 165 + (8 * 20));
	c.drawString (topTen [16], 280, 165 + (9 * 20));
	c.drawString (topTen [17], 451, 165 + (9 * 20));
	c.drawString (topTen [18], 280, 165 + (10 * 20));
	c.drawString (topTen [19], 451, 165 + (10 * 20));

	// INPUT TO MOVE ON
	char leaveInput = c.getChar ();
	// If the input states to erase data,
	if (leaveInput == 'a')
	    try
	    {
		PrintWriter writer = new PrintWriter (new FileWriter ("scores.txt")); // then do so
	    } catch (IOException e){}
	    
    } // And main method controls next method flow
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void credits ()  // The credits
    {
	// Variables
	// i is used in a for loop to create a transition effect when entering credits
	// leaveInput is used so the user can leave this method but also so they have time to read
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 64 ; i++)
	{
	    for (int ii = 0 ; ii < 25 ; ii++)
	    {
		c.fillRect (i * 10, ii * 20, 10, 10);
		c.fillRect (640 - i * 10, 490 - ii * 20, 10, 10);
		try
		{
		    Thread.sleep (1);
		}
		catch (Exception e)
		{
		}
	    }
	    transitionColour = new Color (197 - (i), 94 - (i), 46);
	    c.setColour (transitionColour);
	}
	transitionColour = new Color (197, 94, 46);

	// DRAWS IMAGE
	try
	{
	    BufferedImage credits = ImageIO.read (new File ("IMAGEfolder\\IMAGEcredits.jpg"));
	    c.drawImage (credits, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEcredits.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}

	// INPUT TO MOVE ON
	char leaveInput = c.getChar ();
    
     } // And main method controls next method flow
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void goodBye ()  // The end
    {
	// Variables
	// i is used in a for loop to create a transition effect when entering goodbye
	
	// TRANSITION
	c.setColour (transitionColour);
	for (int i = 0 ; i < 32 ; i++)
	{
	    for (int ii = 0 ; ii < 50 ; ii++)
	    {
		c.fillRect (i * 10, ii * 10, 10, 10);
		c.fillRect (640 - i * 10, 490 - ii * 10, 10, 10);
		try
		{
		    Thread.sleep (1);
		}
		catch (Exception e)
		{
		}
	    }
	    transitionColour = new Color (197 - (i * 2), 94 - (i * 2), 46);
	    c.setColour (transitionColour);
	}
	transitionColour = new Color (197, 94, 46);

	// DRAWS IMAGE
	try
	{
	    BufferedImage goodBye = ImageIO.read (new File ("IMAGEfolder\\IMAGEend.jpg"));
	    c.drawImage (goodBye, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEend.jpg exists within IMAGEfolder", "DOWNLOAD ERROR");}
	// METHOD ENDS
    } // Program ends
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void mainMenu ()  // The main menu
    {
	// VARIABLES USED
	// Global
	// int choice;
	// Local
	String choiceAsk = "0"; // Variable that asks user for information (when proper format, information will be given to "choice")
	choice = 0; // Resets value

	// DRAWS BACKGROUND
	try
	{
	    BufferedImage menu = ImageIO.read (new File ("IMAGEfolder\\IMAGEmenu.jpg"));
	    c.drawImage (menu, 0, 0, null);
	}catch (IOException e){new Message ("Image CANNOT load, ensure IMAGEmenu.jpg exists within IMAGEfolder", "DOWNLOAD ERROR"); }

	// USER INPUT FOR MAIN MENU CHOICE
	while (choice == 0)
	{
	    c.setCursor (19, 44); // Erases old inputs
	    c.print (' ', choiceAsk.length ());
	    c.setCursor (19, 44);
	    choiceAsk = c.readLine (); // Gets input
	    // Number Format Checker
	    try
	    {
		choice = Integer.parseInt (choiceAsk);
	    }catch (NumberFormatException e){new Message ("Please enter an INTEGER choice!", "Input Error"); }
	    // Range Checker
	    if ((choice != 1) && (choice != 2) && (choice != 3) && (choice != 4) && (choice != 5) && (choice != 6))
	    {
		new Message ("Please enter a valid option!", "Input Error");
		choice = 0; // Resets Value
	    }
	} // If input is correct, mainMenu is done
    } // And main method controls next program flow
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ProjectMain () // Constructor
    {
	c = new Console ("Day Dream of a Paleontologist");
    }
    // Main method, controls full program flow
    public static void main (String[] args)
    {
	ProjectMain z = new ProjectMain ();
	//z.introductionAnimation (); // Plays Splash Screen/ Introduction animation
	while (z.choice != 6) // The Main Menu Loop
	{
	    z.mainMenu ();
	    if (z.choice == 1) // If the choice is to read instructional text,
		z.instructionsLearning ();
	    if (z.choice == 2) // If the choice is to practice skills and go to the maze of quizzing,
		z.mazePractice ();
	    if (z.choice == 3) // If the choice is to play the game,
		z.gameTesting ();
	    if (z.choice == 4) // If choice is to check the leaderboard,
		z.leaderboard ();
	    if (z.choice == 5) // If the choice is to check credits.
		z.credits ();
	} // When while loop is done and the user chooses to exit
	z.goodBye ();
    }
}


