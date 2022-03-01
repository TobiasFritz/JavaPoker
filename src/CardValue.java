public enum CardValue {
    TWO     ("2"),
    THREE   ("3"),
    FOUR    ("4"),
    FIVE    ("5"),
    SIX     ("6"),
    SEVEN   ("7"),
    EIGHT   ("8"),
    NINE    ("9"),
    TEN     ("T"),
    JACK    ("J"),
    QUEEN   ("Q"),
    KING    ("K"),
    ACE     ("A")
    ;

    private final String cardValueDenomination;

    CardValue(String cardValueDenomination) {
        this.cardValueDenomination = cardValueDenomination;
    }

    @Override
    public String toString() {
        return this.cardValueDenomination;
    }
}
