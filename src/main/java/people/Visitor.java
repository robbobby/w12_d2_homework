package people;

import attractions.Attraction;

import java.util.ArrayList;

public class Visitor {

    private int age;
    private double height;
    private double money;
    private ArrayList<Attraction> visitedAttractions;


    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visitedAttractions = new ArrayList<>();
    }

    public boolean doesVisitedAttractionsContains(Attraction attraction) {
        return visitedAttractions.contains(attraction);
    }

    public boolean addVisitedAttraction(Attraction attraction) {
        return visitedAttractions.add(attraction);
    }

    public Attraction getVisitedAttraction(int index) {
        return visitedAttractions.get(index);
    }

    public int getVisitedAttractionCount() {
        return visitedAttractions.size();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }
}
