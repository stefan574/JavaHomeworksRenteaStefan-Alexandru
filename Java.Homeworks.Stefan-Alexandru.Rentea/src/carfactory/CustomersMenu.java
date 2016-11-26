/*
 * CustomersMenu class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class CustomersMenu {
    
    /*
     * Displays the menu for the customers variable and switches to the
     * selected operation.
     */
    static void customersMenu(Customers customers) {
        String string = "Choice: ";
        System.out.println("1. Display List of Customers.\n2. Display Detailed "
                + "List of Customers.\n3. Add Customer.\n4. Delete Customer."
                + "\n5. Select Customer\n6. Factory View.\n7. Exit.\n");
        string = new LegalValue().getLegalValue(string);
        SwitchCustomers.doCustomersSwitch(customers, string);
    }
    
}
