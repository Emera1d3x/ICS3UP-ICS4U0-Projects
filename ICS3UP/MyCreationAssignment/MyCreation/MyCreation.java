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
// This is the MyCreation.java file. It contains the MyCreation class which controls all classes so their objects work properly
/////////////////////////////

// IMPORTS
import java.awt.*;
import hsa.Console;
// CLASS
public class MyCreation
{
    Console c; // Console Variable
    // BEGINNING/END SCREEN ///////////////////////////////////////////////////////////////////////
    public void beginningScreen ()// BEGINNING SCREEN
    {
	BeginningScreen a = new BeginningScreen (c); // constructor
    }
    public void endScreen ()  //BEGINNING SCREEN
    {
	EndScreen a = new EndScreen (c);  // constructor
	a.run(); // runs with implements Runnable
    }
    // BACKGROUNDS ///////////////////////////////////////////////////////////////////////
    public void forestOneBackground ()  // FOREST ONE
    {
	ForestOneBackground b = new ForestOneBackground (c);  // constructor
    }
    public void forestTwoBackground ()  // FOREST TWO
    {
	ForestTwoBackground d = new ForestTwoBackground (c);  // constructor
    }
    public void caveBackground ()  // CAVE
    {
	CaveBackground e = new CaveBackground (c);  // constructor
    }
    public void seasideBackground ()  // SEASIDE
    {
	SeasideBackground f = new SeasideBackground (c);  // constructor
    }
    // OBJECTS /////////////////////////////////////////////////////////////////////////////////// (All methods are threads from other classes. The code below are constructors + assigned parameters so it works correctly for its allocated scene + start function to begin thread.)
    public void childFacingRightObjectOne ()  // CHLID FACING RIGHT
    {
	ChildFacingRightObject g = new ChildFacingRightObject (c, 0, 3, 0, 0); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingRightObjectTwo ()  // CHLID FACING RIGHT
    {
	ChildFacingRightObject g = new ChildFacingRightObject (c, 250, 3, 0, 0); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingRightObjectThree ()  // CHLID FACING RIGHT
    {
	ChildFacingRightObject g = new ChildFacingRightObject (c, 460, 1, 0, 20); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingRightObjectFour ()  // CHLID FACING RIGHT
    {
	ChildFacingRightObject g = new ChildFacingRightObject (c, 460, 2, 450, -100); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingRightObjectFive ()  // CHLID FACING RIGHT
    {
	ChildFacingRightObject g = new ChildFacingRightObject (c, 250, 3, 0, 0); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingRightObjectSix ()  // CHLID FACING RIGHT
    {
	ChildFacingRightObject g = new ChildFacingRightObject (c, 350, 3, 404, 0); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingLeftObjectOne ()  // CHLID FACING LEFT
    {
	ChildFacingLeftObject g = new ChildFacingLeftObject (c, 400, 1, -135, 20); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingLeftObjectTwo ()  // CHLID FACING LEFT
    {
	ChildFacingLeftObject g = new ChildFacingLeftObject (c, 200, 3, -300, 20); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingLeftObjectThree ()  // CHLID FACING LEFT
    {
	ChildFacingLeftObject g = new ChildFacingLeftObject (c, 350, 3, -500, 0); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void childFacingLeftObjectFour ()  // CHLID FACING LEFT
    {
	ChildFacingLeftObject g = new ChildFacingLeftObject (c, 555, 2, -500, -100); // constructor + assigned parameters so it works correctly for its allocated scene
	g.start ();
    }
    public void unhealthyPonyObject ()  // UNHEALTHY PONY
    {
	PonyObject h = new PonyObject (c,false); // constructor + the "false" makes sure the PonyObject class is in the correct mode (depicting an unhealthy pony)
	h.start ();
    }
    public void healthyPonyObject ()  // UNHEALTHY PONY
    {
	PonyObject h = new PonyObject (c,true); // constructor + the "true" makes sure the PonyObject class is in the correct mode (depicting a health pony)
	h.start ();
    }
    public void fireObject ()  // FIRE
    {
	FireObject h = new FireObject (c); // constructor
	h.start ();
    }
    public void phoenixObject ()  // PHOENIX OBJECT
    {
	PhoenixObject h = new PhoenixObject (c); // constructor
	h.start ();
    }
    public void pegasusObject ()  // PHOENIX OBJECT
    {
	PegasusObject h = new PegasusObject (c); // constructor
	h.start ();
    }
    public void birdObject ()  // BIRD OBJECT - OVERLOADED
    {
	Color specialBird = new Color (255, 0, 0); // i used this colour variable to reduce some proccessing glitches
	BirdObject i1 = new BirdObject (c); // creates a bird
	i1.start ();
	BirdObject i2 = new BirdObject (c, 30, Color.black); // creates a bird (different position, different colour)
	i2.start ();
	BirdObject i3 = new BirdObject (c, 15, specialBird, 40); // creates a bird (different position, different colour, different speed)
	i3.start ();
    }
    public void portalObject ()  // PORTAL
    {
	PortalObject j = new PortalObject (c); // constructor
	j.start ();
    }
    public void portalTransitionObject ()  // PORTAL
    {
	PortalTransitionObject j = new PortalTransitionObject (c); // constructor
	j.start ();
    }
    public void saplingsObjectOne ()  // SAPLING
    {
	SaplingsObject z = new SaplingsObject (c, 206, 302, 170, 1, false, false); // creates a sapling that has the correct parameters for the scene (console, position x, position y, movement x, movement y, movement direction to the right?, does the sapling grow?)
	z.start ();
	try // this makes sure that the next method (textBoxObject33) plays after this method FINISHES
	{
	    z.join ();
	}
	catch (InterruptedException e)
	{
	}
    }
    public void saplingsObjectTwo ()  // SAPLINGS
    {
	SaplingsObject z = new SaplingsObject (c, 288, 381, -50, 3, true, true); // creates a sapling that has the correct parameters for the scene (console, position x, position y, movement x, movement y, movement direction to the right?, does the sapling grow?)
	z.start ();
	SaplingsObject n = new SaplingsObject (c, 267, 409, -50, 3, true, true); // creates a sapling that has the correct parameters for the scene (console, position x, position y, movement x, movement y, movement direction to the right?, does the sapling grow?)
	n.start ();
	SaplingsObject m = new SaplingsObject (c, 425, 366, 50, 3, true, false); // creates a sapling that has the correct parameters for the scene (console, position x, position y, movement x, movement y, movement direction to the right?, does the sapling grow?)
	m.start ();
	try // this makes sure that the next method (childFacingRightObjectSix) plays after this method FINISHES
	{
	    z.join ();
	}
	catch (InterruptedException e)
	{
	}
    }
    // TEXT BOXES ///////////////////////////////////////////////////////////////////////
    // Every text box gets constructed
    // The parameters include the console, coordinates, size, background refill colour, and text (More information is in the class)
    public void textBoxObject1 () // Text Box 1
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Child: Woah, what is this place?", 1);
	k.start ();
    }
    public void textBoxObject2 () // Text Box 2
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Child: Pony?", 1);
	k.start ();
    }
    public void textBoxObject3 () // Text Box 3
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Magical Pony: i.. n-need your help... please", 1);
	k.start ();
    }
    public void textBoxObject4 () // Text Box 4
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Child: huh?", 1);
	k.start ();
    }
    public void textBoxObject5 ()  // Text Box 5
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Magical Pony: h- heal my forest...", 1);
	k.start ();
    }
    public void textBoxObject6 ()  // Text Box 6
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Child: Wow your flames are beautiful.. and brutal", 3);
	k.start ();
    }
    public void textBoxObject7 ()  // Text Box 7
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: Yes, I agree...", 3);
	k.start ();
    }
    public void textBoxObject8 ()  // Text Box 8
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Child: but, it seems that its destroying the environment...", 3);
	k.start ();
    }
    public void textBoxObject9 ()  // Text Box 9
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Child: ... its hurting the pony..", 3);
	k.start ();
    }
    public void textBoxObject10 ()  // Text Box 10
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: Ah, my own lacking..", 3);
	k.start ();
    }
    public void textBoxObject11 ()  // Text Box 11
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: This forest hath been scarse for decades", 3);
	k.start ();
    }
    public void textBoxObject12 ()  // Text Box 12
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: 'twere so ill that", 3);
	k.start ();
    }
    public void textBoxObject13 ()  // Text Box 13
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: Methought 'twere uncharted territory", 3);
	k.start ();
    }
    public void textBoxObject14 ()  // Text Box 14
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Child: ..huh?", 3);
	k.start ();
    }
    public void textBoxObject15 ()  // Text Box 15
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: I shall pick up mine flames and depart", 3);
	k.start ();
    }
    public void textBoxObject16 ()  // Text Box 16
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Child: Wow! Thank you!", 3);
	k.start ();
    }
    public void textBoxObject17 ()  // Text Box 17
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: Thy journey is not finished now", 3);
	k.start ();
    }
    public void textBoxObject18 ()  // Text Box 18
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: You shall meet the Pegasus and he'll heal this world", 3);
	k.start ();
    }
    public void textBoxObject19 ()  // Text Box 19
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Phoenix: You will now get teleported", 3);
	k.start ();
    }
    public void textBoxObject20 ()  // Text Box 20
    {
	TextBox k = new TextBox (c, 274, 386, 369, 49, "Child: huh? Wait WHA-", 3);
	k.start ();
    }
    public void textBoxObject21 ()  // Text Box 21
    {
	TextBox k = new TextBox (c, 373, 460, 254, 30, "Child: whoa.. where am I?", 2);
	k.start ();
    }
    public void textBoxObject22 ()  // Text Box 22
    {
	TextBox k = new TextBox (c, 373, 460, 254, 30, "Child: Oh! Its a horse with wings!", 2);
	k.start ();
    }
    public void textBoxObject23 ()  // Text Box 23
    {
	TextBox k = new TextBox (c, 47, 464, 254, 30, "Pegasus: That would be called a Pegasus", 2);
	k.start ();
    }
    public void textBoxObject24 ()  // Text Box 24
    {
	TextBox k = new TextBox (c, 47, 464, 234, 30, "Pegasus: Young one", 2);
	k.start ();
    }
    public void textBoxObject25 ()  // Text Box 25
    {
	TextBox k = new TextBox (c, 47, 464, 234, 30, "Pegasus: I expected you", 2);
	k.start ();
    }
    public void textBoxObject26 ()  // Text Box 26
    {
	TextBox k = new TextBox (c, 373, 460, 254, 30, "Child: huh, what do you mean?", 2);
	k.start ();
    }
    public void textBoxObject27 ()  // Text Box 27
    {
	TextBox k = new TextBox (c, 47, 464, 264, 30, "Pegasus: You people have been destroying.. ", 2);
	k.start ();
    }
    public void textBoxObject28 ()  // Text Box 28
    {
	TextBox k = new TextBox (c, 47, 464, 264, 30, "Pegasus: ...the environment for far too long..", 2);
	k.start ();
    }
    public void textBoxObject29 ()  // Text Box 29
    {
	TextBox k = new TextBox (c, 47, 464, 264, 30, "Pegasus: ...it was about time that one of you..", 2);
	k.start ();
    }
    public void textBoxObject30 ()  // Text Box 30
    {
	TextBox k = new TextBox (c, 47, 464, 254, 30, "Pegasus: ..wanted to help out...", 2);
	k.start ();
    }
    public void textBoxObject31 ()  // Text Box 31
    {
	TextBox k = new TextBox (c, 373, 460, 254, 30, "Child: huh?", 2);
	k.start ();
    }
    public void textBoxObject32 ()  // Text Box 32
    {
	TextBox k = new TextBox (c, 47, 464, 254, 30, "Pegasus: Here take these saplings", 2);
	k.start ();
    }
    public void textBoxObject33 ()  // Text Box 33
    {
	TextBox k = new TextBox (c, 47, 464, 254, 30, "Pegasus: Farewell youngling", 2);
	k.start ();
    }
    public void textBoxObject34 ()  // Text Box 34
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Child: Pony! You're okay!", 1);
	k.start ();
    }
    public void textBoxObject35 ()  // Text Box 35
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Magical Pony: Yes, thanks to you!", 1);
	k.start ();
    }
    public void textBoxObject36 ()  // Text Box 36
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Magical Pony: You showed us that with the effort..", 1);
	k.start ();
    }
    public void textBoxObject37 ()  // Text Box 37
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Magical Pony: ...and the awareness...", 1);
	k.start ();
    }
    public void textBoxObject38 ()  // Text Box 38
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Magical Pony: You can save the environment!", 1);
	k.start ();
    }
    public void textBoxObject39 ()  // Text Box 39
    {
	TextBox k = new TextBox (c, 134, 64, 369, 49, "Magical Pony: Go plant some more trees!", 1);
	k.start ();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    // CREATES CONSOLE
    public MyCreation ()
    {
	c = new Console ("Magical Creatures Story - By Sehan Munir"); // Assigns Console variable c to new Console
    }
    // MAIN METHOD - all methods that are pointing towards other classes with parameters are controlled like a timeline in here
    public static void main (String[] args)
    {
	MyCreation z = new MyCreation ();
	z.beginningScreen (); // Beginning Screen
	z.forestOneBackground (); // Scene 1
	z.childFacingRightObjectOne ();
	z.birdObject (); // (Overloaded Object)
	z.forestTwoBackground (); // Scene 2
	z.childFacingRightObjectTwo ();
	z.caveBackground (); // Scene 3
	z.childFacingRightObjectThree ();
	z.textBoxObject1 ();
	z.unhealthyPonyObject();
	z.textBoxObject2();
	z.textBoxObject3();
	z.textBoxObject4();
	z.textBoxObject5();
	z.childFacingLeftObjectOne ();
	z.forestTwoBackground (); // Scene 4
	z.childFacingLeftObjectTwo ();
	z.forestOneBackground (); // Scene 5
	z.fireObject();
	z.childFacingLeftObjectThree ();
	z.phoenixObject ();
	z.textBoxObject6 ();
	z.textBoxObject7 ();
	z.textBoxObject8 ();
	z.textBoxObject9 ();
	z.textBoxObject10 ();
	z.textBoxObject11 ();
	z.textBoxObject12 ();
	z.textBoxObject13 ();
	z.textBoxObject14 ();
	z.textBoxObject15 ();
	z.textBoxObject16 ();
	z.textBoxObject17 ();
	z.textBoxObject18 ();
	z.textBoxObject19 ();
	z.textBoxObject20 ();
	z.portalTransitionObject ();
	z.seasideBackground (); // Scene 6
	z.portalObject ();
	z.childFacingLeftObjectFour ();
	z.textBoxObject21 ();
	z.pegasusObject ();
	z.textBoxObject22 ();
	z.textBoxObject23 ();
	z.textBoxObject24 ();
	z.textBoxObject25 ();
	z.textBoxObject26 ();
	z.textBoxObject27 ();
	z.textBoxObject28 ();
	z.textBoxObject29 ();
	z.textBoxObject30 ();
	z.textBoxObject31 ();
	z.textBoxObject32 ();
	z.saplingsObjectOne ();
	z.textBoxObject33 ();
	z.childFacingRightObjectFour ();
	z.forestOneBackground(); // Scene 7
	z.childFacingRightObjectFive ();
	z.saplingsObjectTwo ();
	z.childFacingRightObjectSix ();
	z.forestTwoBackground (); // Scene 8
	z.childFacingRightObjectTwo ();
	z.caveBackground (); // Scene 9
	z.childFacingRightObjectThree ();
	z.healthyPonyObject();
	z.textBoxObject34 ();
	z.textBoxObject35 ();
	z.textBoxObject36 ();
	z.textBoxObject37 ();
	z.textBoxObject38 ();
	z.textBoxObject39 ();
	z.endScreen(); // End - "implements Runnable"
    }
}
