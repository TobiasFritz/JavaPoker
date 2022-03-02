import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
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
}
