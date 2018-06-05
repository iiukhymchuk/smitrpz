package homework3.cards;

import homework3.entities.CardOptions;
import homework3.enums.CardType;
import homework3.interfaces.SkiPassCard;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseCard implements SkiPassCard {
    private final UUID id;
    protected final LocalDateTime startDate;
    protected final LocalDateTime endDate;
    private final CardType type;

    protected BaseCard(CardOptions options) {
        id = options.getId();
        startDate = options.getStartDate();
        endDate = options.getEndDate();
        type = options.getType();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public CardType getType() {
        return type;
    }

    @Override
    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public abstract String getLeftLiftsNumber();

    @Override
    public abstract void decreaseLiftsNumber();
}
