/*
 * 
 */

package pocketcomputer;

/**
 * @author Stefan-Alexandru Rentea
 */

public class SwitchOperation {
    double doOperation(double numberOne, double numberTwo, String operation) {
        double result = 0;
        switch(operation) {
                case "+" : 
                    result = numberOne + numberTwo;
                    break;
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
