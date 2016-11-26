/*
 * PlacementsOfElements class
 */
package pocketcomputer;

import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class PlacementOfElements {
    
    private String error;
    private int checkNumberExistence;

    public PlacementOfElements() {
        this.error = "";
        this.checkNumberExistence = 0;
    }
    
    /*
     * Verifies the placement of elements in the numerical expression.
     */
    String verifyIllegalPlacement(List<String> list) {
        //illegal placement of a number before an opened bracket
        for (int i = 0; i < list.size() - 1; i++)
            if ((new DoubleVerifier().isDouble(list.get(i)))
                    && (list.get(i + 1).equals("(")
                    || list.get(i + 1).equals("[")
                    || list.get(i + 1).equals("{")))
                error = error + (i + 1) + ": Number \"" + list.get(i)
                        + "\" is next to a " + list.get(i + 1) + " bracket.\n";
            else 
                if ((list.get(i).equals(")")
                        || list.get(i).equals("]")
                        || list.get(i).equals("}"))
                        && (new DoubleVerifier().isDouble(list.get(i + 1))))
                    error = error + (i + 1) + ": Number \"" + list.get(i + 1)
                            + "\" is after a " + list.get(i) + " bracket.\n";
        
        //illegal placement of an operator before a closed bracket
        for (int i = 1; i < list.size(); i++)
            if ((list.get(i).equals(")") || list.get(i).equals("]")
                    || list.get(i).equals("}")) && ((list.get(i - 1).equals("-"))
                    || list.get(i - 1).equals("+") || list.get(i - 1).equals("*")
                    || list.get(i - 1).equals("/") || list.get(i - 1).equals("%")))
                error = error + i + ": Operator " + list.get(i - 1) 
                        + " before a " + list.get(i) + " braket.\n";
        
        //illegal placement of '.' char(period character)
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).equals("."))
                error = error + (i + 1) + ": Illegal placement of '.' "
                        + "char(period character).\n";
        
        //illegal placement of an operator before a '.' char(period character)
        for (int i = 0; i < list.size() - 1; i++)
            if ((list.get(i).equals("*") || list.get(i).equals("/")
                    || list.get(i).equals("%") || list.get(i).equals("+")
                    || list.get(i).equals("-")) && (list.get(i + 1).equals("."))) {
                error = error + (i + 1) + ": Illegal placement of operator \'"
                        + list.get(i) + "\' before a '.' char(period character).\n";
            }
        
        //trebuie sa modific in menu sa puna mereu zero in input!
        
        //illegal placement of on operator next to another operator
        for (int i = 0; i < list.size(); i++) 
            if (list.get(i).equals("+") || list.get(i).equals("-")
                    || list.get(i).equals("*") || list.get(i).equals("/")
                    || list.get(i).equals("%"))
                if ((i + 1 < list.size()) && (list.get(i + 1).equals("+")
                        || list.get(i + 1).equals("-") || list.get(i + 1).equals("*")
                        || list.get(i + 1).equals("/") || list.get(i + 1).equals("%")))
                error = error + (i + 1) + ": Illegal placement of operator \'"
                        + list.get(i) + "\' next to another operator.\n";
                else 
                    if ((i - 1 > 0) && (list.get(i - 1).equals("+")
                            || list.get(i - 1).equals("-") || list.get(i - 1).equals("*")
                            || list.get(i - 1).equals("/") || list.get(i - 1).equals("%")))
                        error = error + i + ": Illegal placement of operator "
                                + list.get(i) + " next to another operator.\n";
        
        // if there's more than one element, we verify if one of them 
        // is a number; (we let one element list pass because it could be
        // an operator like '+', '-', '*', '/' or '%')
        for (int i = 0; i < list.size(); i++)
            if (list.size() > 0)
                if (new DoubleVerifier().isDouble(list.get(i)))
                    checkNumberExistence = 1;
        
        if (checkNumberExistence != 1)
            error = error + "X: There are no numbers in the numerical expression.\n";
        
        return error;
    }
    
}
