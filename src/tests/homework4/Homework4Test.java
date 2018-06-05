package tests.homework4;

import homework4.humans.Fireman;
import homework4.humans.Human;
import homework4.humans.Policeman;
import homework4.vehicles.Bus;
import homework4.vehicles.FireCar;
import homework4.vehicles.PoliceCar;
import homework4.vehicles.Taxi;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Homework4Test {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getOccupiedPlaceNumberIncreaseOnAddingPassenger() {
        PoliceCar car = new PoliceCar(4);
        int occupiedPlaces = car.getOccupiedPlaceNumber();
        Assert.assertEquals(0, occupiedPlaces);

        car.getIn(new Policeman());

        int occupiedPlacesAfterGettingInPassenger = car.getOccupiedPlaceNumber();
        Assert.assertEquals(1, occupiedPlacesAfterGettingInPassenger);
    }

    @Test
    public void getPlaceNumberDoNotIncreaseOnAddingPassenger() {
        FireCar car = new FireCar(4);
        int placeNumber = car.getPlaceNumber();
        Assert.assertEquals(4, placeNumber);

        car.getIn(new Fireman());

        int placeNumberAfterGettingInPassenger = car.getPlaceNumber();
        Assert.assertEquals(4, placeNumberAfterGettingInPassenger);
    }

    @Test
    public void getInThrowsIllegalStateExceptionOnMorePassengers() {
        Bus car = new Bus(4);
        car.getIn(new Human());
        car.getIn(new Human());
        car.getIn(new Human());
        car.getIn(new Human());
        exception.expect(IllegalStateException.class);
        car.getIn(new Human());
    }

    @Test
    public void takeOffThrowsIllegalStateExceptionOnTakingOffPassengerThatIsNotOnVehicle() {
        Taxi car = new Taxi(4);
        car.getIn(new Human());
        exception.expect(IllegalStateException.class);
        car.takeOff(new Human());
    }

    @Test
    public void takeOffRunsWithoutExceptionsWhenTakingOffTheSamePassenger() {
        Taxi car = new Taxi(4);
        Human human = new Human();
        car.getIn(human);
        car.takeOff(human);
    }
}
