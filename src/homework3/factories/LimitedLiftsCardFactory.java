package homework3.factories;

import homework3.Settings;
import homework3.entities.CardOptions;
import homework3.cards.LimitedLiftsCard;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;

public class LimitedLiftsCardFactory implements SkiPassCardFactory {
    @Override
    public CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder) {
        return optionsBuilder.build();
    }

    @Override
    public boolean isValid(CardOptions options) {
        boolean idIsNotNull = options.getId() != null;
        boolean liftsNumberIsValid = Settings.getValidLiftsNumberList().contains(options.getLiftsNumber());

        return idIsNotNull && liftsNumberIsValid;
    }

    @Override
    public SkiPassCard create(CardOptions options) {
        return new LimitedLiftsCard(options);
    }
}
