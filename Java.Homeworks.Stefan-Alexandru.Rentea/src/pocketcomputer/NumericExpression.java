/*
 * NumericExpression class
 */
package pocketcomputer;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Stefan-Alexandru Rentea
 */
public class NumericExpression {
    
    private int numberOperator, startIndex, notFirstElement, curlyOpened;
    private double afterBrackets;
    
    /*
     * Evaluates numerical expressions.
     */
    double solveNumericExpression(List list) {
        curlyOpened = 0;
        notFirstElement = 0;
        afterBrackets = 0;
        double brackets, afterBracketsOne;
        double result = 0, temporary = 0;
        String string, operation = "+", temporaryOperation = "+";
        ListIterator endIndex, iterator;
        
        iterator = list.listIterator();
        
        GoTo:
        while(iterator.hasNext()) {
            string = iterator.next().toString();
            
            // number
            if ((new DoubleVerifier().isDouble(string)) && iterator.hasNext()) {
                string = iterator.next().toString();
                /* 
                 * Check if future operation is *, / or %, in which
                 * case, we need to save the current progress and calculate
                 * the rest of the numerin expression separately.
                 */
                if (((string.equals("*") || string.equals("/")
                        || string.equals("%")) && (operation.equals("+")
                        || operation.equals("-"))) && (notFirstElement != 0)) {
                    temporary = new SwitchOperation()
                            .doOperation(temporary, result, temporaryOperation);
                    iterator.previous();
                    iterator.previous();
                    string = iterator.previous().toString();
                    iterator.next();
                    temporaryOperation = string;
                    string = iterator.next().toString();
                    result = Double.parseDouble(string);
                    continue;
                }
                // first number
                notFirstElement = 1;
                iterator.previous();
                string = iterator.previous().toString();
                iterator.next();
                
                result = new SwitchOperation().doOperation(result,
                       Double.parseDouble(string), operation);
            }
            else
                // last number
                if ((new DoubleVerifier().isDouble(string))) {
                    result = new SwitchOperation().doOperation(result,
                            Double.parseDouble(string), operation);
                    result = new SwitchOperation()
                            .doOperation(temporary, result, temporaryOperation);
                }
            
            /* 
             * Identifies if current element is an operator, and, if so, change
             * the current operation.
             */
            if (string.equals("+"))
                operation = "+";
            if (string.equals("-"))
                operation = "-";
            // first element can't be *, / or %
            if (string.equals("/") && notFirstElement != 0)
                operation = "/";
            if (string.equals("*") && notFirstElement != 0)
                operation = "*";
            if (string.equals("%") && notFirstElement != 0)
                operation = "%";
            
            // treating brackets
            if (string.equals("(") || string.equals("[") || string.equals("{")) {
                
                //start of brackets
                startIndex = iterator.nextIndex();
                
                // first curly bracket opened
                if (string.equals("{"))
                    curlyOpened++;
                
                endIndex = list.listIterator(startIndex);
                
                while(endIndex.hasNext()) {
                    
                    endIndex.next();
                    
                    // found the closed corresponding bracket
                    if ((list.get(endIndex.nextIndex() - 1).toString().equals(")")
                            && string.equals("("))
                            || (list.get(endIndex.nextIndex() - 1).toString().equals("]")
                            && string.equals("["))
                            || (list.get(endIndex.nextIndex() - 1).toString().equals("}")
                            && string.equals("{") && (--curlyOpened == 0))) {
                        
                        brackets = solveNumericExpression(list
                                .subList(startIndex, endIndex.nextIndex() - 1));
                        
                        // apply the minus operator if necessary
                        if (operation.equals("-"))
                            brackets = -brackets;
                        
                        // resolving precedence of operators among brackets
                        if ((list.subList(endIndex.nextIndex(), list.size()).size() > 2)
                                && (list.subList(endIndex.nextIndex(),
                                        list.size()).get(0).equals("*")
                                || list.subList(endIndex.nextIndex(), 
                                        list.size()).get(0).equals("/")
                                || list.subList(endIndex.nextIndex(), 
                                        list.size()).get(0).equals("%"))) {
                            
                            int curlyOpenedLocal = 0;
                            List<String> sublist;
                            ListIterator searchForEndIndex;

                            sublist = list.subList(endIndex.nextIndex(), 
                                    list.size());
                            searchForEndIndex = sublist.listIterator();
                            
                            // sublist starts with */% and a number
                            if ((sublist.get(searchForEndIndex.nextIndex()).equals("*")
                                    || sublist.get(searchForEndIndex.nextIndex()).equals("/")
                                    || sublist.get(searchForEndIndex.nextIndex()).equals("%"))
                                    && new DoubleVerifier().isDouble(sublist
                                            .get(searchForEndIndex.nextIndex() + 1))) {
                                numberOperator = 2;
                                string = list.subList(endIndex.nextIndex(), 
                                        list.size()).get(0).toString();
                            }
                            else {
                                numberOperator = 0;
                                string = list.subList(endIndex.nextIndex(),
                                        list.size()).get(1).toString();
                            }
                                
                            while(searchForEndIndex.hasNext()) {

                                searchForEndIndex.next();
                                
                                // if closed corresponding bracket found or number
                                if (((sublist.get(searchForEndIndex.nextIndex() - 1).equals(")")
                                        && string.equals("("))
                                        || (sublist.get(searchForEndIndex.nextIndex() - 1).equals("]")
                                        && string.equals("["))
                                        || (sublist.get(searchForEndIndex.nextIndex() - 1).equals("}")
                                        && string.equals("{") && --curlyOpenedLocal == 0))
                                        || numberOperator-- == 1)
                                    if (searchForEndIndex.nextIndex() != sublist.size() &&
                                            // */% {[(
                                            (((sublist.get(searchForEndIndex.nextIndex()).equals("*")
                                            || sublist.get(searchForEndIndex.nextIndex()).equals("/")
                                            || sublist.get(searchForEndIndex.nextIndex()).equals("%"))
                                            && (sublist.get(searchForEndIndex.nextIndex() + 1).equals("(")
                                            || sublist.get(searchForEndIndex.nextIndex() + 1).equals("[")
                                            || sublist.get(searchForEndIndex.nextIndex() + 1).equals("{")))
                                            // */% number
                                            || ((sublist.get(searchForEndIndex.nextIndex()).equals("*")
                                            || sublist.get(searchForEndIndex.nextIndex()).equals("/")
                                            || sublist.get(searchForEndIndex.nextIndex()).equals("%"))
                                            && new DoubleVerifier().isDouble(sublist
                                                    .get(searchForEndIndex.nextIndex() + 1)))))
                                        if (new DoubleVerifier().isDouble(sublist.get(searchForEndIndex.nextIndex() + 1)))
                                            // set 2 for the purpose of waiting an iteration
                                            numberOperator = 2;
                                        else 
                                            if (sublist.get(searchForEndIndex.nextIndex() + 1).equals("{")) 
                                                string = "{";
                                            else 
                                                string = sublist.get(searchForEndIndex.nextIndex() + 1); 
                                    else {
                                        afterBracketsOne = solveNumericExpression(sublist
                                                .subList(0, searchForEndIndex.nextIndex()));

                                        afterBrackets = solveNumericExpression(sublist
                                                .subList(searchForEndIndex.nextIndex(),
                                                        sublist.size()));

                                        brackets = new SwitchOperation().doOperation(brackets,
                                                afterBracketsOne, list.subList(endIndex.nextIndex(),
                                                        list.size()).get(0).toString());
                                        
                                        // setting the operation between brackets and afterbrackets
                                        if (searchForEndIndex.nextIndex() != sublist.size())
                                            string = sublist.get(searchForEndIndex.nextIndex());
                                        else
                                            string = "+";
                                            
                                        numberOperator = 1;
                                        
                                        break;
                                    }
                                else
                                    if (list.get(searchForEndIndex.nextIndex() - 1).toString().equals("{"))
                                        curlyOpenedLocal++;
                            }
                        }
                    else
                        // if there is no *, / or % after brackets
                        afterBrackets =  solveNumericExpression(list
                                .subList(endIndex.nextIndex(), list.size()));
                        
                    // the operand after brackets
                    if (!(endIndex.nextIndex() == list.size()) && numberOperator == 0)
                        string = list.get(endIndex.nextIndex()).toString();

                    // no more elements
                    if (endIndex.nextIndex() == list.size())
                        result = new SwitchOperation()
                                .doOperation(result, brackets, operation);
                    else
                        // */% */%
                        if (((operation.equals("*") 
                                || operation.equals("/")
                                || operation.equals("%"))
                                && (string.equals("*")
                                || string.equals("/")
                                || string.equals("%")))
                                // + +
                                || (operation.equals("+")
                                && string.equals("+"))
                                // */% +
                                || ((operation.equals("*")
                                || operation.equals("/")
                                || operation.equals("%"))
                                && string.equals("+"))
                                // - -
                                || (operation.equals("-")
                                && string.equals("-"))
                                // - +
                                || (operation.equals("-")
                                && string.equals("+"))) {
                            result = new SwitchOperation()
                                    .doOperation(result, brackets, operation);
                            result = new SwitchOperation()
                                    .doOperation(result, afterBrackets, string);
                    }
                    else
                        // + - ; */% -
                        if ((operation.equals("+") || operation.equals("*")
                                || operation.equals("/")
                                || operation.equals("%"))
                                && (string.equals("-"))) {
                            result = new SwitchOperation()
                                    .doOperation(result, brackets, operation);
                            result = result + afterBrackets;
                        }
                        else
                            // - */%
                            if (operation.equals("-") && (string.equals("*")
                                    || string.equals("/") || string.equals("%")))
                                result = result + new SwitchOperation()
                                        .doOperation(brackets, afterBrackets, string);
                            else
                                // + */%
                                if (operation.equals("+") && (string.equals("*")
                                        || string.equals("/") || string.equals("%")))
                                    result = result + new SwitchOperation()
                                            .doOperation(brackets, afterBrackets, string);
                    
                    result = new SwitchOperation().doOperation(result, temporary, temporaryOperation);
                    
                    break GoTo;
                    }
                    else
                        // counting the number of opened curly brackets
                        if (list.get(endIndex.nextIndex() - 1).toString().equals("{"))
                                curlyOpened++;
                }
            }
        }
        return result;
    }
    
}
