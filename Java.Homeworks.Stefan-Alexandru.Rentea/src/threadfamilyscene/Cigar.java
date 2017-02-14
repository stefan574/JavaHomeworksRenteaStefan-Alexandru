/*
 * Cigar Class
 */
package threadfamilyscene;

import java.util.concurrent.TimeUnit;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Cigar extends Thread {
    
    /**
     * Runs in the background, displaying a message.
     * If interrupted, it will end the program.
     */
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Cigar is cigaring");
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println("Cigar is put out!");
                break;
            }
        }
    }
    
}
