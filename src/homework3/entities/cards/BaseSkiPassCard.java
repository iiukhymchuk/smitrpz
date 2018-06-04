package homework3.entities.cards;

import homework3.entities.SkiPassCardOptions;
import homework3.enums.SkiPassLiftsLimitation;
import homework3.enums.SkiPassWeekDayType;
import homework3.interfaces.ISkiPassCard;

import java.util.Date;
import java.util.UUID;

public abstract class BaseSkiPassCard implements ISkiPassCard {
    private final UUID id;
    protected final Date startDate;
    protected final Date endDate;
    protected final SkiPassLiftsLimitation liftsLimitation;
    protected final SkiPassWeekDayType weekDayType;

    protected BaseSkiPassCard(SkiPassCardOptions options) {
        id = options.getId();
        startDate = options.getStartDate();
        endDate = options.getEndDate();
        liftsLimitation = options.getLiftsLimitation();
        weekDayType = options.getWeekDayType();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public SkiPassLiftsLimitation getLiftsLimitation() {
        return liftsLimitation;
    }

    @Override
    public SkiPassWeekDayType getWeekDayType() {
        return weekDayType;
    }

    @Override
    public Date getValidityPeriod() {
        return endDate;
    }

    @Override
    public abstract String getLeftLiftsNumber(Date date);
}
