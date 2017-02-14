/*
 * Parser class
 */
package operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Parser {
    
    private int checkExit;
    private final String options;
    private String checkExists, checkNotExists;
    private String[] strings;
    private final List<String> list;

    public Parser() {
        this.checkExit = 0;
        this.options = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 ";
        this.checkExists = null;
        this.checkNotExists = null;
        this.strings = null;
        this.list = new ArrayList<>();
    }
    
    /*
     * Searches the input for requests for which it will create
     * new instances of the Switch class. 
     * Mistakes such as duplicates, no input, bad requests, are 
     * also treated here.
     */
    void doParse(String string) {
        string = string.replace(',', ' ');
        string = string.trim();
        
        while(string.contains("  "))
            string = string.replaceAll("  ", " ");
        
        strings = string.split(" ");
        
        // eliminate duplicates in input
        for (String iterator : strings)
            if (!list.contains(iterator))
                list.add(iterator);
        
        /*
         * If option "19. All" is selected, all other options need to be removed,
         * only option "18. Exit" needs to remain.
         */
        for (String iterator : list)
            if (iterator.equals("19")) {
                for (String element : list)
                    if (element.equals("18")) {
                        checkExit = 1;
                        break;
                    }
                list.removeAll(Arrays.asList(options.trim().split(" ")));
                list.add("19");
                if (checkExit == 1)
                    list.add("18");
                break;
            }
        
        for (String iterator : list) {
            if (iterator.equals("18")) {
                checkExit = 1;
                continue;
            }
            /* 
             * A ' ' char(space character) is added to the front and back
             * so that identification becomes 100% accurate.
             */
            checkExists = " " + iterator + " ";
            
            if (options.contains(checkExists))
                new Switch().doSwitch(iterator);
            else
                // log illegal options or empty input
                checkNotExists = checkNotExists + iterator + ", ";
        }
        
        // display illegal options
        if (checkNotExists != null) {
            checkNotExists = checkNotExists.replaceFirst("null", "").trim();
            checkNotExists = checkNotExists.substring(0, checkNotExists.length() - 1) + "."; 
            
            if (checkNotExists.contains(","))
                System.out.println("\nThe following requests do not exist: " + checkNotExists);
            else
                if (checkNotExists.equals("."))
                    System.out.println("\nPlease insert input.");
                else
                    System.out.println("\nThe following request does not exist: " + checkNotExists);        
        }
        if (checkExit == 1)
            System.exit(0);
    }
    
}