package com.linkedin.javacodechallenges;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Check the Person lname and fname values.
     * There could be more checks, but it would be better to 
     * add error checking in the code first.
     */
    @Test
    public void checkName() {
        Person p = new Person("Doe", "John", 21);
        assertFalse(p.getFname().isEmpty());
        assertFalse(p.getLname().isEmpty());
        Person p2 = new Person("Wick", "John", 20);
        p2.setLname("");
        assertTrue(p2.getLname().isEmpty());    
    }

    /**
     * Person.setAge() throws an IllegalArgumentException if the
     * new value is out of range.  This is probably overkill for
     * a range check.  Also is IllegalArgumentException or 
     * InvalidArgumentException more appopriate here?
     */
    @Test (expected = IllegalArgumentException.class)
    public void checkAge() {
        Person p = new Person("Doe", "John", 21);
        assertTrue(p.getAge() > 0 && p.getAge() < 150);
        p.setAge(200);
    }
}
