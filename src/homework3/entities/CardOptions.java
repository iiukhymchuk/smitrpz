package homework3.entities;

import homework3.enums.CardType;
import homework3.interfaces.SkiPassCardOptionsBuilder;

import java.util.Date;
import java.util.UUID;

public class CardOptions {
    private final UUID id;
    private final Date startDate;
    private final Date endDate;
    private final CardType type;
    private final int liftsNumber;

    private CardOptions(UUID id, Date startDate, Date endDate, CardType type, int liftsNumber) {

        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.liftsNumber = liftsNumber;
    }

    public UUID getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CardType getType() {
        return type;
    }

    public int getLiftsNumber() {
        return liftsNumber;
    }

    public static SkiPassCardOptionsBuilder newBuilder() {
        return new Builder();
    }

    public static class Builder implements SkiPassCardOptionsBuilder {
        private boolean alreadyBuilt = false;

        private UUID id;
        private Date startDate;
        private Date endDate;
        private CardType type;
        private int liftsNumber;

        private Builder() {}

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setType(CardType type) {
            this.type = type;
            return this;
        }

        public Builder setLiftsNumber(int liftsNumber) {
            this.liftsNumber = liftsNumber;
            return this;
        }

        public CardOptions build() {
            if (alreadyBuilt) {
                throw new IllegalStateException("'CardOptions' object is already built");
            }
            alreadyBuilt = true;

            return new CardOptions(id, startDate, endDate, type, liftsNumber);
        }
    }
}
