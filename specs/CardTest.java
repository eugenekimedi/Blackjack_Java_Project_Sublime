import blackjack.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugenekim on 7/7/17.
 */

public class CardTest {

    Card card;
    Card card1;

    @Before
    public void before(){
        card = new Card(Rank.TWO, Suit.SPADES);
        card1 = new Card(Rank.TWO, Suit.SPADES);
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.TWO, card.getRank());
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.SPADES, card.getSuit());
    }

    @Test
    public void canEquals() {
        assertEquals(true, card.equals(card1));
    }

    @Test
    public void canGetCardString(){
        assertEquals("TWO OF SPADES", card.getCardString(card));
    }
}
