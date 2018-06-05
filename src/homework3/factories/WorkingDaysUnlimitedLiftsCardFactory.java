package homework3.factories;

import homework3.Settings;
import homework3.cards.UnlimitedLiftsCard;
import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;
import homework3.utils.ValidationUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class WorkingDaysUnlimitedLiftsCardFactory implements SkiPassCardFactory {
    @Override
    public CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder) {
        return optionsBuilder
            .setLiftsNumber(-1) // no number of lifts
            .build();
    }

    @Override
    public boolean isValid(CardOptions options) {
        List<Duration> workingDayDurations = Settings.getValidWorkingDayDurations();
        List<LocalTime> validTimesForStartDate = Settings.getValidTimesForStartDate();
        List<LocalTime> validTimesForEndDate = Settings.getValidTimesForEndDate();

        LocalDateTime startDate = options.getStartDate();
        LocalDateTime endDate = options.getEndDate();

        boolean idIsNotNull = options.getId() != null;
        boolean isValidDuration = ValidationUtils.isDatesWithinValidDuration(workingDayDurations, startDate, endDate);
        boolean isValidStartDate = ValidationUtils.isValidTimeForDate(validTimesForStartDate, startDate);
        boolean isValidEndDate = ValidationUtils.isValidTimeForDate(validTimesForEndDate, endDate);
        boolean isStartDateWorkingDay = ValidationUtils.isWorkingDay(startDate);
        boolean isEndDateWorkingDay = ValidationUtils.isWorkingDay(endDate);

        return idIsNotNull
            && isValidDuration
            && isValidStartDate
            && isValidEndDate
            && isStartDateWorkingDay
            && isEndDateWorkingDay;
    }

    @Override
    public SkiPassCard create(CardOptions options) {
        return new UnlimitedLiftsCard(options);
    }
}
