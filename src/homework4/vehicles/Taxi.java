package homework4.vehicles;

import homework4.humans.Human;

public class Taxi<T extends Human> extends Car<T> {
    public Taxi(int places) {
        super(places);
    }

    public void getIn(T human) {
        super.getIn(human);
    }

    public void takeOff(T human) {
        super.takeOff(human);
    }
}
