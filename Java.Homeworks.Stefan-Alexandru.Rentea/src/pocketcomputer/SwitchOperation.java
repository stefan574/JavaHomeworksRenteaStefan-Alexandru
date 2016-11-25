/*
 * SwitchOperation class
 */
package pocketcomputer;

/**
 * @author Stefan-Alexandru Rentea
 */
public class SwitchOperation {
    
    private double result;
    
    /*
     * Returns the result of an operation between two numbers with a
     * precision of 2 digits after '.' char(period character).
     */
    double doOperation(double numberOne, double numberTwo, String operation) {
        switch(operation) {
                case "+" : 
                case "-" :
                    result = numberOne + numberTwo;
                    break;
                case "*" :
                    result = numberOne * numberTwo;
                    break;
                case "/" :
                    result = numberOne / numberTwo;
                    break;
                case "%" :
                    result = numberOne % numberTwo;
                    break;
                default : 
                    //Write in log file
                    break;
        }
        return new DoublePrecision().doPrecision(result);
    }
    
}
