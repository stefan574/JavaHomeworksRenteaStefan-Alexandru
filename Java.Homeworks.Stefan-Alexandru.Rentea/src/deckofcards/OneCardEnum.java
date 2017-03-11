/*
 * OneCardEnum
 */
package deckofcards;

/**
 * @author Stefan-Alexandru Rentea
 */
public final class OneCardEnum {
    
    private Deck deckCard;
    private Rank rankCard;
    
    OneCardEnum()
    {
        deckCard = null;
        rankCard = null;
    }
    
    Deck getDeck() {
        return deckCard;
    }
    
    Rank getRank() {
        return rankCard;
    }
    
    void setDeck(Deck s) {
        deckCard = s;
    }
    
    void setRank(Rank s) {
        rankCard = s;
    }
    
    public void print()
    {
        System.out.println("The " + rankCard + " of " + deckCard );
    }
    
}
