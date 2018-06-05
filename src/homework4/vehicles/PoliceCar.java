package homework4.vehicles;

import homework4.humans.Policeman;

public class PoliceCar<T extends Policeman> extends Car<T> {
    public PoliceCar(int places) {
        super(places);
    }

    public void getIn(T human) {
        super.getIn(human);
    }

    public void takeOff(T human) {
        super.takeOff(human);
    }
}
