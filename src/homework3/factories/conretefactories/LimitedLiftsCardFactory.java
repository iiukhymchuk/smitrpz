package homework3.factories.conretefactories;

import homework3.entities.SkiPassCardOptions;
import homework3.entities.cards.LimitedLiftsSkiPassCard;
import homework3.interfaces.ISkiPassCard;
import homework3.interfaces.ISkiPassCardFactory;

public class LimitedLiftsCardFactory implements ISkiPassCardFactory {
    @Override
    public ISkiPassCard create(SkiPassCardOptions options) {
        return new LimitedLiftsSkiPassCard(options);
    }
}
