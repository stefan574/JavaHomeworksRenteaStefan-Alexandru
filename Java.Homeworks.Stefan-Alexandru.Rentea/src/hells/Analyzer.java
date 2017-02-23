/*
 * Analyzer Class
 */
package hells;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Analyzer {
    
    private final Choice dealerChoice;
    private final List<Choice> playerChoices;
    
    /**
     * Constructor for the Analyzer class
     * 
     * @param dealerChoice represents the dealer's choice for the game
     */
    Analyzer(Choice dealerChoice) {
        this.playerChoices = new ArrayList<>();
        this.dealerChoice = dealerChoice;
    }
    
    /**
     * It verifies if the choice of hells of the user is correct or false.
     * 
     * @param choice represents the user's choice
     * @return true or false, depending on the user's choice
     */
    boolean verifyChoice(Choice choice) {
        String description;
        boolean result = true;
        int i = 0;
        int demons = 0;
        int devils = 0;
        
        // if player is right
        for (TheNineHellsOfBaator hell : dealerChoice.getHells())
            if (!choice.getHells()[i++].equals(hell)) {
                result = false;
                break;
            }
        
        // if player is wrong
        if (!result) {
            i = 0;
            for (TheNineHellsOfBaator hell : dealerChoice.getHells())
                if (choice.getHells()[i++].equals(hell)) {
                    devils++;
                }
                else 
                    for (TheNineHellsOfBaator _hell : choice.getHells())
                        if (_hell.equals(hell)) {
                            demons++;
                            break;
                        }
            
            if (devils == 1 && demons == 1)
                description = Arrays.toString(choice.getHells()) + "\n\nYou've found " + demons + " demon and " + devils + " devil."; 
            else
                if (devils == 1 && demons != 1)
                    description = Arrays.toString(choice.getHells()) + "\n\nYou've found " + demons + " demons and " + devils + " devil.";
                else
                    if (devils != 1 && demons == 1)
                        description = Arrays.toString(choice.getHells()) + "\n\nYou've found " + demons + " demon and " + devils + " devils.";
                    else
                        description = Arrays.toString(choice.getHells()) + "\n\nYou've found " + demons + " demons and " + devils + " devils.";
            
            System.out.println(description);
            choice.setDescription(description);
            playerChoices.add(choice);
            return result;
        }
        else
            return result;
    }
    
    /**
     * Prints all of the user's tries
     */
    void printTries() {
        if (!playerChoices.isEmpty()) {
            int i = 0;
            for (Choice choice : playerChoices)
                System.out.println("Try_" + ++i + ": " + choice.getDescription() + "\n");
        }
        else
            System.out.println("There are no tries yet!\n");
    }
    
    /**
     * If user fails to guess the correct answer, it will be printed on the
     * screen for him to see.
     */
    void printCorrectChoice() {
        System.out.println(Arrays.toString(dealerChoice.getHells()) + "\n");
    }
    
}
