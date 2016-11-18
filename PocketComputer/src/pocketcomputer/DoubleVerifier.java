/*
 * 
 */

package pocketcomputer;

import java.util.regex.Pattern;

/**
 * @author Stefan-Alexandru Rentea
 */

public class DoubleVerifier {
    String pattern = "-?\\d+\\.?\\d*";
    boolean bool;
    boolean isDouble(String string) {
        bool = Pattern.matches(pattern, string);
        return bool;
    }
}
