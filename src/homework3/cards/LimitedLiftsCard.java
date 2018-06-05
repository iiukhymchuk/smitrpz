package homework3.cards;

import homework3.entities.LiftsNumber;
import homework3.entities.CardOptions;

import java.time.LocalDateTime;

public class LimitedLiftsCard extends BaseCard {

    protected final LiftsNumber liftsNumber;

    public LimitedLiftsCard(CardOptions options) {
        super(options);
        liftsNumber = new LiftsNumber(options.getLiftsNumber());
    }

    @Override
    public String getLeftLiftsNumber(LocalDateTime date) {
        if (date.isAfter(startDate) && date.isBefore(endDate)) {
            return liftsNumber.toString();
        }
        return "No lifts";
    }
}
