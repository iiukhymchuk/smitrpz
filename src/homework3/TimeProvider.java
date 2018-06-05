package homework3;

import homework3.interfaces.SkiPassTimeProvider;

import java.time.LocalDateTime;

public class TimeProvider implements SkiPassTimeProvider {
    private static final TimeProvider provider = new TimeProvider();

    private TimeProvider() {}

    public static SkiPassTimeProvider getProvider() {
        return provider;
    }

    @Override
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
