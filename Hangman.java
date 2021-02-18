import java.lang.StringBuffer;
/**
 * Hangman Class
 * @author Alkým Önen
 * @version 07/02/2018
 */

public class Hangman
{
   // properties
   
   private static StringBuffer secretWord;
   private static StringBuffer allLetters;
   private static StringBuffer usedLetters;
   private static int numberOfIncorrectTries;
   private static int maxAllowedIncorrectTries;
   private static StringBuffer knownSoFar;  
   
   // constructors
   
   public Hangman ()
   {
      allLetters = new StringBuffer( "abcdefghijklmnopqrstuvwxyz");
      maxAllowedIncorrectTries = 6;
      numberOfIncorrectTries = 0;
      usedLetters = new StringBuffer( "");
      secretWord = new StringBuffer( chooseSecretWord());
      knownSoFar = new StringBuffer( "");
      for ( int i = 0; i < secretWord.length(); i++ )
      {
         knownSoFar.append( "*");
      }
   }
   
   // methods
   
   /**
    * Checks that if the letter is in secret word and does what should be done
    * @param String letter The letter which is entered by user
    * @return int Number of times this letter is repeated in secret word
    */
   public int tryThis( String letter)
   {
      int k;
      int count;
      
      count = -1;
      
      if ( letter.length() == 1 )
      {
         for ( k = 0; k < allLetters.length(); k++ )
         {
            if ( allLetters.substring( k, k+1).equals( letter))
               count = 0;
         }
      }
      
      if ( count == 0 )
      {
         for ( k = 0; k < usedLetters.length(); k++ )
         {
            if ( usedLetters.substring( k, k+1).equals( letter))
               count = -2;
         }
      }
      
      if ( count == 0 )
      {
         usedLetters.append( letter);
         
         for ( k = 0; k < secretWord.length(); k++ )
         {
            if ( secretWord.substring( k, k+1).equals( letter))
            {
               knownSoFar.replace( k, k+1, letter);
               count = count + 1;
            }
         }
         
         if ( count == 0 )
         {
            numberOfIncorrectTries = numberOfIncorrectTries + 1;
            
            if ( numberOfIncorrectTries == 6 )
               count = -3;
         }
      }
      
      return count;
   }
   
   /**
    * Method returns the game is over or not
    * @return true if game is over, false otherwise
    */
   public boolean isGameOver()
   {
      int k;
      boolean won;
      won = true;
      
      for ( k = 0; k < knownSoFar.length(); k++ )
      {
         if ( knownSoFar.charAt( k) == '*' )
            won = false;
      }
      
      if ( hasLost() == true || won )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    * Method returns player has lost or not
    * @return true if game is lost, false otherwise
    */
   public boolean hasLost()
   {
      if ( numberOfIncorrectTries == maxAllowedIncorrectTries)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    * Assigns a random word to the secretWord property.
    * @return String a random secret word.
    */
   public static String chooseSecretWord() 
   {
      String[] secretWordsCollection = { "apple" , "university" , "student" , "atmosphere" , "english" , "computer" , "mathematics" };
      
      return secretWordsCollection[ ( int ) ( Math.random() * secretWordsCollection.length ) ];
   }
   
   /**
    * Method returns all letters
    * @return String of all letters
    */
   public String getAllLetters()
   {
      return allLetters.toString();
   }
   
   /**
    * Method returns all used letters
    * @return String of used letters
    */
   public String getUsedLetters()
   {
      return usedLetters.toString();
   }
   
   /**
    * Method returns number of incorrect tries
    * @return int
    */
   public int getNumOfIncorrectTries()
   {
      return numberOfIncorrectTries;
   }
   
   /**
    * Method returns maximum number of allowed incorrect tries
    * @return int
    */
   public int getMaxAllowedIncorrectTries()
   {
      return maxAllowedIncorrectTries;
   }
   
   /**
    * Method returns all letters found so far
    * @return String 
    */
   public String getKnownSoFar()
   {
      return knownSoFar.toString();
   }
}
