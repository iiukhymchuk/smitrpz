package homework3.interfaces;

import homework3.enums.CardType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface SkiPassCard {
    UUID getId();
    CardType getType();
    LocalDateTime getValidityPeriod();
    String getLeftLiftsNumber(LocalDateTime date);
}
