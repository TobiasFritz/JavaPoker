import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPoker {
    @Test
    public void testGetBetterHandOfBadHands() {
        Hand badHand = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.JACK)
        ));
        Hand badHand2 = new Hand(List.of(
                new Card(CardSuit.C, CardValue.TWO),
                new Card(CardSuit.H, CardValue.THREE),
                new Card(CardSuit.H, CardValue.FIVE),
                new Card(CardSuit.S, CardValue.SIX),
                new Card(CardSuit.H, CardValue.JACK)
        ));
        Hand badHand3 = new Hand(List.of(
                new Card(CardSuit.C, CardValue.TWO),
                new Card(CardSuit.H, CardValue.THREE),
                new Card(CardSuit.H, CardValue.FOUR),
                new Card(CardSuit.S, CardValue.SIX),
                new Card(CardSuit.H, CardValue.JACK)
        ));

        Assertions.assertEquals("No winning hand", Poker.getWinningHand(badHand, badHand2));
        Assertions.assertEquals(badHand.toString(), Poker.getWinningHand(badHand, badHand3));
        Assertions.assertEquals(badHand2.toString(), Poker.getWinningHand(badHand2, badHand3));
    }

    @Test
    public void testGetBetterHandOfPairs() {
        Hand handWithPair = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.QUEEN)
        ));
        Hand handWithPair2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FOUR),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.QUEEN)
        ));
        Hand handWithPair3 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FOUR)
        ));

        Assertions.assertEquals(handWithPair.toString(), Poker.getWinningHand(handWithPair, handWithPair2));
        Assertions.assertEquals(handWithPair.toString(), Poker.getWinningHand(handWithPair, handWithPair3));
        Assertions.assertEquals(handWithPair3.toString(), Poker.getWinningHand(handWithPair2, handWithPair3));
    }

    @Test
    public void testGetBetterHandOfTwoPairs() {
        Hand handWithTwoPairs = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SEVEN)
        ));
        Hand handWithTwoPairs2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.EIGHT),
                new Card(CardSuit.C, CardValue.EIGHT),
                new Card(CardSuit.H, CardValue.SEVEN)
        ));
        Hand handWithTwoPairs3 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.EIGHT),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SEVEN)
        ));

        Assertions.assertEquals(handWithTwoPairs2.toString(), Poker.getWinningHand(handWithTwoPairs, handWithTwoPairs2));
        Assertions.assertEquals(handWithTwoPairs.toString(), Poker.getWinningHand(handWithTwoPairs, handWithTwoPairs3));
        Assertions.assertEquals(handWithTwoPairs2.toString(), Poker.getWinningHand(handWithTwoPairs2, handWithTwoPairs3));
    }

    @Test
    public void testGetBetterHandOfThreeOfAKinds() {
        Hand handWithThreeOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Hand handWithThreeOfAKind2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.ACE),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.C, CardValue.SEVEN),
                new Card(CardSuit.H, CardValue.FIVE)
        ));

        Assertions.assertEquals(handWithThreeOfAKind2.toString(), Poker.getWinningHand(handWithThreeOfAKind, handWithThreeOfAKind2));
    }

    @Test
    public void testGetBetterHandOfStraights() {
        Hand handWithStraight = new Hand(List.of(
                new Card(CardSuit.S, CardValue.EIGHT),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.NINE)
        ));
        Hand handWithStraight2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.NINE),
                new Card(CardSuit.D, CardValue.QUEEN),
                new Card(CardSuit.D, CardValue.KING),
                new Card(CardSuit.C, CardValue.TEN),
                new Card(CardSuit.H, CardValue.JACK)
        ));
        Hand handWithStraight3 = new Hand(List.of(
                new Card(CardSuit.H, CardValue.EIGHT),
                new Card(CardSuit.C, CardValue.SEVEN),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.NINE)
        ));

        Assertions.assertEquals(handWithStraight2.toString(), Poker.getWinningHand(handWithStraight, handWithStraight2));
        Assertions.assertEquals("No winning hand", Poker.getWinningHand(handWithStraight, handWithStraight3));
    }

    @Test
    public void testGetBetterHandOfFlushes() {
        Hand handWithFlush = new Hand(List.of(
                new Card(CardSuit.H, CardValue.TWO),
                new Card(CardSuit.H, CardValue.THREE),
                new Card(CardSuit.H, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.SIX),
                new Card(CardSuit.H, CardValue.JACK)
        ));
        Hand handWithFlush2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.TWO),
                new Card(CardSuit.S, CardValue.THREE),
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.S, CardValue.SIX),
                new Card(CardSuit.S, CardValue.JACK)
        ));
        Hand handWithFlush3 = new Hand(List.of(
                new Card(CardSuit.C, CardValue.QUEEN),
                new Card(CardSuit.C, CardValue.THREE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.SIX),
                new Card(CardSuit.C, CardValue.JACK)
        ));

        Assertions.assertEquals("No winning hand", Poker.getWinningHand(handWithFlush, handWithFlush2));
        Assertions.assertEquals(handWithFlush3.toString(), Poker.getWinningHand(handWithFlush, handWithFlush3));
    }

    @Test
    public void testGetBetterHandOfFullHouses() {
        Hand handWithFullHouse = new Hand(List.of(
                new Card(CardSuit.S, CardValue.SIX),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));
        Hand handWithFullHouse2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.SIX),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.SEVEN),
                new Card(CardSuit.C, CardValue.SEVEN),
                new Card(CardSuit.H, CardValue.SEVEN)
        ));

        Assertions.assertEquals(handWithFullHouse2.toString(), Poker.getWinningHand(handWithFullHouse, handWithFullHouse2));
    }

    @Test
    public void testGetBetterHandOfFourOfAKinds() {
        Hand handWithFourOfAKind = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.D, CardValue.QUEEN),
                new Card(CardSuit.D, CardValue.QUEEN),
                new Card(CardSuit.C, CardValue.QUEEN),
                new Card(CardSuit.H, CardValue.QUEEN)
        ));
        Hand handWithFourOfAKind2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.FIVE),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.D, CardValue.FIVE),
                new Card(CardSuit.C, CardValue.FIVE),
                new Card(CardSuit.H, CardValue.FIVE)
        ));

        Assertions.assertEquals(handWithFourOfAKind.toString(), Poker.getWinningHand(handWithFourOfAKind, handWithFourOfAKind2));
    }

    @Test
    public void testGetBetterHandOfStraightFlushes() {
        Hand handWithStraightFlush = new Hand(List.of(
                new Card(CardSuit.D, CardValue.ACE),
                new Card(CardSuit.D, CardValue.KING),
                new Card(CardSuit.D, CardValue.QUEEN),
                new Card(CardSuit.D, CardValue.JACK),
                new Card(CardSuit.D, CardValue.TEN)
        ));
        Hand handWithStraightFlush2 = new Hand(List.of(
                new Card(CardSuit.S, CardValue.NINE),
                new Card(CardSuit.S, CardValue.KING),
                new Card(CardSuit.S, CardValue.QUEEN),
                new Card(CardSuit.S, CardValue.JACK),
                new Card(CardSuit.S, CardValue.TEN)
        ));
        Hand handWithStraightFlush3 = new Hand(List.of(
                new Card(CardSuit.H, CardValue.ACE),
                new Card(CardSuit.H, CardValue.KING),
                new Card(CardSuit.H, CardValue.QUEEN),
                new Card(CardSuit.H, CardValue.JACK),
                new Card(CardSuit.H, CardValue.TEN)
        ));

        Assertions.assertEquals(handWithStraightFlush.toString(), Poker.getWinningHand(handWithStraightFlush, handWithStraightFlush2));
        Assertions.assertEquals("No winning hand", Poker.getWinningHand(handWithStraightFlush, handWithStraightFlush3));
        Assertions.assertEquals(handWithStraightFlush3.toString(), Poker.getWinningHand(handWithStraightFlush2, handWithStraightFlush3));
    }
}
