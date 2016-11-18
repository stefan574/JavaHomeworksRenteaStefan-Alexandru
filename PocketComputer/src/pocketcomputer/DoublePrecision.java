/*
 * 
 */

package pocketcomputer;

/**
 * @author Stefan-Alexandru Rentea
 */

public class DoublePrecision {
    int precision = 3;
    String string = null;
    double doPrecision(double number) {
        string = number + "";
        if (string.substring(string.indexOf(".")).length() > 2)
            string = string.substring(0, string.indexOf(".") + precision);
        return Double.parseDouble(string);
    }
}
