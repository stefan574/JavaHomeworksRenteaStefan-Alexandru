/*
 * 
 */

package pocketcomputer;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Stefan-Alexandru Rentea
 */

public class NumericExpression {
    static double solveNumericExpression(List list) {
        int startIndex, currentIndex, curlyOpened = 0;
        double Parentheses, afterParentheses;
        int notFirstElement = 0;
        double result = 0.0;
        String string, operation = "+";
        double temporary = 0.0;
        String temporaryOperation = "+";
        ListIterator iterator = list.listIterator();
        ListIterator endIndex;
        
        GoTo:
        while(iterator.hasNext()) {
            string = iterator.next().toString();
            if ((new DoubleVerifier().isDouble(string))&&iterator.hasNext()) {
                string = iterator.next().toString();
                if (((string.equals("*")||string.equals("/")
                        ||string.equals("%"))
                        &&(operation.equals("+")
                        ||operation.equals("-")))
                        &&(notFirstElement != 0)) {
                    temporary = new SwitchOperation().doOperation(temporary, result, temporaryOperation);
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
                    result = new SwitchOperation().doOperation(temporary, result, temporaryOperation);
                }
            
            //swich
            if (string.equals("+"))
                operation = "+";
            if (string.equals("-"))
                operation = "-";
            if (string.equals("/")&&notFirstElement != 0)
                operation = "/";
            if (string.equals("*")&&notFirstElement != 0)
                operation = "*";
            if (string.equals("%")&&notFirstElement != 0)
                operation = "%";
            
            if (string.equals("(")||string.equals("[")||string.equals("{")) {
                startIndex = iterator.nextIndex();
                if (string.equals("{"))
                    curlyOpened++;
                endIndex = list.listIterator(startIndex);
                while(endIndex.hasNext()) {
                    endIndex.next();
                    currentIndex = endIndex.nextIndex() - 1;
                    if ((list.get(currentIndex).toString().equals(")")
                            &&string.equals("("))
                            ||(list.get(currentIndex).toString().equals("]")
                            &&string.equals("["))
                            ||(list.get(currentIndex).toString().equals("}")
                            &&string.equals("{")&&(--curlyOpened == 0))) {
                        //number1 -> result
                        //operation -> first op
                        //list.get(endIndex.nextIndex()) -> second op
                        Parentheses = solveNumericExpression(list.subList(startIndex, endIndex.nextIndex() - 1));
                        afterParentheses =  solveNumericExpression(list.subList(endIndex.nextIndex(), list.size()));
                        
                        if (endIndex.hasNext()&&list.get(endIndex.nextIndex()).equals("-"))
                            afterParentheses = - afterParentheses;
                        
                        if (endIndex.nextIndex() == (list.size()))
                            if (operation.equals("-"))
                                result = result - Parentheses;
                            else 
                                result = new SwitchOperation().doOperation(result, Parentheses, operation);
                        else
                            // */% */%
                            if (((operation.equals("*")||operation.equals("/")||operation.equals("%"))
                                    &&(list.get(endIndex.nextIndex()).equals("*")
                                    ||list.get(endIndex.nextIndex()).equals("/")
                                    ||list.get(endIndex.nextIndex()).equals("%")))
                                    // + +
                                    ||(operation.equals("+")
                                    &&(list.get(endIndex.nextIndex()).equals("+")))
                                    // */% +
                                    ||((operation.equals("*")||operation.equals("/")
                                    ||operation.equals("%"))&&(list.get(endIndex.nextIndex()).equals("+")))) {
                                result = new SwitchOperation().doOperation(result, Parentheses, operation);
                                result = new SwitchOperation().doOperation(result, afterParentheses, list.get(endIndex.nextIndex()).toString());
                            }
                            else
                                // - -
                                if (operation.equals("-")&&(list.get(endIndex.nextIndex()).equals("-"))) {
                                    result = result - Parentheses;
                                    result = result - afterParentheses;
                                }
                                else 
                                    // - +
                                    if (operation.equals("-")&&list.get(endIndex.nextIndex()).equals("+")) {
                                        result = result - Parentheses;
                                        result = new SwitchOperation().doOperation(result, afterParentheses, list.get(endIndex.nextIndex()).toString());
                                    }
                                    else
                                        // + - ; */% -
                                        if ((operation.equals("+")||operation.equals("*")
                                                ||operation.equals("/")||operation.equals("%"))
                                                &&(list.get(endIndex.nextIndex()).equals("-"))) {
                                            result = new SwitchOperation().doOperation(result, Parentheses, operation);
                                            result = result - afterParentheses;
                                        }
                                        else
                                            // - */%
                                            if (operation.equals("-")&&(list.get(endIndex.nextIndex()).equals("*")
                                                    ||list.get(endIndex.nextIndex()).equals("/")
                                                    ||list.get(endIndex.nextIndex()).equals("%")))
                                                result = result - new SwitchOperation().doOperation(Parentheses, afterParentheses,
                                                        list.get(endIndex.nextIndex()).toString());
                                            else
                                                // + */%
                                                if (operation.equals("+")
                                                        &&(list.get(endIndex.nextIndex()).equals("*")
                                                        ||list.get(endIndex.nextIndex()).equals("/")
                                                        ||list.get(endIndex.nextIndex()).equals("%")))
                                                    result = new SwitchOperation().doOperation(result, new SwitchOperation().doOperation(Parentheses,
                                                            afterParentheses, list.get(endIndex.nextIndex()).
                                                            toString()), operation);
                    result = new SwitchOperation().doOperation(result, temporary, temporaryOperation);
                    break GoTo;
                    }
                    else
                        if (list.get(currentIndex).toString().equals("{"))
                                curlyOpened++;
                }
            }
        }
        return result;
    }
}
