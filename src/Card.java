import java.util.List;

public class Card implements Comparable<Card> {
    private final CardSuit suit;
    private final CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.suit.toString() + this.value.toString();
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public int compareTo(Card otherCard) {
        List<CardValue> cardValues = List.of(CardValue.values());
        int thisCardIndex = cardValues.indexOf(getValue());
        int otherCardIndex = cardValues.indexOf(otherCard.getValue());

        return Integer.compare(thisCardIndex, otherCardIndex);
    }

    /**
     * Compare this card to another one.
     * @param otherCard
     * @return  true if the card's value is greater
     */
    public boolean isGreaterThan(Card otherCard) {
        if (otherCard != null) {
            return this.compareTo(otherCard) > 0;
        } else {
            return true;
        }
    }

    /**
     * Compare this card to another one.
     * @param otherCard
     * @return  true if the card's value is less
     */
    public boolean isLessThan(Card otherCard) {
        if (otherCard != null) {
            return this.compareTo(otherCard) < 0;
        } else {
            return false;
        }
    }

    /**
     * Compare this card to another one.
     * @param otherCard
     * @return  true if the card's value is equal
     */
    public boolean isEqualTo(Card otherCard) {
        if (otherCard != null) {
            return this.compareTo(otherCard) == 0;
        } else {
            return false;
        }
    }

    /**
     * Check if two cards are neighbors in the order of card values.
     * @param otherCard
     * @return  true if they're adjacent
     */
    public boolean isAdjacentTo(Card otherCard) {
        if (otherCard != null) {
            List<CardValue> cardValues = List.of(CardValue.values());
            int thisCardIndex = cardValues.indexOf(getValue());
            int otherCardIndex = cardValues.indexOf(otherCard.getValue());
            int difference = thisCardIndex - otherCardIndex;

            return (difference == 1) || (difference == -1);
        } else {
            return false;
        }
    }
}
