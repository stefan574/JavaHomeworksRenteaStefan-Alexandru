/*
 * CardsEnum class
 */
package deckofcards;

/**
 * @author Stefan-Alexandru Rentea
 */
public final class CardsEnum {
    
    private final OneCardEnum[] pack;
    
    CardsEnum() {
        pack = new OneCardEnum[54];
    }
    
    public void populate()
    {
        int k = 0;
        for(Deck i : Deck.values())
            for (Rank j : Rank.values())
            {
                pack[k] = new OneCardEnum();
                pack[k].setDeck(i);
                pack[k].setRank(j);
                pack[k].print();
                k++;
            }
    }   
    
}
