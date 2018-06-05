package tests;

import homework3.Turnstile;
import homework3.cards.UnlimitedLiftsCard;
import homework3.entities.CardOptions;
import homework3.enums.CardType;
import homework3.interfaces.SkiPassCard;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class Homework3Test {

    private static UUID testId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");



    @Test
    public void passReturnsTrueForValidCard() {
        // arrange
        LocalDateTime testCurrentDate = LocalDateTime.of(2018, 6, 5, 11, 12, 32);
        LocalDateTime testStartDate = LocalDateTime.of(2018, 6, 5, 9, 0, 0);
        LocalDateTime testEndDate = LocalDateTime.of(2018, 6, 5, 13, 0, 0);
        CardOptions testOptions = CardOptions.newBuilder()
            .setId(testId)
            .setStartDate(testStartDate)
            .setEndDate(testEndDate)
            .setType(CardType.WORKING_DAYS_UNLIMITED_LIFTS)
            .build();
        SkiPassCard card = new UnlimitedLiftsCard(testOptions, () -> testCurrentDate);

        Turnstile turnstile = new Turnstile(() -> testCurrentDate);

        // act
        boolean passResult = turnstile.pass(card);

        // assert
        Assert.assertTrue(passResult);
    }
}
