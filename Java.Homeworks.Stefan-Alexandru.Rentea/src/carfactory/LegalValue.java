/*
 * LegalValue class
 */
package carfactory;

import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */
public class LegalValue {
    
    Scanner scanner;
    String string;
    
    /**
     * Returns a legal value for parameter requestString
     */
    String getLegalValue(String requestString) {
        WHILE:
        while(true) {
            if (new IntVerifier().isInt(requestString
                    .substring(requestString.length() -1)))
                System.out.print(requestString.substring(0,
                        requestString.length() - 1).trim() + " ");
            else
                System.out.print(requestString.trim() + " ");
            scanner = new Scanner(System.in);
            string = scanner.nextLine().trim();
            //name
            if (requestString.contains("Name")) { 
                for(int i = 0; i < string.length() - 1; i++)
                    if (!Character.isLetter(string.charAt(i))) {
                        System.out.println("Try again:\n");
                        continue WHILE;
                    }
                if (Character.isLetter(string.charAt(string.length() - 1)))
                    return string;
            }
            else
                //factory menu + requests option
                if (requestString.equals("Choice:")
                        && new IntVerifier().isInt(string)
                        && Integer.parseInt(string) > 0
                        && Integer.parseInt(string) < 7)
                    break;
                else
                    //factory menu - requests option
                    if (requestString.equals("Choice: ")
                            && new IntVerifier().isInt(string)
                            && Integer.parseInt(string) > 0 
                            && Integer.parseInt(string) < 8)
                        break;
                    else
                        //color
                        if (requestString.contains("Color")) {
                            for (Color color : Color.values())
                                if (string.equals(color.toString()))
                                    return string;
                        }
                        else
                            //car id, customer id, request id
                            if ((requestString.contains("Which Car: ") 
                                    || requestString.contains("Which Customer: ")
                                    || requestString.contains("Which Request: "))
                                    && new IntVerifier().isInt(string)) {
                                int size = Integer.parseInt(requestString
                                        .substring(requestString.length() - 1));
                                if (Integer.parseInt(string) > 0
                                        && Integer.parseInt(string) <= size)
                                    break;
                            }
                            else
                                //requests menu
                                if (requestString.equals("Choice:  ")
                                        && new IntVerifier().isInt(string)
                                        && Integer.parseInt(string) > 0
                                        && Integer.parseInt(string) < 5)
                                    break;
                                else
                                    //customers menu
                                    if (requestString.equals("Choice:   ")
                                            && new IntVerifier().isInt(string)
                                            && Integer.parseInt(string) > 0
                                            && Integer.parseInt(string) < 6)
                                        break;
                                    else
                                        //customer menu
                                        if (requestString.equals("Choice:    ")
                                                && new IntVerifier().isInt(string)
                                                && Integer.parseInt(string) > 0 
                                                && Integer.parseInt(string) < 9)
                                            break;
                                        else
                                            //salary, money
                                            if ((requestString.contains("Salary")
                                                    || requestString.contains("money"))
                                                    && new DoubleVerifier().isDouble(string))
                                                return "" + new DoublePrecision()
                                                        .doPrecision(Double.parseDouble(string));
                                            else 
                                                if (requestString.contains("value")
                                                    && new DoubleVerifier().isDouble(string))
                                                return "" + new DoublePrecision()
                                                        .doPrecision(Double.parseDouble(string));
            System.out.println("\nTry again!\n");
        }
        System.out.println();
        return string;
    }
    
}
