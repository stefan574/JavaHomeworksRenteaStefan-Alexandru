/*
 * EBookStore class
 */
package ebookstoreDB;

/**
 * @author Stefan-Alexandru Rentea
 */
class EBookStore {
    
    private final EBooks eBooks;

    /**
     * Default Constructor for EBookStore class
     */
    public EBookStore() {
        this.eBooks = new EBooks();
    }
    
    /**
     * Getter for eBooks field
     * 
     * @return eBooks field
     */
    public EBooks getEBooks() {
        return eBooks;
    }
    
}
