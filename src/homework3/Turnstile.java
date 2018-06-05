package homework3;

import homework3.entities.TurnstileSuccessRate;
import homework3.enums.CardType;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassTimeProvider;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Turnstile {
    private static final SkiPassTimeProvider timeProvider = TimeProvider.getProvider();
    private static final HashMap<CardType, TurnstileSuccessRate> statistics = new HashMap<>();

    public boolean pass(SkiPassCard card) {
        if (!isValid(card)) {
            return false;
        }

        card.decreaseLiftsNumber();
        return true;
    }

    public TurnstileSuccessRate getStatistics() {
        int success = 0;
        int nonSuccess = 0;
        for (Map.Entry<CardType, TurnstileSuccessRate> entry : statistics.entrySet()) {
            TurnstileSuccessRate successRate = entry.getValue();
            success += successRate.getSuccesses();
            nonSuccess += successRate.getNonSuccesses();
        }

        return new TurnstileSuccessRate(success, nonSuccess);
    }

    public TurnstileSuccessRate getStatistics(CardType type) {
        if (!statistics.containsKey(type)) {
            return new TurnstileSuccessRate();
        }

        return statistics.get(type);
    }

    private static boolean isValid(SkiPassCard card) {
        UUID id = card.getId();
        LocalDateTime startDate = card.getStartDate();
        LocalDateTime endDate = card.getEndDate();
        String liftsLeft = card.getLeftLiftsNumber();
        LocalDateTime currentTime = timeProvider.getCurrentDateTime();

        // blocked
        if (System.isBlockedCard(id)) {
            return false;
        }

        // within the time range
        if (!(currentTime.isAfter(startDate) && currentTime.isBefore(endDate))) {
            return false;
        }

        // lifts left
        if (liftsLeft.equals("No lifts")) {
            return false;
        }

        return true;
    }

    private static void addNonSuccess(CardType type) {
        if (!statistics.containsKey(type)) {
            statistics.put(type, new TurnstileSuccessRate());
        }

        TurnstileSuccessRate successRate = statistics.get(type);
        successRate.increaseNonSuccesses();
    }

    private static void addSuccess(CardType type) {
        if (!statistics.containsKey(type)) {
            statistics.put(type, new TurnstileSuccessRate());
        }

        TurnstileSuccessRate successRate = statistics.get(type);
        successRate.increaseSuccesses();
    }
}
