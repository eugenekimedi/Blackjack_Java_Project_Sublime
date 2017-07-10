import blackjack.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugenekim on 7/7/17.
 */

public class DeckTest {

    Deck deck;
    Card card;

    @Before
    public void before() {
        deck = new Deck();
        card = new Card(Rank.TWO, Suit.CLUBS);
    }

    @Test
    public void deckStartsEmpty() {
        assertEquals(0, deck.cardCount());
    }


    @Test
    public void canSetup() {
        deck.setup();
        assertEquals(52, deck.cardCount());
    }

    @Test
    public void canGetTop() {
        deck.setup();
        assertTrue(card.equals(deck.getTop()));
    }

    @Test
    public void canShuffle(){
        deck.setup();
        deck.shuffle();
        assertNotNull(deck.getTop());
    }
}
