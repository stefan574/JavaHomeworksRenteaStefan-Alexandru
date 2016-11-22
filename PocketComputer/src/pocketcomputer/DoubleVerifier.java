/*
 * DoubleVerifier class
 */
package pocketcomputer;

import java.util.regex.Pattern;

/**
 * @author Stefan-Alexandru Rentea
 */
public class DoubleVerifier {
    
    private final String pattern = "-?\\d+\\.?\\d*";
    private boolean bool;
    
    /*
     * Uses a pattern to verify if given object can be converted to
     * a double type.
     */
    boolean isDouble(String string) {
        bool = Pattern.matches(pattern, string);
        return bool;
    }
    
}
