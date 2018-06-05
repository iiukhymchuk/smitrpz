package homework3.factories;

import homework3.Settings;
import homework3.cards.UnlimitedLiftsCard;
import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;
import homework3.interfaces.SkiPassTimeProvider;
import homework3.utils.ValidationUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class WeekendUnlimitedLiftsCardFactory implements SkiPassCardFactory {
    @Override
    public CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder) {
        return optionsBuilder
            .setLiftsNumber(-1) // no number of lifts
            .build();
    }

    @Override
    public boolean isValid(CardOptions options) {
        List<Duration> weekendDurations = Settings.getValidWeekendDurations();
        List<LocalTime> validTimesForStartDate = Settings.getValidTimesForStartDate();
        List<LocalTime> validTimesForEndDate = Settings.getValidTimesForEndDate();

        LocalDateTime startDate = options.getStartDate();
        LocalDateTime endDate = options.getEndDate();

        boolean idIsNotNull = options.getId() != null;
        boolean isValidDuration = ValidationUtils.isDatesWithinValidDuration(weekendDurations, startDate, endDate);
        boolean isValidStartDate = ValidationUtils.isValidTimeForDate(validTimesForStartDate, startDate);
        boolean isValidEndDate = ValidationUtils.isValidTimeForDate(validTimesForEndDate, endDate);
        boolean isStartDateWorkingDay = ValidationUtils.isWeekend(startDate);
        boolean isEndDateWorkingDay = ValidationUtils.isWeekend(endDate);

        return idIsNotNull
            && isValidDuration
            && isValidStartDate
            && isValidEndDate
            && isStartDateWorkingDay
            && isEndDateWorkingDay;
    }

    @Override
    public SkiPassCard create(CardOptions options, SkiPassTimeProvider timeProvider) {
        return new UnlimitedLiftsCard(options, timeProvider);
    }
}
