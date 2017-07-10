package blackjack;

/**
 * Created by eugenekim on 7/7/17.
 */

public class Dealer extends Player{
    Dealer dealer;


    public void dealCard(Deck deck, Player player) {
        Card card = deck.getTop();
        player.receiveCard(card);
    }

    public void dealInitialHands(Deck deck, Player player, Player dealer){
        dealCard(deck, player);
        dealCard(deck, dealer);
        dealCard(deck, player);
        dealCard(deck, dealer);
    }
}
