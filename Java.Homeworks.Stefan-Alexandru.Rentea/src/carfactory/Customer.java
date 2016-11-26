/*
 * Customer class
 */
package carfactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Customer {
    
    private final long timeOfEmployment; 
    private final String name;
    private double money, taxes;
    private final double salary; 
    private final Cars ownedCars;
    private Customers customers;

    public Customer() {
        timeOfEmployment = System.currentTimeMillis();
        this.name = new LegalValue().getLegalValue("Name of Customer: ");
        this.salary = Double.parseDouble(new LegalValue()
                .getLegalValue("Salary of " + this.name + ": "));
        this.money = Double.parseDouble(new LegalValue()
                .getLegalValue("Initial sum of money of " + this.name + ": "));
        taxes = -money ;
        ownedCars = new Cars();
        customers = null;
    }

    public List<Car> getOwnedCars() {
        return ownedCars.getCarsList();
    }
    
    public String getName() {
        return name;
    }
    
    public void setTaxes(double tax) {
        this.taxes = this.taxes + tax;
    }
    
    /*
     * Simulates getting salary by growing the money variable each second
     * with a fix amount and subtracting the taxes paid up untill that moment
     */
    public double getMoney() {
        long time = (System.currentTimeMillis() - timeOfEmployment)/1000;
        money = new DoublePrecision().doPrecision((double)(salary*time)) - taxes;
        return money;
    }
    
    void makeRequest() {
        Car car = new Car();
        getCustomers().getFactory().getRequests().addToRequestsList(car);
    }
    
    void repaintCar() {
        if (!ownedCars.getCarsList().isEmpty()) {
            String string = "Which Car: ";
            displayCars();
            string = new LegalValue().getLegalValue(string
                    + getOwnedCars().size());
            String color = "Color: ";
            System.out.println(Arrays.toString(Color.values()) + "\n");
            color = new LegalValue().getLegalValue(color);
            System.out.println();
            if (!color.equalsIgnoreCase(ownedCars.getCarsList()
                    .get(Integer.parseInt(string) - 1).getColor().toString())) {
                ownedCars.getCarsList().get(Integer.parseInt(string) - 1)
                        .setColor(Color.valueOf(color));
                setTaxes(100.0);
                System.out.println("Car RePainted!\n");
            }
            else
                System.out.println("Car is already painted in the color " + color + "!\n");
        }
        else
            System.out.println("Customer doesn't have any car to repaint!\n");   
    }
    
    void buyCar() {
        if (!getCustomers().getFactory().getAvailableCars().getCarsList().isEmpty()) {
            String string = "Which Car: ";
            getCustomers().getFactory().displayAvailableCars();
            string = new LegalValue().getLegalValue(string + getCustomers()
                    .getFactory().getAvailableCars().getCarsList().size());
            Car car = new Car(getCustomers().getFactory().getAvailableCars()
                    .getCarsList().get(Integer.parseInt(string) - 1));
            if (this.getMoney() > car.getValue()) {
                this.ownedCars.getCarsList().add(car);
                setTaxes(car.getValue());
                System.out.println("Car bought!\n");
            }
            else
                System.out.println("Customer doesn't have the necessary money to "
                        + "buy the car.\nTry again later!\n");
        }
        else
            System.out.println("Available Cars List is Empty!\n");
    }
    
    void sellCar() {
        if (!ownedCars.getCarsList().isEmpty()) {
            String string = "Which Car: ";
            displayCars();
            string = new LegalValue().getLegalValue(string
                    + getOwnedCars().size());
            setTaxes(-ownedCars.getCarsList().get(Integer.parseInt(string) - 1)
                    .getValue());
            ownedCars.removeFromCarsList(ownedCars.getCarsList().get(Integer
                    .parseInt(string) - 1));
        }
        else
            System.out.println("Customer doesn't have any car to sell!\n");
    }
    
    void displayCars() {
        System.out.println("CustomerName: " + name + "\n");
        ownedCars.displayCars();
    }
    
    void displayDetails() {
        System.out.println("Name: " + name + "\nSalary: " + salary
                + "\nMoney: " + getMoney() + "\n\nCars:\n");
        ownedCars.displayCars();
    }
    
    void display() {
        System.out.println(". " + name + "\n");
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    
}
