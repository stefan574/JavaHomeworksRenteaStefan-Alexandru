/*
 * Parser class
 */
package pocketcomputer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Parser {
    
    private int checkPreviousIsNumber;
    private String aux, error;
    private final List<String> list;

    public Parser() {
        this.checkPreviousIsNumber = 0;
        this.aux = "";
        this.error = "";
        this.list = new ArrayList<>();
    }
    
    /*
     * Prepares the numerical expression for verification and evalution.
     */
    String parse(String string) {
        /*
         * making the input a string of elements separated by only
         * one ' ' char(space character)
         */
        string = string.trim();
        while(string.contains("  "))
            string = string.replaceAll("  ", " ");
        
        //if input is empty, print this line and go back to the menu
        if (string.length() < 1) {
            System.out.println("Input is Empty.\n");
            Menu.menu("0.0");
        }
        
        //forming the list of elements from the string
        for (char iterator : string.toCharArray()) {
            if ((iterator == '.') && (checkPreviousIsNumber == 1)) {
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
        /*
         * if we find a negative number, we need to add the '-' char
         * (minus character) to the corresponding string element in the list
         */ 
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i).equals("-") && (list.size() - 1 > i))
                if (new DoubleVerifier().isDouble(list.get(i + 1)))
                    list.set(i + 1, "-" + list.get(i + 1));

        new ExitProgram().verifyExitProgram(list);
        new Ac().verifyAc(list);
        new RepetitiveElements().eliminateRepetitive(list);
        
        error = error + new ExistenceOfElements().verifyExistenceOfElements(list);
        error = error + new OrderOfBrackets().verifyOrderOfBrackets(list);
        error = error + new PlacementOfElements().verifyIllegalPlacement(list);
        
        if (error.equals("")) 
            return new NumericExpression().solveNumericExpression(list) + "";
        else {
            System.out.println(error);
            return ("0.0");
        }
    }
    
}
