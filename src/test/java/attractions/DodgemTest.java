package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor;
    @Before public void setUp() throws Exception {
        visitor = new Visitor(12, 145, 50);
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }
    @Test public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }
    @Test public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }
    @Test public void canChargeCustomerFullPrice() {
        assertEquals(4.50f, dodgems.priceFor(visitor), 0.01f);
    }
    @Test public void canChargeCustomerHalfPrice() {
        visitor = new Visitor(11, 145, 50);
        assertEquals(2.25, dodgems.priceFor(visitor), 0.01f);
    }
}
