/*
 * Husband Class
 */
package threadfamilyscene;

import java.util.concurrent.TimeUnit;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Husband extends Thread {

    private final Thread wifeThread, vacuumThread;
    
    /**
     * Constructor for the Husband Class
     * 
     * @param wifeThread represents the thread that needs to be
     * interrupted when the appropriate show starts.
     * @param vacuumThread represents the thread that needs to be
     * interrupted before the wifeThread gets interrupted
     */
    public Husband(Thread wifeThread, Thread vacuumThread) {
        super();
        this.wifeThread = wifeThread;
        this.vacuumThread = vacuumThread;
        System.out.println("Husband started vacuuming");
    }
    
    /**
     * Getter for the show value from the wifeThread
     * 
     * @return the show associated with the wifeThread
     */
    public Shows getShow() {
        return ((Wife)wifeThread).getShow();
    }
    
    /**
     * Starts 2 Threads, the wifeThread and the vacuumThread.
     * Continuously displays a message.
     * If interrupted, it will interrupt the vacuumThread and the wifeThread.
     */
    @Override
    public void run() {
        wifeThread.start();
        vacuumThread.start();
        while(true) {
            try {
                System.out.println("Husband is husbanding");
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch(InterruptedException e) {
                System.out.println("Husband has to turn off the vacuum cleaner!");
                vacuumThread.interrupt();
                System.out.println("Husband has to wake wife!");
                wifeThread.interrupt();
                break;
            }
        }
    }
    
}
