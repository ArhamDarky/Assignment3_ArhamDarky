//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

/**
 * Assignment3Singleton runs client code that tests both EagerSingleton and LazySingleton.
 * It randomly retrieves one of the three singleton instances and logs their access.
 */
import java.util.Random;

public class Assignment3Singleton {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            EagerSingleton s = EagerSingleton.getInstance(r.nextInt(3));
            System.out.println("Retrieved eager singleton " + s.getId());
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
        }

        for (int i = 0; i < 10; i++) {
            LazySingleton s = LazySingleton.getInstance(r.nextInt(3));
            System.out.println("Retrieved lazy singleton " + s.getId());
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
        }
    }
}

