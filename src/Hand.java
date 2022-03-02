import java.util.*;

public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
    }

    public boolean containsStraightFlush() {
        return containsStraight() && containsFlush();
    }

    public boolean containsFourOfAKind() {
        boolean containsFourOfAKind = false;

        for (Integer cardCount: countCardsPerValue().values()) {
            if (cardCount == 4) {
                containsFourOfAKind = true;
                break;
            }
        }

        return containsFourOfAKind;
    }

    public boolean containsFullHouse() {
        return containsThreeOfAKind() && containsPair();
    }

    public boolean containsFlush() {
        boolean containsFlush = false;

        for (Integer cardCount: countCardsPerSuit().values()) {
            if (cardCount == 5) {
                containsFlush = true;
                break;
            }
        }

        return containsFlush;
    }

    public boolean containsStraight() {
        int countStraightCards = 1;
        Iterator<Card> iterator = this.cards.iterator();
        Card a = iterator.next();
        Card b = null;

        while (iterator.hasNext()) {
            b = iterator.next();
            if (a.isAdjacentTo(b)) {
                countStraightCards++;
            } else {
                countStraightCards = 1;
            }
            a = b;
        }

        return countStraightCards >= 5;
    }

    public boolean containsThreeOfAKind() {
        boolean containsThreeOfAKind = false;

        for (Integer cardCount: countCardsPerValue().values()) {
            if (cardCount == 3) {
                containsThreeOfAKind = true;
                break;
            }
        }

        return containsThreeOfAKind;
    }

    public boolean containsTwoPairs() {
        int countPairs = 0;

        for (Integer cardCount: countCardsPerValue().values()) {
            if (cardCount == 2) {
                countPairs++;
            }
        }

        return countPairs == 2;
    }

    public boolean containsPair() {
        boolean containsPair = false;

        for (Integer cardCount: countCardsPerValue().values()) {
            if (cardCount == 2) {
                containsPair = true;
                break;
            }
        }

        return containsPair;
    }

    /**
     * Counts number of cards per card value in hand as a HashMap and returns the result.
     * @return  HashMap<String, Integer>
     */
    private Map<String, Integer> countCardsPerValue() {
        Map<String, Integer> cardsPerValue = new HashMap<>();

        for (CardValue value: CardValue.values()) {
            cardsPerValue.put(value.toString(), 0);
        }
        for (Card card: cards) {
            cardsPerValue.put(card.getValue().toString(), cardsPerValue.get(card.getValue().toString()) + 1);
        }

        return cardsPerValue;
    }

    /**
     * Counts number of cards per card suit in hand as a HashMap and returns the result.
     * @return  HashMap<String, Integer>
     */
    private Map<String, Integer> countCardsPerSuit() {
        Map<String, Integer> cardsPerSuit = new HashMap<>();

        for (CardSuit suit: CardSuit.values()) {
            cardsPerSuit.put(suit.toString(), 0);
        }
        for (Card card: cards) {
            cardsPerSuit.put(card.getSuit().toString(), cardsPerSuit.get(card.getSuit().toString()) + 1);
        }

        return cardsPerSuit;
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }
}
