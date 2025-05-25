//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------


/**
 * NaturalHistoryMuseum.java
 *
 * Uses the Abstract Factory pattern to simulate museum exhibits for different prehistoric eras.
 * Each era factory provides land, sea, and sky animal exhibits.
 * The main method loops through all configured eras and prints each exhibit section.
 */
import java.util.*;

interface Animal {
    String getName();
    String getWalking();
    default String getSwimming() { return ""; }
    default String getFlying()   { return ""; }
}

interface LandAnimal extends Animal {}
interface SeaAnimal  extends Animal { @Override String getSwimming(); }
interface SkyAnimal  extends Animal { @Override String getFlying(); }

interface AnimalAbstractFactory {
    String getEra();
    List<LandAnimal> createLandAnimals();
    List<SeaAnimal>  createSeaAnimals();
    List<SkyAnimal>  createSkyAnimals();
}

// === Cenozoic Factory & Animals ===
class CenozoicAnimalFactory implements AnimalAbstractFactory {
    public String getEra() { return "Cenozoic"; }
    public List<LandAnimal> createLandAnimals() {
        return List.of(new Mammoth(), new CaveLion(), new WoollyRhino());
    }
    public List<SeaAnimal> createSeaAnimals() {
        return List.of(new Whale(), new Otodus());
    }
    public List<SkyAnimal> createSkyAnimals() {
        return List.of(new TerrorBird(), new Argentavis());
    }
}

class Mammoth    implements LandAnimal    { public String getName(){return "Mammoth";}    public String getWalking(){return "stomping";} }
class CaveLion   implements LandAnimal    { public String getName(){return "Cave lion";}   public String getWalking(){return "walking";} }
class WoollyRhino implements LandAnimal    { public String getName(){return "Woolly rhino";}public String getWalking(){return "running";} }
class Whale      implements SeaAnimal     { public String getName(){return "Whale";}      public String getSwimming(){return "swimming";} public String getWalking(){return "";} }
class Otodus     implements SeaAnimal     { public String getName(){return "Otodus";}     public String getSwimming(){return "hunting";}  public String getWalking(){return "";} }
class TerrorBird implements SkyAnimal     { public String getName(){return "Terror bird";}public String getFlying(){return "running";}  public String getWalking(){return "sprinting";} }
class Argentavis implements SkyAnimal     { public String getName(){return "Argentavis";}public String getFlying(){return "flapping";}  public String getWalking(){return "";} }

// === Jurassic Factory & Animals ===
class JurassicAnimalFactory implements AnimalAbstractFactory {
    public String getEra() { return "Jurassic"; }
    public List<LandAnimal> createLandAnimals() {
        return List.of(new Stegosaurus(), new Allosaurus());
    }
    public List<SeaAnimal> createSeaAnimals() {
        return List.of(new Plesiosaurus());
    }
    public List<SkyAnimal> createSkyAnimals() {
        return List.of(new Pterodactyl());
    }
}

class Stegosaurus   implements LandAnimal { public String getName(){return "Stegosaurus";}    public String getWalking(){return "stomping";} }
class Allosaurus    implements LandAnimal { public String getName(){return "Allosaurus";}     public String getWalking(){return "charging";} }
class Plesiosaurus  implements SeaAnimal  { public String getName(){return "Plesiosaurus";}public String getSwimming(){return "swimming swiftly";} public String getWalking(){return "";} }
class Pterodactyl   implements SkyAnimal  { public String getName(){return "Pterodactyl";} public String getFlying(){return "gliding";}    public String getWalking(){return "skipping";} }

// === Triassic Factory & Animals ===
class TriassicAnimalFactory implements AnimalAbstractFactory {
    public String getEra() { return "Triassic"; }
    public List<LandAnimal> createLandAnimals() {
        return List.of(new Coelophysis(), new Plateosaurus());
    }
    public List<SeaAnimal> createSeaAnimals() {
        return List.of(new Nothosaurus());
    }
    public List<SkyAnimal> createSkyAnimals() {
        return List.of(new Eudimorphodon());
    }
}

class Coelophysis    implements LandAnimal { public String getName(){return "Coelophysis";}   public String getWalking(){return "darting";} }
class Plateosaurus   implements LandAnimal { public String getName(){return "Plateosaurus";}public String getWalking(){return "marching";} }
class Nothosaurus    implements SeaAnimal  { public String getName(){return "Nothosaurus";} public String getSwimming(){return "lurking";}   public String getWalking(){return "";} }
class Eudimorphodon  implements SkyAnimal  { public String getName(){return "Eudimorphodon";}public String getFlying(){return "soaring";}    public String getWalking(){return "skittering";} }

// === Main Runner ===
public class NaturalHistoryMuseum {
    public static void main(String[] args) {
        List<AnimalAbstractFactory> factories = List.of(
                new CenozoicAnimalFactory(),
                new JurassicAnimalFactory(),
                new TriassicAnimalFactory()
        );

        for (AnimalAbstractFactory f : factories) {
            System.out.println("You are in the " + f.getEra() + " exhibition");

            System.out.println("===== " + f.getEra() + " land animals section =====");
            for (LandAnimal a : f.createLandAnimals()) {
                System.out.println("A " + a.getName() + " " + a.getWalking());
            }

            System.out.println("===== " + f.getEra() + " sea animals section =====");
            for (SeaAnimal a : f.createSeaAnimals()) {
                System.out.println("A " + a.getName() + " " + a.getSwimming());
            }

            System.out.println("===== " + f.getEra() + " sky animals section =====");
            for (SkyAnimal a : f.createSkyAnimals()) {
                System.out.println("A " + a.getName() + " " + a.getFlying());
            }

            System.out.println("Thank you for visiting the " + f.getEra() + " exhibition!\n");
        }
    }
}
