package homework3.interfaces;

import homework3.enums.CardType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface SkiPassCard {
    UUID getId();
    CardType getType();
    LocalDateTime getStartDate();
    LocalDateTime getEndDate();
    String getLeftLiftsNumber();
    void decreaseLiftsNumber();
}
