import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestHand {
    @Test
    public void testHandContainsStraightFlush() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithStraightFlush = new Hand(List.of(
                new Card(CardSuit.D, CardValue.ACE),
                new Card(CardSuit.D, CardValue.KING),
                new Card(CardSuit.D, CardValue.QUEEN),
                new Card(CardSuit.D, CardValue.JACK),
                new Card(CardSuit.D, CardValue.TEN)
        ));
        Assertions.assertFalse(badHand.containsStraightFlush());
        Assertions.assertTrue(handWithStraightFlush.containsStraightFlush());
    }

    @Test
    public void testGetStraightFlush() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        List<Card> straightFlush = List.of(
                new Card(CardSuit.D, CardValue.ACE),
                new Card(CardSuit.D, CardValue.KING),
                new Card(CardSuit.D, CardValue.QUEEN),
                new Card(CardSuit.D, CardValue.JACK),
                new Card(CardSuit.D, CardValue.TEN)
        );
        Hand handWithStraightFlush = new Hand(straightFlush);
        Assertions.assertTrue(badHand.getStraightFlush().isEmpty());
        Assertions.assertTrue(handWithStraightFlush.getStraightFlush().containsAll(straightFlush));
    }

    @Test
    public void testHandContainsFourOfAKind() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithFourOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Assertions.assertFalse(badHand.containsFourOfAKind());
        Assertions.assertTrue(handWithFourOfAKind.containsFourOfAKind());
    }

    @Test
    public void testGetFourOfAKind() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Card card1 = new Card(CardSuit.S, CardValue.FIVE);
        Card card2 = new Card(CardSuit.D, CardValue.SIX);
        Card card3 = new Card(CardSuit.D, CardValue.FIVE);
        Card card4 = new Card(CardSuit.C, CardValue.FIVE);
        Card card5 = new Card(CardSuit.H, CardValue.FIVE);
        List<Card> fourOfAKind = List.of(card1, card3, card4, card5);
        Hand handWithFourOfAKind = new Hand(List.of(card1, card2, card3, card4, card5));
        Assertions.assertTrue(badHand.getFourOfAKind().isEmpty());
        Assertions.assertTrue(handWithFourOfAKind.getFourOfAKind().containsAll(fourOfAKind));
    }

    @Test
    public void testHandContainsFullHouse() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithFullHouse = new Hand(List.of(
                new Card(CardSuit.S, CardValue.SIX),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Assertions.assertFalse(badHand.containsFullHouse());
        Assertions.assertTrue(handWithFullHouse.containsFullHouse());
    }

    @Test
    public void testGetFullHouse() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Card card1 = new Card(CardSuit.S, CardValue.SIX);
        Card card2 = new Card(CardSuit.D, CardValue.SIX);
        Card card3 = new Card(CardSuit.D, CardValue.FIVE);
        Card card4 = new Card(CardSuit.C, CardValue.FIVE);
        Card card5 = new Card(CardSuit.H, CardValue.FIVE);
        List<Card> pair = List.of(card1, card2);
        List<Card> threeOfAKind = List.of(card3, card4, card5);
        Hand handWithFullHouse = new Hand(List.of(card1, card2, card3, card4, card5));
        Assertions.assertTrue(badHand.getFullHouse().get(0).isEmpty() && badHand.getFullHouse().get(1).isEmpty());
        Assertions.assertTrue(handWithFullHouse.getFullHouse().get(0).containsAll(threeOfAKind) && handWithFullHouse.getFullHouse().get(1).containsAll(pair));
    }

    @Test
    public void testHandContainsFlush() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithFlush = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.H, CardValue.THREE),
                new Card(CardSuit.H, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.H, CardValue.JACK)
        ));
        Assertions.assertFalse(badHand.containsFlush());
        Assertions.assertTrue(handWithFlush.containsFlush());
    }

    @Test
    public void testGetFlush() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        List<Card> flush = List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.H, CardValue.THREE),
                new Card(CardSuit.H, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.H, CardValue.JACK)
        );
        Hand handWithFlush = new Hand(flush);
        Assertions.assertTrue(badHand.getFlush().isEmpty());
        Assertions.assertTrue(flush.containsAll(handWithFlush.getFlush()));
    }

    @Test
    public void testHandContainsStraight() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithStraight = new Hand(List.of(
                new Card(CardSuit.S, CardValue.EIGHT),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.NINE)
        ));
        Assertions.assertFalse(badHand.containsStraight());
        Assertions.assertTrue(handWithStraight.containsStraight());
    }

    @Test
    public void testGetStraight() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        List<Card> straight = List.of(
                new Card(CardSuit.S, CardValue.EIGHT),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.NINE)
        );
        Hand handWithStraight = new Hand(straight);
        Assertions.assertTrue(badHand.getStraight().isEmpty());
        Assertions.assertTrue(straight.containsAll(handWithStraight.getStraight()));
    }

    @Test
    public void testHandContainsThreeOfAKind() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithThreeOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Hand handWithFourOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Assertions.assertFalse(badHand.containsThreeOfAKind());
        Assertions.assertTrue(handWithThreeOfAKind.containsThreeOfAKind());
        Assertions.assertFalse(handWithFourOfAKind.containsThreeOfAKind());
    }

    @Test
    public void testGetThreeOfAKind() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Card card1 = new Card(CardSuit.S, CardValue.ACE);
        Card card2 = new Card(CardSuit.D, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.D, CardValue.FIVE);
        Card card4 = new Card(CardSuit.C, CardValue.FIVE);
        Card card5 = new Card(CardSuit.H, CardValue.FIVE);
        List<Card> threeOfAKind = List.of(card3, card4, card5);
        Hand handWithThreeOfAKind = new Hand(List.of(card1, card2, card3, card4, card5));
        Hand handWithFourOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Assertions.assertTrue(badHand.getThreeOfAKind().isEmpty());
        Assertions.assertTrue(threeOfAKind.containsAll(handWithThreeOfAKind.getThreeOfAKind()));
        Assertions.assertTrue(handWithFourOfAKind.getThreeOfAKind().isEmpty());
    }

    @Test
    public void testHandContainsTwoPair() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithTwoPairs = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SEVEN)
        ));
        Assertions.assertFalse(badHand.containsTwoPairs());
        Assertions.assertTrue(handWithTwoPairs.containsTwoPairs());
    }

    @Test
    public void testGetTwoPairs() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Card card1 = new Card(CardSuit.S, CardValue.ACE);
        Card card2 = new Card(CardSuit.D, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.D, CardValue.FIVE);
        Card card4 = new Card(CardSuit.C, CardValue.FIVE);
        Card card5 = new Card(CardSuit.H, CardValue.SEVEN);
        List<Card> pair1 = List.of(card2, card5);
        List<Card> pair2 = List.of(card3, card4);
        Hand handWithTwoPairs = new Hand(List.of(card1, card2, card3, card4, card5));

        Assertions.assertTrue(badHand.getPairs().isEmpty());
        Assertions.assertTrue(
                pair1.containsAll(handWithTwoPairs.getPairs().get(0)) &&
                        pair2.containsAll(handWithTwoPairs.getPairs().get(1))
        );
        Assertions.assertFalse(
                pair1.containsAll(handWithTwoPairs.getPairs().get(1)) &&
                        pair2.containsAll(handWithTwoPairs.getPairs().get(0))
        );
    }

    @Test
    public void testHandContainsPair() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand handWithPair = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.QUEEN)
        ));
        Hand handWithThreeOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Hand handWithFourOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Assertions.assertFalse(badHand.containsPair());
        Assertions.assertTrue(handWithPair.containsPair());
        Assertions.assertFalse(handWithThreeOfAKind.containsPair());
        Assertions.assertFalse(handWithFourOfAKind.containsPair());
    }

    @Test
    public void testGetPair() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Card card1 = new Card(CardSuit.S, CardValue.ACE);
        Card card2 = new Card(CardSuit.D, CardValue.SEVEN);
        Card card3 = new Card(CardSuit.D, CardValue.FIVE);
        Card card4 = new Card(CardSuit.C, CardValue.FIVE);
        Card card5 = new Card(CardSuit.H, CardValue.QUEEN);
        List<Card> pair = List.of(card3, card4);
        Hand handWithPair = new Hand(List.of(card1, card2, card3, card4, card5));
        Hand handWithThreeOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Hand handWithFourOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Assertions.assertTrue(badHand.getPair().isEmpty());
        Assertions.assertTrue(pair.containsAll(handWithPair.getPair()));
        Assertions.assertTrue(handWithThreeOfAKind.getPair().isEmpty());
        Assertions.assertTrue(handWithFourOfAKind.getPair().isEmpty());
    }
}
