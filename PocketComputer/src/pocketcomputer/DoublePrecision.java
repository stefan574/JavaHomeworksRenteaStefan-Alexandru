/*
 * DoublePrecision class
 */
package pocketcomputer;

/**
 * @author Stefan-Alexandru Rentea
 */
public class DoublePrecision {
    
    private final int precision;
    private String string;

    public DoublePrecision() {
        this.precision = 3;
    }
    
    /*
     * Limits the number of digits after '.' char(period character).
     */
    double doPrecision(double number) {
        string = number + "";
        if (string.substring(string.indexOf(".")).length() > 2)
            string = string.substring(0, string.indexOf(".") + precision);
        return Double.parseDouble(string);
    }
    
}
