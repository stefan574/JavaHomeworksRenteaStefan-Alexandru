/*
 * RepetitiveElements Class
 */
package pocketcomputer;

import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class RepetitiveElements {
    
    private String string;
    private int j;
    
    /*
     * Eliminates repetitive elements from the numerical expression
     * except for numbers.
     */
    void eliminateRepetitive(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i).equals("+") || list.get(i).equals("-")
                    || list.get(i).equals("*") || list.get(i).equals("/")
                    || list.get(i).equals("%") || list.get(i).equals(".")) {
                string = list.get(i);
                j = i + 1;
                while((j < list.size()) && list.get(j).equals(string))
                        list.remove(j);
                }
        
        j = list.size() - 1;
            while((j >= 0) && list.get(j).equals("="))
                    list.remove(j--);
            
        for (j = 0; j < list.size() - 1; j++)
            if (list.get(j).contains("..")) {
                string = list.get(j);
                while(string.contains(".."))
                    string = string.replace("..", ".");
                list.set(j, string);
            }      
    }
    
}
