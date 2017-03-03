/*
 * DoublePrecision class
 */
package ebookstoreDB;

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
    
    double doPrecisionRating(double rating) {
        string = rating + "";
        if (string.substring(string.length() - 1).equals("0")
                || string.substring(string.length() - 1).equals("1")
                || string.substring(string.length() - 1).equals("2"))
            return Double.parseDouble(string.substring(0, 2) + "0");
        else
            if (string.substring(string.length() - 1).equals("8")
                    || string.substring(string.length() - 1).equals("9"))
                return Double.parseDouble((Integer.parseInt(string.substring(0, 1)) + 1) + ".0");
            else 
                return Double.parseDouble(string.substring(0, 2) + "5");
    }
    
}
