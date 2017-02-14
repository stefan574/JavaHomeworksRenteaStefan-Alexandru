/*
 * VacuumCleaner Class
 */
package threadfamilyscene;

import java.util.concurrent.TimeUnit;

/**
 * @author Stefan-Alexandru Rentea
 */
public class VacuumCleaner extends Thread {
    
    /**
     * Runs in the background, displaying a message.
     */
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Vacuum cleaner is vacuuming");
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println("Vacuum is turned off!");
                break;
            }
        }
    }
    
}
