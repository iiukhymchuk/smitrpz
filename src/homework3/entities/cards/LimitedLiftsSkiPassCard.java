package homework3.entities.cards;

import homework3.entities.LiftsNumber;
import homework3.entities.SkiPassCardOptions;

import java.util.Date;

public class LimitedLiftsSkiPassCard extends BaseSkiPassCard {

    protected final LiftsNumber liftsNumber;

    public LimitedLiftsSkiPassCard(SkiPassCardOptions options) {
        super(options);
        liftsNumber = new LiftsNumber(options.getNumberOfLifts());
    }

    @Override
    public String getLeftLiftsNumber(Date date) {
        if (date.after(startDate) && date.before(endDate)) {
            return liftsNumber.toString();
        }
        return "No lifts";
    }
}
