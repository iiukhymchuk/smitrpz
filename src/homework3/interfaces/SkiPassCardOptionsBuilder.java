package homework3.interfaces;

import homework3.entities.CardOptions;
import homework3.enums.CardType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface SkiPassCardOptionsBuilder {
    SkiPassCardOptionsBuilder setId(UUID id);
    SkiPassCardOptionsBuilder setStartDate(LocalDateTime startDate);
    SkiPassCardOptionsBuilder setEndDate(LocalDateTime endDate);
    SkiPassCardOptionsBuilder setType(CardType type);
    SkiPassCardOptionsBuilder setLiftsNumber(int liftsNumber);
    CardOptions build();
}
