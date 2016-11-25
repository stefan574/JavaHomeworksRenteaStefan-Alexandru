/*
 * Requests class
 */
package carfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Requests {
    
    private final List<Car> requestsList;
    private Factory factory;

    public Requests() {
        this.requestsList = new ArrayList<>();
    }
    
    public List<Car> getRequestsList() {
        return requestsList;
    }
    
    public void addToRequestsList(Car car) {
        if (factory.getAvailableCars().verifyExistenceOfCarAvailability(car))
            System.out.println("Car Already Exists in Available Cars List!\n");
        else
            if (verifyExistenceOfCarRequest(car))
                System.out.println("Car Already Exists in Requests Cars List!\n");
            else {
                requestsList.add(car);
                System.out.println("Request added!\n");
            }
    }
    
    void removeFromRequestsList() {
        displayRequests();
        if (!requestsList.isEmpty()) {
            String string = "Which Request: ";
            string = new LegalValue().getLegalValue(string
                    + requestsList.size());
            requestsList.remove(Integer.parseInt(string) - 1);
            System.out.println("Request removed!\n");
        }
    }
    
    void displayRequests() {
        if (!requestsList.isEmpty()) {
            int i = 0;
            System.out.println("\nId      CarName     CarColor\n"
                    + "============================\n");
            for (Car car : requestsList) {
                System.out.println(++i + "      " + car.display());
            }
            System.out.println();
        }
        else
            System.out.println("Requests List is Empty!\n");
    }

    boolean verifyExistenceOfCarRequest(Car car) {
        for (Car request : requestsList)
            if (car.getName().equals(request.getName())
                    && car.getColor().equals(request.getColor())
                    && car.getValue() == request.getValue()) 
                return true;
        return false;
    }
    
    void resolveRequest() {
        if (requestsList != null && !requestsList.isEmpty()) {
            displayRequests();
            String string = "Which Request: ";
            string = new LegalValue().getLegalValue(string
                    + requestsList.size());
            Car car = new Car(requestsList.get(Integer.parseInt(string) - 1));
            getFactory().getAvailableCars().addToCarsList(car);
            requestsList.remove(Integer.parseInt(string) - 1);
            System.out.println("Request resolved!\n");
        }
        else
            System.out.println("Requests Cars List is Empty!\n");
    }
    
    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
    
}
