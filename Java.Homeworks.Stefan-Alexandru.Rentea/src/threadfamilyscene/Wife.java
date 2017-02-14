/*
 * Wife Class
 */
package threadfamilyscene;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Wife extends Thread {
    
    private final Random random;
    private final Shows show;
    private final Thread cigarThread;
    
    /**
     * Constructor for the Wife Class
     * 
     * @param cigarThread represents the thread that needs to be interrupted
     * after the wifeThread is interrupted
     */
    public Wife(Thread cigarThread) {
        this.random = new Random();
        this.show = Shows.values()[random.nextInt(Shows.values().length)];
        this.cigarThread = cigarThread;
    }

    /**
     * Getter for the show value
     * 
     * @return the show
     */
    public Shows getShow() {
        return show;
    }
    
    /**
     * Starts the cigarThread Thread.
     * Continuously displays a message.
     * If interrupted, it will interrupt the cigarThread.
     */
    @Override
    public void run() {
        cigarThread.start();
        while (true) {
            try {
                System.out.println("Wife is sleeping");
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Wife is awake!");
                System.out.println("Wife needs to put out the cigar!");
                cigarThread.interrupt();
                break;
            }
        }
    }
    
}
