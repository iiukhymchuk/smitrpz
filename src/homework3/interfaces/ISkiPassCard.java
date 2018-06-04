package homework3.interfaces;

import homework3.enums.SkiPassLiftsLimitation;
import homework3.enums.SkiPassWeekDayType;

import java.util.Date;
import java.util.UUID;

public interface ISkiPassCard {
    UUID getId();
    SkiPassLiftsLimitation getLiftsLimitation();
    SkiPassWeekDayType getWeekDayType();
    Date getValidityPeriod();
    String getLeftLiftsNumber(Date date);
}
