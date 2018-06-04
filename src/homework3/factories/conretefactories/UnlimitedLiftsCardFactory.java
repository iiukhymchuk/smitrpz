package homework3.factories.conretefactories;

import homework3.entities.SkiPassCardOptions;
import homework3.entities.cards.UnlimitedLiftsSkiPassCard;
import homework3.interfaces.ISkiPassCard;
import homework3.interfaces.ISkiPassCardFactory;

public class UnlimitedLiftsCardFactory implements ISkiPassCardFactory {
    @Override
    public ISkiPassCard create(SkiPassCardOptions options) {
        return new UnlimitedLiftsSkiPassCard(options);
    }
}
