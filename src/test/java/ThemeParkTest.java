import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThemeParkTest {
    Visitor visitor;
    ThemePark themePark;
    Attraction dodgems;
    Attraction park;
    Attraction playground;
    Attraction rollerCoaster;
    Stall candyflossStall;
    Stall iceCreamStall;
    Stall tobaccoStall;
    @Before public void setUp() {
        visitor = new Visitor(12,140,50);
        dodgems = new Dodgems("Dodgets Ride", 0);
        park = new Park("Park Ride", 0);
        playground = new Playground("Playerground Ride", 0);
        rollerCoaster = new RollerCoaster("Rollercoaster Ride", 20);
        candyflossStall = new CandyflossStall("The Candy Floss Stall", "Me", ParkingSpot.A1, 0);
        iceCreamStall = new IceCreamStall("The Candy Floss Stall", "Me", ParkingSpot.A1, 0);
        tobaccoStall = new TobaccoStall("The Candy Floss Stall", "Me", ParkingSpot.A1, 0);
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
        var reviewedItems =  themePark.getReviewedItems();
        assertEquals(7, reviewedItems.size());
        assertEquals(dodgems, reviewedItems.get(0));
    }
    @Test public void visitorCanVisitAttractions() {
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertTrue(visitor.doesVisitedAttractionsContains(rollerCoaster));
    }
    @Test public void canGetReviews() {
        HashMap<String, Integer> review = new HashMap<>();
        review.put(rollerCoaster.getName(), rollerCoaster.getRating());
        assertEquals(review.get(rollerCoaster.getName()), themePark.getAllReviews().get(rollerCoaster.getName()));
    }
    @Test public void canGetAllAllowedForRides() {
        ArrayList<IReviewed> ridesAllowedOn =  themePark.getAllAllowedFor(visitor);
        assertEquals(5, ridesAllowedOn.size());
    }
    @Test public void _canGetAllAllowedForRides() {
        visitor = new Visitor(19,140,50);
        ArrayList<IReviewed> ridesAllowedOn =  themePark.getAllAllowedFor(visitor);
        assertEquals(5, ridesAllowedOn.size());
        System.out.println(ridesAllowedOn);
    }
    @Test public void __canGetAllAllowedForRides() {
        visitor = new Visitor(13,150,50);
        ArrayList<IReviewed> ridesAllowedOn =  themePark.getAllAllowedFor(visitor);
        assertEquals(6, ridesAllowedOn.size());
    }
}
