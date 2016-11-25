/*
 * Cars class
 */
package carfactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Cars {
    
    private final List<Car> carsList;
    
    public Cars() {
        this.carsList = new ArrayList<>();
    }
    
    public List<Car> getCarsList() {
        return carsList;
    }

    public void addToCarsList(Car car) {
        carsList.add(car);
        System.out.println("\nCar added!\n");
    }
    
    void removeFromCarsList() {
        displayCars();
        if (!carsList.isEmpty()) {
            String string = "Which Car: ";
            string = new LegalValue().getLegalValue(string
                    + carsList.size());
            carsList.remove(Integer.parseInt(string) - 1);
            System.out.println("Car removed!\n");
        }
    }
    
    void removeFromCarsList(Car car) {
        carsList.remove(car);
        System.out.println("Car removed!\n");
    }
    
    void displayCars() {
        if (!carsList.isEmpty()) {
            int i = 0;
            System.out.println("\nId      CarName     CarColor\n"
                    + "============================\n");
            for (Car car : carsList) {
                System.out.println(++i + "      " + car.display());
            }
            System.out.println();
        }
        else
            System.out.println("Available Cars List is Empty!\n");
    }
    
    boolean verifyExistenceOfCarAvailability(Car car) {
        for (Car available : carsList)
            if (car.getName().equals(available.getName())
                    && car.getColor().equals(available.getColor())
                    && car.getValue() == available.getValue())
                return true;
        return false;
    }
    
}
