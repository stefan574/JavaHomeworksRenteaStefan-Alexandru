/*
 * LegalValue class
 */
package ebookstore;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */
public class LegalValue {
    
    private Scanner scanner;
    private String string;
    
    String getLegalValue(String requestString) {
        WHILE:
        while(true) {
            System.out.println();
            if (requestString.equals("Type: ")) {
                System.out.println(Arrays.toString(NovelType.values()));
                System.out.println();
            }
            else
                if (requestString.equalsIgnoreCase("Subject: ")) {
                    System.out.println(Arrays.toString(TechnicalType.values()));
                    System.out.println();
                }
                else 
                    if (requestString.equalsIgnoreCase("Quality of paper: ")) {
                        System.out.println(Arrays.toString(ArtAlbumType.values()));
                        System.out.println();
                    }
            System.out.print(requestString);
            scanner = new Scanner(System.in);
            string = scanner.nextLine().trim(); 
            if (requestString.equals("Title: ")
                    || requestString.equals("First Name: ")
                    || requestString.equals("Family Name: ")) {
                for(int i = 0; i < string.length() - 1; i++)
                    if (!Character.isLetter(string.charAt(i))
                            && !Character.isDigit(string.charAt(i))) {
                        System.out.println("Try again:\n");
                        continue WHILE;
                    }
                break;
            }
            else 
                if (requestString.equals("Number of Pages: ")
                        && new IntVerifier().isInt(string)) {
                    if (Integer.parseInt(string) > 4
                            && Integer.parseInt(string) < 10000)
                        break;
                }
                else 
                    if (requestString.equals("Price: ")
                            && new IntVerifier().isInt(string)) {
                        if (Integer.parseInt(string) > -1
                            && Integer.parseInt(string) < 100000)
                        break;
                    }
                    else 
                        if (requestString.equals("yes/no")) {
                            if (string.equalsIgnoreCase("yes")
                                    || string.equalsIgnoreCase("no"))
                                break;
                        }
                        else 
                            if (requestString.equals("Type: ")) {
                                for (NovelType novelType : NovelType.values())
                                    if (string.equalsIgnoreCase(novelType.toString()))
                                        break WHILE;
                            }
                            else 
                                if (requestString.equals("Subject: ")) {
                                    for (TechnicalType technicalType : TechnicalType.values())
                                        if (string.equalsIgnoreCase(technicalType.toString()))
                                            break WHILE;
                                }
                                else 
                                    if (requestString.equalsIgnoreCase("Quality of paper: ")) {
                                        for (ArtAlbumType artAlbumType : ArtAlbumType.values())
                                            if (string.equalsIgnoreCase(artAlbumType.toString()))
                                                break WHILE;
                                    }
                                    else 
                                        if (requestString.equalsIgnoreCase("Rating: ")
                                                && new IntVerifier().isInt(string)) {
                                            if (Integer.parseInt(string) > 0
                                                && Integer.parseInt(string) < 6)
                                            break;
                                        }
        System.out.println("\nTry again!");
        }
        return string;
    }
    
    int getLegalValue(int requestInt) {
        while(true) {
            System.out.print("\nChoice: ");
            scanner = new Scanner(System.in);
            string = scanner.nextLine().trim();
            if (new IntVerifier().isInt(string) 
                    && Integer.parseInt(string) > 0
                    && Integer.parseInt(string) <= requestInt)
                break;
            System.out.println("\nTry Again!\n");
        }
        return Integer.parseInt(string);
    }
    
}
