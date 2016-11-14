/*
 * The Parser class - parses the input; the result will
 * be given to the Switch class. It makes sure that there
 * are no duplicates in the output, no bad requests, no mistakes.
 */

package operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */

public class Parser {
    static void doParse(String string) {
        int checkExit = 0;
        //Variable used to verify if options selected by user are valid.
        //Every element is separated by a ' ' char(space character), even
        //at the beggining and at the end.
        //The reason for this is to validate each option correctly. For example,
        //if we were to check if "options" string variable contains the "2"
        //option, it will say "yes", but the '2' char is present also in
        //the "12" option. If the option "2" were to be selected, and a method
        //associated with it didn't exist, that could only result in erroneos 
        // output or program crash.
        String options = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 ";
        String checkExists, checkNotExists = null;
        List<String> list = new ArrayList<>();
        
        //making the input a string of elements separated by a ' ' char(space character)
        string = string.replace(',', ' ');
        string = string.trim();
        while(string.contains("  "))
            string = string.replaceAll("  ", " ");
        
        String[] strings = string.split(" ");
        
        //eliminating duplicates
        for (String iterator : strings)
            if (!list.contains(iterator))
                list.add(iterator);
        
        //if option "19. All" is selected, all other options need to be removed
        //if option "18. Exit" is also selected, it will be added back to the list
        if (list.contains("19")) {
            if (list.contains("18")) 
                checkExit = 1;
            List<String> list1 = Arrays.asList(options.trim().split(" "));
            list.removeAll(list1);
            list.add("19");
            if (checkExit == 1)
                list.add("18");
        }
        
        //analyzing the options selected by the user
        for (String iterator : list) {
            //check to see if option "18. Exit" is selected
            if (iterator.contains("18")) {
                checkExit = 1;
                continue;
            }
            
            //To each option is added a ' ' char(space character), at the end
            //and at the back, so it can be verified if it exists in the
            //"options" string variable.
            //If it exists, then the option is valid, and it can be given
            //to the "doSwitch" method in order for it to be properly resolved.
            //If the option doesn't exist, it will be added to the 
            //"checkNotExists" string variable.
            checkExists = " " + iterator + " ";
            if (options.contains(checkExists))
                Switch.doSwitch(iterator);
            else
                //the illegal options are separated by a ',' char(comma character)
                checkNotExists = checkNotExists + iterator + ", ";
        }
        
        //if there were illegal options in the input, show them in the console
        if (checkNotExists != null){
            checkNotExists = checkNotExists.replaceFirst("null", "");
            checkNotExists = checkNotExists.trim();
            StringBuilder buffer = new StringBuilder(checkNotExists);
            //the last ',' char(comma character) will be replaced by a '.' 
            //char(period character), because there are no more illegal
            //options after it.
            checkNotExists = buffer.reverse().toString().replaceFirst(",",".");
            checkNotExists = new StringBuffer(checkNotExists).reverse().toString();
            //if a ',' char(comma character) exists in the "checkNotExists"
            //string variable, it means that there were more than one illegal
            //options selected by the user
            if (checkNotExists.contains(","))
                //if there are more then one illegal options selected, print
                //this line to the console
                System.out.println("\nThe following requests do not exist: " + checkNotExists);
            else
                //if there is just one illegal option selected, print this
                //line to the console
                System.out.println("\nThe following request does not exist: " + checkNotExists);        
        }
        
        //if option "18. Exit" is select, the program will terminate
        if (checkExit == 1)
            System.exit(0);
    }
}
