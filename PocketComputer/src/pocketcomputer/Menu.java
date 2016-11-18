/*
 * 
 */

package pocketcomputer;

import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */

public class Menu {
    static void menu(String current) {
        System.out.println("\n1 \t2 \t3 \t4\n"
                + "5 \t6 \t7 \t8\n"
                + "9 \t0 \t+ \t-\n"
                + "* \t/ \t% \t.\n"
                + "{ \t} \t[ \t]\n"
                + "( \t) \tAC \tExit\n");
        
        String string;
        
        if (current.endsWith("+")||current.endsWith("-")||current.endsWith("*")
                ||current.endsWith("/")||current.endsWith("%"))
            string = current.substring(0, current.length() - 1);
        else
            string = current;
        
        System.out.println("Result: " + string + "\n");
        System.out.print(">>: ");
        
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine().trim();
        
        if (string.equals("+")||string.equals("-")||string.equals("*")
                ||string.equals("/")||string.equals("%")) {
            string = current + string;
            menu(string);
        }
        else
            if ((current.endsWith("+")||current.endsWith("-")
                    ||current.endsWith("*")||current.endsWith("/")
                    ||current.endsWith("%"))&&(new DoubleVerifier()
                            .isDouble(string))) {
                string = current + string;
                string = Parser.parse(string);
                menu(string);
            }
            else
                if (((string.startsWith("+")||string.startsWith("-")
                        ||string.startsWith("*")||string.startsWith("/")
                        ||string.startsWith("%"))&&string.length() > 1)
                        &&(new DoubleVerifier()
                            .isDouble(current))) {
                    string = current + string;
                    string = Parser.parse(string);
                    menu(string);
                }
                    else {
                        string = Parser.parse(string);
                        menu(string);
                    }
        //string = current + "+" + string;
        //menu(Parser.parse(string));
        
        //String string = "1 + 2";
        
        //Parser.parse(string);
        //menu(string);
    }
}
