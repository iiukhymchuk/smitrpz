package homework3.utils;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ValidationUtils {
    public static boolean isDatesWithinValidDuration(List<Duration> validDurations, LocalDateTime first, LocalDateTime second) {
        if (first == null || second == null) {
            return false;
        }
        Duration duration = Duration.between(first, second);
        return validDurations.contains(duration);
    }

    public static boolean isValidTimeForDate(List<LocalTime> validTimes, LocalDateTime date) {
        if (date == null) {
            return false;
        }
        int hour = date.getHour();
        int minute = date.getMinute();
        int second = date.getSecond();
        int nano = date.getNano();

        for (LocalTime validTime : validTimes) {
            boolean isValid =
                hour == validTime.getHour()
                && minute == validTime.getMinute()
                && second == validTime.getSecond()
                && nano == validTime.getNano();
            if (isValid) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWorkingDay(LocalDateTime date) {
        return !isWeekend(date);
    }

    public static boolean isWeekend(LocalDateTime date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
