/*
 * 
 */

package pocketcomputer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Stefan-Alexandru Rentea
 */

public class OrderOfBrackets {
    void verifyOrderOfBrackets(List<String> list) {
        //order of brackets: curlybraketopen = fiecare deschidere
        //curlybracketenvironement = 1, restul 2 -> semnifica inca n au 
        //aparut dar trebuie musai ca sa fie corecta sintaxa
        //canclose - verifica daca poate sa inchida acum, altfel eroare
        
        int check;
        int squareEnvironement = 0, roundEnvironement = 0;
        int curlyCanClose = 0;
        
        List<String> curlyOpen = new ArrayList<>();
        List<String> squareOpen = new ArrayList<>();
        List<String> roundOpen = new ArrayList<>();
        
        String string, error = "";
        
        ListIterator iterator = list.listIterator();
        
        while(iterator.hasNext()) {
            check = 1;
            string = iterator.next().toString();
            
            if (string.equals("{")) {
                if (squareEnvironement == 1) {
                    error = error + (iterator.nextIndex()) + ": Curly bracket"
                            + " connot be opened after [ bracket.\n";
                    check = 0;
                }
                if (roundEnvironement == 1) {
                    error = error + (iterator.nextIndex()) + ": Curly bracket"
                            + " connot be opened after ( bracket.\n";
                    check = 0;
                }
                if (check == 1) {
                    curlyCanClose++;
                    squareEnvironement = roundEnvironement = 2;
                    curlyOpen.add((iterator.nextIndex()) + ": Curly bracket opened but not closed.\n");
                }
            }
            
            if (string.equals("[")) {
                if (squareEnvironement == 1) {
                    error = error + (iterator.nextIndex()) + ": Square bracket"
                            + " connot be opened after [ bracket.\n";
                    check = 0;
                }
                if (roundEnvironement == 1) {
                    error = error + (iterator.nextIndex()) + ": Square bracket"
                            + " connot be opened after ( bracket.\n";
                    check = 0;
                }
                if (check == 1) {
                    squareEnvironement = 1;
                    roundEnvironement = 2;
                    squareOpen.add((iterator.nextIndex()) + ": Square bracket opened but not closed.\n");
                }
            }
            
            if (string.equals("(")) {
                if (roundEnvironement == 1) {
                    error = error + (iterator.nextIndex()) + ": Round bracket"
                            + " connot be opened after ( bracket.\n";
                    check = 0;
                }
                if (check == 1) {
                    roundEnvironement = 1;
                    roundOpen.add((iterator.nextIndex()) + ": Round bracket opened but not closed.\n");
                }
            }
            
            if (string.equals("}")&&(curlyCanClose >= 1)) {
                curlyCanClose--;
                curlyOpen.remove(curlyOpen.size() - 1);
                if (squareEnvironement == 2) {
                    error = error + (iterator.nextIndex()) + ": Curly bracket"
                            + " is closed before a pair of [] brackets is used.\n";
                    squareEnvironement = 0;
                }
                else
                    if (squareEnvironement == 1) {
                        error = error + (iterator.nextIndex()) + ": Curly bracket"
                            + " is closed before a ] bracket.\n";
                        squareEnvironement = 0;
                    }
                if (roundEnvironement == 2) {
                    error = error + (iterator.nextIndex()) + ": Curly bracket"
                                + " is closed before a pair of () brackets is used.\n";
                        roundEnvironement = 0;
                }
                else
                    if (roundEnvironement == 1) {
                        error = error + (iterator.nextIndex()) + ": Curly bracket"
                                + " is closed before a ) bracket.\n";
                        roundEnvironement = 0;
                    }
            }
            else
                if ((string.equals("}")&&(curlyCanClose == 0)))
                    error = error + (iterator.nextIndex()) + ": Curly bracket"
                                + " is closed before it was opened.\n";
            
            if (string.equals("]")&&(squareEnvironement == 1)) {
                squareEnvironement = 0;
                squareOpen.remove(squareOpen.size() - 1);
                if (roundEnvironement == 2) {
                    error = error + (iterator.nextIndex()) + ": Square bracket"
                                + " is closed before a pair of () brackets.\n";
                        roundEnvironement = 0;
                }
                else
                    if (roundEnvironement == 1) {
                        error = error + (iterator.nextIndex()) + ": Square bracket"
                                + " is closed before a ) bracket.\n";
                        roundEnvironement = 0;
                    }
            }
            else
                if ((string.equals("]")))
                    error = error + (iterator.nextIndex()) + ": Square bracket"
                                + " is closed before it was opened.\n";
            
            if (string.equals(")")&&(roundEnvironement == 1)) {
                roundEnvironement = 0;
                roundOpen.remove(roundOpen.size() - 1);
            }
            else
                if (string.equals(")"))
                    error = error + (iterator.nextIndex()) + ": Round bracket"
                            + " is closed before it was opened.\n";
        }
        
        for (String line : curlyOpen)
            error = error + line;
        for (String line : squareOpen)
            error = error + line;
        for (String line : roundOpen)
            error = error + line;
        
        System.out.println(error);
    }
}
