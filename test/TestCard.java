import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestCard {
    @Test
    public void testToString() {
        List<String> expected = List.of(
            "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CT", "CJ", "CQ", "CK","CA",
            "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DT", "DJ", "DQ", "DK","DA",
            "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "HT", "HJ", "HQ", "HK","HA",
            "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "ST", "SJ", "SQ", "SK","SA"
        );
        List<String> actual = new LinkedList<>();

        for (CardSuit suit: CardSuit.values()) {
            for (CardValue value: CardValue.values()) {
                actual.add(new Card(suit, value).toString());
            }
        }

        System.out.println("expected:\t" + expected);
        System.out.println("actual:\t\t" + actual);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void testComparingCards() {
        Card cardJack = new Card(CardSuit.H, CardValue.JACK);
        Card cardQueen = new Card(CardSuit.C, CardValue.QUEEN);

        Assertions.assertTrue(cardJack.isLessThan(cardQueen));
        Assertions.assertFalse(cardQueen.isLessThan(cardJack));

        Assertions.assertTrue(cardQueen.isGreaterThan(cardJack));
        Assertions.assertFalse(cardJack.isGreaterThan(cardQueen));
    }

    @Test
    public void testSortingCards() {
        List<Card> hand = Arrays.asList(
                new Card(CardSuit.C, CardValue.KING),
                new Card(CardSuit.H, CardValue.JACK),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.S, CardValue.THREE),
                new Card(CardSuit.S, CardValue.ACE)
        );
        List<Card> handSorted = Arrays.asList(
                new Card(CardSuit.S, CardValue.THREE),
                new Card(CardSuit.D, CardValue.SIX),
                new Card(CardSuit.H, CardValue.JACK),
                new Card(CardSuit.C, CardValue.KING),
                new Card(CardSuit.S, CardValue.ACE)
        );

        Collections.sort(hand);
        Assertions.assertEquals(handSorted.toString(), hand.toString());
    }

    @Test
    public void testAdjacentCards() {
        Card cardJack = new Card(CardSuit.H, CardValue.JACK);
        Card cardQueen = new Card(CardSuit.C, CardValue.QUEEN);
        Card cardKing = new Card(CardSuit.C, CardValue.KING);

        Assertions.assertTrue(cardJack.isAdjacentTo(cardQueen));
        Assertions.assertFalse(cardJack.isAdjacentTo(cardKing));
        Assertions.assertTrue(cardQueen.isAdjacentTo(cardJack));
        Assertions.assertTrue(cardQueen.isAdjacentTo(cardKing));

    }

}
