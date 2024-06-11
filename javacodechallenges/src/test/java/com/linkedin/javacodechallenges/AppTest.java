package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertNotNull;

import org.junit.Test;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * Test redaction no file
     */
    @Test
    public void TestRedactionNoFile() {
        try {
            Path testFile = Files.createTempFile("jctest", ".txt");
            String[] redactList = { "ivy", "oats" };
            List<String> redactedList = App.redactTextFile(testFile.toAbsolutePath().toString(), redactList);
            assertTrue(redactedList.size() == 0);
            Files.delete(testFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            assertTrue(false);
            return;
        }
        assertTrue(true);
    }

    /**
     * Test redaction
     */
    @Test
    public void TestRedaction() {
        try {
            Path testFile = Files.createTempFile("jctest", ".txt");
            Files.writeString(testFile, "Mares eat oats and does eat oats and little lambs eat ivy.\n" +
                    "A kid'll eat ivy too, wouldn't you.");
            String[] redactList = { "ivy", "oats" };
            List<String> redactedList = App.redactTextFile(testFile.toAbsolutePath().toString(), redactList);
            assertTrue(redactedList.size() != 0);
            Files.delete(testFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            assertTrue(false);
            return;
        }
        assertTrue(true);
    }
}
