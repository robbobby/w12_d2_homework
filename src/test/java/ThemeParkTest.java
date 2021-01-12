import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import stalls.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    ThemePark themePark;
    Attraction dodgems;
    Attraction park;
    Attraction playground;
    Attraction rollerCoaster;
    Stall candyflossStall;
    Stall iceCreamStall;
    Stall tobaccoStall;
    @Before public void setUp() {
        dodgems = new Dodgems("Dodgets Ride", 0);
        park = new Park("Park Ride", 0);
        playground = new Playground("Playerground Ride", 0);
        rollerCoaster = new RollerCoaster("Rollercoaster Ride", 0);
        candyflossStall = new CandyflossStall("The Candy Floss Stall", "Me", ParkingSpot.A1, 0);
        iceCreamStall = new IceCreamStall("The Candy Floss Stall", "Me", ParkingSpot.A1, 0);
        tobaccoStall = new IceCreamStall("The Candy Floss Stall", "Me", ParkingSpot.A1, 0);
        ArrayList<Attraction> attractions  = new ArrayList<>(
                Arrays.asList(dodgems, park, playground, rollerCoaster));
        ArrayList<Stall> stalls = new ArrayList<>(
                Arrays.asList(candyflossStall, iceCreamStall, tobaccoStall));
        ArrayList<IReviewed> reviewedItems = new ArrayList<>(
                Arrays.asList(dodgems, park, playground, rollerCoaster,
                        candyflossStall, iceCreamStall, tobaccoStall));
        themePark = new ThemePark(attractions, stalls, reviewedItems);
    }
    @Test public void hasAttractionList() {
        assertEquals(4, themePark.getAttractionsCount());
    }
    @Test public void hasStallList() {
        assertEquals(3, themePark.getStallCount());
    }
    @Test public void hasReviewedList() {
        assertEquals(7, themePark.getReviwedItemsCount());
    }
}
