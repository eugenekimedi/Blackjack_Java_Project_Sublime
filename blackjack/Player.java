package blackjack;

import java.util.ArrayList;

/**
 * Created by eugenekim on 7/7/17.
 */

public class Player {

    private ArrayList<Card> hand;

    public Player() {
        this.hand = new ArrayList<Card>();
    }

    public int cardCount() {
        int numberOfCards = 0;

        for(Card card : this.hand) {
            if (card != null) {
                numberOfCards++;
            }
        }
        return numberOfCards;
    }

    public void receiveCard(Card newCard) {
        this.hand.add(newCard);
    }

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public void eraseHand(){
        this.hand = new ArrayList<Card>();
    }
}
