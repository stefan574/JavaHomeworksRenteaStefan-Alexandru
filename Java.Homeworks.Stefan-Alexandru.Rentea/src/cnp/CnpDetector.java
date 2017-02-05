/*
 * CnpDetector Class
 */
package cnp;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Stefan-Alexandru Rentea
 */
public class CnpDetector {
    
    private static List<String> cnps;
    private static String regex;
                
    /**
     * Constructor for the CnpDetector Class
     */
    public CnpDetector() {
        cnps = new ArrayList<>();
        regex = // the first digit is a natural number between 1 and 9
                "[1-9]"
                // the 2nd and 3rd digits are two natural numbers,
                // together they form a number between 01 to 99
                + "[0-9]{2}"
                // the 4th and 5th digits are two natural numbers
                // together they form a number between 01 to 12
                // the 6th and 7th digits are two natural numbers,
                // together they form a number between 01 to 31
                // february
                + "((02((0[1-9])|(1|2[0-9])))"
                // months with 31 days
                + "|(((01)|(03)|(05)|(07)|(08)|(10)|(12))((0[1-9])|(1|2[0-9])|(3[0-2])))"
                // months with 30 days
                + "|(((02)|(04)|(06)|(09)|(11))((0[1-9])|(1|2[0-9])|(30|1))))"
                // the 8th and 9th digits are two natural numbers,
                // together they form a number between 01 to 52
                + "((0[1-9])|([1-3][0-9]|(4[0-6])|(5[0-2])))"
                // the 10th, 11th and 12th digits are three natural
                // numbers, together they form a number between
                // 001 to 999
                + "((00[1-9])|(0[1-9][0-9])|([1-9][0-9][0-9]))"
                // the 13th digit is a natural number between 0 and 9
                + "[0-9]";
    }
    
    /**
     * Simulates user input
     */
    void readInput() {
        String parameters = "1920229351141 3861126024253";
        System.setIn(new ByteArrayInputStream(parameters.getBytes()));
        Scanner scanner = new Scanner (System.in);
        addToListOfCnp(scanner.nextLine());
        System.setIn(System.in);
    }
    
    /**
     * Adds to the list of personal numerical codes
     * 
     * @param line represents a line of user input
     */
    private void addToListOfCnp(String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()) 
                cnps.add(matcher.group());
        if (!cnps.isEmpty())
        cnps.forEach((cnp) -> {
            System.out.println("CNP" + "_" + cnps.indexOf(cnp) + ": " + cnp + "\n");
            new CnpValidater().validate(cnp);
        });
        else
            System.out.println("No CNP detected!\n");
    }
    
}
