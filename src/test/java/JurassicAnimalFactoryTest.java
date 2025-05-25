//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class JurassicAnimalFactoryTest {
    @Test
    void testEra() {
        AnimalAbstractFactory f = new JurassicAnimalFactory();
        assertEquals("Jurassic", f.getEra());
    }
    @Test
    void testLandAnimals() {
        AnimalAbstractFactory f = new JurassicAnimalFactory();
        List<LandAnimal> land = f.createLandAnimals();
        assertEquals(2, land.size());
        assertEquals("Stegosaurus", land.get(0).getName());
    }
    @Test
    void testSeaAnimals() {
        AnimalAbstractFactory f = new JurassicAnimalFactory();
        List<SeaAnimal> sea = f.createSeaAnimals();
        assertEquals("Plesiosaurus", sea.get(0).getName());
    }
    @Test
    void testSkyAnimals() {
        AnimalAbstractFactory f = new JurassicAnimalFactory();
        List<SkyAnimal> sky = f.createSkyAnimals();
        assertEquals("Pterodactyl", sky.get(0).getName());
    }
}
