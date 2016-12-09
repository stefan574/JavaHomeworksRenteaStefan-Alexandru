/*
 * ArtAlbumEBook
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public class ArtAlbumEBook extends EBook {
    
    private final ArtAlbumType paperQuality;

    public ArtAlbumEBook() {
        super();
        this.paperQuality = ArtAlbumType.valueOf(new LegalValue()
                .getLegalValue("Quality of paper: ").toUpperCase());
    }
    
    @Override
    public String getSpecialField() {
        return "Paper Quality: " + paperQuality;
    }
    
}
