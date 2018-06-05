package homework3.cards;

import homework3.entities.CardOptions;

import java.util.Date;

public class UnlimitedLiftsCard extends BaseCard {

    public UnlimitedLiftsCard(CardOptions options) {
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
