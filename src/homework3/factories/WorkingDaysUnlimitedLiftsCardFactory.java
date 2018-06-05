package homework3.factories;

import homework3.Settings;
import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;
import homework3.utils.ValidationUtils;

public class WorkingDaysUnlimitedLiftsCardFactory implements SkiPassCardFactory {
    @Override
    public CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder) {
        return optionsBuilder
            .setLiftsNumber(-1) // no number of lifts
            .build();
    }

    @Override
    public boolean isValid(CardOptions options) {
        boolean idIsNotNull = options.getId() != null;
        boolean isValidTimePeriod = ValidationUtils.isDatesWithinValidDuration(Settings.getValidWorkingDayDurations(),
                options.getStartDate(), options.getEndDate());
        return false;
    }

    @Override
    public SkiPassCard create(CardOptions options) {
        return null;
    }
}
