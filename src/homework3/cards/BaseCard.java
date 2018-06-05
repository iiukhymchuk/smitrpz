package homework3.cards;

import homework3.entities.CardOptions;
import homework3.enums.CardType;
import homework3.interfaces.SkiPassCard;

import java.util.Date;
import java.util.UUID;

public abstract class BaseCard implements SkiPassCard {
    private final UUID id;
    protected final Date startDate;
    protected final Date endDate;
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
    public Date getValidityPeriod() {
        return endDate;
    }

    @Override
    public abstract String getLeftLiftsNumber(Date date);
}
