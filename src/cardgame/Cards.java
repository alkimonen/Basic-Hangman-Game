package cardgame;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:
// date:
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned? Yes, this way computer will not open a new data location for the same card,. Even though the other one gets deleted
            valid++;            
            return true;
        }
        return false;
    }
    
    private void createFullPackOfCards()
    {
       int k;
       
       for ( k = 0; k < cards.length; k++)
       {
          addTopCard( new Card(k) );
       }
    }
    
    public void shuffle()
    {
       int k;
       int n;
       Card[] shuffled;
       shuffled = new Card[NOOFCARDSINFULLPACK];
       
       n = 0;
       while ( n < valid )
       {
          k = (int) Math.ceil( (Math.random() * valid) - 1 );
          
          if ( cards[k] != null )
          {
             shuffled[n] = cards[k];
             cards[k] = null;
             n++;
          }
       }
       cards = shuffled;
    }
    
    // For testOnly... remove from production version!
    public void testOnlyPrint()
    {
        for ( int i =0; i < valid; i++)
        {
            System.out.println( cards[i] );
        }
    }
    
} // end class Cards