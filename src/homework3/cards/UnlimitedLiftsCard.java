package homework3.cards;

import homework3.entities.CardOptions;

import java.time.LocalDateTime;

public class UnlimitedLiftsCard extends BaseCard {

    public UnlimitedLiftsCard(CardOptions options) {
        super(options);
    }

    @Override
    public String getLeftLiftsNumber(LocalDateTime date) {
        if (date.isAfter(startDate) && date.isBefore(endDate)) {
            return "Unlimited lifts";
        }
        return "No lifts";
    }
}
