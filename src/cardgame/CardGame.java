package cardgame;

import java.util.ArrayList;

// Cardgame
// author:
// date:
public class CardGame
{
   // properties
   Cards             fullPack;
   ArrayList<Player> players;
   ScoreCard         scoreCard;
   Cards[]           cardsOnTable;
   int               roundNo;
   int               turnOfPlayer;
   
   // constructors
   public CardGame( Player p1, Player p2, Player p3, Player p4)
   {
      fullPack = new Cards( true);
      fullPack.shuffle();
      
      players = new ArrayList<Player>();
      players.add( p1);
      players.add( p2);
      players.add( p3);
      players.add( p4);
      
      turnOfPlayer = 0;
      while ( fullPack.valid > 0 )
      {
         players.get( turnOfPlayer).add( fullPack.getTopCard());
         if ( turnOfPlayer == 3 )
            turnOfPlayer = 0;
         else
            turnOfPlayer++;
      }
      
      scoreCard = new ScoreCard( 4);
      
      cardsOnTable = new Cards[4];
      cardsOnTable[0] = new Cards( false);
      cardsOnTable[1] = new Cards( false);
      cardsOnTable[2] = new Cards( false);
      cardsOnTable[3] = new Cards( false);
      
      roundNo = 1;
      turnOfPlayer = 0;
   }
   
   // methods
   public boolean playTurn( Player p, Card c)
   {
      if ( isGameOver() || !isTurnOf( p) )
          return false;
      
      cardsOnTable[turnOfPlayer].addTopCard( c);
      if ( turnOfPlayer == 3 )
      {
         updateScores();
         
         turnOfPlayer = 0;
         roundNo++;
      }
      else
         turnOfPlayer++;
      return true;
   }
   
   public boolean isTurnOf( Player p)
   {
      if ( p == players.get( turnOfPlayer))
         return true;
      return false;
   }
   
   public boolean isGameOver()
   {
      if ( roundNo < 14 )
         return false;
      return true;
   }
   
   public int getScore( int playerNumber)
   {
      return scoreCard.getScore( playerNumber);
   }
   
   public String getName( int playerNumber)
   {
      return players.get( playerNumber).getName();
   }
   
   public int getRoundNo()
   {
      return roundNo;
   }
   
   public int getTurnOfPlayerNo()
   {
      return turnOfPlayer;
   }
   
   public Player[] getWinners()
   {
      int k;
      int[] winnerNumbers;
      Player[] winners;
      
      winnerNumbers = scoreCard.getWinners();
      winners = new Player[winnerNumbers.length];
      
      for( k = 0; k < winnerNumbers.length; k++ )
      {
         winners[k] = players.get( winnerNumbers[k]);
      }
      
      return winners;
   }
   
   public String showScoreCard()
   {
      return scoreCard.toString();
   }
   
   public void updateScores()
   {
         Card largest;
         Card c;
         
         largest = cardsOnTable[0].getTopCard();
         cardsOnTable[0].addTopCard( largest);
         
         for ( turnOfPlayer = 1; turnOfPlayer < 4; turnOfPlayer++ )
         {
            c = cardsOnTable[turnOfPlayer].getTopCard();
            cardsOnTable[turnOfPlayer].addTopCard( c);
            
            if ( largest.getFaceValue() == c.getFaceValue() && largest.getSuit() < c.getSuit() )
               largest = c;
            else if ( largest.getFaceValue() < c.getFaceValue() )
               largest = c;
         }
         
         for ( turnOfPlayer = 0; turnOfPlayer < 4; turnOfPlayer++ )
         {
            c = cardsOnTable[turnOfPlayer].getTopCard();
            cardsOnTable[turnOfPlayer].addTopCard( c);
            
            if ( c.equals( largest))
               scoreCard.update( turnOfPlayer, 1);
         }
      
   }
   
}