/*
 * Television Class
 */
package threadfamilyscene;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Television extends Thread {
    
    private final Random random;
    private final Shows[] shows;
    private final Thread husbandThread;

    /**
     * Constructor for the Television Class
     * 
     * @param husbandThread represents the thread that needs to be
     * interrupted when the appropriate show starts.
     */
    public Television(Thread husbandThread) {
        super();
        this.random = new Random();
        this.shows = Shows.values();
        this.husbandThread = husbandThread;
    }
        
    /**
     * Starts the husbandThread Thread.
     * Chooses a random value from the Shows[] shows, and then
     * displays it on the standard output stream.
     * If the random value equals the searched value, the husbandThread
     * will be interrupted.
     */
    @Override
    public void run() {
        husbandThread.start();
        int i;
        try {
            while(true) {
                i = random.nextInt(shows.length);
                System.out.println("Curent show: " + shows[i]);
                if (shows[i].equals(((Husband)husbandThread).getShow()))
                    throw new InterruptedException();
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            husbandThread.interrupt();
        }
    }
    
}
