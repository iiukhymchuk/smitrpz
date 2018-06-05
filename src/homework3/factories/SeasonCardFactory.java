package homework3.factories;

import homework3.SkiPassSettings;
import homework3.cards.UnlimitedLiftsCard;
import homework3.entities.CardOptions;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardFactory;
import homework3.interfaces.SkiPassCardOptionsBuilder;

import java.util.Date;

public class SeasonCardFactory implements SkiPassCardFactory {
    @Override
    public CardOptions createOptions(SkiPassCardOptionsBuilder optionsBuilder) {
        Date startDate = SkiPassSettings.getSeasonStartDate();
        Date endDate = SkiPassSettings.getSeasonEndDate();

        return optionsBuilder
            .setStartDate(startDate)
            .setEndDate(endDate)
            .build();
    }

    @Override
    public boolean isValid(CardOptions options) {
        return options.getId() != null;
    }

    @Override
    public SkiPassCard create(CardOptions options) {
        return new UnlimitedLiftsCard(options);
    }
}
