/*
 * EBooksMenu
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public class EBooksMenu {
    
    static void eBookStoreMenu(EBookStore eBookStore) {
        System.out.println("1. Add EBook.\n2. Delete EBook.\n3. List EBooks.\n4. "
                + "List Detailed EBooks.\n5. Add Rating for EBook.\n6. Exit.");
    int choice = new LegalValue().getLegalValue(6);
    EBookStoreSwitch.eBookStoreSwitch(eBookStore, choice);
    }
    
}
