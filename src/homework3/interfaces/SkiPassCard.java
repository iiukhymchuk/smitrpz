package homework3.interfaces;

import homework3.enums.CardType;

import java.util.Date;
import java.util.UUID;

public interface SkiPassCard {
    UUID getId();
    CardType getType();
    Date getValidityPeriod();
    String getLeftLiftsNumber(Date date);
}
