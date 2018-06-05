package homework3;

import homework3.enums.CardType;
import homework3.factories.CardFactory;
import homework3.interfaces.SkiPassCard;
import homework3.interfaces.SkiPassCardSystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class System implements SkiPassCardSystem {
    private static final HashMap<UUID, SkiPassCard> cards = new HashMap();
    private static final HashSet<UUID> blockedCards = new HashSet();

    public static SkiPassCard createCard(CardType cardType, LocalDateTime startDate, LocalDateTime endDate, int liftsNumber) {
        UUID id = UUID.randomUUID();
        SkiPassCard card = CardFactory.create(cardType, id, startDate, endDate, liftsNumber);
        cards.put(id, card);
        return card;
    }

    public static void blockCard(UUID id) {
        if (!blockedCards.contains(id)) {
            blockedCards.add(id);
        }
    }

    public static boolean isBlockedCard(UUID id) {
        return blockedCards.contains(id);
    }
}
