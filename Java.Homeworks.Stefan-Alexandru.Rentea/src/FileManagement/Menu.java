/*
 * Menu class
 */
package FileManagement;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Menu {
    
    static void menu(Contents contents) {
        System.out.println("1. Add Content to List of Contents.\n"
                + "2. Print List of Contents.\n"
                + "3. Create File.\n"
                + "4. Read File.\n"
                + "5. Write Content to File.\n"
                + "6. Delete Content from List of Contents.\n"
                + "7. Delete File.\n"
                + "8. Delete All Content from File.\n"
                + "9. Exit.");
        
     int choice = new LegalValue().getLegalValue(9);
     SwitchMenu.switchMenu(choice, contents);
    }
    
}
