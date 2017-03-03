/*
 * EBooks class
 */
package ebookstoreDB;

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
    
    /**
     * Default Constructor for the EBooks class
     */
    public EBooks() {
        this.listOfEBooks = new ArrayList<>();
        this.mapOfRatings = new HashMap<>();
    }
    
    /**
     * Getter for the listOfEBooks field
     * 
     * @return the listOfEBooks field
     */
    public List<EBook> getListOfEBooks() {
        return listOfEBooks;
    }
    
    /**
     * Adds an ebook to the list of ebooks and returns true if the ebook
     * was added, or false if the ebook already exists.
     * 
     * @param eBook is the ebook to be added
     * @return true or false, depending on the result of the operation
     */
    boolean addEBook(EBook eBook) {
        if (verifyExistenceOfEBook(eBook))
            return false;
        else {
            listOfEBooks.add(eBook);
            return true;
        }
    }
    
    /**
     * Deletes an ebook from the list of ebooks
     */
    /*void deleteEBook() {
        printListOfEBooks();
        if (!listOfEBooks.isEmpty()) {
            int choice = new LegalValue().getLegalValue(listOfEBooks.size());
            listOfEBooks.remove(choice - 1);
            System.out.println("\nEBook Removed!");
        }
    }*/
    
    /**
     * Adds a rating to a specific ebook
     */
    void addRatingToEBook() {
        printListOfEBooks();
        if (!listOfEBooks.isEmpty()) {
            int choice = new LegalValue().getLegalValue(listOfEBooks.size());
            Rating rating = new Rating();
            if (mapOfRatings.containsKey(listOfEBooks.get(choice - 1))) {
                boolean ok = true;
                for (Rating _rating : mapOfRatings.get(listOfEBooks.get(choice - 1)))
                    if (_rating.getUserId() == rating.getUserId()) {
                        System.out.println("\nCannot Add the New Rating, User"
                                + " Already Rated this EBook!");
                        ok = false;
                        break;
                    }
                if (ok) {
                    mapOfRatings.get(listOfEBooks.get(choice - 1)).add(rating);
                    listOfEBooks.get(choice - 1).addRating(rating.getRating());
                    System.out.println("\nRating Added!");
                }
            }
            else {
                List<Rating> list = new ArrayList<>();
                list.add(rating);
                mapOfRatings.put(listOfEBooks.get(choice - 1), list);
                listOfEBooks.get(choice - 1).addRating(rating.getRating());
                System.out.println("\nRating Added!");
            }
        }
    }
   
    /**
     * Prints the list of ebooks with little details
     */
    void printListOfEBooks() {
        System.out.println();
        if (!listOfEBooks.isEmpty())
            for (int i = 0; i < listOfEBooks.size(); i++)
                System.out.println(i + 1 + ": "
                        + listOfEBooks.get(i).printEBook());
        else 
            System.out.println("Table EBOOKS is Empty!");
    }
    
    /**
     * Prints the list of ebooks with all details
     */
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
            System.out.println("The List of EBooks is Empty!\n");
    }
    
    /**
     * Modifies a description of a rating for a specific ebook
     */
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
                        System.out.println("\nThe List of Ratings for this EBook is Empty!");
                }
            }
            else 
                System.out.println("\nThe List of Ratings is Empty!");
        else
            System.out.println("\nThe List of EBooks is Empty!");
    }
    
    /**
     * Verifies if an ebook already exists
     * 
     * @param eBook is the ebook which will be tested for existence in the
     * list of ebooks
     * @return returns true or false, depending on the existence of the 
     * @param eBook in the list of ebooks
     */
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
    
    void addAuthorToEbook() {
        printListOfEBooks();
        if (!listOfEBooks.isEmpty()) {
            int choice = new LegalValue().getLegalValue(listOfEBooks.size());
            listOfEBooks.get(choice - 1).addAuthor();
        }
    }
    
    void addEBookToAuthor() {
        if (!Authors.listOfAuthors.isEmpty()) {
            printListOfEBooks();
            if (!listOfEBooks.isEmpty()) {
                int choiceEBook = new LegalValue().getLegalValue(listOfEBooks.size());
                int choiceAuthor = new Authors().chooseFromListOfAuthors();
                if (!listOfEBooks.get(choiceEBook - 1).checkExistenceOfAuthor(Authors.listOfAuthors.get(choiceAuthor))) {
                    listOfEBooks.get(choiceEBook - 1).getListOfAuthors().add(Authors.listOfAuthors.get(choiceAuthor));
                    System.out.println("\nEBook Added to Author!");
                }
                else
                    System.out.println("\nConnot Add EBook to Author, EBook Already Exists!");
            }
        }
        else
            System.out.println("\nThe List of Authors is Empty!");
    }
}
