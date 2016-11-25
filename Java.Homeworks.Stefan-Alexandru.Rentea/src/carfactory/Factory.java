/*
 * Factory class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Factory {
    
    private Cars availableCars;
    private Customers customers;
    private Requests requests;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Factory() {
        this.availableCars = new Cars();
        this.customers = new Customers();
        this.customers.setFactory(this);
        this.requests = new Requests();
        this.requests.setFactory(this);
    }

    public Cars getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(Cars availableCars) {
        this.availableCars = availableCars;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }
    
    void displayAvailableCars() {
        System.out.println("Available Cars:\n");
        availableCars.displayCars();
    }
    
    void displayRequests() {
        System.out.println("Requests:\n");
        requests.displayRequests();
    }
    
    void displayCarsPerCustomers() {
        System.out.println("Delivered Cars Per Customer:\n");
        customers.displayCarsPerCustomer();
    }
    
    void removeFromAvailableCarsList() {
        availableCars.removeFromCarsList();
    }
    
}
