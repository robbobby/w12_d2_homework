package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        if(visitor.getAge() < 12) return false;
        if(visitor.getHeight() < 145) return false;
        return true;
    }

    @Override
    public double defaultPrice() {
        return 8.40f;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if(visitor.getHeight() > 200) return defaultPrice() * 2;
        return defaultPrice();
    }
}
