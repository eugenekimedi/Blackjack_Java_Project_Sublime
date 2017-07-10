package blackjack;

/**
 * Created by eugenekim on 7/7/17.
 */

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public boolean equals(Card otherCard) {
        return rank == otherCard.getRank() && suit == otherCard.getSuit();
    }

    public String getCardString(Card card){
        return card.getRank().toString() + " OF " + card.getSuit().toString();
    }
}
