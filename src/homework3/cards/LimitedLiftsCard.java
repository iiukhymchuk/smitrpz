package homework3.cards;

import homework3.entities.LiftsNumber;
import homework3.entities.CardOptions;

import java.util.Date;

public class LimitedLiftsCard extends BaseCard {

    protected final LiftsNumber liftsNumber;

    public LimitedLiftsCard(CardOptions options) {
        super(options);
        liftsNumber = new LiftsNumber(options.getLiftsNumber());
    }

    @Override
    public String getLeftLiftsNumber(Date date) {
        if (date.after(startDate) && date.before(endDate)) {
            return liftsNumber.toString();
        }
        return "No lifts";
    }
}
