/*
 * EBooks class
 */
package ebookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stefan-Alexandru Rentea
 */
class EBooks {
    
    private final List<EBook> listOfEBooks;
    private final Map<EBook, List<Rating>> mapOfRatings;
    
    public EBooks() {
        this.listOfEBooks = new ArrayList<>();
        this.mapOfRatings = new HashMap<>();
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
        printListOfEBooks();
        if (!listOfEBooks.isEmpty()) {
            int choice = new LegalValue().getLegalValue(listOfEBooks.size());
            listOfEBooks.remove(choice - 1);
            System.out.println("\nEBook Removed!");
        }
    }
    
    void addRatingToEBook() {
        printListOfEBooks();
        if (!listOfEBooks.isEmpty()) {
            int choice = new LegalValue().getLegalValue(listOfEBooks.size());
            Rating rating = new Rating();
            listOfEBooks.get(choice - 1).addRating(rating.getRating());
            if (mapOfRatings.containsKey(listOfEBooks.get(choice - 1)))
                mapOfRatings.get(listOfEBooks.get(choice - 1)).add(rating);
            else {
                List<Rating> list = new ArrayList<>();
                list.add(rating);
                mapOfRatings.put(listOfEBooks.get(choice - 1), list);
            }
            System.out.println("\nRating Added!");
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
                if (mapOfRatings.containsKey(listOfEBooks.get(i))) {
                    int j = 1;
                    for (Rating rating : mapOfRatings.get(listOfEBooks.get(i)))
                        System.out.println("Rating_" + j++ + ": " + rating.printRating());
                }
                System.out.println();
            }
        else 
            System.out.println("List of EBooks is Empty!\n");
    }
    
    void modifyDescriptionOfRating() {
        if (!listOfEBooks.isEmpty())
            if (!mapOfRatings.isEmpty()) {
                printListOfEBooks();
                if (!listOfEBooks.isEmpty()) {
                    int choice = new LegalValue().getLegalValue(listOfEBooks.size()) - 1;
                    if (mapOfRatings.containsKey(listOfEBooks.get(choice))) {
                        int j = 1;
                        for (Rating rating : mapOfRatings.get(listOfEBooks.get(choice)))
                                System.out.println("\nRating_" + j++ + ": " + rating.printRating());
                        j = new LegalValue().getLegalValue(j--) - 1;
                        mapOfRatings.get(listOfEBooks.get(choice)).get(j).setDescription();
                    }
                    else
                        System.out.println("\nList of Ratings for this EBook is Empty!");
                }
            }
            else 
                System.out.println("\nList of Ratings is Empty!");
        else
            System.out.println("\nList of EBooks is Empty!");
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
