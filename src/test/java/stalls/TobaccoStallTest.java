package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {
    TobaccoStall tobaccoStall;
    Visitor visitor;

    @Before public void setUp() throws Exception {
        visitor = new Visitor(18, 183, 90);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
    }
    @Test public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }
    @Test public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }
    @Test public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }
    @Test public void checkIsAllowedToTrue() {
        assertTrue(tobaccoStall.isAllowedTo(visitor));
    }
    @Test public void checkIsAllowedToFalse() {
        visitor = new Visitor(12, 183, 90);
        assertFalse(tobaccoStall.isAllowedTo(visitor));
    }
}
