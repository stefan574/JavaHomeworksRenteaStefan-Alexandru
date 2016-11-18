/*
 * 
 */
package pocketcomputer;

import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */

public class AC {
    void verifyAC(List<String> list) {
        for(int i = 0; i < list.size() - 2; i++)
            if ((list.get(i).equals("a")||list.get(i).equals("A"))
                    &&(list.get(i + 1).equals("c")||list.get(i + 1).equals("C")))
                Menu.menu("0.0");
    }
}
