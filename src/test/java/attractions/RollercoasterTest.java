package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {
    Visitor visitor;
    RollerCoaster rollerCoaster;

    @Before public void setUp() {
        visitor = new Visitor(12, 145, 50);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }
    @Test public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }
    @Test public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }
    @Test public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }
    @Test public void hasDefaultPriceForVisitor() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }
    @Test public void hasDoublePriceForVisitor() {
        visitor = new Visitor(12, 210, 50);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }
}
