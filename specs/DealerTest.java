import blackjack.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugenekim on 7/7/17.
 */

public class DealerTest {
    Player player;
    Deck deck;
    Dealer dealer;

    @Before
    public void before() {
        player = new Player("Player");
        deck = new Deck();
        dealer = new Dealer("Dealer");
        deck.setup();
    }

    @Test
    public void canDealCard() {
        dealer.dealCard(deck, player);
        assertEquals(51, deck.cardCount());
        assertEquals(1, player.cardCount());
    }

    @Test
    public void canDealInitialHands(){
        dealer.dealInitialHands(deck, player, dealer);
        assertEquals(2, player.cardCount());
        assertEquals(2, dealer.cardCount());
        assertEquals(48, deck.cardCount());
    }

}
