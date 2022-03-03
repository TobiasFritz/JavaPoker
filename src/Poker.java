import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Poker {
    public static Hand HAND1 = new Hand(List.of(
            new Card(CardSuit.D, CardValue.JACK),
            new Card(CardSuit.D, CardValue.KING),
            new Card(CardSuit.D, CardValue.QUEEN),
            new Card(CardSuit.D, CardValue.ACE),
            new Card(CardSuit.D, CardValue.TEN)
    ));
    public static Hand HAND2 = new Hand(List.of(
            new Card(CardSuit.S, CardValue.TWO),
            new Card(CardSuit.S, CardValue.THREE),
            new Card(CardSuit.S, CardValue.FOUR),
            new Card(CardSuit.S, CardValue.FIVE),
            new Card(CardSuit.S, CardValue.SIX)
    ));

    public static void main(String[] args) {
        System.out.println("Poker start");
        System.out.print("\n- hand 1: " + HAND1.toString());
        System.out.print("\n- hand 2: " + HAND2.toString());
        System.out.println("\n\nWinning hand: " + getWinningHand(HAND1, HAND2));
    }

    public static String getWinningHand(Hand hand1, Hand hand2) {
        Hand winningHand = getBetterHandOf(hand1, hand2);
        return winningHand == null ? "No winning hand" : winningHand.toString();
    }

    /**
     * Compare both hands and return the better one.
     * Returns null if both are equal.
     * @param hand1
     * @param hand2
     * @return      Hand or null.
     */
    private static Hand getBetterHandOf(Hand hand1, Hand hand2) {
        // return the hand with the greater Straight flush
        // if no Straight flush carry on
        Hand categoryStraightFlush = rankByCategory(hand1, hand2, Hand::containsStraightFlush, Hand::getStraightFlush);
        if (categoryStraightFlush != null)
            return categoryStraightFlush;

        // return the hand with the greater Four of a kind
        // if no Four of a kind carry on
        Hand categoryFourOfAKind = rankByCategory(hand1, hand2, Hand::containsFourOfAKind, Hand::getFourOfAKind);
        if (categoryFourOfAKind != null)
            return categoryFourOfAKind;

        // return the hand with the greater Full house
        // if no Full house carry on
        if (hand1.containsFullHouse() && hand2.containsFullHouse()) {
            return hand1.getFullHouse().get(0).get(0)
                    .isGreaterThan(hand2.getFullHouse().get(0).get(0))
                    ? hand1
                    : hand2;
        } else if (hand1.containsFullHouse() && !hand2.containsFullHouse()) {
            return hand1;
        } else if (!hand1.containsFullHouse() && hand2.containsFullHouse()) {
            return hand2;
        }

        // return the hand with the greater Flush
        // if no Flush carry on
        Hand categoryFlush = rankByCategory(hand1, hand2, Hand::containsFlush, Hand::getFlush);
        if (categoryFlush != null)
            return categoryFlush;

        // return the hand with the greater Straight
        // if no Straight carry on
        Hand categoryStraight = rankByCategory(hand1, hand2, Hand::containsStraight, Hand::getStraight);
        if (categoryStraight != null)
            return categoryStraight;

        // return the hand with the greater Three of a kind
        // if no Three of a kind carry on
        Hand categoryThreeOfAKind = rankByCategory(hand1, hand2, Hand::containsThreeOfAKind, Hand::getThreeOfAKind);
        if (categoryThreeOfAKind != null)
            return categoryThreeOfAKind;

        // return the hand with the greater Two Pairs
        // if no Two Pairs carry on
        if (hand1.containsTwoPairs() && hand2.containsTwoPairs()) {
            Iterator<List<Card>> iterator1 = hand1.getPairs().iterator();
            Iterator<List<Card>> iterator2 = hand2.getPairs().iterator();

            while (iterator1.hasNext() && iterator2.hasNext()) {
                Card card1 = iterator1.next().get(0);
                Card card2 = iterator2.next().get(0);
                if (card1.isGreaterThan(card2)) {
                    return hand1;
                }
                if (card1.isLessThan(card2)) {
                    return hand2;
                }
            }
        } else if (hand1.containsTwoPairs() && !hand2.containsTwoPairs()) {
            return hand1;
        } else if (!hand1.containsTwoPairs() && hand2.containsTwoPairs()) {
            return hand2;
        }

        // return the hand with the greater Pair
        // if no Pair carry on
        if (hand1.containsPair() && hand2.containsPair()) {
            Card card1 = hand1.getPairs().get(0).get(0);
            Card card2 = hand2.getPairs().get(0).get(0);
            if (card1.isGreaterThan(card2)) {
                return hand1;
            } else if (card1.isLessThan(card2)) {
                return hand2;
            } else {
                // if pairs are equal compare remaining cards
                Iterator<Card> iterator1 = hand1.getPairs().get(1).iterator();
                Iterator<Card> iterator2 = hand2.getPairs().get(1).iterator();

                while (iterator1.hasNext() && iterator2.hasNext()) {
                    card1 = iterator1.next();
                    card2 = iterator2.next();
                    if (card1.isGreaterThan(card2)) {
                        return hand1;
                    }
                    if (card1.isLessThan(card2)) {
                        return hand2;
                    }
                }
            }
        } else if (hand1.containsTwoPairs() && !hand2.containsTwoPairs()) {
            return hand1;
        } else if (!hand1.containsTwoPairs() && hand2.containsTwoPairs()) {
            return hand2;
        }

        // if no other category matched return the hand with the higher card value
        // return null if both hands are equal
        return rankByHighCard(hand1, hand2);
    }

    /**
     * Compare both hands using the given methods.
     * Return the better hand.
     * Return null if category doesn't apply or if both hands are equal.
     * @param hand1
     * @param hand2
     * @param hasCategory
     * @param categoryGetter
     * @return
     */
    private static Hand rankByCategory(
            Hand hand1,
            Hand hand2,
            Function<Hand, Boolean> hasCategory,
            Function<Hand, List<Card>> categoryGetter
    ) {
        if (hasCategory.apply(hand1) && hasCategory.apply(hand2)) {
            return categoryGetter.apply(hand1).get(0).isGreaterThan(categoryGetter.apply(hand2).get(0))
                    ? hand1
                    : categoryGetter.apply(hand1).get(0).isLessThan(categoryGetter.apply(hand2).get(0))
                        ? hand2
                        : rankByHighCard(hand1, hand2);
        } else if (hasCategory.apply(hand1) && !hasCategory.apply(hand2)) {
            return hand1;
        } else if (!hasCategory.apply(hand1) && hasCategory.apply(hand2)) {
            return hand2;
        } else {
            return null;
        }
    }

    /**
     * Compare both hands using the rule of High Card.
     * Return the better hand.
     * Return if both hands are equal.
     * @param hand1
     * @param hand2
     * @return
     */
    private static Hand rankByHighCard(Hand hand1, Hand hand2) {
        Iterator<Card> iterator1 = hand1.getCards().iterator();
        Iterator<Card> iterator2 = hand2.getCards().iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            Card card1 = iterator1.next();
            Card card2 = iterator2.next();
            if (card1.isGreaterThan(card2)) {
                return hand1;
            }
            if (card1.isLessThan(card2)) {
                return hand2;
            }
        }

        return null;
    }
}
