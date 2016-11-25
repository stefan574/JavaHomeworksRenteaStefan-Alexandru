/*
 * Customers class
 */
package carfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Customers {
    
    private final List<Customer> customersList;
    private Factory factory;
    
    public Customers() {
        this.customersList = new ArrayList<>();
    }
    
    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void addToCustomersList(Customer customer) {
        customersList.add(customer);
        customer.setCustomers(this);
        System.out.println("Customer Added!\n");
    }
    
    public void removeFromCustomersList() {
        displayCustomersSimple();
        if (!customersList.isEmpty()) {
            String string = "Which Customer: ";
            string = new LegalValue().getLegalValue(string
                    + customersList.size());
            customersList.remove(Integer.parseInt(string) - 1);
            System.out.println("Customer removed!\n");
        }
    }
    
    void displayCarsPerCustomer() {
        if (!customersList.isEmpty())
            customersList.forEach((customer) -> {
                customer.displayCars();
            });
        else 
            System.out.println("Delivered Cars Per Customer List is Empty!\n");
    }
    
    void displayCustomers() {
        if (!customersList.isEmpty())
            customersList.forEach((customer) -> {
                System.out.println("Customer:\n");
                customer.displayDetails();
            });
        else
            System.out.println("Customers List is Empty!\n");
    }
    
    void displayCustomersSimple() {
        int i = 0;
        if (!customersList.isEmpty())
            for (Customer customer : customersList) {
                System.out.print(++i);
                customer.display();
            }
        else
            System.out.println("Customers List is Empty!\n");
    }
    
    void chooseCustomer() {
        String string = "Which Customer: ";
        if (!customersList.isEmpty()) {
            displayCustomersSimple();
            string = new LegalValue().getLegalValue(string
                    + customersList.size());
            CustomerMenu.customerMenu(customersList.get(Integer
                    .parseInt(string) - 1));
        }
        else
            System.out.println("Customers List is Empty!\n");
    }
    
    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
    
}
