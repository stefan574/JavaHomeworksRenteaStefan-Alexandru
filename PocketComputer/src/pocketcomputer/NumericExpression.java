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
    
    

    /*public NumericExpression() {
        this.result = 0;
        this.temporary = 0;
        this.notFirstElement = 0;
        this.curlyOpened = 0;
        this.addedBracket = 0;
        this.operation = "+";
        this.temporaryOperation = "+";
    }*/
    
    /*
     * Evaluates numerical expressions.
     */
    double solveNumericExpression(List list) {
        
        int startIndex, curlyOpened = 0, notFirstElement = 0, addedBracket = 0;
        double brackets, afterBrackets, afterBracketsOne, afterBracketsTwo;
        double result = 0, temporary = 0;
        String string, operation = "+", temporaryOperation = "+";
        ListIterator endIndex, iterator;
        
        System.out.println(list);
        
        iterator = list.listIterator();
        
        GoTo:
        while(iterator.hasNext()) {
            string = iterator.next().toString();
            
            if ((new DoubleVerifier().isDouble(string))&&iterator.hasNext()) {
                string = iterator.next().toString();
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
                notFirstElement = 1;
                iterator.previous();
                string = iterator.previous().toString();
                iterator.next();
                
                result = new SwitchOperation().doOperation(result,
                       Double.parseDouble(string), operation);
            }
            else
                if ((new DoubleVerifier().isDouble(string))) {
                    result = new SwitchOperation().doOperation(result,
                            Double.parseDouble(string), operation);
                    result = new SwitchOperation()
                            .doOperation(temporary, result, temporaryOperation);
                }
            
            //swich
            if (string.equals("+"))
                operation = "+";
            if (string.equals("-"))
                operation = "-";
            if (string.equals("/") && notFirstElement != 0)
                operation = "/";
            if (string.equals("*") && notFirstElement != 0)
                operation = "*";
            if (string.equals("%") && notFirstElement != 0)
                operation = "%";
            
            if (string.equals("(") || string.equals("[") || string.equals("{")) {

                startIndex = iterator.nextIndex();
                
                if (string.equals("{"))
                    curlyOpened++;
                
                endIndex = list.listIterator(startIndex);
                
                while(endIndex.hasNext()) {
                    
                    endIndex.next();
                    
                    if ((list.get(endIndex.nextIndex() - 1).toString().equals(")")
                            && string.equals("("))
                            || (list.get(endIndex.nextIndex() - 1).toString().equals("]")
                            && string.equals("["))
                            || (list.get(endIndex.nextIndex() - 1).toString().equals("}")
                            && string.equals("{") && (--curlyOpened == 0))) {
                        
                        brackets = solveNumericExpression(list
                                .subList(startIndex, endIndex.nextIndex() - 1));
                        
                        if (operation.equals("-"))
                            brackets = - brackets;
                        
                        if ((list.subList(endIndex.nextIndex(), list.size()).size() > 2)
                                && (list.subList(endIndex.nextIndex(), 
                                        list.size()).get(0).equals("*")
                                || list.subList(endIndex.nextIndex(), 
                                        list.size()).get(0).equals("/")
                                || list.subList(endIndex.nextIndex(), 
                                        list.size()).get(0).equals("%"))
                                && (!list.subList(endIndex.nextIndex(), 
                                        list.size()).get(1).equals("(")
                                || !list.subList(endIndex.nextIndex(), 
                                        list.size()).get(1).equals("(")
                                || !list.subList(endIndex.nextIndex(), 
                                        list.size()).get(1).equals("{"))
                                && (list.subList(endIndex.nextIndex(), 
                                        list.size()).contains("+")
                                || list.subList(endIndex.nextIndex(), 
                                        list.size()).contains("-"))) {
                            
                            List<String> sublist;
                            ListIterator searchForEndIndex;
                            
                            sublist = list.subList(endIndex.nextIndex(), 
                                    list.size());
                            searchForEndIndex = sublist.listIterator();
                            
                            while(searchForEndIndex.hasNext()) {
                                string = searchForEndIndex.next().toString();
                                if (string.equals("+")||string.equals("-"))
                                    break;
                            }
                            
                            sublist.add(0, brackets + "");
                            
                            afterBracketsOne = solveNumericExpression(sublist
                                    .subList(0, searchForEndIndex.nextIndex()));
                            
                            afterBracketsTwo = solveNumericExpression(sublist
                                    .subList(searchForEndIndex.nextIndex(), 
                                            sublist.size()));
                            
                            sublist.remove(0);
                            
                            // setting check for already added the bracket result
                            addedBracket = 1;
                            
                            brackets = afterBracketsOne;
                            afterBrackets = afterBracketsTwo;
                        }
                        else
                            afterBrackets =  solveNumericExpression(list
                                    .subList(endIndex.nextIndex(), list.size()));
                        
                        if (!(endIndex.nextIndex() == list.size()) && addedBracket == 0)
                            string = list.get(endIndex.nextIndex()).toString();
                        
                        if (endIndex.nextIndex() == list.size())
                            if (operation.equals("-"))
                                result = result + brackets;
                            else 
                                result = new SwitchOperation()
                                        .doOperation(result, brackets, operation);
                        else
                            // */% */%
                            if (((operation.equals("*") 
                                    || operation.equals("/") || operation.equals("%"))
                                    && (string.equals("*")
                                    || string.equals("/")
                                    || string.equals("%")))
                                    // + +
                                    || (operation.equals("+")
                                    && (string.equals("+")))
                                    // */% +
                                    || ((operation.equals("*") || operation.equals("/")
                                    || operation.equals("%"))
                                    && (string.equals("+")))) {
                                
                                result = new SwitchOperation()
                                        .doOperation(result, brackets, operation);
                                result = new SwitchOperation()
                                        .doOperation(result, afterBrackets, string);
                                }
                            else
                                // - -
                                if (operation.equals("-") && (string.equals("-"))) {
                                    result = result + brackets;
                                    result = result + afterBrackets;
                                    }
                                else 
                                    // - +
                                    if (operation.equals("-") && string.equals("+")) {
                                        result = result + brackets;
                                        result = new SwitchOperation()
                                                .doOperation(result, afterBrackets,
                                                        list.get(endIndex.nextIndex()).toString());
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
                        if (list.get(endIndex.nextIndex() - 1).toString().equals("{"))
                                curlyOpened++;
                }
            }
        }
        return result;
    }
    
}
