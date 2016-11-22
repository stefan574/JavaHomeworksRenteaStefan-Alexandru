/*
 * ExitProgram class 
 */
package pocketcomputer;

import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class ExitProgram {
    
    /*
     * Verifies if the user wants to exit the program; if so,
     * it will make a call to the System.exit() method. 
     */
    void verifyExitProgram(List<String> list) {
        for(int i = 0; i < list.size() - 3; i++)
            if ((list.get(i).equals("e") || list.get(i).equals("E"))
                    && (list.get(i + 1).equals("x") || list.get(i + 1).equals("X"))
                    && (list.get(i + 2).equals("i") || list.get(i + 2).equals("I"))
                    && (list.get(i + 3).equals("t") || list.get(i + 3).equals("T")))
                System.exit(0);
    }
    
}
