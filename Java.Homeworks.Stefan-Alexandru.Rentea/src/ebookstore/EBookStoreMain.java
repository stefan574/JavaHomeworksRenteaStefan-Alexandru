/*
 * Main class
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public class EBookStoreMain {
    
    /**
     * Main method starts the program by calling the eBookStoreMenu() method
     * 
     * @param args are the main method's parameters
     */
    public static void main(String[] args) {
        EBooksMenu.eBookStoreMenu(new EBookStore());
    }
    
}
