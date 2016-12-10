/*
 * DoublePrecision class
 */
package pocketcomputer;

/**
 * @author Stefan-Alexandru Rentea
 */
public class DoublePrecision {
    
    private String string;

    public DoublePrecision() {
        this.string = null;
    }
    
    /*
     * Limits the number of digits after '.' char(period character).
     */
    double doPrecision(double number, int precision) {
        string = number + "";
        if (string.substring(string.indexOf(".")).length() > 2)
            string = string.substring(0, string.indexOf(".") + precision);
        return Double.parseDouble(string);
    }
    
}
