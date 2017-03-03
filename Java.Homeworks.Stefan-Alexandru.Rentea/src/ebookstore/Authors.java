/*
 * Authors class
 */
package ebookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Authors {
    
    static List<Author> listOfAuthors;
    
    static {
        listOfAuthors = new ArrayList<>();
    }
    
    /**
     * Returns the position of an author from the list of authors
     * 
     * @return the user choice of an existing author
     */
    int chooseFromListOfAuthors() {
        System.out.println();
        
        for (int i = 0; i < listOfAuthors.size(); i++)
            if (listOfAuthors.get(i).getFirstName().contains("nonymous")
                && listOfAuthors.get(i).getFamilyName() == null)
                System.out.println(i + 1 + ": " + listOfAuthors.get(i).getFirstName()
                        + ", id: " + listOfAuthors.get(i).getId());
            else 
                System.out.println(i + 1 + ": " + listOfAuthors.get(i).getFirstName()
                        + listOfAuthors.get(i).getFamilyName()
                        + ", id: " + listOfAuthors.get(i).getId());
        
        int choice = new LegalValue().getLegalValue(listOfAuthors.size());
        return choice - 1; 
    }
    
}
