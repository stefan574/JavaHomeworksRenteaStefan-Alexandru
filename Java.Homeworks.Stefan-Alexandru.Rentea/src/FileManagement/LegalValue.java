/*
 * LegalValue class
 */
package FileManagement;

import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */
public class LegalValue {
    
    private Scanner scanner;
    private String string;
    boolean bool;

    public LegalValue() {
        this.bool = true;
    }
    
    int getLegalValue(int requestInt) {
        while(bool) {
            bool = false;
            System.out.print("\nChoice: ");
            scanner = new Scanner(System.in);
            string = scanner.nextLine().trim();
            try {
                Integer.parseInt(string);
                if (Integer.parseInt(string) <= 0
                        || Integer.parseInt(string) > requestInt)
                    throw new IllegalArgumentException("\nChoice is out of bounds!\nTry Again!");
            }
            catch (NumberFormatException e) {
                System.out.println("\nChoice not number!\nTry Again!");
                bool = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bool = true;
            }
        }
        System.out.println();
        return Integer.parseInt(string);
    }    
    
    String getLegalValue(String requestString) {
        while(bool) {
            bool = false;
            System.out.print(requestString);
            scanner = new Scanner(System.in);
            string = scanner.nextLine().trim(); 
            try {
                if (requestString.equals("Content: ")) {
                    if (!string.matches(".+"))
                            throw new IllegalArgumentException("\nTry again!");
                }
                else
                    // we consider a file naming to be simple, letters and digits
                    if (requestString.equals("New File Name: ")) {
                        for(int i = 0; i < string.length() - 1; i++)
                        if (!Character.isLetter(string.charAt(i))
                                && !Character.isDigit(string.charAt(i))
                                && !(string.charAt(i) == '.')) {
                            throw new IllegalArgumentException("\nTry again!");
                        }
                }
                    else 
                        if (requestString.equals("Choice: ")) {
                            if (!string.equalsIgnoreCase("yes")
                                    && !string.equalsIgnoreCase("no"))
                                throw new IllegalArgumentException("\nTry again!");
                        }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bool = true;
            }
        System.out.println();
        }
        return string;
    }
        
}
