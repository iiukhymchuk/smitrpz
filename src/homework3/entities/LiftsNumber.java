package homework3.entities;

public class LiftsNumber {
    private int lifts;

    public LiftsNumber(int lifts) {
        if (lifts <= 0) {
            throw new IllegalArgumentException("Argument 'lifts' must be more than zero.");
        }
        this.lifts = lifts;
    }

    public void decrease() {
        if (lifts > 0) lifts--;
    }
}
