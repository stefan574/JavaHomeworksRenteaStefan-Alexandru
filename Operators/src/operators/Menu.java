/*
 * Menu class - displays the menu and reads
 * the arguments from the console.
 */
package operators;

import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Menu {
    
    static void menu() {
        
        System.out.println("\n1. int \t\t2. long \t3. short \t4. byte\n"
                + "5. char \t6. float \t7. double \t8. boolean\n"
                + "9. Integer \t10. Long \t11. Short \t12. Byte\n"
                + "13. Character \t14. Float \t15. Double \t16. Boolean\n"
                + "17. String \t18. Exit \t19. All\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choice: ");
        String string = scanner.nextLine();

        new Parser().doParse(string);

        menu();
    }
    
}
