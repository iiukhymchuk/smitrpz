package homework3.cards;

import homework3.entities.CardOptions;
import homework3.enums.CardType;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassTimeProvider;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseCard implements SkiPassCard {
    private final UUID id;
    protected final LocalDateTime startDate;
    protected final LocalDateTime endDate;
    private final CardType type;
    protected final SkiPassTimeProvider timeProvider;

    protected BaseCard(CardOptions options, SkiPassTimeProvider timeProvider) {
        id = options.getId();
        startDate = options.getStartDate();
        endDate = options.getEndDate();
        type = options.getType();
        this.timeProvider = timeProvider;
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
