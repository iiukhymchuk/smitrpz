package homework3.factories;

import homework3.entities.SkiPassCardOptions;
import homework3.enums.SkiPassLiftsLimitation;
import homework3.factories.conretefactories.LimitedLiftsCardFactory;
import homework3.factories.conretefactories.UnlimitedLiftsCardFactory;
import homework3.interfaces.ISkiPassCard;
import homework3.interfaces.ISkiPassCardFactory;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

class SkiPassCardFactory {
    private static final ISkiPassCardFactory unlimitedLiftsFactory = new LimitedLiftsCardFactory();
    private static final ISkiPassCardFactory limitedLiftsFactory = new UnlimitedLiftsCardFactory();

    private static HashMap<SkiPassLiftsLimitation, ISkiPassCardFactory> concreteFactories = new HashMap<>(Map.ofEntries(
            entry(SkiPassLiftsLimitation.UNLIMITED_LIFTS, unlimitedLiftsFactory),
            entry(SkiPassLiftsLimitation.LIMITED_LIFTS, limitedLiftsFactory)
    ));

    public static ISkiPassCard create(SkiPassCardOptions options) {

        ISkiPassCardFactory concreteFactory = concreteFactories.getOrDefault(options.getLiftsLimitation(), null);
        if (concreteFactory == null) {
            throw new UnsupportedOperationException("Factory for argument 'skiPassType' is not supported.");
        }

        return concreteFactory.create(options);
    }
}
