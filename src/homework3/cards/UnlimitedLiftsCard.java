package homework3.cards;

import homework3.TimeProvider;
import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassTimeProvider;

import java.time.LocalDateTime;

public class UnlimitedLiftsCard extends BaseCard {

    public UnlimitedLiftsCard(CardOptions options) {
        super(options);
    }

    @Override
    public String getLeftLiftsNumber() {
        SkiPassTimeProvider timeProvider = TimeProvider.getProvider();
        LocalDateTime currentDate = timeProvider.getCurrentDateTime();

        if (currentDate.isAfter(startDate) && currentDate.isBefore(endDate)) {
            return "Unlimited lifts";
        }
        return "No lifts";
    }

    @Override
    public void decreaseLiftsNumber() {
        // do nothing
    }
}
