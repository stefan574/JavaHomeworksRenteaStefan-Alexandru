/*
 * HellsMenu Class
 */
package hells;

/**
 * @author Stefan-Alexandru Rentea
 */
public class HellsMenu {
    
    private static int numberOfTries;
    
    /**
     * The first menu of the game, takes user input and switches to the
     * appropriate context.
     */
    static void newGameMenu() {
        System.out.println("1. New Game.\n"
                + "2. Rules.\n"
                + "3. Exit.");
        
        int choice = new LegalValue().getLegalValue(3);
        
        if (choice == 1) {
            System.out.println();
            numberOfTries = 0;
            gameMenu(new Analyzer(new Choice()));
        }
        else
            if (choice == 2) {
                System.out.println("");
                newGameMenu();
            }
    }
    
    /**
     * Second menu of the game, takes user input and switches to the
     * appropriate context by calling the switchNewGameMenu() method.
     * 
     * @param analyzer represents the verifier class for the game
     */
    static void gameMenu(Analyzer analyzer) {
        System.out.println("1. Try your luck.\n"
                + "2. List tries.\n"
                + "3. Back To Main Menu.\n"
                + "4. Exit.");
        
        int choice = new LegalValue().getLegalValue(4);
        switchNewGameMenu(choice, analyzer);
    }
    
    /**
     * Switch method for the second menu in the game
     * 
     * @param choice represents the user's choice
     * @param analyzer represents the verifier class for the game
     */
    static void switchNewGameMenu(int choice, Analyzer analyzer) {
        switch (choice) {
            case 1:
                numberOfTries++;
                int i = 0;
                
                System.out.println();
                
                for (TheNineHellsOfBaator hell : TheNineHellsOfBaator.values())
                    System.out.println(++i + ". " + hell.toString());
                
                System.out.println();
                
                String _choice = new LegalValue().getLegalValue("Try: ");
                
                System.out.println();
                
                boolean bool = analyzer.verifyChoice(new Choice(
                        _choice.charAt(0) - '0',
                        _choice.charAt(1) - '0',
                        _choice.charAt(2) - '0',
                        _choice.charAt(3) - '0'));
                
                if (bool) {
                    System.out.println("Congrats!\n");
                    newGameMenu();
                }
                else
                    if (numberOfTries == 9) {
                        System.out.println("\nFail!\n\nThe correct answer was:\n");
                        analyzer.printCorrectChoice();
                        newGameMenu();
                    }
                    else {
                        System.out.println("\nTry again!\n");
                        gameMenu(analyzer);
                    }
                break;
            case 2:
                System.out.println();
                
                analyzer.printTries();
                
                gameMenu(analyzer);
                break;
            case 3:
                System.out.println();
                
                newGameMenu();
                break;
            default:
                break;
        }
    }
    
}
