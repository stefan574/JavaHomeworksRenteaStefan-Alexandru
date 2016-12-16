/*
 * EBookStore class
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
class EBookStore {
    
    private final EBooks eBooks;

    public EBookStore() {
        this.eBooks = new EBooks();
    }
    
    public EBooks getEBooks() {
        return eBooks;
    }
    
}
