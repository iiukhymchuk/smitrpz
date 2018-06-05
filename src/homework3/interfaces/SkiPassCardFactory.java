package homework3.interfaces;

import homework3.entities.CardOptions;

public interface SkiPassCardFactory {
    CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder);
    boolean isValid(CardOptions options);
    SkiPassCard create(CardOptions options, SkiPassTimeProvider timeProvider);
}
