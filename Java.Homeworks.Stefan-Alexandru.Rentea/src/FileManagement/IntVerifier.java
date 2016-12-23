/*
 * IntVerifier class
 * #ProjectCarFactory
 */
package FileManagement;

import java.util.regex.Pattern;

/**
 * @author Stefan-Alexandru Rentea
 */
public class IntVerifier {
    
    private final String pattern;
    private boolean bool;

    public IntVerifier() {
        this.pattern = "-?\\d+";
        this.bool = false;
    }
    
    /*
     * Uses a pattern to verify if given object can be converted to
     * an int type.
     */
    boolean isInt(String string) {
        bool = Pattern.matches(pattern, string);
        return bool;
    }
    
}
