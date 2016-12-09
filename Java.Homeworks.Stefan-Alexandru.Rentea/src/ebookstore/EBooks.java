/*
 * EBooks class
 */
package ebookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class EBooks {
    
    private final List<EBook> listOfEBooks;

    public EBooks() {
        this.listOfEBooks = new ArrayList<>();
    }
    
    public List<EBook> getListOfEBooks() {
        return listOfEBooks;
    }
    
    boolean addEBook(EBook eBook) {
        if (verifyExistenceOfEBook(eBook))
            return false;
        else {
            listOfEBooks.add(eBook);
            return true;
        }
    }
    
    void deleteEBook() {
        int choice;
        printListOfEBooks();
        if (!listOfEBooks.isEmpty()) {
            choice = new LegalValue().getLegalValue(listOfEBooks.size());
            listOfEBooks.remove(choice - 1);
            System.out.println("\nEBook Removed!\n");
        }
    }
    
    void addRatingToEBook() {
        int choice;
        String rating;
        printListOfEBooks();
        if (!listOfEBooks.isEmpty()) {
            choice = new LegalValue().getLegalValue(listOfEBooks.size());
            rating = new LegalValue().getLegalValue("Rating: ");
            listOfEBooks.get(choice - 1).addRating(Integer.parseInt(rating));
            System.out.println("\nRating Added!\n");
        }
    }
    
   void printListOfEBooks() {
       System.out.println();
       if (!listOfEBooks.isEmpty())
            for (int i = 0; i < listOfEBooks.size(); i++)
                System.out.println(i + 1 + ": "
                        + listOfEBooks.get(i).printEBook());
        else 
            System.out.println("List of EBooks is Empty!");
   }
    
    void printDetailedListOfEBooks() {
        System.out.println();
        if (!listOfEBooks.isEmpty())
            for (int i = 0; i < listOfEBooks.size(); i++) {
                System.out.print("Book_" + (i + 1) + ":\n");
                listOfEBooks.get(i).printDetailedEBook();
            }
        else 
            System.out.println("List of EBooks is Empty!");
    }
    
    private boolean verifyExistenceOfEBook(EBook eBook) {
        for (EBook eBookFromList : listOfEBooks)
            if (eBook.getNumberOfPages() == eBookFromList.getNumberOfPages()
                    && eBook.getTitle().equalsIgnoreCase(eBookFromList.getTitle()))
                for (Author author : eBook.getListOfAuthors())
                    for (Author authorFromList : eBookFromList.getListOfAuthors())
                        if (author.getFirstName()
                                .equalsIgnoreCase(authorFromList.getFirstName())
                                && author.getFamilyName()
                                        .equalsIgnoreCase(authorFromList.getFamilyName())
                                && author.getId() == authorFromList.getId())
                            return true;
        return false;
    }
    
}
