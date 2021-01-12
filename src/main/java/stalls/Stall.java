package stalls;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public abstract class Stall implements IReviewed {

    private String name;
    private String ownerName;
    private ParkingSpot parkingSpot;
    private int rating;

    @Override
    public int getRating() {
        return rating;
    }

    public Stall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        this.rating = rating;
        this.name = name;
        this.ownerName = ownerName;
        this.parkingSpot = parkingSpot;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return true;
    }
}
