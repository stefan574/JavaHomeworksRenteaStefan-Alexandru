/*
 * TechnicalEBook class
 */
package ebookstoreDB;

/**
 * @author Stefan-Alexandru Rentea
 */
public class TechnicalEBook extends EBook {
    
    private final TechnicalType subject;

    public TechnicalEBook() {
        super();
        this.subject = TechnicalType.valueOf(new LegalValue()
                .getLegalValue("Subject: ").toUpperCase());
    }
    
    // for Test Class
    public TechnicalEBook(String isbn, String title, int numberOfPages, double price, double rating, TechnicalType subject) {
        super(isbn, title, numberOfPages, price, rating);
        this.subject = subject;
    }
    
    @Override
    public String getSpecialField() {
        return "Subject: " + subject;
    }
    
}
