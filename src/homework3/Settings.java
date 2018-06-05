package homework3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Settings {
    // settings
    private static final int HOUR_OF_DAY_START = 9;
    private static final int HOUR_OF_DAY_END = 17;
    private static final LocalDateTime SEASON_START_DATE = LocalDateTime.of(2018, 12, 1, HOUR_OF_DAY_START, 0);
    private static final LocalDateTime SEASON_END_DATE = LocalDateTime.of(2019, 3, 31, HOUR_OF_DAY_END, 0);
    private static final List<Integer> VALID_LIFTS_NUMBER_LIST = Arrays.asList(10, 20, 50, 100);
    private static final List<Duration> VALID_WEEKEND_TIME_PERIODS = Arrays.asList(
        Duration.ofHours(4), Duration.ofDays(1L), Duration.ofDays(2L)
    );
    private static final List<Duration> VALID_WORKING_DAYS_TIME_PERIODS = Arrays.asList(
        Duration.ofHours(4),Duration.ofDays(1L), Duration.ofDays(2L), Duration.ofDays(5L)
    );
    private static final List<LocalTime> VALID_TIMES_FOR_START_DATE = Arrays.asList(
            LocalTime.of(9, 0, 0),
            LocalTime.of(13, 0, 0)
    );

    private static final List<LocalTime> VALID_TIMES_FOR_END_DATE = Arrays.asList(
            LocalTime.of(13, 0, 0),
            LocalTime.of(17, 0, 0)
    );

    // getters
    public static LocalDateTime getSeasonStartDate() {
        return SEASON_START_DATE;
    }

    public static LocalDateTime getSeasonEndDate() {
        return SEASON_END_DATE;
    }

    public static List<Integer> getValidLiftsNumberList() {
        return VALID_LIFTS_NUMBER_LIST;
    }

    public static List<Duration> getValidWeekendDurations() {
        return VALID_WEEKEND_TIME_PERIODS;
    }

    public static List<Duration> getValidWorkingDayDurations() {
        return VALID_WORKING_DAYS_TIME_PERIODS;
    }


    public static List<LocalTime> getValidTimesForStartDate() {
        return VALID_TIMES_FOR_START_DATE;
    }

    public static List<LocalTime> getValidTimesForEndDate() {
        return VALID_TIMES_FOR_END_DATE;
    }
}
