package homework3.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ValidationUtils {
    public static boolean isDatesWithinValidDuration(List<Duration> validDurations, LocalDateTime startDate, LocalDateTime endDate) {
        Duration duration = Duration.between(startDate, endDate);
        return validDurations.contains(duration);
    }
}
