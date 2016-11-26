/*
 * ExistenceOfElements class
 */
package pocketcomputer;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Stefan-Alexandru Rentea
 */
public class ExistenceOfElements {
    
    private final String elements;
    private String string, error;
    private ListIterator iterator;

    public ExistenceOfElements() {
        this.elements = " { } ( ) [ ] / * - + % ";
        this.string = null;
        this.error = "";
        this.iterator = null;
    }
    
    /*
     * Verifies if the elements from the given list are 
     * legal and can be parsed.
     */
    String verifyExistenceOfElements(List<String> list) {
        
        iterator = list.listIterator();  
        
        while(iterator.hasNext()) {
            string = " " + iterator.next() + " ";
                if(!elements.contains(string) && 
                        !(new DoubleVerifier().isDouble(string.trim()))) {
                    error = error + iterator.nextIndex() + ": Element \'"
                            + string + "\' is invalid\n";
                }
        }
        return error;
    }
    
}
