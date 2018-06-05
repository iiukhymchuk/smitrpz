package homework3.factories;

import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;

public class WorkingDaysUnlimitedLiftsCardFactory implements SkiPassCardFactory {
    @Override
    public CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder) {
        return null;
    }

    @Override
    public boolean isValid(CardOptions options) {
        return false;
    }

    @Override
    public SkiPassCard create(CardOptions options) {
        return null;
    }
}
