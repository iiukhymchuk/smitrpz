package homework4.vehicles;

import homework4.humans.Human;

public abstract class Car<T extends Human> extends Vehicle<T> {
    public Car(int places) {
        super(places);
    }

    public void getIn(T human) {
        super.getIn(human);
    }

    public void takeOff(T human) {
        super.takeOff(human);
    }
}
