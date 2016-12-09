/*
 * Menu class
 */
package pocketcomputer;

import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Menu {
    
    /*
     * Displays the menu, the current result and makes calls to
     * the parse() method.
     */
    static void menu(String current) {
        System.out.println("1 \t2 \t3 \t4\n"
                + "5 \t6 \t7 \t8\n"
                + "9 \t0 \t+ \t-\n"
                + "* \t/ \t% \t.\n"
                + "{ \t} \t[ \t]\n"
                + "( \t) \tAC \tExit\n");
        
        String string;
        
        if (current.endsWith("+") || current.endsWith("-") || current.endsWith("*")
                || current.endsWith("/") || current.endsWith("%"))
            string = current.substring(0, current.length() - 1);
        else
            string = current;
        
        System.out.println("Result: " + string + "\n");
        System.out.print(">>: ");
        
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine().trim();
        
        System.out.println();
        
        if (string.equals("+")
                || string.equals("-") || string.equals("*")
                || string.equals("/") || string.equals("%")) {
            string = current + string;
            menu(string);
        }
        else
            if ((new DoubleVerifier().isDouble(current.substring(0, 
                    current.length() - 2))) && (current.endsWith("+")
                    || current.endsWith("-") || current.endsWith("*")
                    || current.endsWith("/") || current.endsWith("%"))
                    && (new DoubleVerifier().isDouble(string))) {
                string = current + string;
                string = new Parser().parse(string);
                menu(string);
            }
            else
                if (((string.startsWith("+") || string.startsWith("-")
                        || string.startsWith("*") || string.startsWith("/")
                        || string.startsWith("%")) && string.length() > 1)
                        && (new DoubleVerifier().isDouble(current))) {
                    string = current + string;
                    string = new Parser().parse(string);
                    menu(string);
                }
                else {
                    string = new Parser().parse(string);
                    menu(string);
                }
    }
    
}
