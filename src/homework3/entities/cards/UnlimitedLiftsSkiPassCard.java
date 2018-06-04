package homework3.entities.cards;

import homework3.entities.SkiPassCardOptions;

import java.util.Date;

public class UnlimitedLiftsSkiPassCard extends BaseSkiPassCard {

    public UnlimitedLiftsSkiPassCard(SkiPassCardOptions options) {
        super(options);
    }

    @Override
    public String getLeftLiftsNumber(Date date) {
        if (date.after(startDate) && date.before(endDate)) {
            return "Unlimited lifts";
        }
        return "No lifts";
    }
}
