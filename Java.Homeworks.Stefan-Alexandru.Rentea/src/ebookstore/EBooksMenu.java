/*
 * EBooksMenu
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public class EBooksMenu {
    
    /**
     * The menu for the eBookStore object
     * 
     * @param eBookStore represents the single most important object that
     * contains the list of ebooks
     */
    static void eBookStoreMenu(EBookStore eBookStore) {
        System.out.println("1. Add EBook.\n2. Delete EBook.\n3. List EBooks.\n4. "
                + "List Detailed EBooks.\n5. Add Rating for EBook.\n"
                + "6. Modify a Description of a Rating.\n7. Test.\n"
                + "8. Add Author to EBook.\n9. Add EBook to Author.\n10. Exit.");
        
    int choice = new LegalValue().getLegalValue(10);
    EBookStoreSwitch.eBookStoreSwitch(eBookStore, choice);
    }
    
}
