package homework3.factories;

import homework3.TimeProvider;
import homework3.entities.CardOptions;
import homework3.enums.CardType;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.Map.entry;

public class CardFactory {
    private static final int NO_NUMBER_OF_LIFTS = -1;

    private static final SkiPassCardFactory seasonFactory = new SeasonCardFactory();
    private static final SkiPassCardFactory limitedLiftsFactory = new LimitedLiftsCardFactory();
    private static final SkiPassCardFactory workingDaysUnlimitedLiftsFactory = new WorkingDaysUnlimitedLiftsCardFactory();
    private static final SkiPassCardFactory weekendUnlimitedLiftsFactory = new WeekendUnlimitedLiftsCardFactory();

    private static HashMap<CardType, SkiPassCardFactory> concreteFactories = new HashMap<>(Map.ofEntries(
        entry(CardType.SEASON, seasonFactory),
        entry(CardType.WORKING_DAYS_LIMITED_LIFTS, limitedLiftsFactory),
        entry(CardType.WORKING_DAYS_UNLIMITED_LIFTS, workingDaysUnlimitedLiftsFactory),
        entry(CardType.WEEKEND_LIMITED_LIFTS, limitedLiftsFactory),
        entry(CardType.WEEKEND_UNLIMITED_LIFTS, weekendUnlimitedLiftsFactory)
    ));

    public static SkiPassCard create(CardType cardType, UUID id, LocalDateTime startDate, LocalDateTime endDate, int liftsNumber) {

        SkiPassCardFactory concreteFactory = concreteFactories.getOrDefault(cardType, null);
        if (concreteFactory == null) {
            throw new UnsupportedOperationException("Factory for argument 'skiPassType' is not supported.");
        }

        SkiPassCardOptionsBuilder optionsBuilder = CardOptions.newBuilder()
            .setId(id)
            .setStartDate(startDate)
            .setEndDate(endDate)
            .setType(cardType)
            .setLiftsNumber(liftsNumber);

        CardOptions options = concreteFactory.createOptions(optionsBuilder);
        if (!concreteFactory.isValid(options)) {
            throw new IllegalStateException("Illegal state of parameters: 'cardType','id', 'startDate', 'endDate', 'liftsNumber'.");
        }
        return concreteFactory.create(options, TimeProvider.getProvider());
    }

    public static SkiPassCard create(CardType cardType, UUID id) {
        return create(cardType, id, null, null, NO_NUMBER_OF_LIFTS);
    }

    public static SkiPassCard create(CardType cardType, UUID id, LocalDateTime startDate, LocalDateTime endDate) {
        return create(cardType, id, startDate, endDate, NO_NUMBER_OF_LIFTS);
    }
}
