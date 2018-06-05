package homework3.factories;

import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;

public class WeekendUnlimitedLiftsCardFactory implements SkiPassCardFactory {
    @Override
    public CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder) {
        return optionsBuilder
            .setLiftsNumber(-1) // no number of lifts
            .build();
    }

    @Override
    public boolean isValid(CardOptions options) {
        boolean idIsNotNull = options.getId() != null;
        return false;
    }

    @Override
    public SkiPassCard create(CardOptions options) {
        return null;
    }
}
