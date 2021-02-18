package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:
// date:
public class ScoreCard
{
   // properties
   int[] scores;
   
   // constructors
   public ScoreCard( int noOfPlayers)
   {
      scores = new int[noOfPlayers];
      
      // init all scores to zero
      for ( int i = 0; i < scores.length; i++)
         scores[i] = 0;
   }
   
   // methods
   public int getScore( int playerNo)
   {
      return scores[playerNo];
   }
   
   public void update( int playerNo, int amount)
   {
      scores[playerNo] += amount;
   }
   
   public String toString()
   {
      String s;
      s = "\n"
         + "_____________\n"
         + "\nPlayer\tScore\n"
         + "_____________\n";
      
      for ( int playerNo = 0; playerNo < scores.length; playerNo++)
      {
         s = s + playerNo + "\t" + scores[playerNo] + "\n";
      }
      
      s += "_____________\n";
      return s;
   }
   
   public int[] getWinners()
   {
      int player;
      int k;
      int noOfWinners;
      int maxScore;
      int[] winners;
      
      noOfWinners = 0;
      maxScore = 0;
      
      for ( player = 0; player < 4; player++ )
      {
         if ( getScore(player) == maxScore )
            noOfWinners++;
         else if ( getScore(player) > maxScore )
         {
            noOfWinners = 1;
            maxScore = getScore(player);
         }
      }
      
      winners = new int[noOfWinners];
      
      k = 0;
      for ( player = 0; k < noOfWinners; player++ )
      {
         if ( getScore( player) == maxScore )
         {
            winners[k] = player;
            k++;
         }
      }
      return winners;
   }
   
} // end class ScoreCard
