//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

/**
 * LazySingleton implements a modified singleton pattern where
 * up to 3 instances are created lazily only when accessed.
 */
public class LazySingleton {
    private static final LazySingleton[] instances = new LazySingleton[3];
    private final int id;

    private LazySingleton(int id) {
        this.id = id;
        System.out.println("LazySingleton " + id + " instantiated");
    }

    public static LazySingleton getInstance(int index) {
        if (instances[index] == null) {
            instances[index] = new LazySingleton(index);
        }
        return instances[index];
    }

    public int getId() {
        return id;
    }
}
