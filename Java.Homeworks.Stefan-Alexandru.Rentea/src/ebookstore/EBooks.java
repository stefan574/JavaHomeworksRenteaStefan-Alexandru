/*
 * EBooks class
 */
package ebookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
class EBooks {
    
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
            System.out.println("\nEBook Removed!");
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
                System.out.println();
            }
        else 
            System.out.println("List of EBooks is Empty!\n");
    }
    
    private boolean verifyExistenceOfEBook(EBook eBook) {
        
        int numberOfIdenticalAuthors = 0;
        
        for (EBook eBookFromList : listOfEBooks)
            if (eBook.getNumberOfPages() == eBookFromList.getNumberOfPages()
                    && eBook.getTitle().equalsIgnoreCase(eBookFromList.getTitle())
                    && eBook.getSpecialField().equalsIgnoreCase(eBookFromList.getSpecialField())
                    && eBook.getListOfAuthors().size() == eBookFromList.getListOfAuthors().size())
                for (Author author : eBook.getListOfAuthors())
                    numberOfIdenticalAuthors = eBookFromList.getListOfAuthors()
                            .stream().filter((authorFromList) -> 
                                    (author.getFirstName().equalsIgnoreCase(authorFromList.getFirstName())
                                            && author.getFamilyName().equalsIgnoreCase(authorFromList.getFamilyName())
                                            && author.getId() == authorFromList.getId())).map((_item) -> 1)
                            .reduce(numberOfIdenticalAuthors, Integer::sum);
        
        return numberOfIdenticalAuthors == eBook.getListOfAuthors().size();
    }
    
}
