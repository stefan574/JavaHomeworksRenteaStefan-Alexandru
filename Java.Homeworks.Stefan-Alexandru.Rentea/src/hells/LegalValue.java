/*
 * LegalValue class
 */
package hells;

import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */
public class LegalValue {
    
    private Scanner scanner;
    private String string;
    
    /**
     * Verifies that the user input is a legal value in a specific context.
     * 
     * @param requestString represents the specific context in which a user 
     * is obliged to enter a specific input
     * @return a legal string value for a specific context
     */
    String getLegalValue(String requestString) {
        WHILE:
        while(true) {
            System.out.print(requestString);
            scanner = new Scanner(System.in);
            string = scanner.nextLine().trim();
            string = string.replace(" ", "");
            if (requestString.equals("Try: ") &&
                    string.matches("\\d{4}")) {
                    break;
            }
            else
                System.out.println("\nTry again!");
        }
        return string;
    }
    
    /**
     * Verifies if the user input is a legal int and that it is included in
     * the specified interval.
     * 
     * @param requestInt is a maximum legal value for the user input
     * @return an legal int value which is the user's option
     */
    int getLegalValue(int requestInt) {
        while(true) {
            System.out.print("\nChoice: ");
            scanner = new Scanner(System.in);
            string = scanner.nextLine().trim();
            if (new IntVerifier().isInt(string) 
                    && Integer.parseInt(string) > 0
                    && Integer.parseInt(string) <= requestInt)
                break;
            System.out.println("\nTry Again!");
        }
        return Integer.parseInt(string);
    }
    
}
