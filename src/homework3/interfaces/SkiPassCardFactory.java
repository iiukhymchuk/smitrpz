package homework3.interfaces;

import homework3.entities.CardOptions;
import homework3.enums.CardType;

public interface SkiPassCardFactory {
    CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder);
    boolean isValid(CardOptions options);
    SkiPassCard create(CardOptions options);
}
