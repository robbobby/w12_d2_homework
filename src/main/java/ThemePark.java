import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ThemePark {
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;
    ArrayList<IReviewed> reviewedItems;


    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls, ArrayList<IReviewed> reviewedItems) {
        this.attractions = attractions;
        this.stalls = stalls;
        this.reviewedItems = reviewedItems;
    }

    public int getAttractionsCount() {
        return attractions.size();
    }

    public int getStallCount() {
        return stalls.size();
    }

    public ArrayList<IReviewed> getReviewedItems() {
        return reviewedItems;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisitedAttraction(attraction);
        attraction.addVisitCount();
    }

    public HashMap<String, Integer> getAllReviews() {
        HashMap<String, Integer> reviews = new HashMap<>();
        reviewedItems.forEach((item) -> {
            reviews.put(item.getName(), item.getRating());
        });
        return reviews;
    }
    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {

        ArrayList<IReviewed> allAllowedFor = new ArrayList<>();
        reviewedItems.forEach(item -> {
            if(item.isAllowedTo((visitor))) allAllowedFor.add(item);
        });
        return allAllowedFor;
    }
}


