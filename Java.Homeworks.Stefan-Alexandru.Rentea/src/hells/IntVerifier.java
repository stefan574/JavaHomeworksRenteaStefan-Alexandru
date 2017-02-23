/*
 * IntVerifier class
 * #ProjectCarFactory
 */
package hells;

import java.util.regex.Pattern;

/**
 * @author Stefan-Alexandru Rentea
 */
public class IntVerifier {
    
    private final String pattern;
    private boolean bool;

    /**
     * Constructor for the IntVerifier Class
     */
    public IntVerifier() {
        this.pattern = "-?\\d+";
        this.bool = false;
    }
    
    /**
     * Uses a pattern to verify if given object can be converted to
     * an int type.
     * 
     * @param string is tested to see if it is an int
     * @return true or false, depending if @param string is an int or not
     */
    boolean isInt(String string) {
        bool = Pattern.matches(pattern, string);
        return bool;
    }
    
}
