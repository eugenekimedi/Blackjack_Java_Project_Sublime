import blackjack.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugenekim on 7/8/17.
 */

public class RulesTest {
    Player player;
    Dealer dealer;
    Rules rules;
    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void before() {
        rules = new Rules();
        dealer = new Dealer();
        player = new Player();
        card1 = new Card(Rank.ACE, Suit.SPADES);
        card2 = new Card(Rank.TEN, Suit.SPADES);
        card3 = new Card(Rank.NINE, Suit.SPADES);
        card4 = new Card(Rank.EIGHT, Suit.SPADES);
    }

    @Test
    public void canCountValues(){
        player.receiveCard(card1);
        player.receiveCard(card3);
        assertEquals(20, rules.countValues(player.getHand()));
    }

    @Test
    public void canCountValuesDealer(){
        dealer.receiveCard(card2);
        dealer.receiveCard(card4);
        assertEquals(18, rules.countValues(dealer.getHand()));
    }

    @Test
    public void canChangeAce(){
        player.receiveCard(card1);
        player.receiveCard(card1);
        player.receiveCard(card3);
        player.receiveCard(card2);
        assertEquals(21, rules.countValues(player.getHand()));
    }

    @Test
    public void canCompareHandsPlayerWins(){
        player.receiveCard(card1);
        player.receiveCard(card3);
        dealer.receiveCard(card2);
        dealer.receiveCard(card4);
        assertEquals("player wins", rules.compareHands(player, dealer));
    }

    @Test
    public void canCompareHandsPlayerBlackjack(){
        player.receiveCard(card1);
        player.receiveCard(card2);
        dealer.receiveCard(card3);
        dealer.receiveCard(card4);
        assertEquals("BLACKJACK!", rules.compareHands(player, dealer));
    }

    @Test
    public void canCompareHandsDealerWins(){
        player.receiveCard(card4);
        player.receiveCard(card3);
        dealer.receiveCard(card1);
        dealer.receiveCard(card2);
        assertEquals("dealer wins", rules.compareHands(player, dealer));
    }

    @Test
    public void canCompareHandsDraw(){
        player.receiveCard(card1);
        player.receiveCard(card4);
        dealer.receiveCard(card2);
        dealer.receiveCard(card3);
        assertEquals("draw", rules.compareHands(player, dealer));
    }


    @Test
    public void canCompareBlackjacks(){
        player.receiveCard(card1);
        player.receiveCard(card2);
        dealer.receiveCard(card1);
        dealer.receiveCard(card2);
        assertEquals("draw", rules.compareHands(player, dealer));
    }
}
