/*
 * Book Interface
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public interface Book {
    
    void printListOfAuthors();
    void addRating(double rating);
    String getIsbnValue();
    void addAuthor();
    String getSpecialField();
    
}
