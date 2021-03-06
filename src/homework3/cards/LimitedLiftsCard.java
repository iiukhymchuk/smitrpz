package homework3.cards;

import homework3.entities.LiftsNumber;
import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassTimeProvider;

import java.time.LocalDateTime;

public class LimitedLiftsCard extends BaseCard {

    protected final LiftsNumber liftsNumber;

    public LimitedLiftsCard(CardOptions options, SkiPassTimeProvider timeProvider) {
        super(options, timeProvider);
        liftsNumber = new LiftsNumber(options.getLiftsNumber());
    }

    @Override
    public String getLeftLiftsNumber() {
        LocalDateTime currentDate = timeProvider.getCurrentDateTime();

        if (currentDate.isAfter(startDate) && currentDate.isBefore(endDate)) {
            return liftsNumber.toString();
        }
        return "No lifts";
    }

    @Override
    public void decreaseLiftsNumber() {
        liftsNumber.decrease();
    }
}
