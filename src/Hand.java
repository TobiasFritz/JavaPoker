import java.util.*;

public class Hand {
    private List<Card> cards;
    private List<Card> straightFlush;
    private List<Card> fourOfAKind;
    private List<List<Card>> fullHouse;
    private List<Card> flush;
    private List<Card> straight;
    private List<Card> threeOfAKind;
    private List<List<Card>> pairs;

    public Hand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
        Collections.sort(this.cards);
        Collections.reverse(this.cards);

        this.pairs = containsPair() ? createListOfPairs() : Collections.emptyList();
        this.threeOfAKind = containsThreeOfAKind() ? createListThreeOfAKind() : Collections.emptyList();
        this.straight = containsStraight() ? new ArrayList<>(cards) : Collections.emptyList();
        this.flush = containsFlush() ? new ArrayList<>(cards) : Collections.emptyList();
        this.fullHouse = containsFullHouse() ? List.of(getThreeOfAKind(), getPair()) : List.of(Collections.emptyList(), Collections.emptyList());
        this.fourOfAKind = containsFourOfAKind() ? createListFourOfAKind() : Collections.emptyList();
        this.straightFlush = containsStraightFlush() ? new ArrayList<>(cards) : Collections.emptyList();
    }

    /**
     * Creates a list of four same value cards if the hand contains four cards of a kind.
     * Returns empty list otherwise.
     * @return  List of four same value cards or empty list.
     */
    private List<Card> createListFourOfAKind() {
        return createListFromSameValueCardsAmountingTo(4);
    }

    /**
     * Creates a list of three same value cards if the hand contains three cards of a kind.
     * Returns empty list otherwise.
     * @return  List of three same value cards or empty list.
     */
    private List<Card> createListThreeOfAKind() {
        return createListFromSameValueCardsAmountingTo(3);
    }

    /**
     * @return  Returns a list containing lists of pairs. Sorted by card value in descending order.
     */
    private List<List<Card>> createListOfPairs() {
        List<List<Card>> listOfPairs = new ArrayList<>();
        List<Card> cardsInPair = new ArrayList<>();
        List<Card> remainder = new ArrayList<>();
        Map<String, Integer> cardPerValue = countCardsPerValue();

        for (String key: cardPerValue.keySet()) {
            if (cardPerValue.get(key) == 2) {
                List<Card> pair = new ArrayList<>();
                for (Card card: this.cards) {
                    if (Objects.equals(card.getValue().toString(), key)) {
                        pair.add(card);
                        cardsInPair.add(card);
                    }
                }
                listOfPairs.add(pair);
            }
        }

        Collections.reverse(listOfPairs);
        for (Card card: cards) {
            if (!cardsInPair.contains(card)) {
                remainder.add(card);
            }
        }
        listOfPairs.add(remainder);

        return listOfPairs;
    }

    /**
     * Creates a list when same value cards amounting to given number exist.
     * Creates an empty list otherwise.
     * @param number    Number of same value cards for a list to be created.
     * @return          List of same value cards of given number or empty list.
     */
    private List<Card> createListFromSameValueCardsAmountingTo(int number) {
        List<Card> listOfCards = new ArrayList<>();
        Map<String, Integer> cardPerValue = countCardsPerValue();

        for (String key: cardPerValue.keySet()) {
            if (cardPerValue.get(key) == number) {
                for (Card card: this.cards) {
                    if (Objects.equals(card.getValue().toString(), key)) {
                        listOfCards.add(card);
                    }
                }
                break;
            }
        }

        return listOfCards;
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
    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getStraightFlush() {
        return straightFlush;
    }

    public List<Card> getFourOfAKind() {
        return fourOfAKind;
    }

    public List<List<Card>> getFullHouse() {
        return fullHouse;
    }

    public List<Card> getFlush() {
        return flush;
    }

    public List<Card> getStraight() {
        return straight;
    }

    public List<Card> getThreeOfAKind() {
        return threeOfAKind;
    }

    public List<List<Card>> getPairs() {
        return pairs;
    }

    public List<Card> getPair() {
        return pairs.isEmpty() ? Collections.emptyList() : pairs.get(0);
    }
}
