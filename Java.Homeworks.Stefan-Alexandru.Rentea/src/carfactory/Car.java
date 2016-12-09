/*
 * Car class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Car {
    
    private final String name;
    private Color color;
    private final double value;

    public Car() {
        this.name = new LegalValue().getLegalValue("Name of Car: ");
        this.color = Color.valueOf(new LegalValue().getLegalValue("Color of Car: "));
        this.value = Double.parseDouble(new LegalValue().getLegalValue("The value of the car is: "));
        System.out.println();
    }
    
    public Car(Car car) {
        this.name = car.getName();
        this.color = car.getColor();
        this.value = car.getValue();
    }
    
    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public double getValue() {
        return value;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    String display() {
        return name + "     " + color;
    }
    
}
