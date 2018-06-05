package tests.homework3;

import homework3.Turnstile;
import homework3.cards.UnlimitedLiftsCard;
import homework3.entities.CardOptions;
import homework3.enums.CardType;
import homework3.interfaces.SkiPassCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@RunWith(Parameterized.class)
public class TurnstileTest {
    private static final UUID testId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime currentDate;
    private CardType cardType;
    private int liftsLeft;
    private boolean expectedResult;

    private Turnstile turnstile;

    public TurnstileTest(LocalDateTime startDate, LocalDateTime endDate, LocalDateTime currentDate, CardType cardType,
        int liftsLeft, boolean expectedResult) {

        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentDate = currentDate;
        this.cardType = cardType;
        this.liftsLeft = liftsLeft;
        this.expectedResult = expectedResult;
    }

    @Before
    public void initialize() {
        turnstile = new Turnstile(() -> currentDate);
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {
            {
                LocalDateTime.of(2018, 6, 5, 9, 0, 0),
                LocalDateTime.of(2018, 6, 5, 13, 0, 0),
                LocalDateTime.of(2018, 6, 5, 11, 12, 32),
                CardType.WORKING_DAYS_UNLIMITED_LIFTS,
                -1,
                true
            },
            {
                LocalDateTime.of(2018, 6, 5, 9, 0, 0),
                LocalDateTime.of(2018, 6, 5, 13, 0, 0),
                LocalDateTime.of(2018, 6, 5, 11, 12, 32),
                CardType.WEEKEND_UNLIMITED_LIFTS,
                -1,
                true
            },
            {
                LocalDateTime.of(2018, 6, 5, 9, 0, 0),
                LocalDateTime.of(2018, 6, 5, 13, 0, 0),
                LocalDateTime.of(2018, 6, 5, 14, 12, 32),
                CardType.WORKING_DAYS_UNLIMITED_LIFTS,
                -1,
                false
            }
        });
    }

    @Test
    public void passReturnsValidResultsForUnlimitedLiftsCards() {
        // arrange
        CardOptions options = CardOptions.newBuilder()
            .setId(testId)
            .setStartDate(startDate)
            .setEndDate(endDate)
            .setType(cardType)
            .setLiftsNumber(liftsLeft)
            .build();
        SkiPassCard card = new UnlimitedLiftsCard(options, () -> currentDate);

        // act
        boolean actual = turnstile.pass(card);

        // assert
        Assert.assertEquals(expectedResult, actual);
    }
}
