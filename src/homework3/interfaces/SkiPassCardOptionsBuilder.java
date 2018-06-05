package homework3.interfaces;

import homework3.entities.CardOptions;
import homework3.enums.CardType;

import java.util.Date;
import java.util.UUID;

public interface SkiPassCardOptionsBuilder {
    SkiPassCardOptionsBuilder setId(UUID id);
    SkiPassCardOptionsBuilder setStartDate(Date startDate);
    SkiPassCardOptionsBuilder setEndDate(Date endDate);
    SkiPassCardOptionsBuilder setType(CardType type);
    SkiPassCardOptionsBuilder setLiftsNumber(int liftsNumber);
    CardOptions build();
}
