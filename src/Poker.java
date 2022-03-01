import java.util.List;

public class Poker {
    public static List<Card> HAND1 = List.of(
            new Card(CardSuit.C, CardValue.FOUR),
            new Card(CardSuit.H, CardValue.KING),
            new Card(CardSuit.S, CardValue.FIVE),
            new Card(CardSuit.D, CardValue.ACE),
            new Card(CardSuit.D, CardValue.EIGHT)
    );
    public static List<Card> HAND2 = List.of(
            new Card(CardSuit.S, CardValue.ACE),
            new Card(CardSuit.D, CardValue.SEVEN),
            new Card(CardSuit.D, CardValue.FIVE),
            new Card(CardSuit.C, CardValue.FIVE),
            new Card(CardSuit.H, CardValue.QUEEN)
    );

    public static void main(String[] args) {
        System.out.println("Poker start");
        System.out.print("\n- hand 1: ");
        for (Card card: HAND1) {
            System.out.print(card.toString() + ", ");
        }
        System.out.print("\n- hand 2: ");
        for (Card card: HAND2) {
            System.out.print(card.toString() + ", ");
        }
    }
}
