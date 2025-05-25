//------------------------------------------------------
// Assignment 3
// Written by: Arham Darky  Student ID = 2186561
// For SES350 Section 602 – Spring 2025
//--------------------------------------------------------

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class NaturalHistoryMuseumTest {
    @Test
    void testMainOutputContainsEras() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        NaturalHistoryMuseum.main(new String[]{});

        String output = out.toString();
        assertTrue(output.contains("You are in the Cenozoic exhibition"));
        assertTrue(output.contains("You are in the Jurassic exhibition"));
        assertTrue(output.contains("A Mammoth stomping"));
        assertTrue(output.contains("A Pterodactyl gliding"));
    }
}
