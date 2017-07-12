import blackjack.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugenekim on 7/7/17.
 */

public class PlayerTest {

    Player player;
    Card card;
    Card card1;

    @Before
    public void before() {
        player = new Player();
        card = new Card(Rank.ACE, Suit.SPADES);
        card1 = new Card(Rank.TWO, Suit.CLUBS);
    }

    @Test
    public void handStartsEmpty() {
        assertEquals(0, player.cardCount());
    }

    @Test
    public void canReceiveCard() {
        player.receiveCard(card);
        player.receiveCard(card1);
        assertEquals(2, player.cardCount());
    }

    @Test
    public void canGetHand() {
        player.receiveCard(card);
        player.receiveCard(card1);
        ArrayList<Card> expected = new ArrayList<Card>();
        expected.add(card);
        expected.add(card1);
        assertEquals(2, player.getHand().size());
    }

    @Test
    public void canEraseHands(){
        player.receiveCard(card);
        player.receiveCard(card1);
        assertEquals(2, player.cardCount());
        player.eraseHand();
        assertEquals(0, player.cardCount());
    }

    @Test
    public void canGetMoney() {
        assertEquals(100, player.getMoney());
    }

    @Test
    public void canAddMoney() {
        player.addMoney(10);
        assertEquals(110, player.getMoney());
    }

    @Test
    public void canSubtractMoney() {
        player.subtractMoney(10);
        assertEquals(90, player.getMoney());
    }
}
