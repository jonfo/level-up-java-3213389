package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testRollDice() {
        DoubleOrNothing dblOrNot = new DoubleOrNothing();
        int runs[] = { 0, 0 };
        for (int i = 0; i < 100000; i++) {
            runs[dblOrNot.rollDice() ? 1 : 0]++;
        }
        // System.out.println("runs[false] = " + runs[0]);
        // System.out.println("runs[true] = " + runs[1]);
        assertEquals(Math.round((float) runs[1] / (float) runs[0]), 1);
    }
}
