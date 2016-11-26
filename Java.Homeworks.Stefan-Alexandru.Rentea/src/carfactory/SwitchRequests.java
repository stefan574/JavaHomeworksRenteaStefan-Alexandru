/*
 * SwitchRequests class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class SwitchRequests {
    
    /*
     * Chooses the appropriate response depending on the String operation
     */
    static void doRequestsSwitch(Requests requests, String option) {
        switch(option) {
            case "1" : 
                requests.displayRequests();
                break;
            case "2" :
                requests.resolveRequest();
                if (requests.getRequestsList().isEmpty())
                    FactoryMenu.factoryMenu(requests.getFactory());
                break;
            case "3" : 
                requests.removeFromRequestsList();
                if (requests.getRequestsList().isEmpty())
                    FactoryMenu.factoryMenu(requests.getFactory());
                break;
            case "4" :
                FactoryMenu.factoryMenu(requests.getFactory());
                break;
            case "5" :
                System.exit(0);
                //break; - not necessary
            default : 
                //write in log file
        }
        RequestsMenu.requestsMenu(requests);
    }
    
}
