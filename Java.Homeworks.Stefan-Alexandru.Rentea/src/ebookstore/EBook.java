/*
 * EBook class
 */
package ebookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public abstract class EBook {
    
    private final String isbn;
    private final String title;
    private final int numberOfPages;
    private final double price;
    private double rating;
    private final List<Integer> listOfRatings;
    private final List<Author> listOfAuthors;

    public EBook() {
        this.isbn = getIsbnValue();
        this.title = new LegalValue().getLegalValue("Title: ");
        this.numberOfPages = Integer.parseInt(new LegalValue()
                .getLegalValue("Number of Pages: "));
        this.price = Integer.parseInt(new LegalValue()
                .getLegalValue("Price: "));
        this.rating = 0;
        this.listOfRatings = new ArrayList<>();
        this.listOfAuthors = new ArrayList<>();
        System.out.println("\nAdd Author:");
        addAuthor();
    }
    
    private String getRating() {
        if (rating == 0)
            return "No rating!";
        else
            return rating + "";
    }
    
    private void printListOfAuthors() {
        if (listOfAuthors.size() == 1) {
            System.out.print("Author: \n");
            listOfAuthors.get(0).printAuthor();
            System.out.println();
        }
        else {
            int i = 0;
            System.out.print("Author_" + i++ + ": \n");
            for (Author author : listOfAuthors) {
                author.printAuthor();
                System.out.println();
            }
        }
    }
    
    void addRating(int rating) {
        this.rating = 0;
        listOfRatings.add(rating);
        for (int ratingToAdd : listOfRatings)
            this.rating += ratingToAdd;
        this.rating = new DoublePrecision()
                .doPrecision(this.rating/listOfRatings.size(), 2);
    }

    private String getIsbnValue() {
        return (int)(Math.random()*900)+100 + "-"
                + (int)(Math.random()*90)+10 + "-"
                + (int)(Math.random()*90000)+10000 + "-"
                + (int)(Math.random()*900)+100;
    }
    
    private void addAuthor() {
        int firstAuthor, choice;
        firstAuthor = 0;
        while (true) {
            System.out.println("\n1. New Author.\n2. Existing Author.\n3."
                    + " Anonymous Author.\n4. Exit Authors Menu.");
            choice = new LegalValue().getLegalValue(4);
            if (choice == 1) {
                Author author = new Author();
                Authors.listOfAuthors.add(author);
                listOfAuthors.add(author);
                firstAuthor = 1;
            }
            else
                if (choice == 2) 
                    if (!Authors.listOfAuthors.isEmpty()) {
                        choice = new Authors().chooseFromListOfAuthors();
                        Author author = new Author(Authors.listOfAuthors.get(choice));
                        listOfAuthors.add(author);
                        firstAuthor = 1;
                    }
                    else 
                        System.out.println("The list of Authors is Empty!\n");
                else 
                    if (choice == 3) {
                        Author author = new Author("Anonymous");
                        Authors.listOfAuthors.add(author);
                        listOfAuthors.add(author);
                        firstAuthor = 1;
                    }
                    else
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
    
    String printEBook() {
         return "Title: " + title + ", ISBN: " + isbn;
    }
    
    void printDetailedEBook() {
        System.out.println("ISBN: " + isbn + "\nTitle: " + title
                + "\nNumber of Pages: " + numberOfPages
                + "\nPrice: " + price + "\nRating: " 
                + getRating() + "\n" + getSpecialField());
        printListOfAuthors();
    }
    
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getListOfAuthors() {
        return listOfAuthors;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public abstract String getSpecialField();
    
}