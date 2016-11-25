/*
 * CustomerMenu class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class CustomerMenu {
    
    static void customerMenu(Customer customer) {
        String string = "Choice:    ";
        System.out.println("1. Display Details of Customer.\n2. Make Request of"
                + " Car.\n3. Buy Car.\n4. Sell Car.\n5. Repaint Car."
                + "\n6. Customers View\n7. Factory View.\n8. Exit.\n");
        string = new LegalValue().getLegalValue(string);
        SwitchCustomer.doCustomerSwitch(customer, string);
    }
    
}
