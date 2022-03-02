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

    public boolean isGreaterThan(Card otherCard) {
        return this.compareTo(otherCard) > 0;
    }

    public boolean isLessThan(Card otherCard) {
        return this.compareTo(otherCard) < 0;
    }

    public boolean isAdjacentTo(Card otherCard) {
        List<CardValue> cardValues = List.of(CardValue.values());
        int thisCardIndex = cardValues.indexOf(getValue());
        int otherCardIndex = cardValues.indexOf(otherCard.getValue());
        int difference = thisCardIndex - otherCardIndex;

        return (difference == 1) || (difference == -1);
    }
}
