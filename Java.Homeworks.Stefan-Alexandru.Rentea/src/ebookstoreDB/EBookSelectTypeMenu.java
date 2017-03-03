/*
 * EBookSelectTypeMenu class
 */
package ebookstoreDB;

/**
 * @author Stefan-Alexandru Rentea
 */
public class EBookSelectTypeMenu {
    
    static void ebookSelectTypeMenu(EBooks eBooks) {
        boolean bool;
        System.out.println("\n1. Novel.\n2. Technical.\n3. Art Album.");
        int choice = new LegalValue().getLegalValue(3);
        switch (choice) {
            case 1 :
                EBook novelEBook = new NovelEBook();
                bool = eBooks.addEBook(novelEBook);
                if (bool)
                    System.out.println("\nNovel EBook Added!\n");
                else 
                    System.out.println("\nNovel Already Exists!\n");
                break;
            case 2 :
                EBook technicalEBook = new TechnicalEBook();
                bool = eBooks.addEBook(technicalEBook);
                if (bool)
                    System.out.println("\nTechnical EBook Added!\n");
                else 
                    System.out.println("\nTechnical Already Exists!\n");
                break;
            case 3 :
                EBook artAlbumEBook = new ArtAlbumEBook();
                bool = eBooks.addEBook(artAlbumEBook);
                if (bool)
                    System.out.println("\nArt Album EBook Added!\n");
                else 
                    System.out.println("\nArt Album Already Exists!\n");
                break;
            default :
                // write to log file
                break;
        }
    }
    
}
