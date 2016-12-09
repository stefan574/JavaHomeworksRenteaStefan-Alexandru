/*
 * EBookStore class
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public class EBookStore {
    
    private final EBooks eBooks;

    public EBookStore() {
        this.eBooks = new EBooks();
    }
    
    public EBooks getEBooks() {
        return eBooks;
    }
    
}
