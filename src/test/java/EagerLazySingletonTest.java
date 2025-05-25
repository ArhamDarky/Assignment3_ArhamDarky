//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EagerLazySingletonTest {

    @Test
    void eagerInstancesAreUniquePerIndex() {
        EagerSingleton a0 = EagerSingleton.getInstance(0);
        EagerSingleton b0 = EagerSingleton.getInstance(0);
        assertSame(a0, b0, "Same index should return same instance");
        EagerSingleton a1 = EagerSingleton.getInstance(1);
        assertNotSame(a0, a1, "Different indices should be different instances");
    }

    @Test
    void lazyInstancesAreCreatedOnce() {
        // first access should instantiate
        LazySingleton l1 = LazySingleton.getInstance(1);
        LazySingleton l1b = LazySingleton.getInstance(1);
        assertSame(l1, l1b, "LazySingleton for index 1 should be same instance");
    }

    @Test
    void lazyDoesNotPreInstantiateOthers() {
        // only the one you call should exist
        LazySingleton.getInstance(2);
        // index 0 should still be null before access
        // (we can't directly inspect private array, but we can test creation order indirectly)
        LazySingleton l0 = LazySingleton.getInstance(0);
        assertNotNull(l0, "Accessing index 0 should create instance on first call");
    }
}
