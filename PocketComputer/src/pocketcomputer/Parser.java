/*
 * 
 */

package pocketcomputer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */

public class Parser {
    static String parse(String string) {
        int noErrors = 1;
        int checkPreviousIsNumber = 0;
        String aux = "";
        double result;
        List<String> list = new ArrayList<>();
        
        //making the input a string of elements separated by a only
        //one ' ' char(space character)
        string = string.trim();
        while(string.contains("  "))
            string = string.replaceAll("  ", " ");
        
        //if input is empty, print this line and go back to the menu
        if (string.length() < 1) {
            System.out.println("Input is Empty.");
            System.exit(0);
            //Menu.menu(0);
        }
        
        //forming the list of elements from the string
        for (char iterator : string.toCharArray()) {
            if ((iterator == '.')&&(checkPreviousIsNumber == 1)) {
                aux = aux + iterator;
                continue;
            }
            if (Character.isDigit(iterator)) {
                checkPreviousIsNumber = 1;
                aux = aux + iterator;
            }
            else {
                checkPreviousIsNumber = 0;
                if (!aux.equals(""))
                    list.add(aux);
                aux = "" + iterator;
                list.add(aux);
                aux = "";
            }  
        }
        
        //if there is one more at the end, add it to the list
        if (!aux.equals(""))
                list.add(aux);
        
        //remove every ' ' char(space character) from the list
        while(list.contains(" "))
            list.remove(" ");
        
        //looking at the last element to see if it has a legal placement
        if (list.get(list.size() - 1).equals("+")
                ||list.get(list.size() - 1).equals("-")
                ||list.get(list.size() - 1).equals("*")
                ||list.get(list.size() - 1).equals("/")
                ||list.get(list.size() - 1).equals("%"))
            System.out.println(list.get(list.size() - 1) + ": Expression terminates"
                    + "with " + list.get(list.size() - 1) + ".\n");
        
        //if we find a negative number, we need to add the '-' char
        //(minus character) to the corresponding string element in the list
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i).equals("-")&&(list.size() - 1 > i))
                //if (isDouble(list.get(i + 1)))//
                if (new DoubleVerifier().isDouble(list.get(i + 1)))
                    list.set(i + 1, "-" + list.get(i + 1));
        
        new ExitProgram().verifyExitProgram(list);
        new AC().verifyAC(list);
        new RepetitiveElements().eliminateRepetitive(list);
        new ExistenceOfElements().verifyExistenceOfElements(list);
        new OrderOfBrackets().verifyOrderOfBrackets(list);
        new PlacementOfElements().verifyIllegalPlacement(list);
        
        if (noErrors == 1) 
            return (NumericExpression.solveNumericExpression(list) + "");
            //System.out.println(NumericExpression.solveNumericExpression(list));
        else 
            return (0.0 + "");
    }
}
