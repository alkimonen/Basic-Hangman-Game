import java.util.Scanner;

/**
 * Game of hangman
 * @author Alkým Önen
 * @version 07/02/2018
 */
public class HangmanGame
{
   public static void main ( String [] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // Variables
      String letter;
      Hangman hangmanGame;
      
      // Program Code
      hangmanGame = new Hangman();
      System.out.println( "Welcome to the HangMan Game!" );
      
      //Shows all the letters of the alphabet
      System.out.println( hangmanGame.getAllLetters());
      
      // Shows maximum amount of tries available 
      System.out.println( "Maximum incorrect tries: " + hangmanGame.getMaxAllowedIncorrectTries());
      
      // Game plays until the player has won or lost
      do
      {
         System.out.println( "Enter the Letter for the Secret Word ");
         
         // User inputs letter
         letter = scan.next();
         
         if ( hangmanGame.tryThis( letter) == -2 )
            System.out.println( "This letter is already used!");
         else if ( hangmanGame.tryThis( letter) == -1 )
            System.out.println( "You entered an invalid letter!");
         else
         {
            System.out.println( hangmanGame.getKnownSoFar());
            System.out.println( "Used letters: " + hangmanGame.getUsedLetters());
            System.out.println( "No. of incorrect tries: " + hangmanGame.getNumOfIncorrectTries());
         }
      }
      while ( !hangmanGame.isGameOver());
      
      // Indictes whether player has won or lost
      if( hangmanGame.hasLost() )
         System.out.println( "You Lose!");
      else
         System.out.println( "You Won!");
   }
}
