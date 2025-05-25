//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

/**
 * EagerSingleton implements a modified singleton pattern where
 * 3 instances are eagerly created at startup and accessed by index.
 */
public class EagerSingleton {
    private static final EagerSingleton[] instances = new EagerSingleton[3];
    private final int id;

    static {
        for (int i = 0; i < 3; i++) {
            instances[i] = new EagerSingleton(i);
            System.out.println("EagerSingleton " + i + " instantiated");
        }
    }

    private EagerSingleton(int id) {
        this.id = id;
    }

    public static EagerSingleton getInstance(int index) {
        return instances[index];
    }

    public int getId() {
        return id;
    }
}

