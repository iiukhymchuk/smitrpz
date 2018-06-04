package homework3.entities;

import homework3.enums.SkiPassLiftsLimitation;
import homework3.enums.SkiPassWeekDayType;

import java.util.Date;
import java.util.UUID;

public class SkiPassCardOptions {
    private static final int NO_NUMBER_OF_LIFTS = -1;

    private final UUID id;
    private final Date startDate;
    private final Date endDate;
    private final SkiPassLiftsLimitation liftsLimitation;
    private final SkiPassWeekDayType weekDayType;
    private final int numberOfLifts;

    public SkiPassCardOptions(UUID id, Date startDate, Date endDate, SkiPassLiftsLimitation liftsLimitation,
        SkiPassWeekDayType weekDayType) {

        this(id, startDate, endDate, liftsLimitation, weekDayType, NO_NUMBER_OF_LIFTS);
    }

    public SkiPassCardOptions(UUID id, Date startDate, Date endDate, SkiPassLiftsLimitation liftsLimitation,
        SkiPassWeekDayType weekDayType, int numberOfLifts) {

        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfLifts = numberOfLifts;
        this.liftsLimitation = liftsLimitation;
        this.weekDayType = weekDayType;
    }

    public UUID getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SkiPassLiftsLimitation getLiftsLimitation() {
        return liftsLimitation;
    }

    public SkiPassWeekDayType getWeekDayType() {
        return weekDayType;
    }

    public int getNumberOfLifts() {
        return numberOfLifts;
    }
}
