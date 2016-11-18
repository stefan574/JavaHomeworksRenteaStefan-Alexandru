/*
 * 
 */

package pocketcomputer;

/**
 * @author Stefan-Alexandru Rentea
 */

public class SwitchPrintOperator {
    String printOperator(String string) {
        switch (string) {
                case "+": 
                    string = "\'+\' char(plus operator)";
                    break;
                case "-":
                    string = "\'-\' char(minus operator)";
                    break;
                case "*":
                    string = "\'*\' char(multiplication operator)";
                    break;
                case "/":
                    string = "\'-\' char(devision operator)";
                    break;
                case "%":
                    string = "\'-\' char(remainder operator)";
                    break;
                default:
                    //write in log
                    break;
        }
        return string;
    }
}
