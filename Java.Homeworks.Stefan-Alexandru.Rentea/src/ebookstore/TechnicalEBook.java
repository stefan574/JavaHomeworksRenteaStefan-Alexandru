/*
 * TechnicalEBook class
 */
package ebookstore;

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
    
    @Override
    public String getSpecialField() {
        return "Subject: " + subject;
    }
    
}
