package homework3;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SkiPassSettings {
    private static final int HOUR_OF_DAY_START = 9;
    private static final int HOUR_OF_DAY_END = 17;
    private static final Date SEASON_START_DATE = new Date(2018, 12, 1, HOUR_OF_DAY_START, 0);
    private static final Date SEASON_END_DATE = new Date(2019, 3, 31, HOUR_OF_DAY_END, 0);
    private static final List<Integer> VALID_LIFTS_NUMBER_LIST = Arrays.asList(10, 20, 50, 100);

    public static Date getSeasonStartDate() {
        return SEASON_START_DATE;
    }

    public static Date getSeasonEndDate() {
        return SEASON_END_DATE;
    }

    public static List<Integer> getValidLiftsNumberList() {
        return VALID_LIFTS_NUMBER_LIST;
    }
}
