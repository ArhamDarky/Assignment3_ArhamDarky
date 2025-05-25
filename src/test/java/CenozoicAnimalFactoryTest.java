//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class CenozoicAnimalFactoryTest {
    @Test
    void testEra() {
        AnimalAbstractFactory f = new CenozoicAnimalFactory();
        assertEquals("Cenozoic", f.getEra());
    }
    @Test
    void testLandAnimals() {
        AnimalAbstractFactory f = new CenozoicAnimalFactory();
        List<LandAnimal> land = f.createLandAnimals();
        assertEquals(3, land.size());
        assertEquals("Mammoth", land.get(0).getName());
    }
    @Test
    void testSeaAnimals() {
        AnimalAbstractFactory f = new CenozoicAnimalFactory();
        List<SeaAnimal> sea = f.createSeaAnimals();
        assertTrue(sea.stream().anyMatch(a -> a.getName().equals("Whale")));
    }
    @Test
    void testSkyAnimals() {
        AnimalAbstractFactory f = new CenozoicAnimalFactory();
        List<SkyAnimal> sky = f.createSkyAnimals();
        assertTrue(sky.stream().anyMatch(a -> a.getName().equals("Terror bird")));
    }
}
