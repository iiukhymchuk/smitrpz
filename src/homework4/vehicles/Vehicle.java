package homework4.vehicles;

import homework4.humans.Human;

import java.util.HashSet;

public abstract class Vehicle<T extends Human> {
    private int places;
    private int occupiedPlaces;
    private HashSet<T> passengers = new HashSet<>();

    public Vehicle(int places) {
        this.places = places;
    }


    public int getPlaceNumber() {
        return places;
    }

    public int getOccupiedPlaceNumber() {
        return occupiedPlaces;
    }

    protected void getIn(T human) {
        if (places - occupiedPlaces <= 0) {
            throw new IllegalStateException("The vehicle is full stuffed.");
        }

        occupiedPlaces++;
        passengers.add(human);
    }

    protected void takeOff(T human) {
        if (!passengers.contains(human)) {
            throw new IllegalStateException("There is no spoon.");
        }

        occupiedPlaces--;
        passengers.remove(human);
    }
}
