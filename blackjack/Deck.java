package blackjack;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by eugenekim on 7/7/17.
 */

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public int cardCount() {
        int numberOfCards = 0;

        for(Card card : this.cards) {
            if (card != null) {
                numberOfCards++;
            }
        }
        return numberOfCards;
    }

    public void setup(){
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                this.cards.add(card);
            }
        }
    }

    public Card getTop() {
        Card topCard = this.cards.get(0);
        this.cards.remove(0);
        return topCard;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
