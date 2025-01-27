/*
* Name: Sehan Munir
* Teacher: Mrs. Krasteva
* Date: 2024-03-7
* Purpose: This program simulate a round of the card game bridge
*/

// Imports
import java.util.*;
import java.lang.*;

// Main Class (Driver)
public class SehanMunirBridge { // Public Class
    // Variables
    static ArrayList<String> deck = new ArrayList<>(52); // The Deck, using an ArrayList as properties of it are similar to a real deck (.remove, .add)
    static String[] possibleDenomination = {"K","Q","J","T","9","8","7","6","5","4","3","2", "A"}; // Just for simplicity
    static String[] possibleSuit  = {"S","H","D","C"}; // Just for simplicity
    static ArrayList<String> playerOne = new ArrayList<>(13); // Player One Hand
    static ArrayList<String> playerTwo = new ArrayList<>(13); // Player Two Hand
    static ArrayList<String> playerThree = new ArrayList<>(13); // Player Three Hand
    static ArrayList<String> playerFour = new ArrayList<>(13); // Player Four Hand
    // Player points
    static int playerOnePoints = 0;
    static int playerTwoPoints = 0;
    static int playerThreePoints = 0;
    static int playerFourPoints = 0;
   
    public static void bridgeIntroduction(){ // Introduction Thing
      // Introduction
      System.out.println("||            + + + + +  BRIDGE  + + + + +              ||");
      System.out.println("||     Welcome to the card game bridge! From a deck     ||");
      System.out.println("||         four players a dealt thirteen cards.         ||");
      System.out.println("||                                                      ||");
      System.out.println("||   - For each ACE, player gains FOUR points           ||");
      System.out.println("||   - For each KING, player gains THREE points         ||");
      System.out.println("||   - For each QUEEN, player gains TWO points          ||");
      System.out.println("||   - For each JACK, player gains ONE points           ||");
      System.out.println("||                                                      ||");
      System.out.println("||   - For VOID (0 from a suit),                        ||");
      System.out.println("||      - Player gains THREE points                     ||");
      System.out.println("||   - For SINGLETON (1 from a suit),                   ||");
      System.out.println("||      - Player gains TWO points                       ||");
      System.out.println("||   - For DOUBLETON (0 from a suit),                   ||");
      System.out.println("||      - Player gains ONE points                       ||");
    }
    public static void bridgeDeckCreation(){ // Create Default Deck
      // Deck Creation
      System.out.println("|| Creating Deck...                                     ||");
      for (String demonitation : possibleDenomination)
        for (String suit: possibleSuit)
          deck.add(demonitation+suit); // Nested for loop iterating through every possible card combination and adding it to the deck
    }
    public static void bridgeDeckDisplay(){ // Display Deck
      // Deck Display
      System.out.println("|| Here is the deck:                                    ||");
      for (int i = 0; i < 52; i+=4){ // Displays the deck
        System.out.println("||              "+deck.get(i)+"    "+deck.get(i+1)+"    "+deck.get(i+2)+"    "+deck.get(i+3)+"                    ||");
      }
    }
    public static void bridgeDeckShuffle(){ // Shuffle Deck
      // Deck Shuffle
      System.out.println("|| Shuffling Deck...                                    ||");
      Collections.shuffle(deck); // Collections.shuffle(); is a command that randomly changes position of objects
    }
    public static void bridgeAssignCards(){ // Assign Cards To Players
      // Assign Cards To Players
      System.out.println("|| Assigning Cards...                                   ||");
      for (int i = 0; i < 13; i++){ // For loop going over 13 times and assigning players the "top" card
        playerOne.add(deck.remove(0));
        playerTwo.add(deck.remove(0));
        playerThree.add(deck.remove(0));
        playerFour.add(deck.remove(0));
      }
     
    }
    public static void bridgeCheckHands(){ // Check Hands
      // Check Hand
      System.out.println("|| Here are the hands:                                  ||");
      System.out.print("|| PlayerOne   : ");
      for (int i = 0; i < 13; i++){ // Print out hand
        System.out.print(playerOne.get(i)+" ");
      }
      System.out.println("||");
      System.out.print("|| PlayerTwo   : ");
      for (int i = 0; i < 13; i++){ // Print out hand
        System.out.print(playerTwo.get(i)+" ");
      }
      System.out.println("||");
      System.out.print("|| PlayerThree : ");
      for (int i = 0; i < 13; i++){ // Print out hand
        System.out.print(playerThree.get(i)+" ");
      }
      System.out.println("||");
      System.out.print("|| PlayerFour  : ");
      for (int i = 0; i < 13; i++){ // Print out hand
        System.out.print(playerFour.get(i)+" ");
      }
      System.out.println("||");
    }
    public static String bridgeTranslateValueCard(String input, boolean translation){ // This method basically gives each card a value allowing for "easier" sorting
      // This method translates from Card Value to Numbers and the other way around 
      // for easier sorting
      // You can kind of think of it like translating from base 13 to 10 but with special characters 
      String output = "";
      if (translation){ // Translate Card to Num
        int value = 0;
        if (input.charAt(1)=='S'){
          value+=39;
        } else if (input.charAt(1)=='H'){
          value+=26;
        } else if (input.charAt(1)=='D'){
          value+=13;
        }
        if (input.charAt(0)=='A') {
          value++;
        } else if (input.charAt(0)=='2'){
          value+=2;
        }  else if (input.charAt(0)=='3'){
          value+=3;
        }  else if (input.charAt(0)=='4'){
          value+=4;
        }  else if (input.charAt(0)=='5'){
          value+=5;
        }  else if (input.charAt(0)=='6'){
          value+=6;
        }  else if (input.charAt(0)=='7'){
          value+=7;
        }  else if (input.charAt(0)=='8'){
          value+=8;
        }  else if (input.charAt(0)=='9'){
          value+=9;
        }  else if (input.charAt(0)=='T'){
          value+=10;
        }  else if (input.charAt(0)=='J'){
          value+=11;
        }  else if (input.charAt(0)=='Q'){
          value+=12;
        } else if (input.charAt(0)=='K'){
          value+=13;
        }
        output = Integer.toString(value);
      } else { // Translate Num to Card
        int value = Integer.parseInt(input);
        if (value%13==1){
          output+="A";
        } else if (value%13==2){
          output+="2";
        } else if (value%13==3){
          output+="3";
        } else if (value%13==4){
          output+="4";
        } else if (value%13==5){
          output+="5";
        } else if (value%13==6){
          output+="6";
        } else if (value%13==7){
          output+="7";
        } else if (value%13==8){
          output+="8";
        } else if (value%13==9){
          output+="9";
        } else if (value%13==10){
          output+="T";
        }  else if (value%13==11){
          output+="J";
        } else if (value%13==12){
          output+="Q";
        } else {
          output+="K";
        }
        if (value/13==0){
          output+="C";
        } else if (value/13==1){
          output+="D";
        } else if (value/13==2){
          output+="H";
        } else {
          output+="S";
        }
      }
      return output;
    }
    public static void bridgeSortHands(){ // This methods sorts the hands
      // Sort Hands
      System.out.println("|| Sorting Hands...                                     ||");
      // Converting Player Cards To Numbers For Easier Sorting
      ArrayList<Integer> playerOneHandInteger = new ArrayList<>();
      ArrayList<Integer> playerTwoHandInteger = new ArrayList<>();
      ArrayList<Integer> playerThreeHandInteger = new ArrayList<>();
      ArrayList<Integer> playerFourHandInteger = new ArrayList<>();
      for (int i = 0; i < 13; i++){
        playerOneHandInteger.add(Integer.parseInt(bridgeTranslateValueCard(playerOne.remove(0),true)));
        playerTwoHandInteger.add(Integer.parseInt(bridgeTranslateValueCard(playerTwo.remove(0),true)));
        playerThreeHandInteger.add(Integer.parseInt(bridgeTranslateValueCard(playerThree.remove(0),true)));
        playerFourHandInteger.add(Integer.parseInt(bridgeTranslateValueCard(playerFour.remove(0),true)));
      }
      // Sorting
      Collections.sort(playerOneHandInteger,Collections.reverseOrder());
      Collections.sort(playerTwoHandInteger,Collections.reverseOrder());
      Collections.sort(playerThreeHandInteger,Collections.reverseOrder());
      Collections.sort(playerFourHandInteger,Collections.reverseOrder());
      // Putting back correct sorted values
      for (int i = 0; i < 13; i++){
        playerOne.add(bridgeTranslateValueCard(Integer.toString(playerOneHandInteger.remove(0)),false));
        playerTwo.add(bridgeTranslateValueCard(Integer.toString(playerTwoHandInteger.remove(0)),false));
        playerThree.add(bridgeTranslateValueCard(Integer.toString(playerThreeHandInteger.remove(0)),false));
        playerFour.add(bridgeTranslateValueCard(Integer.toString(playerFourHandInteger.remove(0)),false));
      }
    }
    public static void bridgeFinalCalcAndWinner(){ // Final calculations, calculates points according to rules and declaring a winner
      System.out.println("|| Finally, time to calculate: ");
      System.out.println("|| This is PlayerOne: ");
      System.out.println("||   Spades: ");
      System.out.print("||    ");
      int iterator = 0; // This method helps iterate over every card
      int numOfS = 0; // This is important as bridge requires the number of cards from a particular suit
      int numOfH = 0; // This is important as bridge requires the number of cards from a particular suit
      int numOfD = 0; // This is important as bridge requires the number of cards from a particular suit
      int numOfC = 0; // This is important as bridge requires the number of cards from a particular suit
      // PLAYER ONE CALCULATION
      while(true){
        if (iterator>=13)
          break;
        String cur = playerOne.get(iterator);
        if (cur.charAt(1)!='S')
          break;
        System.out.print(cur+" ");
        numOfS++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Hearts: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerOne.get(iterator);
        if (cur.charAt(1)!='H')
          break;
        System.out.print(cur+" ");
        numOfH++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Diamonds: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerOne.get(iterator);
        if (cur.charAt(1)!='D')
          break;
        System.out.print(cur+" ");
        numOfD++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Clubs: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerOne.get(iterator);
        if (cur.charAt(1)!='C')
          break;
        System.out.print(cur+" ");
        numOfC++;
        iterator++;
      }
      System.out.println();
      for (int i = 0; i < 13; i++){
        if (playerOne.get(i).charAt(0)=='A'){
            playerOnePoints+=4;
        } else if(playerOne.get(i).charAt(0)=='K'){
            playerOnePoints+=3;
        } else if(playerOne.get(i).charAt(0)=='Q'){
            playerOnePoints+=2;
        } else if(playerOne.get(i).charAt(0)=='J'){
            playerOnePoints++;
        }
      }
      if(numOfS==0){
        playerOnePoints+=3;
      }
      else if (numOfS==1){
        playerOnePoints+=2;
      }
      else if (numOfS==2){
        playerOnePoints++;
      }
      if(numOfH==0){
        playerOnePoints+=3;
      }
      else if (numOfH==1){
        playerOnePoints+=2;
      }
      else if (numOfH==2){
        playerOnePoints++;
      }
      if(numOfD==0){
        playerOnePoints+=3;
      }
      else if (numOfD==1){
        playerOnePoints+=2;
      }
      else if (numOfD==2){
        playerOnePoints++;
      }
      if(numOfC==0){
        playerOnePoints+=3;
      }
      else if (numOfC==1){
        playerOnePoints+=2;
      }
      else if (numOfC==2){
        playerOnePoints++;
      }
      System.out.println("||   This gives them a total point of " + playerOnePoints+".");
      // PLAYER Two CALCULATION
      System.out.println("|| This is PlayerTwo: ");
      System.out.println("||   Spades: ");
      System.out.print("||    ");
      iterator = 0;
      numOfS = 0;
      numOfH = 0;
      numOfD = 0;
      numOfC = 0;
      while(true){
        if (iterator>=13)
          break;
        String cur = playerTwo.get(iterator);
        if (cur.charAt(1)!='S')
          break;
        System.out.print(cur+" ");
        numOfS++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Hearts: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerTwo.get(iterator);
        if (cur.charAt(1)!='H')
          break;
        System.out.print(cur+" ");
        numOfH++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Diamonds: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerTwo.get(iterator);
        if (cur.charAt(1)!='D')
          break;
        System.out.print(cur+" ");
        numOfD++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Clubs: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerTwo.get(iterator);
        if (cur.charAt(1)!='C')
          break;
        System.out.print(cur+" ");
        numOfC++;
        iterator++;
      }
      System.out.println();
      for (int i = 0; i < 13; i++){
        if (playerTwo.get(i).charAt(0)=='A'){
            playerTwoPoints+=4;
        } else if(playerTwo.get(i).charAt(0)=='K'){
            playerTwoPoints+=3;
        } else if(playerTwo.get(i).charAt(0)=='Q'){
            playerTwoPoints+=2;
        } else if(playerTwo.get(i).charAt(0)=='J'){
            playerTwoPoints++;
        }
      }
      if(numOfS==0){
        playerTwoPoints+=3;
      }
      else if (numOfS==1){
        playerTwoPoints+=2;
      }
      else if (numOfS==2){
        playerTwoPoints++;
      }
      if(numOfH==0){
        playerTwoPoints+=3;
      }
      else if (numOfH==1){
        playerTwoPoints+=2;
      }
      else if (numOfH==2){
        playerTwoPoints++;
      }
      if(numOfD==0){
        playerTwoPoints+=3;
      }
      else if (numOfD==1){
        playerTwoPoints+=2;
      }
      else if (numOfD==2){
        playerTwoPoints++;
      }
      if(numOfC==0){
        playerTwoPoints+=3;
      }
      else if (numOfC==1){
        playerTwoPoints+=2;
      }
      else if (numOfC==2){
        playerTwoPoints++;
      }
      System.out.println("||   This gives them a total point of " + playerTwoPoints+".");
      // PLAYER THREE CALCULATION
      System.out.println("|| This is PlayerThree: ");
      System.out.println("||   Spades: ");
      System.out.print("||    ");
      iterator = 0;
      numOfS = 0;
      numOfH = 0;
      numOfD = 0;
      numOfC = 0;
      while(true){
        if (iterator>=13)
          break;
        String cur = playerThree.get(iterator);
        if (cur.charAt(1)!='S')
          break;
        System.out.print(cur+" ");
        numOfS++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Hearts: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerThree.get(iterator);
        if (cur.charAt(1)!='H')
          break;
        System.out.print(cur+" ");
        numOfH++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Diamonds: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerThree.get(iterator);
        if (cur.charAt(1)!='D')
          break;
        System.out.print(cur+" ");
        numOfD++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Clubs: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerThree.get(iterator);
        if (cur.charAt(1)!='C')
          break;
        System.out.print(cur+" ");
        numOfC++;
        iterator++;
      }
      System.out.println();
      for (int i = 0; i < 13; i++){
        if (playerThree.get(i).charAt(0)=='A'){
            playerThreePoints+=4;
        } else if(playerThree.get(i).charAt(0)=='K'){
            playerThreePoints+=3;
        } else if(playerThree.get(i).charAt(0)=='Q'){
            playerThreePoints+=2;
        } else if(playerThree.get(i).charAt(0)=='J'){
            playerThreePoints++;
        }
      }
      if(numOfS==0){
        playerThreePoints+=3;
      }
      else if (numOfS==1){
        playerThreePoints+=2;
      }
      else if (numOfS==2){
        playerThreePoints++;
      }
      if(numOfH==0){
        playerThreePoints+=3;
      }
      else if (numOfH==1){
        playerThreePoints+=2;
      }
      else if (numOfH==2){
        playerThreePoints++;
      }
      if(numOfD==0){
        playerThreePoints+=3;
      }
      else if (numOfD==1){
        playerThreePoints+=2;
      }
      else if (numOfD==2){
        playerThreePoints++;
      }
      if(numOfC==0){
        playerThreePoints+=3;
      }
      else if (numOfC==1){
        playerThreePoints+=2;
      }
      else if (numOfC==2){
        playerThreePoints++;
      }
      System.out.println("||   This gives them a total point of " + playerThreePoints+".");
      // PLAYER FOUR CALCULATION
      System.out.println("|| This is PlayerFour: ");
      System.out.println("||   Spades: ");
      System.out.print("||    ");
      iterator = 0;
      numOfS = 0;
      numOfH = 0;
      numOfD = 0;
      numOfC = 0;
      while(true){
        if (iterator>=13)
          break;
        String cur = playerFour.get(iterator);
        if (cur.charAt(1)!='S')
          break;
        System.out.print(cur+" ");
        numOfS++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Hearts: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerFour.get(iterator);
        if (cur.charAt(1)!='H')
          break;
        System.out.print(cur+" ");
        numOfH++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Diamonds: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerFour.get(iterator);
        if (cur.charAt(1)!='D')
          break;
        System.out.print(cur+" ");
        numOfD++;
        iterator++;
      }
      System.out.println();
      System.out.println("||   Clubs: ");
      System.out.print("||    ");
      while(true){
        if (iterator>=13)
          break;
        String cur = playerFour.get(iterator);
        if (cur.charAt(1)!='C')
          break;
        System.out.print(cur+" ");
        numOfC++;
        iterator++;
      }
      System.out.println();
      for (int i = 0; i < 13; i++){
        if (playerFour.get(i).charAt(0)=='A'){
            playerFourPoints+=4;
        } else if(playerFour.get(i).charAt(0)=='K'){
            playerFourPoints+=3;
        } else if(playerFour.get(i).charAt(0)=='Q'){
            playerFourPoints+=2;
        } else if(playerFour.get(i).charAt(0)=='J'){
            playerFourPoints++;
        }
      }
      if(numOfS==0){
        playerFourPoints+=3;
      }
      else if (numOfS==1){
        playerFourPoints+=2;
      }
      else if (numOfS==2){
        playerFourPoints++;
      }
      if(numOfH==0){
        playerFourPoints+=3;
      }
      else if (numOfH==1){
        playerFourPoints+=2;
      }
      else if (numOfH==2){
        playerFourPoints++;
      }
      if(numOfD==0){
        playerFourPoints+=3;
      }
      else if (numOfD==1){
        playerFourPoints+=2;
      }
      else if (numOfD==2){
        playerFourPoints++;
      }
      if(numOfC==0){
        playerFourPoints+=3;
      }
      else if (numOfC==1){
        playerFourPoints+=2;
      }
      else if (numOfC==2){
        playerFourPoints++;
      }
      System.out.println("||   This gives them a total point of " + playerFourPoints+".");
      // Display final winner (compares point to everyone (ties are accounted))
      System.out.println("||             The final winner(s) is: ");
      if (playerOnePoints>=playerTwoPoints&&playerOnePoints>=playerThreePoints&&playerOnePoints>=playerFourPoints){
        System.out.println("||                     Player One");
      }
      if (playerTwoPoints>=playerOnePoints&&playerTwoPoints>=playerThreePoints&&playerTwoPoints>=playerFourPoints){
        System.out.println("||                     Player Two");
      }
      if (playerThreePoints>=playerOnePoints&&playerThreePoints>=playerTwoPoints&&playerThreePoints>=playerFourPoints){
        System.out.println("||                     Player Three");
      } 
      if (playerFourPoints>=playerOnePoints&&playerFourPoints>=playerTwoPoints&&playerThreePoints<=playerFourPoints){
        System.out.println("||                     Player Four");
      }
    }
    public static void main(String[] args) { // Main Method
        SehanMunirBridge game = new SehanMunirBridge();
        Scanner s = new Scanner(System.in);
        System.out.println("==========================================================");
        // Introduction
        game.bridgeIntroduction();
        System.out.println("==========================================================");
        // Creating Default Deck
        game.bridgeDeckCreation();
        System.out.println("==========================================================");
        // Displaying Deck
        game.bridgeDeckDisplay();
        System.out.println("==========================================================");
        // Shuffling Deck
        game.bridgeDeckShuffle();
        System.out.println("==========================================================");
        // Displaying Deck
        game.bridgeDeckDisplay();
        System.out.println("==========================================================");
        // Assigning Cards To Players
        game.bridgeAssignCards();
        System.out.println("==========================================================");
        // Display Player Hands
        game.bridgeCheckHands();
        System.out.println("==========================================================");
        // Sort Hands
        game.bridgeSortHands();
        System.out.println("==========================================================");
        // Display Player Hands
        game.bridgeCheckHands();
        System.out.println("==========================================================");
        // Final Calculations And Display
        game.bridgeFinalCalcAndWinner();
        System.out.println("==========================================================");
       
    }
}
