/*
 * EBook class
 */
package ebookstoreDB;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
abstract class EBook implements Book {
    
    private final String isbn;
    private final String title;
    private final int numberOfPages;
    private final double price;
    private double rating;
    private final List<Double> listOfRatings;
    private final List<Author> listOfAuthors;

    /**
     * Default Constructor for the EBook class
     */
    public EBook() {
        this.isbn = getIsbnValue();
        this.title = new LegalValue().getLegalValue("Title: ");
        this.numberOfPages = Integer.parseInt(new LegalValue()
                .getLegalValue("Number of Pages: "));
        this.price = Double.parseDouble(new LegalValue()
                .getLegalValue("Price: "));
        this.rating = 0;
        this.listOfRatings = new ArrayList<>();
        this.listOfAuthors = new ArrayList<>();
        System.out.println("\nAdd Author:");
        addAuthor();
    }
    
    /**
     * Parameterized Constructor for the EBook class
     * 
     * @param isbn represents the value for the Isbn field
     * @param title represents the value for the title field
     * @param numberOfPages represents the value for the numberOfPages field
     * @param price represents the value for the price field
     * @param rating represents the value for the rating field
     */
    public EBook(String isbn, String title, int numberOfPages, double price, double rating) {
        this.isbn = isbn;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.rating = rating;
        this.listOfRatings = new ArrayList<>();
        this.listOfRatings.add(rating);
        this.listOfAuthors = new ArrayList<>();
    }
    
    /**
     * Getter for the rating field
     * 
     * @return "No rating" if rating is 0, else, the rating field as a String
     */
    public String getRating() {
        if (rating == 0)
            return "No rating!";
        else
            return rating + "";
    }
    
    /**
     * Getter for the rating field
     * 
     * @return rating field
     */
    public double getActualRating() {
        return this.rating;
    }
    
    /**
     * Prints the list of authors for a specific ebook
     */
    @Override
    public void printListOfAuthors() {
        if (listOfAuthors.size() == 1) {
            System.out.print("Author: ");
            listOfAuthors.get(0).printAuthor();
        }
        else {
            int i = 1;
            for (Author author : listOfAuthors) {
                System.out.print("Author_" + i++ + ": ");
                author.printAuthor();
            }
        }
    }
    
    /**
     * Adds a new rating for a specific ebook and calculates the new rating
     * 
     * @param rating the new rating value to be added
     */
    @Override
    public void addRating(double rating) {
        this.rating = 0;
        listOfRatings.add(rating);
        listOfRatings.forEach((ratingToAdd) -> {
            this.rating += ratingToAdd;
        });
        this.rating = new DoublePrecision()
                .doPrecision(this.rating/listOfRatings.size(), 2);
    }

    /**
     * Calculates a legal Isbn value for a ebook
     * The Isbn value will be something like "xxx-xx-xxxxx-xx".
     * 
     * @return a valid Isbn value
     */
    @Override
    public final String getIsbnValue() {
        return ((int)(Math.random() * 899) + 100) + "-"
                + ((int)(Math.random() * 89) + 10) + "-"
                + ((int)(Math.random() * 89999) + 10000) + "-"
                + ((int)(Math.random() * 899) + 100);
    }
    
    /**
     * Adds authors for a specific ebook
     */
    public final void addAuthor() {
        int firstAuthor, choice;
        firstAuthor = 0;
        while (true) {
            System.out.println("\n1. New Author.\n2. Existing Author.\n3."
                    + " Anonymous Author.\n4. Exit Authors Menu.");
            choice = new LegalValue().getLegalValue(4);
            if (choice == 1) {
                Author author = new Author();
                if (!checkExistenceOfAuthorAll(author))
                    if (!checkExistenceOfAuthor(author)) {
                        Authors.listOfAuthors.add(author);
                        listOfAuthors.add(author);
                        firstAuthor = 1;
                    }
                    else {
                        System.out.println("\nConnot Add Author, Author Already Exists for This EBook!");
                        Author.decrementCount();
                    }
                else {
                    System.out.println("\nCannot Create Author, Author Already Exists in the List Of Authors!");
                    Author.decrementCount();
                }
            }
            else
                if (choice == 2) 
                    if (!Authors.listOfAuthors.isEmpty()) {
                        choice = new Authors().chooseFromListOfAuthors();
                        Author author = new Author(Authors.listOfAuthors.get(choice));
                        if (!checkExistenceOfAuthor(author)) {
                            listOfAuthors.add(author);
                            firstAuthor = 1;
                        }
                        else
                            System.out.println("\nConnot Add Author, Author already exists!");
                    }
                    else 
                        System.out.println("\nThe List of Authors is Empty!");
                else 
                    if (choice == 3) {
                        Author author = new Author("Anonymous");
                        Authors.listOfAuthors.add(author);
                        listOfAuthors.add(author);
                        firstAuthor = 1;
                    }
                    else
                        /*
                         * If "exit" is selected and no author was created,
                         * an anonymous author will be automatically created.
                         */
                        if (choice == 4 && firstAuthor == 0) {
                            Author author = new Author("Anonymous");
                            Authors.listOfAuthors.add(author);
                            listOfAuthors.add(author);
                            break;
                        }
                        else
                            break;
        }
    }
    
    /**
     * Verifies if the author to be added already exists for an ebook
     * 
     * @param author is the author checked for existence
     * @return true or false, depending on the existence of the author object
     */
    public boolean checkExistenceOfAuthor(Author author) {
        return listOfAuthors.stream().anyMatch((_author) -> 
                (_author.getFirstName().equalsIgnoreCase(author.getFirstName())
                && _author.getFamilyName().equalsIgnoreCase(author.getFamilyName())));
    }
    
    public boolean checkExistenceOfAuthorAll(Author author) {
        return Authors.listOfAuthors.stream().anyMatch((_author) -> 
                (_author.getFirstName().equalsIgnoreCase(author.getFirstName())
                && _author.getFamilyName().equalsIgnoreCase(author.getFamilyName())));
    }
    
    /**
     * Getter for the title and Isbn fields merged into a String element
     * 
     * @return a String composed of the title and Isbn fields of an EBook
     */
    String printEBook() {
         return "Title: " + title + ", ISBN: " + isbn;
    }
    
    /**
     * Prints all the fields of an EBook
     */
    void printDetailedEBook() {
        System.out.println("ISBN: " + isbn + "\nTitle: " + title
                + "\nNumber of Pages: " + numberOfPages
                + "\nPrice: " + price + "\nRating: " 
                + getRating() + "\n" + getSpecialField());
        printListOfAuthors();
    }
    
    /**
     * Getter for the field title
     * 
     * @return the title field
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Getter for the numberOfPages field
     * 
     * @return the numberOfPages field 
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }
    
    /**
     * Getter for the price field used in the Test Class
     * 
     * @return 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter for the Isbn field used in the Test Class
     * 
     * @return 
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Getter for the listOfRating field
     * 
     * @return the listOfRatings field
     */
    public List<Double> getListOfRatings() {
        return listOfRatings;
    }
    
    /**
     * Getter for the listOfAuthors field
     * 
     * @return the listOfAuthors field
     */
    public List<Author> getListOfAuthors() {
        return listOfAuthors;
    }
    
    /**
     * Getter for the special field of each ebook
     * It is an abstract method, therefore it must be implemented.
     * 
     * @return the special field of the ebook as a String
     */
    @Override
    public abstract String getSpecialField();
    
}
