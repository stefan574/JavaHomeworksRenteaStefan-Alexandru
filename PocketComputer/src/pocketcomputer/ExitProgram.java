/*
 * 
 */

package pocketcomputer;

import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */

public class ExitProgram {
    void verifyExitProgram(List<String> list) {
        for(int i = 0; i < list.size() - 3; i++)
            if ((list.get(i).equals("e")||list.get(i).equals("E"))
                    &&list.get(i + 1).equals("x")
                    &&list.get(i + 2).equals("i")
                    &&list.get(i + 3).equals("t"))
                System.exit(0);
    }
}
