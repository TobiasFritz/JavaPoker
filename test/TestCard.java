import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

public class TestCard {
    @Test
    public void testCreateAndPrintCards() {
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

}
