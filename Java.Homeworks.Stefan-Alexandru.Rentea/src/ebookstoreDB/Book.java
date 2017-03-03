/*
 * Book Interface
 */
package ebookstoreDB;

/**
 * @author Stefan-Alexandru Rentea
 */
public interface Book {
    
    void printListOfAuthors();
    void addRating(double rating);
    String getIsbnValue();
    String getSpecialField();
    
}
