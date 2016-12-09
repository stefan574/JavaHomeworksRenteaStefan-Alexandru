/*
 * NovellEBook class
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public class NovelEBook extends EBook {
    
    private final NovelType type;

    public NovelEBook() {
        super();
        this.type = NovelType.valueOf(new LegalValue()
                .getLegalValue("Type: ").toUpperCase());
    }

    @Override
    public String getSpecialField() {
        return "Novel Type: " + type;
    }
    
}
