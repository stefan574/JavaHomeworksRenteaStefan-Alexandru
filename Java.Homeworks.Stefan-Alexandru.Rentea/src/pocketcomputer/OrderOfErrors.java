/*
 * OrderOfErrors class
 */
package pocketcomputer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class OrderOfErrors {
    
    private int ok;
    private String aux;
    private List<String> list;
    
    public OrderOfErrors() {
        this.ok = 1;
        this.aux = null;
        list = null;
    }
    
    /*
     * Puts the errors in the order of appearance.
     */
    void displayErrorsInOrder(String string) {
        list = new ArrayList<>(Arrays.asList(string.split("\n")));
        string = "";
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).charAt(0) == 'X') {
                string = string + list.get(i) + "\n";
                list.remove(i);
                i--;
            }
        while(ok == 1) {
            ok = 0;
            for (int i = 0; i < list.size() - 1; i++)
                if (Integer.parseInt(list.get(i).substring(0,
                        list.get(i).indexOf(":")))
                        > Integer.parseInt(list.get(i + 1).substring(0,
                                list.get(i + 1).indexOf(":")))) {
                    aux = list.get(i + 1);
                    list.set(i + 1, list.get(i));
                    list.set(i, aux);
                    ok = 1;
                }
        }
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        System.out.println(string);
    }
    
}
