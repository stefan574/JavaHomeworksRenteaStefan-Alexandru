/*
 * 
 */

package pocketcomputer;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Stefan-Alexandru
 */

public class ExistenceOfElements {
    void verifyExistenceOfElements(List<String> list) {
        String elements = " { } ( ) [ ] / * - + % ";
        String string, error = "";
        ListIterator iterator = list.listIterator();
        
        while(iterator.hasNext()) {
            string = " " + iterator.next() + " ";
                if(!elements.contains(string)&&!(new DoubleVerifier().isDouble(string.trim()))) {
                //if (!(new DoubleVerifier().isDouble(string))||!elements.contains(string)) {
                    error = error + iterator.nextIndex() + ": Element "
                            + string + " is invalid\n";
                }
        }
        System.out.println(error);
    }
}
