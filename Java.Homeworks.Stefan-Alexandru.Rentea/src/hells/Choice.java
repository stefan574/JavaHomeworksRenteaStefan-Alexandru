/*
 * Choice Class
 */
package hells;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Choice {
    
    private final TheNineHellsOfBaator[] hells = new TheNineHellsOfBaator[4];
    private String description;

    /**
     * Constructor for the Choice class, specifically for the player
     * 
     * @param firstHell represents the first hell
     * @param secondHell represents the second hell
     * @param thirdHell represents the third hell
     * @param forthHell represents the forth hell
     */
    Choice(int firstHell, int secondHell, int thirdHell, int forthHell) {
        this.hells[0] = TheNineHellsOfBaator.values()[firstHell - 1];
        this.hells[1] = TheNineHellsOfBaator.values()[secondHell - 1];
        this.hells[2] = TheNineHellsOfBaator.values()[thirdHell - 1];
        this.hells[3] = TheNineHellsOfBaator.values()[forthHell - 1];
        this.description = null;
    }
    
    /**
     * Constructor for the Choice class, specifically for the dealer
     */
    Choice() {
        Random random = new Random();
        List<TheNineHellsOfBaator> listOfHells = new ArrayList<>();
        
        listOfHells.addAll(Arrays.asList(TheNineHellsOfBaator.values()));
        Collections.shuffle(listOfHells);
        
        this.hells[0] = listOfHells.get(random.nextInt(listOfHells.size() - 1));
        
        listOfHells.remove(this.hells[0]);
        Collections.shuffle(listOfHells);
        
        this.hells[1] = listOfHells.get(random.nextInt(listOfHells.size() - 1));
        
        listOfHells.remove(this.hells[1]);
        Collections.shuffle(listOfHells);
        
        this.hells[2] = listOfHells.get(random.nextInt(listOfHells.size() - 1));
        
        listOfHells.remove(this.hells[2]);
        Collections.shuffle(listOfHells);
        
        this.hells[3] = listOfHells.get(random.nextInt(listOfHells.size() - 1));
        
        this.description = null;
    }

    /**
     * Getter for the hells field
     * 
     * @return hells field
     */
    public TheNineHellsOfBaator[] getHells() {
        return hells;
    }

    /**
     * Getter for the description field
     * 
     * @return description field
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the description field
     * 
     * @param description represents the value for the description field
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
