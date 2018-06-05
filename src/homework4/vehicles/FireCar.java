package homework4.vehicles;

import homework4.humans.Fireman;

public class FireCar<T extends Fireman> extends Car<T> {
    public FireCar(int places) {
        super(places);
    }

    public void getIn(T human) {
        super.getIn(human);
    }

    public void takeOff(T human) {
        super.takeOff(human);
    }
}
