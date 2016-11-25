/*
 * Ac class
 */
package pocketcomputer;

import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Ac {
    
    /*
     * Verifies if "AC" was pressed; if so, it will make 
     * a call to the menu() method with "0.0" as input.
     */
    void verifyAc(List<String> list) {
        for(int i = 0; i < list.size() - 1; i++)
            if ((list.get(i).equals("a") || list.get(i).equals("A"))
                    && (list.get(i + 1).equals("c") || list.get(i + 1).equals("C")))
                Menu.menu("0.0");
    }
    
}