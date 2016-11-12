/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefan-Alexandru Rentea
 */

public class Switch {
    static void doSwitch(String string){
        switch(string) {
        case "1" : {
            AllOperators.forInt();  
            break;
        }
        case "2" : {
            AllOperators.forLong();
            break;
        }
        case "3" : {
            AllOperators.forShort();
            break;
        }
        case "4" : {
            AllOperators.forByte();
            break;
        }
        case "5" : {
            AllOperators.forChar();
            break;
        }
        case "6" : {
            AllOperators.forBoolean();
            break;
        }
        case "7" : {
            AllOperators.forFloat();
            break;
        }
        case "8" : {
            AllOperators.forDouble();
            break;
        }
        case "9" : {
            AllOperators.forIntWrapper();
            break;
        }
        case "10" : {
            AllOperators.forLongWrapper();
            break;
        }
        case "11" : {
            AllOperators.forByteWrapper();
            break;
        }
        case "12" : {
            AllOperators.forCharWrapper();
            break;
        }
        case "13" : {
            AllOperators.forShortWrapper();
            break;
        }
        case "14" : {
            AllOperators.forFloatWrapper();
            break;
        }
        case "15" : {
            AllOperators.forDoubleWrapper();
            break;
        }
        case "16" : {
            AllOperators.forBooleanWrapper();
            break;
        }
        case "17" : {
            AllOperators.forString();
            break;
        }
        case "18" : {
            System.exit(0);
        }
    }
    }
    static void doParse(String string) {
        int checkExit = 0;
        String options = " 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 ";
        String checkExists, checkNotExists = null;
        List<String> list = new ArrayList<String>();
        
        string = string.replace(',', ' ');
        string = string.trim();
        while(string.contains("  "))
            string = string.replaceAll("  ", " ");
        
        String[] strings = string.split(" ");
         
        for (String iterator : strings)
            if (!list.contains(iterator))
                list.add(iterator);
        
        for (String iterator : list) {
            if (iterator.contains("18")) {
                checkExit = 1;
                continue;
            }
            
            checkExists = " " + iterator + " ";
            if (options.contains(checkExists))
                doSwitch(iterator);
            else
                checkNotExists = checkNotExists + iterator + ", ";
        }
        
        if (checkNotExists != null){
            checkNotExists = checkNotExists.replaceFirst("null", "");
            checkNotExists = checkNotExists.trim();
            StringBuilder buffer = new StringBuilder(checkNotExists);
            checkNotExists = buffer.reverse().toString().replaceFirst(",",".");
            checkNotExists = new StringBuffer(checkNotExists).reverse().toString();
            if (checkNotExists.contains(","))
                System.out.println("\nThe following requests do not exist: " + checkNotExists);
            else
                System.out.println("\nThe following request does not exist: " + checkNotExists);        
        }
        
        if (checkExit == 1)
            System.exit(0);
    }
}

