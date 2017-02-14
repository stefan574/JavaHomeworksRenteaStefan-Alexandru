/*
 * FamilySceneMain Class
 */
package threadfamilyscene;

/**
 * Main method starts the program by creating and starting
 * a televisionThread Thread object.
 *
 * @author Stefan-Alexandru Rentea
 */
public class FamilySceneMain {
    
    public static void main(String[] args) throws InterruptedException {
        Thread televisionThread = new Television(
                new Husband(new Wife(new Cigar()), new VacuumCleaner()));
        televisionThread.start();
    }
    
}
